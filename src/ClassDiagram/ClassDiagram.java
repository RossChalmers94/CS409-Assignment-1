package ClassDiagram;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NamedNodeMap;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.ClassExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class ClassDiagram {
	
	private static final String PRIVATE_MODIFIER = "PRIVATE";
	private static final String PUBLIC_MODIFIER = "PUBLIC";
	private static ArrayList<String> classNames = new ArrayList<String>();
	private static ArrayList<FieldDeclaration> fields = new ArrayList<FieldDeclaration>(); 
	private static ArrayList<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
	
	
	
    public static void main(String[] args) throws Exception {
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream("JavaFilesNew/Test.java");

        CompilationUnit cu;
        try {
            // parse the file
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }

        // visit and print the methods names
        new ClassDiagramVisitor().visit(cu, null);
        ClassDiagramCreator diagram = new ClassDiagramCreator(classNames, fields, methods);
        diagram.classDiagramPrinter();
         
    }
    
    public static class ClassDiagramVisitor extends VoidVisitorAdapter {
    	
    	// Method to return Class Name, Inheritance & Interface.
    	public void visit(ClassOrInterfaceDeclaration c, Object arg){
    	
    		classNames.add(c.getName());
    		
    		super.visit(c, arg);

    	}
    	
    	//Method to return class fields with their types.
    	public void visit(FieldDeclaration f, Object arg){
    		
    	/*	ArrayList<String> fieldNames = new ArrayList<String>();
    		
    		List<VariableDeclarator> fieldName = f.getVariables();
    		for(VariableDeclarator var : fieldName){
    			fieldNames.add(var.getId().getName())
;    		}
*/			fields.add(f);
    		
    		super.visit(f, arg);

    	}
    	
    	// Method to return Method names, return type, parameter list
    	public void visit(MethodDeclaration m, Object arg){
    		
    		methods.add(m);
    		
    		
    		super.visit(m, arg);
    	}
    	
    }

}
