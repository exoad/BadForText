package pkg.exoad.bad4text.core;
import pkg.exoad.bad4text.B4T;
import pkg.exoad.bad4text.core.consts.ConstCharacters;
import pkg.exoad.bad4text.core.defs.B4T_HeavyOperation;
import pkg.exoad.bad4text.core.intf.IFlushableComponent;
import pkg.exoad.bad4text.core.text.TextStyle;

import java.util.ArrayList;
public class CharRegion
		implements IFlushableComponent
{
	ArrayList< TextStyle.StyledText > lines;

	public CharRegion()
	{
		lines = new ArrayList<>();
	}

	public synchronized CharRegion append(TextStyle.StyledText e)
	{
		lines.add(e);
		return this;
	}

	public synchronized CharRegion newLine()
	{
		lines.add(TextStyle.StyledText.make(ConstCharacters.NEW_LINE));
		return this;
	}

	public synchronized CharRegion space()
	{
		lines.add(TextStyle.StyledText.make(ConstCharacters.SPACE));
		return this;
	}

	@B4T_HeavyOperation(reason = "Only if there are preserved lines does all of them get dereferenced and cleared.")
	public synchronized void clearAllStoredLines()
	{
		if (!lines.isEmpty())
			lines.clear();
	}

	@Override public void flush()
	{
		lines.forEach((x) -> B4T.IO.print(x.toString()
		                                    .toCharArray()));
	}
}
