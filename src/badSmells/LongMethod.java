package badSmells;

import java.util.ArrayList;

import com.github.javaparser.Position;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class LongMethod {
	
	private static final int METHOD_LINE_LIMIT = 10;
	private static ArrayList<ClassOrInterfaceDeclaration> classValues = new ArrayList<ClassOrInterfaceDeclaration>();
	private static ArrayList<MethodDeclaration> methodValues = new ArrayList<MethodDeclaration>();
	private static ArrayList<String> methodsOverLimit = new ArrayList<String>();
	
	public LongMethod(ArrayList<ClassOrInterfaceDeclaration> classes, ArrayList<MethodDeclaration> methods){
		classValues = classes;
		methodValues = methods;
	}
	
	public void calculateLineCount(){
		
		for(int i = 0; i < classValues.size(); i++){
			if(!classValues.get(i).isInterface()){
			for(int j = 0; j < methodValues.size(); j++){
				MethodDeclaration m = methodValues.get(j);
				ClassOrInterfaceDeclaration c = (ClassOrInterfaceDeclaration) m.getParentNode();
				if(c.equals(classValues.get(i))){
					int methodLineCount = m.getEnd().line - m.getBegin().line; 
					if(methodLineCount > METHOD_LINE_LIMIT){
						methodsOverLimit.add(m.getName());
					}
				}
			}
			
			printResult(classValues.get(i));
			methodsOverLimit.clear();
		}
		}
		
	}
	
	public void printResult(ClassOrInterfaceDeclaration c){
		
		
		System.out.println("The class we are analyzing is " + c.getName().toString());
		if(methodsOverLimit.size()>0){
			System.out.println("The methods that exceed the method line count of " + METHOD_LINE_LIMIT + " are: ");
			for(String method : methodsOverLimit){
				System.out.print(method + " ");
			}
		}
		else {
			System.out.println("No methods in this class exceed the method line count");
		}
		System.out.println("\n");
		
	}
	
	

}
