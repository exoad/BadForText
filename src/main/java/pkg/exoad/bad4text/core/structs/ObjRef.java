package pkg.exoad.bad4text.core.structs;

/**
 * 主要用于绕过 Java 对于 Lambda 表达式中 final 变量的限制。
 *
 * @param <T> 载荷的类型。
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
