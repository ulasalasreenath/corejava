package org.speakingcs.threads.threadlocal;

public class MyThreadLocal {
	
	public static final ThreadLocal<Context> userThreadLocal = new ThreadLocal<>();
	public static int a = 5;
	
	
	public static void set(Context user)
	{
		userThreadLocal.set(user);
	}
	
	public static Context get()
	{
		return userThreadLocal.get();
	}
	
	public static void unset()
	{
		userThreadLocal.remove();
	}

}
