package pkg.exoad.bad4text.debug;
import java.util.Collection;
public final class Code
{
	private Code() {}

	public static String referenceFx(String name, String... params)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("++ ")
		  .append(name)
		  .append("[")
		  .append(params.length)
		  .append("]:: ");
		for (String e : params)
			sb.append("\n\t\t\t\t++ ")
			  .append(e);

		return sb.toString();
	}

	public static < T > String nullableObj(T ref)
	{
		return ref == null ? "null" : ref.toString();
	}

	public static String formatCollection(Collection< ? > collection)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\n\t\t\t\t++ ")
		  .append(collection.getClass()
		                    .getCanonicalName())
		  .append("[")
		  .append(collection.size())
		  .append("]:: ");
		for (Object e : collection)
			sb.append("\n\t\t\t\t\t++ ")
			  .append(e);

		return sb.toString();
	}
}
