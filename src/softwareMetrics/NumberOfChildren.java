package softwareMetrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

public class NumberOfChildren {
	
	private static final int NOC_LIMIT = 2;
	private static ArrayList<ClassOrInterfaceDeclaration> classValues = new ArrayList<ClassOrInterfaceDeclaration>();
	private static ArrayList<String> baseClasses = new ArrayList<String>();
	
	
	
    public NumberOfChildren(ArrayList<ClassOrInterfaceDeclaration> classes){
    	classValues = classes;
    }
    
	public void setUp(){
		
		for(int i = 0; i < classValues.size(); i++){
			ClassOrInterfaceDeclaration c = classValues.get(i);
			String parentClass = "";
			List<ClassOrInterfaceType> inherits = c.getExtends();
			for(ClassOrInterfaceType inheritClass : inherits){
				parentClass = inheritClass.toString();
			}
			if(!parentClass.equals("")){
				baseClasses.add(parentClass);
			}
		}
		
		calculateNOC();
	
	}
		
		
	public void calculateNOC(){
		
		String className = "";
		for(int i = 0; i < baseClasses.size(); i++){
			int subClassCounter = 1;
			className = baseClasses.get(i);
			baseClasses.remove(i);
			for(int j = 0; j < baseClasses.size(); j++){
				String childClass = baseClasses.get(j);
				if (className.equals(childClass)){
					subClassCounter++;
					baseClasses.remove(j);
				}
			}
			
			System.out.println(tidyOutput(className, subClassCounter));
			
			i--;
		}
	
	}
	
	private String tidyOutput(String className, int subClassCounter){
		
		StringBuffer toReturn = new StringBuffer();
		toReturn.append("Class - " + className + ".\nChildren - " + subClassCounter + ".\n");
		if(subClassCounter > NOC_LIMIT){
			toReturn.append("This is above the recommended number of children. "
					+ "The Developer should restructure his/her code.\n");
		} else
		{
			toReturn.append("This is equal to or below the recommended number of children. Congratulations!\n");
		}
		
		return toReturn.toString();
		
	}

}
