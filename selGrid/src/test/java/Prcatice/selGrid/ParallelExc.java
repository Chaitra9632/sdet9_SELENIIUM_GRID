package Prcatice.selGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelExc {
	
@Test(dataProvider ="dataname")
public void remoteExceution(Platform platform, String browserName) throws Throwable
{
	URL url=new URL("http://13.232.247.233:4444/wd/hub");
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setPlatform(platform);
	cap.setBrowserName(browserName);
	
	RemoteWebDriver driver = new RemoteWebDriver(url, cap);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://gmail.com");
	
}
	
@DataProvider(name="dataname", parallel=true)
public Object[][] getdata()
{
	Object[][] testdata=new Object[][]
			{
		{Platform.WINDOWS,"chrome"},
		{Platform.WINDOWS,"firefox"}
			};
	return testdata;
			
}

}
