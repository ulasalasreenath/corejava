package com.speakingcs.corejava.threads;

public class BusinessService {
	
	public void businessMethod()
	{
		Context context = MyThreadLocal.getContext();
		System.out.println(context.getTransactionId());
	}

}
