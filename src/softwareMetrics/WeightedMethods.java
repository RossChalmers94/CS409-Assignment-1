package softwareMetrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class WeightedMethods {
	
	private static final int WMC_LIMIT = 12;
	private static ArrayList<ClassOrInterfaceDeclaration> classValues = new ArrayList<ClassOrInterfaceDeclaration>();
	private static ArrayList<MethodDeclaration> methodValues = new ArrayList<MethodDeclaration>();
	private static HashMap<ClassOrInterfaceDeclaration, Integer> weightedMethods = new HashMap<ClassOrInterfaceDeclaration, Integer>();
	
	
    public WeightedMethods(ArrayList<ClassOrInterfaceDeclaration> classNames, ArrayList<MethodDeclaration> methods){
    	classValues = classNames;
    	methodValues = methods;
    }
    
	public void setUp(){
		
		for(int i = 0; i < classValues.size(); i++){
			int methodCounter = 0;
			ClassOrInterfaceDeclaration c = classValues.get(i);
			String className = c.getName();
			for(MethodDeclaration m : methodValues){
				ClassOrInterfaceDeclaration parent = (ClassOrInterfaceDeclaration) m.getParentNode();
				if(parent.getName().equals(className)){
					methodCounter++;
				}
			}
			
			weightedMethods.put(c, methodCounter);
		}
		
		calculateWMC();
	}
		
		
	public void calculateWMC(){
		
		for(int i = 0; i < weightedMethods.size(); i++){
			Object[] keys = weightedMethods.keySet().toArray();
			ClassOrInterfaceDeclaration classValue = (ClassOrInterfaceDeclaration) keys[i];
			String classname = classValue.getName();
			int methodCount = weightedMethods.get(classValue);
			
			if(!classValue.isInterface()){
				System.out.println(tidyOutput(classname, methodCount));
			}
		}
		
		weightedMethods.clear();
	}
	
	private String tidyOutput(String classname, int methodCount){
		StringBuffer toReturn = new StringBuffer();
		toReturn.append("The class we are analyzing is " + classname + ".\n");
		toReturn.append("This class has " + methodCount + " methods.\n");
		if(methodCount > WMC_LIMIT){
			toReturn.append("Unfortunately, this class is over the recommeneded classes per method. "
					+ "The Developer should consider restructuring his/her code.\n");
		} else {
			toReturn.append("This class is under or equal to the recommended classes per method, " 
					+ "Congratulations!\n");
		}
		
		return toReturn.toString();
		
	}

}
