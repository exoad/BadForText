package tests;
import java.util.function.Supplier;
public record TestCase < T >(Supplier< T > value, T expected)
{

	public boolean assertEq()
	{
		return value.get().equals(expected);
	}
}
