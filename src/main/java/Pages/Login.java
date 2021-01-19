package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	WebDriver driver;
	
    By UserName = By.id("Username");
    By Password = By.id("Password");
    By titleText =By.className("mi-login-caption");
    By SignIn = By.id("btnSignin");
    
    public Login(WebDriver driver)
    {
    	this.driver = driver;
    }
    
    public void EnterUserName(String UserNameEmail)
    {
    	driver.findElement(UserName).sendKeys(UserNameEmail);
    }
    
    
    public void EnterPassword(String UserPassword)
    {
    	driver.findElement(Password).sendKeys(UserPassword);
    }
    

    public void ClickSignIn()
    {
    	driver.findElement(SignIn).click();
    }
    
    public String getLoginTitle()
    {

    	return    driver.findElement(titleText).getText();
    }
    
    public void logintoHCM(String UserNameEmail,String UserPassword)
    {
    	this.EnterUserName(UserNameEmail);
    	this.EnterPassword(UserPassword);
    	this.ClickSignIn();
    }
}
