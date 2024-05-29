package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//@RunWith(Suite.class)
//@SuiteClasses({JunitSuiteLevel.class,JunitSuiteLevel2.class})
public class Execute1 {
	
	@Test
	public void result() {
	Result result = JUnitCore.runClasses(JunitSuiteLevel.class,JunitSuiteLevel2.class);
	
	System.out.println("Run Count:"+result.getRunCount());
	System.out.println("Failure Count:"+result.getFailureCount());
	System.out.println("Ignore Count:"+result.getIgnoreCount());
	int passCount=result.getRunCount()-result.getFailureCount();
	System.out.println("Pass Count:"+passCount);
	List<Failure> failures = result.getFailures();
	for (Failure x : failures) {
		System.out.println(x);
		
	}
	}

}
