package pkg.exoad.bad4text.core.text;
public class NullStylesPipelineMember
		implements
		TextStyle.ITextStylizerPipelineMember
{
	@Override public TextStyle.StyledText apply(String text, TextStyle.Styles... styles)
	{
		return new TextStyle.StyledText(
				text,
				text
		);
	}
}
