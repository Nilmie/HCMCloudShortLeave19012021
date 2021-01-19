package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ShortLeaveRequest {
	
	WebDriver driver;
	
	By ShortLeaveDate = By.xpath("(//div[contains(@class,'col-xs-4-5 hcm-form_controller')]//input)[1]");
	By ShortLeaveSession = By.xpath("//div[contains(@class,'col-xs-4-5 hcm-form_controller')]//select[1]");
	By ShortFromTime = By.xpath("(//div[contains(@class,'col-xs-4-5 hcm-form_controller')]//input)[2]");
	By ShortToTime = By.xpath("(//div[contains(@class,'col-xs-4-5 hcm-form_controller')]//input)[3]");
	By ShortRemark = By.xpath("//div[@class='hcm-reason_area']//textarea[1]");
	By ClickApplyLeaveButton = By.xpath("(//div[contains(@class,'hcm-button_area top-20')]//button)[2]");
	By ClickButtonOK_FromTime = By.xpath("(//div[contains(@class,'popover clockpicker-popover')]//button)[1]");
	By ClickButtonOK_ToTime = By.xpath("(//div[contains(@class,'popover clockpicker-popover')]//button)[2]");
	
	public ShortLeaveRequest(WebDriver driver)
	  {
		  this.driver = driver;
	  }

	public void Select_Date() 
	{
		//Date
		driver.findElement(ShortLeaveDate).click();
		driver.manage().timeouts().implicitlyWait(55,TimeUnit.SECONDS);
		driver.findElement(ShortLeaveDate).sendKeys("01/15/2021");
    	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	}
	
	public void Select_Session() 
	{
		//Short Leave Session
    	Select Session = new Select (driver.findElement(ShortLeaveSession));
    	Session.selectByValue("IN");	
	}
	
	public void Select_FromTime() 
	{
		//From Time
		driver.findElement(ShortFromTime).click();
		driver.manage().timeouts().implicitlyWait(55,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[2]/div[9]")).click();
		//driver.findElement(ShortFromTime).sendKeys("08:30");
    	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
    	driver.findElement(ClickButtonOK_FromTime).click();
	}

	public void Select_ToTime() 
	{
		//To Time
		driver.findElement(ShortToTime).click();
		driver.manage().timeouts().implicitlyWait(55,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/div[10]")).click();
		driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[3]/div[7]")).click();
    	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
    	driver.findElement(ClickButtonOK_ToTime).click();
	}

	public void Select_Reason() 
	{
		//Add Reason
    	driver.findElement(ShortRemark).sendKeys("RemarksShort Leave");
		
	}
	
	public void ButtonClickApplyShortLeave() 
	{
		//Click Apply Leave
		driver.findElement(ClickApplyLeaveButton).click();
	}
	
    public String Verify_NoHours()
    {
    	By HourCount = By.className("caption-2");
	    return   driver.findElement(HourCount).getText();
    }
    

}
