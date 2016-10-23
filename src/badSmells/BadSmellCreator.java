package badSmells;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class BadSmellCreator {
	
	private static ArrayList<File> filesForUse = new ArrayList<File>();
	private static ArrayList<ClassOrInterfaceDeclaration> classes = new ArrayList<ClassOrInterfaceDeclaration>();
	private static ArrayList<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
	private static ArrayList<FieldDeclaration> fields = new ArrayList<FieldDeclaration>();
	

	public static void setUpCompilationUnit(ArrayList<File> files, int bloater) throws Exception {
		// creates an input stream for the file to be parsed
		
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
		new BloatersVisitor().visit(cu, null);
				
		}
		
		if(bloater == 1){
			LongMethod longMethod = new LongMethod(classes, methods);
			longMethod.calculateLineCount();
		} else if(bloater == 2){
			LargeClass largeClass = new LargeClass(classes, fields, methods);
			largeClass.calculateClassSize();
		} else if(bloater == 3){
			LongParameterList parameterList = new LongParameterList(classes, methods);
			parameterList.calculateParameterSize();
		}
		

	}

	public static class BloatersVisitor extends VoidVisitorAdapter {

		public void visit(ClassOrInterfaceDeclaration c, Object arg) {

			classes.add(c);

			super.visit(c, arg);
		}
		
		public void visit(FieldDeclaration f, Object arg){
			
			fields.add(f);
			
			super.visit(f, arg);
		}

		public void visit(MethodDeclaration m, Object arg) {

			methods.add(m);

			super.visit(m, arg);
		}

	}

}
