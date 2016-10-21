package SoftwareMetrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

public class DepthOfInheritance {

	private static final int DIT_LIMIT = 2;
	private static int inheritanceDepthCounter = 1;
	private static ArrayList<ClassOrInterfaceDeclaration> classValues = new ArrayList<ClassOrInterfaceDeclaration>();
	private static HashMap<String, String> inheritanceDepth = new HashMap<String, String>();
	
	
	
    public DepthOfInheritance(ArrayList<ClassOrInterfaceDeclaration> classNames){
    	classValues = classNames;
    }
    
	public void calculateDIT(){
		
		for(int i = 0; i < classValues.size(); i++){
			ClassOrInterfaceDeclaration c = classValues.get(i);
			String className = c.getName();
			String parentClass = "";
			List<ClassOrInterfaceType> inherits = c.getExtends();
			for(ClassOrInterfaceType inheritClass : inherits){
				parentClass = inheritClass.toString();
			}
			
			inheritanceDepth.put(className, parentClass);
		}
	
	}
		
		
	public void printResult(){
		for(int i = 0; i < classValues.size(); i++){
			ClassOrInterfaceDeclaration c = classValues.get(i);
			String className = c.getName();
			if(!inheritanceDepth.get(className).equals("")){
				String parentClass = inheritanceDepth.get(className);
				inheritanceDepthCounter++;
				for(int j = 0; j < inheritanceDepth.size(); j++){
					if(inheritanceDepth.get(parentClass) != null){
						inheritanceDepthCounter++;
						break;
					}
				}
			} else
			{
				inheritanceDepthCounter = 1;
			}
			
			System.out.println("The class " + className + " has a Depth of Inheritance of " + inheritanceDepthCounter + ".");
			if(inheritanceDepthCounter > DIT_LIMIT){
				System.out.println("This is above the recommended depth. The Developer should restructure his/her code.\n");
			} else
			{
				System.out.println("This is equal to or below the recommended depth. Congratulations!\n");
			}
			inheritanceDepthCounter = 1;
		}
		
		classValues.clear();
	}

}
