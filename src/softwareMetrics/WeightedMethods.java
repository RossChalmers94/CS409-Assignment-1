package softwareMetrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class WeightedMethods {
	
	private static final int WMC_LIMIT = 12;
	private static int methodCounter = 0;
	private static ArrayList<ClassOrInterfaceDeclaration> classValues = new ArrayList<ClassOrInterfaceDeclaration>();
	private static ArrayList<MethodDeclaration> methodValues = new ArrayList<MethodDeclaration>();
	private static HashMap<ClassOrInterfaceDeclaration, Integer> weightedMethods = new HashMap<ClassOrInterfaceDeclaration, Integer>();
	
	
    public WeightedMethods(ArrayList<ClassOrInterfaceDeclaration> classNames, ArrayList<MethodDeclaration> methods){
    	classValues = classNames;
    	methodValues = methods;
    }
    
	public void calculateWMC(){
		
		for(int i = 0; i < classValues.size(); i++){
			ClassOrInterfaceDeclaration c = classValues.get(i);
			String className = c.getName();
			for(MethodDeclaration m : methodValues){
				ClassOrInterfaceDeclaration parent = (ClassOrInterfaceDeclaration) m.getParentNode();
				if(parent.getName().equals(className)){
					methodCounter++;
				}
			}
			
			weightedMethods.put(c, methodCounter);
			methodCounter = 0;
		}
	}
		
		
	public void printResult(){
		
		for(int i = 0; i < weightedMethods.size(); i++){
			Object[] keys = weightedMethods.keySet().toArray();
			ClassOrInterfaceDeclaration classValue = (ClassOrInterfaceDeclaration) keys[i];
			String classname = classValue.getName();
			int methodCount = weightedMethods.get(classValue);
			
			if(!classValue.isInterface()){
				System.out.println("The class we are analyzing is " + classname + ".");
				System.out.println("This class has " + methodCount + " methods.");
				if(methodCount > WMC_LIMIT){
					System.out.println("Unfortunately, this class is over the recommeneded classes per method. "
							+ "The Developer should consider restructuring his/her code.\n");
				} else {
					System.out.println("This class is under or equal to the recommended classes per method, " 
							+ "Congratulations!\n");
				}
			}
		}
		
		weightedMethods.clear();
		methodCounter = 0;
	}

}