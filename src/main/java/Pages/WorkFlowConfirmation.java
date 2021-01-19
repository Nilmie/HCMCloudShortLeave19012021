package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class WorkFlowConfirmation {
	
	 WebDriver driver;
 	By WorkFlow = By.xpath("(//div[@class='textfield']//select)[1]");
 	By WorkFlowApprover = By.xpath("(//div[@class='textfield']//select)[2]");
 	By ButtonApply = By.xpath("//div[@class='row row-align-middle']//button[1]");
	 
	public WorkFlowConfirmation(WebDriver driver)
	{

	        this.driver = driver;

	}
	    
	public void SelectWorkFlow() 
	{
		//driver.findElement(By.id("WorkflowId")).click();
		Select Workflow = new Select(driver.findElement(By.id("WorkflowId")));
		Workflow.selectByValue("5");
       	driver.manage().timeouts().implicitlyWait(55,TimeUnit.SECONDS);
	}
	
	public void SelectWorkFlowApprover() 
	{
		Select Workflow = new Select(driver.findElement(By.id("ApproverId")));
		Workflow.selectByValue("2");
    	driver.manage().timeouts().implicitlyWait(55,TimeUnit.SECONDS);
	}
	
	public void ClickButtonApply() 
	{
    	driver.findElement(ButtonApply).click();
   
	}
	
    public String Verify_SuccessfullMessage()
    {
    	By SuccessfullMessage = By.xpath("/html/body/div[7]/div/div[1]/div[3]/h1");
	    return   driver.findElement(SuccessfullMessage).getText();
    }
}
