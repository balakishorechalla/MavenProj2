package com.spicejet.tests;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class CustomBlockJUnit4ClassRunner extends BlockJUnit4ClassRunner {

	public CustomBlockJUnit4ClassRunner(Class<?> klass) throws InitializationError {
		super(klass);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run(RunNotifier notifier)
	{
		notifier.addListener(new CustomRunListener());
		super.run(notifier);
		
	}
	

}
