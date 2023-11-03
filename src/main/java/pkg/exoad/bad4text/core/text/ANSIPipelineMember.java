package pkg.exoad.bad4text.core.text;
import pkg.exoad.bad4text.core.util.Operations;
import pkg.exoad.bad4text.debug.B4T_Exception;
import pkg.exoad.bad4text.debug.Code;

import java.util.HashMap;
public class ANSIPipelineMember
		implements TextStyle.ITextStylizerPipelineMember
{
	private static HashMap< TextStyle.Styles, Integer > stylesMap;

	static
	{
		stylesMap.put(
				TextStyle.Styles.BOLD,
				1
		);
		stylesMap.put(
				TextStyle.Styles.BLINK,
				6
		);
		stylesMap.put(
				TextStyle.Styles.RESET_FORMAT,
				0
		);
		stylesMap.put(
				TextStyle.Styles.ITALIC,
				3
		);
		stylesMap.put(
				TextStyle.Styles.FG_BLACK,
				30
		);
		stylesMap.put(
				TextStyle.Styles.BG_BLACK,
				40
		);
		stylesMap.put(
				TextStyle.Styles.FG_RED,
				31
		);
		stylesMap.put(
				TextStyle.Styles.BG_RED,
				41
		);
		stylesMap.put(
				TextStyle.Styles.FG_BRIGHT_RED,
				91
		);
		stylesMap.put(
				TextStyle.Styles.BG_BRIGHT_RED,
				101
		);
		stylesMap.put(
				TextStyle.Styles.FG_GREEN,
				32
		);
		stylesMap.put(
				TextStyle.Styles.BG_GREEN,
				42
		);
		stylesMap.put(
				TextStyle.Styles.FG_BRIGHT_GREEN,
				92
		);
		stylesMap.put(
				TextStyle.Styles.BG_BRIGHT_GREEN,
				102
		);
		stylesMap.put(
				TextStyle.Styles.FG_YELLOW,
				33
		);
		stylesMap.put(
				TextStyle.Styles.BG_YELLOW,
				43
		);
		stylesMap.put(
				TextStyle.Styles.FG_BRIGHT_YELLOW,
				93
		);
		stylesMap.put(
				TextStyle.Styles.BG_BRIGHT_YELLOW,
				103
		);
		stylesMap.put(
				TextStyle.Styles.FG_BLUE,
				34
		);
		stylesMap.put(
				TextStyle.Styles.BG_BLUE,
				44
		);
		stylesMap.put(
				TextStyle.Styles.FG_BRIGHT_BLUE,
				94
		);
		stylesMap.put(
				TextStyle.Styles.BG_BRIGHT_BLUE,
				104
		);
		stylesMap.put(
				TextStyle.Styles.FG_MAGENTA,
				35
		);
		stylesMap.put(
				TextStyle.Styles.BG_MAGENTA,
				45
		);
		stylesMap.put(
				TextStyle.Styles.FG_BRIGHT_MAGENTA,
				95
		);
		stylesMap.put(
				TextStyle.Styles.BG_BRIGHT_MAGENTA,
				105
		);
		stylesMap.put(
				TextStyle.Styles.FG_CYAN,
				36
		);
		stylesMap.put(
				TextStyle.Styles.BG_CYAN,
				46
		);
		stylesMap.put(
				TextStyle.Styles.FG_BRIGHT_CYAN,
				96
		);
		stylesMap.put(
				TextStyle.Styles.BG_BRIGHT_CYAN,
				106
		);
		stylesMap.put(
				TextStyle.Styles.FG_WHITE,
				37
		);
		stylesMap.put(
				TextStyle.Styles.BG_WHITE,
				47
		);
		stylesMap.put(
				TextStyle.Styles.FG_GRAY,
				90
		);
		stylesMap.put(
				TextStyle.Styles.BG_GRAY,
				100
		);
	}

	private static final CharSequence CARRIAGE_START = "\033[";

	private static String _format(int[] codes, String text)
	{
		codes = Operations.makeUnique(codes);
		StringBuilder sb = new StringBuilder();
		sb.append(CARRIAGE_START);
		for (int i = 0; i < codes.length; i++)
		{
			sb.append(codes[i]);
			if (i != codes.length - 1)
				sb.append(';');
		}
		sb.append('m');
		sb.append(text);
		return sb.toString();
	}

	@Override public TextStyle.StyledText apply(String text, TextStyle.Styles... styles)
	{
		int[] codes = new int[styles.length];
		for (int i = 0; i < styles.length; i++)
		{
			Integer code = stylesMap.get(styles[i]);
			if (code == null)
				B4T_Exception.throwNow(
						this.getClass(),
						Code.referenceFx(
								"apply",
								"String text",
								"Styles[] styles"
						),
						new IllegalArgumentException(
								"Unknown style: " + styles[i]
						)
				);
			codes[i] = code;
		}
		return new TextStyle.StyledText(
				text,
				_format(
						codes,
						text
				)
		);
	}
}
