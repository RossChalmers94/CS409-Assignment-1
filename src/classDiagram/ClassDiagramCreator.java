package classDiagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

public class ClassDiagramCreator {
	
	private static final String PRIVATE_MODIFIER = "PRIVATE";
	private static final String PUBLIC_MODIFIER = "PUBLIC";
	private ArrayList<ClassOrInterfaceDeclaration> classes = new ArrayList<ClassOrInterfaceDeclaration>();
	private ArrayList<FieldDeclaration> fields = new ArrayList<FieldDeclaration>(); 
	private ArrayList<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
	
	public ClassDiagramCreator(ArrayList<ClassOrInterfaceDeclaration> classValues, ArrayList<FieldDeclaration> fieldValues, 
			ArrayList<MethodDeclaration> methodValues){
		classes = classValues;
		fields = fieldValues;
		methods = methodValues;
	}
	
	public void classDiagramPrinter(){
		
		for(int i = 0; i < classes.size(); i++){
			
			Boolean emptyFields = true;
			
			System.out.println(getClassAttributes(classes.get(i)));
			System.out.println("---------------------------");
			
			for(FieldDeclaration f : fields){
				ClassOrInterfaceDeclaration c = (ClassOrInterfaceDeclaration) f.getParentNode();
				if(c.getName().equals(classes.get(i).getName())){
					emptyFields = false;
					System.out.println(getFieldAttributes(classes.get(i), f));
			}
			}
				
			if(emptyFields == false){
				System.out.println("---------------------------");
			}
			
			
			for(MethodDeclaration m : methods){
				ClassOrInterfaceDeclaration c = (ClassOrInterfaceDeclaration) m.getParentNode();
				if(c.getName().equals(classes.get(i).getName())){
					System.out.println(getMethodAttributes(classes.get(i), m));
				}
			}
			
			System.out.println("---------------------------");
			
			System.out.println(getClassRelationships(classes.get(i)));
			
			System.out.println("---------------------------");
			
			}
		
		
		
	}
	
	private String getClassAttributes(ClassOrInterfaceDeclaration c){
		
		String className = c.getName();
		if(c.isInterface()){
			return className + " - Interface";
		}
		else
		{
			return className;
		}
		
	}
	
	private String getFieldAttributes(ClassOrInterfaceDeclaration c, FieldDeclaration f){
		
			StringBuffer toReturn = new StringBuffer();
		
				for(Modifier m : f.getModifiers())
				{
					if(m.toString().equals(PRIVATE_MODIFIER)){
						toReturn.append("- ");
					} else if(m.toString().equals(PUBLIC_MODIFIER)){
						toReturn.append("+ ");
					} else {
						toReturn.append("# ");
					}
					
				}

				List<VariableDeclarator> fieldNames = f.getVariables();
				for(int j = 0; j < fieldNames.size(); j++){
					if(j == fieldNames.size()-1){
						toReturn.append(fieldNames.get(j));
					}
					else
					{
						toReturn.append(fieldNames.get(j) + ", ");
					}
				}
				toReturn.append(" : ");
				toReturn.append(f.getElementType().toString());
				
				return toReturn.toString();
			}
	
	private String getMethodAttributes(ClassOrInterfaceDeclaration c, MethodDeclaration m){
		
		StringBuffer toReturn = new StringBuffer();
		
		for(Modifier mod : m.getModifiers())
		{
			if(mod.toString().equals(PRIVATE_MODIFIER)){
				toReturn.append("- ");
			} else if(mod.toString().equals(PUBLIC_MODIFIER)){
				toReturn.append("+ ");
			} else {
				toReturn.append("# ");
			}
			
		}

		toReturn.append(m.getName() + " : " + m.getElementType().toString());
		if(m.getParameters().size() != 0){
			toReturn.append(" (");
			for(int j = 0; j < m.getParameters().size(); j++){
				Parameter p = m.getParameters().get(j);
				if(j == m.getParameters().size()-1){
					toReturn.append(p.getName() + ": " + p.getElementType());
				}
				else {
					toReturn.append(p.getName() + ": " + p.getElementType() + ", ");
				}
			}
			toReturn.append(")");
		}
		
		return toReturn.toString();
	}
	
	private String getClassRelationships(ClassOrInterfaceDeclaration c){
		
		StringBuffer toReturn = new StringBuffer();
		String parent = "N/A";
		String inherits = "N/A";
		
		for(ClassOrInterfaceType parentValue : c.getImplements()){
			parent = parentValue.getName().toString();
		}
		
		for(ClassOrInterfaceType inherit : c.getExtends()){
			inherits = inherit.getName().toString();
		}
		
		toReturn.append("Generalisation : " + parent + "\nRealisation : " + inherits);
		
		return toReturn.toString();
		
		
	}
	
			
		
	

}
