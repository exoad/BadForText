package pkg.exoad.bad4text.core;
public final class OperationsHelper
{
	private OperationsHelper()
	{
	}

	public static int[] makeUnique(int[] e)
	{
		int[] r = new int[e.length];
		int i = 0;
		for (int value : e)
		{
			boolean found = false;
			for (int k = 0; k < i; k++)
			{
				if (r[k] == value)
				{
					found = true;
					break;
				}
			}
			if (!found)
			{
				r[i] = value;
				i++;
			}
		}
		int[] r2 = new int[i];
		System.arraycopy(
				r,
				0,
				r2,
				0,
				i
		);
		return r2;
	}
}
