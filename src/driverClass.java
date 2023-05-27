import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import commonFunction.Utility_Common_Functions;

public class driverClass {
    
	public static void main(String args[]) throws IOException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{	
		{
			ArrayList<String>testCaseRunner=Utility_Common_Functions.readDataExcel("testRunner","TestCaseNameToExecute");
			int count=testCaseRunner.size();
			System.out.println(count);
			for(int i=1;i<count;i++)
			 {
				String testCaseName=testCaseRunner.get(i);
				Class<?> testClassName=Class.forName("testClass."+testCaseName);
				Method executeMethod=testClassName.getDeclaredMethod("execute");
				executeMethod.setAccessible(true);
				Object instanceOfTestClass=testClassName.getDeclaredConstructor().newInstance();
				executeMethod.invoke(instanceOfTestClass);
			 }

		}

	}
}