package classDiagram;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;


import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


public class ClassDiagram {
	
	private static ArrayList<ClassOrInterfaceDeclaration> classes = new ArrayList<ClassOrInterfaceDeclaration>();
	private static ArrayList<FieldDeclaration> fields = new ArrayList<FieldDeclaration>(); 
	private static ArrayList<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
	private static ArrayList<File> filesForUse = new ArrayList<File>();
	
	
	
    public static void setUpCompilationUnit(ArrayList<File> files) throws Exception {
    	
    	filesForUse = files;
		for(File file : filesForUse){
		FileInputStream in = new FileInputStream(file);
		CompilationUnit cu;
        try {
            // parse the file
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }

        // visit and print the methods names
        new ClassDiagramVisitor().visit(cu, null);
		}
		
        ClassDiagramCreator diagram = new ClassDiagramCreator(classes, fields, methods);
        diagram.classDiagramPrinter();
        
         
    }
    
    public static class ClassDiagramVisitor extends VoidVisitorAdapter<Object> {
    	
  
    	public void visit(ClassOrInterfaceDeclaration c, Object arg){
    	
    		classes.add(c);
    		
    		super.visit(c, arg);

    	}
    	

    	public void visit(FieldDeclaration f, Object arg){
    		
    		fields.add(f);
    		
    		super.visit(f, arg);

    	}
    	

    	public void visit(MethodDeclaration m, Object arg){
    		
    		methods.add(m);
    		
    		
    		super.visit(m, arg);
    	}
    	
    }

}
