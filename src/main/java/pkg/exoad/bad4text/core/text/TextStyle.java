package pkg.exoad.bad4text.core.text;
import pkg.exoad.bad4text.core.intf.IPipelineMember;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
public class TextStyle
{
	public static final Queue< ITextStylizerPipelineMember > TEXT_STYLING_PIPELINE_MEMBERS;

	static
	{
		TEXT_STYLING_PIPELINE_MEMBERS = new ArrayDeque<>();
	}

	public enum Styles
	{
		BLINK("blink"),
		RESET_FORMAT("reset"),
		BOLD("bold"),
		ITALIC("italic"), // this one maybe unsupported on some systems idk
		FG_BLACK("fg_black"),
		BG_BLACK("bg_black"),
		FG_RED("fg_red"),
		BG_RED("bg_red"),
		FG_BRIGHT_RED("fg_b_red"),
		BG_BRIGHT_RED("bg_b_red"),
		FG_GREEN("fg_green"),
		BG_GREEN("bg_green"),
		FG_BRIGHT_GREEN("fg_b_green"),
		BG_BRIGHT_GREEN("bg_b_green"),
		FG_YELLOW("fg_yellow"),
		BG_YELLOW("bg_yellow"),
		FG_BRIGHT_YELLOW("fg_b_yellow"),
		BG_BRIGHT_YELLOW("bg_b_yellow"),
		FG_BLUE("fg_blue"),
		BG_BLUE("bg_blue"),
		FG_BRIGHT_BLUE("fg_b_blue"),
		BG_BRIGHT_BLUE("bg_b_blue"),
		FG_MAGENTA("fg_magenta"),
		BG_MAGENTA("bg_magenta"),
		FG_BRIGHT_MAGENTA("fg_b_magenta"),
		BG_BRIGHT_MAGENTA("bg_b_magenta"),
		FG_CYAN("fg_cyan"),
		BG_CYAN("bg_cyan"),
		FG_BRIGHT_CYAN("fg_b_cyan"),
		BG_BRIGHT_CYAN("bg_b_cyan"),
		FG_WHITE("fg_white"),
		BG_WHITE("bg_white"),
		FG_GRAY("fg_gray"),
		BG_GRAY("bg_gray");

		public final String value;

		Styles(String xmlCode)
		{
			this.value = xmlCode;
		}
	}

	public static ArrayList< String > asMarkupTags()
	{
		ArrayList< String > out = new ArrayList<>();
		for (Styles style : Styles.values())
			out.add(style.value);
		return out;
	}

	public interface ITextStylizerPipelineMember
	{
		StyledText apply(String text, Styles... styles);
	}

	public static class StyledText
	{
		public String styled;
		public String original;

		public static StyledText make(String original, String styled)
		{
			return new StyledText(
					original,
					styled
			);
		}

		public static StyledText make(String original)
		{
			return new StyledText(
					original,
					null
			);
		}

		private StyledText(String original, String styled)
		{
			this.original = original;
			this.styled = styled;
		}

		@Override public String toString()
		{
			return TEXT_STYLING_PIPELINE_MEMBERS.isEmpty() ? original : styled;
		}
	}
}
