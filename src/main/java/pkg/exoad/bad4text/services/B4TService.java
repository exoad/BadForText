package pkg.exoad.bad4text.services;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class B4TService
{
	private B4TService()
	{}

	private static Timer persistentWorker = new Timer(
	        "B4T_primaryWorker",
	        false
	);
	private static ExecutorService localWorker = Executors.newCachedThreadPool();
	private static Timer daemonWorker = new Timer(
	        "B4T_daemonWorker",
	        true
	);

	private static TimerTask _wrap(Runnable task)
	{
		return new TimerTask()
		{
			@Override public void run()
			{ task.run(); }
		};
	}

	public static Future< Void > submitAsyncTask(Runnable r)
	{
		return localWorker.submit(() -> { r.run(); return (Void) null; });
	}

	public static < T > Future< T > submitAsyncTask(Callable< T > function)
	{
		return localWorker.submit(function);
	}

	public static void submitPersistentTaskNow(Runnable task)
	{
		persistentWorker.schedule(
		        _wrap(task),
		        0
		);
	}

	public static void submitPersistentTaskNow(Runnable task, long delay)
	{
		persistentWorker.schedule(
		        _wrap(task),
		        delay
		);
	}

	public static void submitPersistentTaskNow(Runnable task, long delay, long period)
	{
		persistentWorker.scheduleAtFixedRate(
		        _wrap(task),
		        delay,
		        period
		);
	}

	public static void submitDaemonTaskNow(Runnable task)
	{
		daemonWorker.schedule(
		        _wrap(task),
		        0
		);
	}

	public static void submitDaemonTask(Runnable task, long delay)
	{
		daemonWorker.schedule(
		        _wrap(task),
		        delay
		);
	}

	public static void submitDaemonTask(Runnable task, long delay, long period)
	{
		daemonWorker.scheduleAtFixedRate(
		        _wrap(task),
		        delay,
		        period
		);
	}

}
