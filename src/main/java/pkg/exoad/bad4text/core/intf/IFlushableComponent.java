package pkg.exoad.bad4text.core.intf;

/**
 * 用于将格式化内容输出的直接链接到输出流的引用
 *
 * @author Jack Meng
 */
public interface IFlushableComponent
{
	/**
	 * 表示此组件现在将把其所有格式化内容输出到一个接收流。
	 * <p> <br/>
	 * 主要用于输出格式化内容。
	 *
	 * @see pkg.exoad.bad4text.core.OutStream
	 */

	void flush();
}
