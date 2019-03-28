import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Form form = new Form();
		form.add(new Name());
		form.add(new Gender());
		form.add(new Age());
		form.add(new Payment());
		form.add(new Birthdate());
		form.add(new Email());
		form.fill(new Scanner(System.in));
		System.out.println("Hello "+(("M".equals(form.get(1).getValue()))?"Sr":"Ms")+". "+form.get("Name").getValue()+"!");
		System.out.println("You born in "+form.get(4).getValue().toString()+" and are "+form.get(2).getValue().toString()+" years old.");
		System.out.println("With a 10% up, your payment will be $"+String.format("%.02f",(Double)form.get("Payment").getValue()*1.1)+".");

	}

}
