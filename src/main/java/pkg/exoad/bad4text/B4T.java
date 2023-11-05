package pkg.exoad.bad4text;

import pkg.exoad.bad4text.core.Console;
import pkg.exoad.bad4text.core.OutStream;
import pkg.exoad.bad4text.services.StructService;

import java.util.HashMap;
import java.util.Optional;

public class B4T
{
	public static final Console IO = new Console();

	private static final HashMap< String, Object > INTERNAL_PROPERTIES;

	static
	{
		INTERNAL_PROPERTIES = new HashMap<>();
		// io configurations
		INTERNAL_PROPERTIES.put(
				"io.useansi",
				true
		); // whether to use ANSI at all
		INTERNAL_PROPERTIES.put(
				"io.dumb_console_clear_nls",
				80
		); // the number of characters to print before clearing the console (this is the dumb method for clearing the console)
	}

	public static void setProperty(String key, Object value)
	{
		INTERNAL_PROPERTIES.put(
				key,
				value
		);
	}

	public static Object getProperty(String key)
	{
		return INTERNAL_PROPERTIES.get(key);
	}

	public static synchronized void armEngine()
	{
		IO.print(StructService.prettifyMap(INTERNAL_PROPERTIES) + "\n\n");
	}
}
