package task2;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
@Listeners(listenerdemo.ListenerClass.class)
public class CaseTest2{
	ExtentTest test=null;
	WebDriver driver=null;
	protected static ExtentReports report=new ExtentReports("src/ExtentReports.html");
	static final Logger log=LogManager.getLogger(CaseTest2.class.getName());
    @Test
	public void testmethod1() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
    	log.info("###########");
    	log.info("TEST Has Started");
    	test=report.startTest("Flipkart Page");
    	Logger logger=Logger.getLogger("CaseTest2");
    	System.setProperty("webdriver.edge.driver","C:\\Users\\yamin\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get("https://www.zeptonow.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		logger.debug("zeptonow launched successfully");
		try {
			Thread.sleep(4000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		if(driver.getTitle().equals("zepto")) {
			test.log(LogStatus.PASS, "zeptonowpage launched successfully");
		}
		else {
			test.log(LogStatus.FAIL, "zeptonowpage launched failed");
			
		}
		WebElement tw=driver.findElement(By.xpath("//span[@class='text-sm capitalize']"));
		tw.click();
		String pw=driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> l1=s.iterator();
		while(l1.hasNext()) {
			String cw=l1.next();
			if(!(pw.equals(cw))) {
				driver.switchTo().window(cw);
				System.out.println(driver.switchTo().window(cw).getTitle());
			}
		}
		Thread.sleep(4000);
		WebElement tw2=driver.findElement(By.xpath("//input[@placeholder='Enter Phone Number']"));
		tw2.sendKeys("9014277549");
		WebElement tw3=driver.findElement(By.xpath("//div[@class='flex items-center justify-center']"));
		tw3.click();
		Thread.sleep(4000);
		WebElement tw4=driver.findElement(By.xpath("//input[@inputmode='numeric']"));
		tw4.click();
		Thread.sleep(4000);
		driver.switchTo().window(pw);
		System.out.println(driver.switchTo().window(pw).getTitle());
		Thread.sleep(5000);
		WebElement tw5=driver.findElement(By.xpath("//input[@placeholder='Search for over 5000 products']"));
		tw5.sendKeys("phones stand");
		
		
	}
    

	@AfterClass
    public void reportend() {
    	report.endTest(test);
    }
    @AfterSuite
    public void reportflush() {
    	report.flush();
    }
    

    
    

}
