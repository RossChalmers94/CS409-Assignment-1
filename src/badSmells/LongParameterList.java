package badSmells;

import java.util.ArrayList;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;

public class LongParameterList {
	
	private static final int PARAMETER_LIMIT = 2;
	private int parameterSizeCounter = 0;
	private static ArrayList<ClassOrInterfaceDeclaration> classValues = new ArrayList<ClassOrInterfaceDeclaration>();
	private static ArrayList<MethodDeclaration> methodValues = new ArrayList<MethodDeclaration>();
	
	public LongParameterList(ArrayList<ClassOrInterfaceDeclaration> classes, ArrayList<MethodDeclaration> methods){
		classValues = classes;
		methodValues = methods;
	}
	
	public void calculateParameterSize(){
		
		for(int i = 0; i < classValues.size(); i++){
			if(!classValues.get(i).isInterface()){
				System.out.println("The class we are analyzing is " + classValues.get(i).getName() +".");
				System.out.println("Methods with at least one method will be shown in the results.\n");
				for(int j = 0; j < methodValues.size(); j++){
					MethodDeclaration m = methodValues.get(j);
					ClassOrInterfaceDeclaration c = (ClassOrInterfaceDeclaration) m.getParentNode();
					if(c.equals(classValues.get(i))){
						parameterSizeCounter = m.getParameters().size();
					}
					
					if(parameterSizeCounter != 0){
						printResult(m);
					}
					
					parameterSizeCounter = 0;
				}
				System.out.println("------------------------");
			}
			
			
		}
		
	}
	
	public void printResult(MethodDeclaration m){
		
		
		System.out.println("The method we are analyzing is " + m.getName().toString() + ". This method has " + parameterSizeCounter 
				+ " parameter(s).");
		if(parameterSizeCounter > PARAMETER_LIMIT){
			System.out.print("This method has too many parameters.\nThe Developer should restructure his/her code.");
		} else{
			System.out.print("There are no issues with the parameters given in this method.");
		}
		
		System.out.println("\n");
		
		
	}


}
