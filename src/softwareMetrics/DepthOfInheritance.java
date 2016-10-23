package softwareMetrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

public class DepthOfInheritance {

	private static final int DIT_LIMIT = 2;
	private static ArrayList<ClassOrInterfaceDeclaration> classValues = new ArrayList<ClassOrInterfaceDeclaration>();
	private static HashMap<String, String> inheritanceDepth = new HashMap<String, String>();
	
	
	
    public DepthOfInheritance(ArrayList<ClassOrInterfaceDeclaration> classNames){
    	classValues = classNames;
    }
    
	public void setUp(){
		
		for(int i = 0; i < classValues.size(); i++){
			ClassOrInterfaceDeclaration c = classValues.get(i);
			String className = c.getName();
			String parentClass = "";
			List<ClassOrInterfaceType> inherits = c.getExtends();
			for(ClassOrInterfaceType inheritClass : inherits){
				parentClass = inheritClass.toString();
			}
			if(!parentClass.isEmpty()){
				inheritanceDepth.put(className, parentClass);
			} else
			{
				inheritanceDepth.put(className, " ");
			}
		}

		calculateDIT();
	
	}
		
		
	public void calculateDIT(){
		for(int i = 0; i < classValues.size(); i++){
			int inheritanceDepthCounter = 1;
			ClassOrInterfaceDeclaration c = classValues.get(i);
			String className = c.getName();
			if(!inheritanceDepth.get(className).equals(" ")){
				String parentClass = inheritanceDepth.get(className);
				inheritanceDepthCounter++;
				for(int j = 0; j < inheritanceDepth.size(); j++){
					if(!inheritanceDepth.get(parentClass).equals(" ")){
						inheritanceDepthCounter++;
					}
				}
			} else
			{
				inheritanceDepthCounter = 1;
			}
			
			System.out.println(tidyOutput(className, inheritanceDepthCounter));
		}
		
		classValues.clear();
	}
	
	private String tidyOutput(String classname, int inheritance){
		
		StringBuffer toReturn = new StringBuffer();
		toReturn.append("The class " + classname + " has a Depth of Inheritance of " + inheritance + ".\n");
		if(inheritance > DIT_LIMIT){
			toReturn.append("This is above the recommended depth. The Developer should restructure his/her code.\n");
		} else
		{
			toReturn.append("This is equal to or below the recommended depth. Congratulations!\n");
		}
		
		return toReturn.toString();
	}

}
