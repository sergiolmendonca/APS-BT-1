package templateMethod;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
//		Utilizando Template Method, desenhe o diagrama de classes e implemente as classes Field e Form de modo que o c�digo funcione corretamente como no exemplo de execu��o.
//		Considere ainda que:
//		1) O set(String value) de um Field s� pode ocorrer se isValid(value) == true, caso contr�rio, InvalidValueException deve ser lan�ada.
//		2) O set(String value) de um Field deve utilizar convertFromString(value) para transformar a String value no tipo alvo.
//		3) O fill(Scanner in) de um Form deve perguntar, para cada Field field adicionado, um String value at� que ocorra field.set(value).
//
//		C�digo:
//		=======

		Form form = new Form();
		form.add(new Field<String>("Name")
		{	public boolean isValid(String value) { return(value.matches("[A-Z][a-z]+( [A-Z][a-z]+)+")); }
			public String convertFromString(String value) { return(value); }
		});
		form.add(new Field<String>("Gender")
		{	public boolean isValid(String value) { return(value.matches("[MF]")); }
			public String convertFromString(String value) { return(value); }
		});
		form.add(new Field<Integer>("Age")
		{	public boolean isValid(String value) { return(value.matches("[0-9]+")); }
			public Integer convertFromString(String value) { return(Integer.parseInt(value)); }
		});
		form.add(new Field<String>("CEP")
		{	public boolean isValid(String value) { return(value.matches("[0-9]{5}-[0-9]{3}")); }
			public String convertFromString(String value) { return (value); }
		});
		form.add(new Field<Double>("Payment")
		{	public boolean isValid(String value) { return(value.matches("[0-9]+\\.[0-9]{0,2}")); }
			public Double convertFromString(String value) { return(Double.parseDouble(value)); }
		});
		form.add(new Field<String>("CPF") 
		{	public boolean isValid(String value) { return value.matches("([0-9]{3}\\.){2}[0-9]{3}-[0-9]{2}");}
			public String convertFromString(String value) {return (value);}
		});
		form.add(new Field<LocalDate>("Birthdate")
		{	public boolean isValid(String value)
			{	//return(value.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"));
				try { return(LocalDate.parse(value) != null); }
				catch (Exception e) { return(false); }
			}
			public LocalDate convertFromString(String value) { return(LocalDate.parse(value)); }
		});
		form.add(new Field<String>("Email")
		{	public boolean isValid(String value) { return(value.matches("[a-z]+@[a-z]+\\.(com|edu|mil|gov|org)(\\.[a-z]{2})?")); }
			public String convertFromString(String value) { return(value); }
		});
		form.fill(new Scanner(System.in));
		try {
			System.out.println("Hello "+(("M".equals(form.get(1).getValue()))?"Sr":"Ms")+". "+form.get("Name").getValue()+"!");
			System.out.println("You born in "+form.get(6).getValue().toString()+" and are "+form.get(2).getValue().toString()+" years old.");
			System.out.println("With a 10% up, your payment will be $"+String.format("%.02f",(Double)form.get("Payment").getValue()*1.1)+".");
		}catch(FieldNotFoundException e) {
			System.out.println(e);
		}
		

//		Exemplo de execu��o:
//		====================

//		Name: xxxxx
//		Re-enter Name: abc def
//		Re-enter Name: Abc Def
//		Gender: x
//		Re-enter Gender: m
//		Re-enter Gender: M
//		Age: abc
//		Re-enter Age: 
//		Re-enter Age: 19
//		Payment: abc
//		Re-enter Payment: 123
//		Re-enter Payment: 123.45
//		Birthdate: abc
//		Re-enter Birthdate: 2000
//		Re-enter Birthdate: 2000-10
//		Re-enter Birthdate: 2000-10-99
//		Re-enter Birthdate: 2000-10-15
//		Email: abc
//		Re-enter Email: abc@def.com.br
//		Hello Sr. Abc Def!
//		You born in 2000-10-15 and are 19 years old.
//		With a 10% up, your payment will be $135,80.


	}

}
