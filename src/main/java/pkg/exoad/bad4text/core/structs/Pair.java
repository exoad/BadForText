package pkg.exoad.bad4text.core.structs;
import pkg.exoad.bad4text.debug.Code;
public class Pair < A, B >
{
	public A first;
	public B second;

	public static < T, V > Pair< T, V > make(T first, V second)
	{
		return new Pair<>(
				first,
				second
		);
	}

	public Pair(A first, B second)
	{
		this.first = first;
		this.second = second;
	}

	public A getFirst()
	{
		return first;
	}

	public B getSecond()
	{
		return second;
	}

	public void setFirst(A first)
	{
		this.first = first;
	}

	public void setSecond(B second)
	{
		this.second = second;
	}

	@Override public String toString()
	{
		return "@Pair::[\n\t" + Code.nullableObj(first) + ",\n\t" + Code.nullableObj(second) + " \n]";
	}
}
