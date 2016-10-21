package ClassDiagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;

public class ClassDiagramCreator {
	
	private static final String PRIVATE_MODIFIER = "PRIVATE";
	private static final String PUBLIC_MODIFIER = "PUBLIC";
	private ArrayList<String> classNames = new ArrayList<String>();
	private ArrayList<FieldDeclaration> fields = new ArrayList<FieldDeclaration>(); 
	private ArrayList<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
	
	public ClassDiagramCreator(ArrayList<String> classValues, ArrayList<FieldDeclaration> fieldValues, 
			ArrayList<MethodDeclaration> methodValues){
		classNames = classValues;
		fields = fieldValues;
		methods = methodValues;
	}
	
	public void classDiagramPrinter(){
		
		for(int i = 0; i < classNames.size(); i++){
			
			Boolean emptyFields = true;
			
			System.out.println(classNames.get(i));
			System.out.println("---------------------------");
			
			for(FieldDeclaration f : fields){
				ClassOrInterfaceDeclaration c = (ClassOrInterfaceDeclaration) f.getParentNode();
				if(c.getName().equals(classNames.get(i))){
					emptyFields = false;
					for(Modifier m : f.getModifiers())
					{
						if(m.toString().equals(PRIVATE_MODIFIER)){
							System.out.print("- ");
						} else if(m.toString().equals(PUBLIC_MODIFIER)){
							System.out.print("+ ");
						} else {
							System.out.print("# ");
						}
						
					}

					List<VariableDeclarator> fieldNames = f.getVariables();
					for(int j = 0; j < fieldNames.size(); j++){
						if(j == fieldNames.size()-1){
							System.out.print(fieldNames.get(j));
						}
						else
						{
							System.out.print(fieldNames.get(j) + ", ");
						}
					}
					System.out.print(" : ");
					System.out.print(f.getElementType().toString() + "\n");
				}
			}
			if(emptyFields == false){
				System.out.println("---------------------------");
			}
			
			
			for(MethodDeclaration m : methods){
				ClassOrInterfaceDeclaration c = (ClassOrInterfaceDeclaration) m.getParentNode();
				if(c.getName().equals(classNames.get(i))){
					for(Modifier mod : m.getModifiers())
					{
						if(mod.toString().equals(PRIVATE_MODIFIER)){
							System.out.print("- ");
						} else if(mod.toString().equals(PUBLIC_MODIFIER)){
							System.out.print("+ ");
						} else {
							System.out.print("# ");
						}
						
					}

					System.out.print(m.getName());
					System.out.print(" : ");
					System.out.print(m.getElementType().toString());
					System.out.print(" (");
					for(int j = 0; j < m.getParameters().size(); j++){
						Parameter p = m.getParameters().get(j);
						if(j == m.getParameters().size()-1){
							System.out.print(p.getName() + ": " + p.getElementType());
						}
						else {
							System.out.print(p.getName() + ": " + p.getElementType() + ", ");
						}
					}
					System.out.print(")\n");
				}
			}
			
			System.out.println("---------------------------");
			
			
		}
	}

}
