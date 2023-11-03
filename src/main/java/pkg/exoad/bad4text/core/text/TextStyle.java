package pkg.exoad.bad4text.core.text;
public class TextStyle
{

	public enum Styles
	{
		BLINK,
		RESET_FORMAT,
		BOLD,
		ITALIC, // this one maybe unsupported on some systems idk
		FG_BLACK,
		BG_BLACK,
		FG_RED,
		BG_RED,
		FG_BRIGHT_RED,
		BG_BRIGHT_RED,
		FG_GREEN,
		BG_GREEN,
		FG_BRIGHT_GREEN,
		BG_BRIGHT_GREEN,
		FG_YELLOW,
		BG_YELLOW,
		FG_BRIGHT_YELLOW,
		BG_BRIGHT_YELLOW,
		FG_BLUE,
		BG_BLUE,
		FG_BRIGHT_BLUE,
		BG_BRIGHT_BLUE,
		FG_MAGENTA,
		BG_MAGENTA,
		FG_BRIGHT_MAGENTA,
		BG_BRIGHT_MAGENTA,
		FG_CYAN,
		BG_CYAN,
		FG_BRIGHT_CYAN,
		BG_BRIGHT_CYAN,
		FG_WHITE,
		BG_WHITE,
		FG_GRAY,
		BG_GRAY
	}

	public interface ITextStylizerPipelineMember
	{
		StyledText apply(String text, Styles... styles);
	}

	public record StyledText(String original, String styled)
	{
		@Override public String toString()
		{
			return styled;
		}
	}
}
