package pkg.exoad.bad4text.core.util;
public final class TextFormat
{

	private TextFormat() {}

	public static char[][] splitOn(char[] array, char splitter)
	{
		int[] indexes = new int[array.length];
		int i = 0;
		for (int k = 0; k < array.length; k++)
		{
			if (array[k] == splitter)
			{
				indexes[i] = k;
				i++;
			}
		}
		char[][] r = new char[i + 1][];
		r[0] = new char[indexes[0]];
		System.arraycopy(
				array,
				0,
				r[0],
				0,
				indexes[0]
		);
		for (int k = 1; k < i; k++)
		{
			int i1 = indexes[k] - indexes[k - 1] - 1;
			r[k] = new char[i1];
			System.arraycopy(
					array,
					indexes[k - 1] + 1,
					r[k],
					0,
					i1
			);
		}
		r[i] = new char[array.length - indexes[i - 1] - 1];
		System.arraycopy(
				array,
				indexes[i - 1] + 1,
				r[i],
				0,
				array.length - indexes[i - 1] - 1
		);
		return r;
	}
}
