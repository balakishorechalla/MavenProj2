package com.spicejet.util;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class OutputFolder implements TestRule{

	public Statement apply(final Statement st,  final Description desc) {
		// TODO Auto-generated method stub
		return new Statement()
				{

					@Override
					public void evaluate() throws Throwable {
						System.out.println("Before executing method "+desc.getMethodName());
						CreateFolders.getTestDetails(desc);
						// TODO Auto-generated method stub
						st.evaluate();
						System.out.println("After executing method "+desc.getMethodName());
						
					}
			
				};
	}

}
