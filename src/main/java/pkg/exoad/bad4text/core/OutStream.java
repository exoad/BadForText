package pkg.exoad.bad4text.core;

import pkg.exoad.bad4text.debug.B4T_Exception;
import pkg.exoad.bad4text.debug.Code;

import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 输出流类，实现 Flushable 接口，用于将字符内容输出到指定输出流。
 */
public class OutStream
		implements
		Flushable
{
	private OutputStream os;

	/**
	 * 构造方法，初始化输出流。
	 *
	 * @param defaultStream 默认的输出流。
	 */
	public OutStream(OutputStream defaultStream)
	{
		this.os = defaultStream;
	}

	/**
	 * 设置输出流为新的输出流。
	 *
	 * @param newStream 新的输出流。
	 */
	public synchronized void setOutputStream(OutputStream newStream)
	{
		this.os = newStream;
	}

	/**
	 * 重置输出流为默认输出流（如果不是 System.out）。
	 */
	public synchronized void resetOutputStream()
	{
		if (!os.equals(System.out))
			this.os = System.out;
	}

	/**
	 * 将字符数组内容输出到输出流。
	 *
	 * @param content 字符数组内容。
	 */
	public void print(char... content)
	{
		try
		{
			byte[] bytes = new byte[content.length];
			for (int i = 0; i < content.length; i++)
				bytes[i] = (byte) content[i];
			os.write(bytes);
			os.flush();
		} catch (IOException e)
		{
			B4T_Exception.throwNow(
					this.getClass(),
					Code.referenceFx(
							"print",
							"char[] content"
					),
					e
			);
		}
	}

	/**
	 * 刷新输出流。
	 *
	 * @throws IOException 如果刷新操作出现异常。
	 */
	@Override
	public void flush() throws
	                    IOException
	{
		os.flush();
	}
}
