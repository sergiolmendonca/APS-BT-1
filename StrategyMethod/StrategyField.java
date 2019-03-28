
public interface StrategyField<T> {
	public T getValue();
	public boolean setValue(String value);
	public String getName();
	public boolean isValid(String value);
	public T convertFromString(String value);
}
