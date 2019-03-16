package templateMethod;

public abstract class Field<T> {

	private String name;
	private T value;

	public Field(String name) {
		this.name = name;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public boolean setValue(String value) {
		if(this.isValid(value)) {
			this.value = this.convertFromString(value);
			return true;
		}
		return false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public abstract boolean isValid(String value);
	
	public abstract T convertFromString(String value);
	
	
}
