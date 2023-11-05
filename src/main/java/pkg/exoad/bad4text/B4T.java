package pkg.exoad.bad4text;

import pkg.exoad.bad4text.core.Console;
import pkg.exoad.bad4text.services.StructService;

import java.util.HashMap;

/**
 * B4T 主类，用于控制台输入输出和属性设置。
 */
public class B4T
{
	public static final Console IO = new Console();

	private static final HashMap< String, Object > INTERNAL_PROPERTIES;

	static
	{
		INTERNAL_PROPERTIES = new HashMap<>();
		// 输入输出配置
		INTERNAL_PROPERTIES.put(
				"io.useansi",
				true
		); // 使用 ANSI
		INTERNAL_PROPERTIES.put(
				"io.dumb_console_clear_nls",
				80
		); // 在清空控制台之前打印的字符数（这是清空控制台的简单方法）
	}

	/**
	 * 设置属性的键值对。
	 *
	 * @param key   属性键。
	 * @param value 属性值。
	 */
	public static void setProperty(String key, Object value)
	{
		INTERNAL_PROPERTIES.put(
				key,
				value
		);
	}

	/**
	 * 获取指定属性的值。
	 *
	 * @param key 属性键。
	 * @return 属性对应的值。
	 */
	public static Object getProperty(String key)
	{
		return INTERNAL_PROPERTIES.get(key);
	}

	/**
	 * 启动 B4T 引擎并打印内部属性配置。
	 */
	public static synchronized void armEngine()
	{
		IO.print(StructService.prettifyMap(INTERNAL_PROPERTIES) + "\n\n");
	}
}
