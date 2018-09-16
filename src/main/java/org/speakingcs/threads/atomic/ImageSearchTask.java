package threads.atomic;

import java.nio.file.Path;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.DefaultListModel;

public class ImageSearchTask implements Runnable{
	
	private Path searchDir;
	private Executor executor;
	private DefaultListModel listModel;
	private AtomicInteger fileCounter;
	
	public ImageSearchTask(Path searchDir, Executor executor, DefaultListModel listModel, AtomicInteger fileCounter)
	{
		this.searchDir = searchDir;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
}
