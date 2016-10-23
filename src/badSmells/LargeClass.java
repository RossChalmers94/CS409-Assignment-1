package badSmells;

import java.util.ArrayList;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class LargeClass {
	
	private static final int CLASS_SIZE = 10;
	private static ArrayList<ClassOrInterfaceDeclaration> classValues = new ArrayList<ClassOrInterfaceDeclaration>();
	private static ArrayList<MethodDeclaration> methodValues = new ArrayList<MethodDeclaration>();
	private static ArrayList<FieldDeclaration> fieldValues = new ArrayList<FieldDeclaration>();
	
	public LargeClass(ArrayList<ClassOrInterfaceDeclaration> classes, ArrayList<FieldDeclaration> fields,
	ArrayList<MethodDeclaration> methods){
		classValues = classes;
		methodValues = methods;
		fieldValues = fields;
	}
	
	public void calculateClassSize(){
		
		for(int i = 0; i < classValues.size(); i++){
			if(!classValues.get(i).isInterface()){
				int methodSizeCounter = 0;
				for(int j = 0; j < methodValues.size(); j++){
					MethodDeclaration m = methodValues.get(j);
					ClassOrInterfaceDeclaration c = (ClassOrInterfaceDeclaration) m.getParentNode();
					if(c.equals(classValues.get(i))){
						methodSizeCounter++;
					}
				}
				int fieldSizeCounter = 0;
				for(int j = 0; j < fieldValues.size(); j++){
					FieldDeclaration f = fieldValues.get(j);
					ClassOrInterfaceDeclaration c = (ClassOrInterfaceDeclaration) f.getParentNode();
					if(c.equals(classValues.get(i))){
						fieldSizeCounter++;
					}
				}
			
				printResult(classValues.get(i),methodSizeCounter,fieldSizeCounter);
			}
			
		}
		
		classValues.clear();
		methodValues.clear();
		fieldValues.clear();
		
	}
	
	public void printResult(ClassOrInterfaceDeclaration c, int methodCount, int fieldCount){
		
		
		System.out.println("The class we are analyzing is " + c.getName().toString());
		System.out.println("This class has " + fieldCount + " fields.");
		System.out.println("This class has " + methodCount + " methods.");
		if((fieldCount + methodCount) > CLASS_SIZE){
			System.out.print("The size of this class exceeds the recommended class size.\nThe Developer should restructure his"
					+ "/her code.");
		} else{
			System.out.print("The size of this class is under or equal to the recommended class size.\nCongratulations!");
		}
		
		System.out.println("\n");
		
		
	}

}
