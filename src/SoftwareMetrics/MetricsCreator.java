package SoftwareMetrics;

import java.io.FileInputStream;
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

	private static ArrayList<ClassOrInterfaceDeclaration> classes = new ArrayList<ClassOrInterfaceDeclaration>();
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
		new MetricsVisitor().visit(cu, null);
		
		Boolean stop = false;
		while(!stop){

		System.out.println("Type the number of the Metric you would like to run.");
		System.out.println("1. WMC?");
		System.out.println("2. DIT?");

		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		if (input.equals("1")) {
			WeightedMethods wmc = new WeightedMethods(classes, methods);
			wmc.calculateWMC();
			wmc.printResult();
		} else if (input.equals("2")) {
			DepthOfInheritance dit = new DepthOfInheritance(classes);
			dit.calculateDIT();
			dit.printResult();
		} else if(input.toLowerCase().equals("q")){
			System.out.println("Bye!");
			break;
		}else {
			System.out.println("Enter your number only please.");
		}
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
