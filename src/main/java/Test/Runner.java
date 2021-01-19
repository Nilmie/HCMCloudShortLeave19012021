package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.*;
import Utility.JSONReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Runner {
	
	public static WebDriver driver;
	
	Login ObjLogin;
	MenuNavigation ObjNavigation;
	ShortLeaveRequest ObjShortLeaveRequest;
	WorkFlowConfirmation ObjWorkFlowConfirmation;
	
	 @Test
	public void ESS_ShortLeaveRequest() throws FileNotFoundException, IOException, ParseException
	{
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		ObjLogin = new Login(driver);
		driver.get(JSONReader.ReadJSONFile("url", "./Data/URL.json"));
		
		ObjLogin.EnterUserName(JSONReader.ReadJSONFile("username", "./Data/LoginDetails.json"));
		ObjLogin.EnterPassword(JSONReader.ReadJSONFile("password", "./Data/LoginDetails.json"));
		ObjLogin.ClickSignIn();
		
		//Navigation to Leave Request 
		ObjNavigation = new MenuNavigation(driver);
		
		ObjNavigation.NavigateToESSMainMenu();
		ObjNavigation.NavigateToManageLeaveMenu();
		ObjNavigation.NavigateToShortLeaveRequest();
		
		ObjShortLeaveRequest = new ShortLeaveRequest(driver);
		ObjShortLeaveRequest.Select_Date();
		ObjShortLeaveRequest.Select_Session();
		ObjShortLeaveRequest.Select_FromTime();
		ObjShortLeaveRequest.Select_ToTime();
		ObjShortLeaveRequest.Select_Reason();
		ObjShortLeaveRequest.ButtonClickApplyShortLeave();
		
		Assert.assertTrue(ObjShortLeaveRequest.Verify_NoHours().contains("1:30hrs"));
		
		ObjWorkFlowConfirmation = new WorkFlowConfirmation(driver);
		ObjWorkFlowConfirmation.SelectWorkFlow();
		ObjWorkFlowConfirmation.SelectWorkFlowApprover();
		ObjWorkFlowConfirmation.ClickButtonApply();
		
		Assert.assertTrue(ObjWorkFlowConfirmation.Verify_SuccessfullMessage().contains("Successfully Completed"));
		
		
		driver.close();
    	driver.quit();
		
		
	}
	
	 
	

}
 