package com.speakingcs.corejava.threads;

import java.util.ArrayList;
import java.util.List;

public class MyThread extends Thread{

	public void run()
	{
		System.out.println("Foo");
	}

	public static void main(String[] args) {
		MyThread thread = new MyThread(){
			public void run()
			{
				System.out.println("Bar");
				print();
			}
			
			public void print()
			{
				System.out.println("abc");
			}
		};
		thread.start();
		
		ArrayList<String> al = new ArrayList<String>()
				{
					@Override
					public int size() {
						print();
						return super.size();
					}
					public void print()
					{
						System.out.println("cde");
					}
				};
		System.out.println(al.size());
	}
	
}
