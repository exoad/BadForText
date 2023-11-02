package pkg.exoad.bad4text.core.util;
public class Color
{
	public float red;
	public float green;
	public float blue;
	public float opacity;

	public static Color make(float red, float green, float blue)
	{
		return new Color(red, green, blue, 1F);
	}

	public static Color make(float red, float green, float blue, float opacity)
	{
		return new Color(red, green, blue, opacity);
	}

	private Color(float red, float green, float blue, float opacity)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.opacity = opacity;
	}

}
