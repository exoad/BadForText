package pkg.exoad.bad4text.services;
import pkg.exoad.bad4text.debug.B4T_Exception;

import java.io.IOException;

/**
 * 平台服务类，提供有关操作系统平台信息的方法和功能。
 */
public final class PlatformService
{
	private PlatformService()
	{}

	/**
	 * 操作系统平台名称枚举。
	 */
	public enum PlatformName
	{
		WINDOWS,
		LINUX,
		MACOS,
		UNKNOWN
	}

	/**
	 * 获取当前操作系统平台名称。
	 *
	 * @return 当前操作系统平台名称。
	 */
	public static PlatformName getPlatformName()
	{
		String osName = System.getProperty("os.name")
		                      .toLowerCase();
		if (osName.contains("win"))
			return PlatformName.WINDOWS;
		else
			if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix"))
				return PlatformName.LINUX;
			else
				if (osName.contains("mac"))
					return PlatformName.MACOS;
				else
					return PlatformName.UNKNOWN;
	}

	/**
	 * 检查当前平台是否为Linux。
	 *
	 * @return 如果当前平台为Linux，则返回 true，否则返回 false。
	 */
	public static boolean isLinux()
	{
		return getPlatformName() == PlatformName.LINUX;
	}

	/**
	 * 检查当前平台是否为Windows。
	 *
	 * @return 如果当前平台为Windows，则返回 true，否则返回 false。
	 */
	public static boolean isWindows()
	{
		return getPlatformName() == PlatformName.WINDOWS;
	}

	/**
	 * 检查当前平台是否为MacOS。
	 *
	 * @return 如果当前平台为MacOS，则返回 true，否则返回 false。
	 */
	public static boolean isMacOS()
	{
		return getPlatformName() == PlatformName.MACOS;
	}

	/**
	 * 创建一个用于执行系统命令的进程生成器。
	 *
	 * @param command 要执行的系统命令。
	 * @return 进程生成器。
	 */
	public static ProcessBuilder makeProcessBuilder(String... command)
	{
		return new ProcessBuilder(command);
	}

	/**
	 * 执行系统命令。
	 *
	 * @param command 要执行的系统命令。
	 */
	public static void executeSysCmd(String command)
	{
		try
		{
			Runtime.getRuntime()
			       .exec(command);
		} catch (IOException e)
		{
			B4T_Exception.throwNow(
					PlatformService.class,
					"Command execution failed for \"" + command + "\"",
					e
			);
		}
	}
}
