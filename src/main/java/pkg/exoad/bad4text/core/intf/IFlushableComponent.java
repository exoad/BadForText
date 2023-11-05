package pkg.exoad.bad4text.core.intf;

/**
 * A direct link to an output stream to dump formatted content to.
 *
 * @author Jack Meng
 */
public interface IFlushableComponent
{
	/**
	 * Signifies that this component will now dump all of its formatted content to a receiving stream.
	 * <p>
	 * Mostly used for outputting formatted content.
	 *
	 * @see pkg.exoad.bad4text.core.OutStream
	 */
	void flush();
}
