package SoftwareMetrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

public class NumberOfChildren {
	
	private static final int NOC_LIMIT = 2;
	private static ArrayList<ClassOrInterfaceDeclaration> classValues = new ArrayList<ClassOrInterfaceDeclaration>();
	private static HashMap<String, String> baseClass = new HashMap<String, String>();
	private static ArrayList<String> baseClasses = new ArrayList<String>();
	
	
	
    public NumberOfChildren(ArrayList<ClassOrInterfaceDeclaration> classes){
    	classValues = classes;
    }
    
	public void calculateNOC(){
		
		for(int i = 0; i < classValues.size(); i++){
			ClassOrInterfaceDeclaration c = classValues.get(i);
			String className = c.getName();
			String parentClass = "";
			List<ClassOrInterfaceType> inherits = c.getExtends();
			for(ClassOrInterfaceType inheritClass : inherits){
				parentClass = inheritClass.toString();
			}
			
			baseClass.put(className, parentClass);
			baseClasses.add(parentClass);
		}
	
	}
		
		
	public void printResult(){
		
		for(int i = 0; i < baseClasses.size(); i++){
			int subClassCounter = 0;
			String baseClass = baseClasses.get(i);
			for(int j = 0; j < baseClasses.size(); j++){
				ClassOrInterfaceDeclaration c = classValues.get(j);
				if(c.getExtends().contains(baseClass)){
					subClassCounter++;
				}
			}
			
			System.out.println("The class " + baseClass + " has " + subClassCounter + " children.");
			if(subClassCounter > NOC_LIMIT){
				System.out.println("This is above the recommended number of children. "
						+ "The Developer should restructure his/her code.\n");
			} else
			{
				System.out.println("This is equal to or below the recommended number of children. Congratulations!\n");
			}
		}
	}

}
