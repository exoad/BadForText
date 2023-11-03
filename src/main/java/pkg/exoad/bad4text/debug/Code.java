package pkg.exoad.bad4text.debug;
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
}
