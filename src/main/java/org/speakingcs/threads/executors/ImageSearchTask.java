package threads.executors;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
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
		this.executor = executor;
		this.listModel = listModel;
		this.fileCounter = fileCounter;
	}
	
	public void run()
	{
		
		if(fileCounter.get() > ImageSearcher.MAX_RESULT)
		{
			return;
		}
		
		try(DirectoryStream<Path> children = Files.newDirectoryStream(searchDir))
		{
			for(final Path child : children)
			{
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
