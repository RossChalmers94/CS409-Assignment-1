package SoftwareMetrics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.ClassExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class MetricsCreator {

	private static ArrayList<File> filesForUse = new ArrayList<File>();
	private static ArrayList<ClassOrInterfaceDeclaration> classes = new ArrayList<ClassOrInterfaceDeclaration>();
	private static ArrayList<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
	

	public static void setUpCompilationUnit(ArrayList<File> files, int metric) throws Exception {
		// creates an input stream for the file to be parsed
		
		filesForUse = files;
		System.out.println(filesForUse);
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
		new MetricsVisitor().visit(cu, null);
		
		if(metric == 1){
			WeightedMethods wmc = new WeightedMethods(classes, methods);
			wmc.calculateWMC();
			wmc.printResult();
		}
		
		if(metric == 2){
			DepthOfInheritance dit = new DepthOfInheritance(classes);
			dit.calculateDIT();
			dit.printResult();
		}
		
		classes.clear();
		methods.clear();
		
		}

	}

	public static class MetricsVisitor extends VoidVisitorAdapter {

		public void visit(ClassOrInterfaceDeclaration c, Object arg) {

			classes.add(c);

			super.visit(c, arg);
		}

		public void visit(MethodDeclaration m, Object arg) {

			methods.add(m);

			super.visit(m, arg);
		}

	}

}
