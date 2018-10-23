package threads;

public class DriverThread extends Thread{

	DeliveryNoteHolder deliveryNoteHolder;
	String driverName;
	boolean stopped = false;
	
	
	public DriverThread(DeliveryNoteHolder deliveryNoteHolder, String driverName)
	{
		this.deliveryNoteHolder = deliveryNoteHolder;
		this.driverName = driverName;
	}
	
	public void run()
	{
		while(!stopped)
		{
			String deliveryNote = deliveryNoteHolder.get();
			try
			{
				sleep(300);
			} catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
