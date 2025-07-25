package com.comcast.crm.ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImp implements IRetryAnalyzer{

	
	int Count=0;
	int limitCount=5;
	public boolean retry(ITestResult result) {
		if(Count<limitCount) {
			Count++;
			return true;
		}
		return false;
	}
}
