package threads;

public class Inconsistent {
	
	static  boolean started = false;
	
	public static void main(String[] args)
	{
		Thread t1 = new Thread(new Runnable() {
			public void run()
			{
				try
				{
					Thread.sleep(3000);
				} catch(InterruptedException ie)
				{
					
				}
				started = true;
				System.out.println("started set to true");
			}
		});
		
		t1.start();
		
		while(!started)
		{
			
		}
		
		System.out.println("Wait 3 seconds and exit");
	}

}
