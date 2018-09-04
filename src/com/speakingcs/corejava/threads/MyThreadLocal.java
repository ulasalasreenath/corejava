package com.speakingcs.corejava.threads;

public class MyThreadLocal {

	public static final ThreadLocal userThreadLocal = new ThreadLocal();
	
	public static void set(Context user)
	{
		userThreadLocal.set(user);
	}
	
	public static void unset()
	{
		userThreadLocal.remove();
	}
	
	public static Context getContext()
	{
		return (Context) userThreadLocal.get();
	}
	
	
}
