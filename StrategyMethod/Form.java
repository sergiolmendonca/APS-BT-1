import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Form {
	
	protected List<StrategyField> fields = new ArrayList<StrategyField>();

	public Form() {

	}

	public void add(StrategyField field) {
		this.fields.add(field);
	}

	public StrategyField get(int index) {
		return this.fields.get(index);
	}

	public StrategyField get(String name) {
		return this.fields.stream().filter(n -> name.equals(n.getName())).findFirst().orElse(null);
	}

	public void fill(Scanner scan) {
		for (StrategyField item : fields) {
			System.out.print(item.getName() + ": ");
			while (!item.setValue(scan.nextLine())) {
				System.out.print("Re-Enter " + item.getName() + ": ");
			}
			System.out.println(item.getValue());
		}
	}
}
