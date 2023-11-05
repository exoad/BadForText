package pkg.exoad.bad4text.services;
import java.util.Map;
public final class StructService
{
	private StructService()
	{}

	public static String prettifyMap(Map<?,?> map)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		for (Map.Entry<?,?> entry : map.entrySet())
		{
			sb.append("\t");
			sb.append(entry.getKey());
			sb.append(" : ");
			sb.append(entry.getValue());
			sb.append("\n");
		}
		sb.append("}");
		return sb.toString();
	}
}
