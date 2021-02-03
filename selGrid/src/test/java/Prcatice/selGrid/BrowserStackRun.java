package Prcatice.selGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BrowserStackRun {
	
	RemoteWebDriver driver;
	
	public static final String USERNAME = "chaitram1";
	  public static final String AUTOMATE_KEY = "P7y5b5H99xYzHfpdkSHx";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
@Test(dataProvider ="Data")
public void browserRun(Platform platform, String BName, String BVersion) throws MalformedURLException, InterruptedException
{
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setPlatform(platform);
	cap.setBrowserName(BName);
	cap.setVersion(BVersion);
	cap.setCapability("name", BName);
	cap.setCapability("browserstack.debug", true);
	
	driver = new RemoteWebDriver(new URL(URL),cap);
	driver.get("http://gmail.com");
	Thread.sleep(2000);
	driver.quit();
	
}

@DataProvider(name ="Data", parallel=true)
public Object[][] getData(){
	Object[][] test = new Object[][] {
		{Platform.WINDOWS,"chrome","80"},
		{Platform.WINDOWS,"firefox","57"},
		{Platform.MAC,"chrome","80"}};
		return test;
	}

}
