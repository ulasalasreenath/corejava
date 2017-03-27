package threads;

public class ThreadCoordinationTest {
	
	public static void main(String[] args)
	{
		DeliveryNoteHolder c = new DeliveryNoteHolder();
		DispatcherThread dispatcherThread = new DispatcherThread(c);
		DriverThread driverThread = new DriverThread(c, "Sreenath");
		dispatcherThread.start();
		driverThread.start();
		
	}

}
