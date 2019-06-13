package templateMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class Form {

	protected List<Field<?>> fields = new ArrayList<Field<?>>();
	
	public Form() {
		
	}
	
	public void add(Field<?> field) {
		this.fields.add(field);
	}
	
	public Field<?> get(int index){
		return this.fields.get(index);
	}
	
	public Field<?> get(String name) throws FieldNotFoundException{
		return this.fields
				.stream()
				.filter(n -> name.equals(n.getName()))
					.findFirst()
					.orElseThrow(() ->new FieldNotFoundException("Field " + name + " Not Found!"));
	}
	
	public void fill(Scanner scan) {
		for(Field<?> item : fields) {
			System.out.print(item.getName() + ": ");
			while(!item.setValue(scan.nextLine())) {
				System.out.print("Re-Enter " + item.getName() + ": ");
			}
			System.out.println(item.getValue());
		}
	}
	

}
