package pkg.exoad.bad4text.services;

import java.util.Map;

/**
 * 结构服务类，提供关于数据结构的方法和功能。
 */
public final class StructService
{
	private StructService()
	{}

	/**
	 * 格式化输出 Map 对象的内容，使其更易读。
	 *
	 * @param map 要格式化的 Map 对象。
	 * @return 格式化后的字符串表示。
	 */
	public static String prettifyMap(Map< ?, ? > map)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		for (Map.Entry< ?, ? > entry : map.entrySet())
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
