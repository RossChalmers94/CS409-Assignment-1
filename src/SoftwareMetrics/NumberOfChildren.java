package SoftwareMetrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

public class NumberOfChildren {
	
	private static final int DIT_LIMIT = 2;
	private static int subClassCounter = 1;
	private static ArrayList<ClassOrInterfaceDeclaration> classValues = new ArrayList<ClassOrInterfaceDeclaration>();
	private static HashMap<String, String> baseClass = new HashMap<String, String>();
	private static ArrayList<String> baseClasses = new ArrayList<String>();
	
	
	
    public NumberOfChildren(ArrayList<ClassOrInterfaceDeclaration> classNames){
    	classValues = classNames;
    	calculateNOC();
    	printResult();
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
			String baseClass = baseClasses.get(i);
			for(int j = 0; j < baseClasses.size(); j++){
				
			}
		}
	}

}
