package pkg.exoad.bad4text.core.structs;

/**
 * Primarily for getting around Java restrictions on finalized variables in lambdas.
 *
 * @param <T> The type of the payload.
 * @author Jack Meng
 */
public class ObjRef < T >
{
	public T payload;

	public ObjRef(T payload)
	{
		this.payload = payload;
	}

	public T get()
	{
		return payload;
	}

	public void set(T payload)
	{
		this.payload = payload;
	}
}
