package javaparser;

import java.util.*;

public class Portfolio extends Observable implements IPortfolio {

	private String name;
	private List<Holding> holdings;
	private List<Observer> observers;
	
	public Portfolio(String name){
		this.name = name;
		holdings = new ArrayList<Holding>();
		observers = new ArrayList<Observer>();
	}
	
	@Override
	public void addObserver(Observer o){
		super.addObserver(o);
		observers.add(o);
		for(Holding h : holdings)
			h.addObserver(o);
	}
	
	@Override
	public float getValue() {
		float value=0;
		for(Holding h : holdings)
			value+=h.getHeldValue();
		return value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<Holding> getHoldings() {
		return holdings;
	}

	private Holding findMatchingHolding(String name, String ticker) throws TickerShareMismatchException
	{
		//Loop through all holdings we have, and return first name & ticker match
		for(Holding h : holdings){
			if(h.getTickerSymbol().equals(ticker)){
				if(!h.getStockName().equals(name))
					//Notify caller of existing ticker with different name
					throw new TickerShareMismatchException(h.getStockName());
				
				return h;
			}
		}
		return null;
	}
	
	@Override
	public Holding buyShares(String name, String ticker, int shares)
			throws NoSuchTickerException, WebsiteDataException, TickerShareMismatchException {
		
		Float originalValue=null;
		//This will always pass, just remembers original value for later
		assert (originalValue=this.getValue())!=null;
		
		if(shares<=0)
			return null;
	
		Holding targetHolding = findMatchingHolding(name, ticker);
		
		// if this is a new ticker, create a new holding
		if(targetHolding==null){
			
			String ppsStr = StrathQuoteServer.getLastValue(ticker);
			float pps = Float.parseFloat(ppsStr.replace(",",""));
			targetHolding = new Holding(name,ticker,shares);
			targetHolding.setPricePerShare(pps);
			
			//Give new folio the same observers as we have
			for(Observer o : observers)
				targetHolding.addObserver(o);
			
			holdings.add(targetHolding);
			
		// Else add the shares to an existing holding
		} else {
			targetHolding.setHeldShares(shares + targetHolding.getHeldShares());
		}
		
		setChanged();
		notifyObservers();
		clearChanged();
		
		assert isCorrectSum(originalValue,targetHolding,shares):
			String.format("new val=%10.2f, should be=%10.2f", this.getValue(),
					originalValue+targetHolding.getPricePerShare()*shares);
		
		return targetHolding;
	}
	
	private boolean isCorrectSum(Float originalValue, Holding targetHolding, int shares) {
		//Is the magnitude of (actual - expected) negligible?
		return Math.abs(
					this.getValue()-
					(originalValue+targetHolding.getPricePerShare()*shares)
				)<0.001;
	}

	@Override
	public Holding sellShares(String name, String ticker, int shares)
			throws TickerShareMismatchException, NotEnoughSharesException {
		if(shares<=0)
			return null;
	
		Holding targetHolding = findMatchingHolding(name, ticker);
		
		// if this is a new ticker, we can't sell shares from it!
		if(targetHolding==null){
			throw new TickerShareMismatchException();
		
		} else {
			// if you don't have enough shares, throw NotEnoughSharesException
			if(targetHolding.getHeldShares()<shares){
				throw new NotEnoughSharesException(Integer.toString(targetHolding.getHeldShares()));
			}
			// if you sell all the shares, remove the holding object too
			else if(targetHolding.getHeldShares()==shares){
				removeHolding(targetHolding);
			// Otherwise, remove the shares from the holding
			} else {
				targetHolding.setHeldShares(targetHolding.getHeldShares()-shares);
			}
		}
		
		setChanged();
		notifyObservers();
		clearChanged();
		
		return targetHolding;
	}
	
	@Override
	public boolean removeHolding(IHolding h) {
		boolean wasRemoved = holdings.remove(h);

		setChanged();
		notifyObservers();
		clearChanged();
		
		return wasRemoved;
	}

}
