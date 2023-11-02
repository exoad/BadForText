package tests;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Supplier;

import static java.lang.System.*;

public class TestEnv
		implements
		Runnable
{
	private static TestEnv defaultTestEnv = new TestEnv();

	public static < T > TestCase< T > test(Supplier< T > value, T expected)
	{
		return new TestCase<>(
				value,
				expected);
	}

	public static TestCase< Integer > test(Runnable r)
	{
		return new TestCase<>(
				() -> {
					r.run();
					return 1;
				},
				1);
	}

	public static < T > void addTest(TestCase< T > e)
	{
		defaultTestEnv.addCase(e);
	}

	public static void runTests()
	{
		defaultTestEnv.run();
	}

	private final Queue< TestCase< ? > > tests;
	private int index = 1;
	private int failed = 0; // if not ok
	private int passed = 0; // if ok

	protected TestEnv()
	{
		tests = new ArrayDeque<>();
	}

	public < T > void addCase(TestCase< T > e)
	{
		tests.add(e);
	}

	@Override public void run()
	{
		for (int i = 0; i < tests.size(); i++)
		{
			TestCase< ? > tc = tests.poll();
			boolean isOk = tc.assertEq();
			out.println((isOk ? "PASSED" : "FAILED") + " [ TEST " + index + " ]:\n\tGot " + tc.value()
					.get()
					.toString()
					+ "\n\tExpected: " + tc.expected()
							.toString());
			if (isOk)
				passed++;
			else failed++;
			index++;
		}
		out.println("---\nResults:\n\tFailed: " + failed + "\n\tPassed: " + passed);
	}
}
