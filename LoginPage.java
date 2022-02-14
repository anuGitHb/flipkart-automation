package qa.devnext.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public WebDriver driver;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private  By loginEntrybttn = By.className("_1_3w1N");
	private By enterMobileno = By.xpath("//span[text()='Get access to your Orders, Wishlist and Recommendations']/following::input");
	private By enterPwd = By.xpath("//input[contains(@class,'_2IX_2- _3mctLh')]");
	private By SignUplink = By.linkText("New to Flipkart? Create an account");
	private By loginSubmit = By.xpath("//button[contains(@class,'_2KpZ6l _2HKlqd')]");
	
	//Page action
	
	public String getTitlePage()
	{
		return driver.getTitle();
	}
	public void clickonLoginentrance()
	{ WebDriverWait wait = new WebDriverWait(driver,60);
	WebElement el=wait.until(ExpectedConditions.elementToBeClickable(loginEntrybttn));
	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", el);
		
	}
	
	public boolean isSignuplinkexist()
	{
		return driver.findElement(SignUplink).isDisplayed();
	}

	public void enterUserPhn(String phoneno)
	{
		driver.findElement(enterMobileno).sendKeys(phoneno);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(enterPwd).sendKeys(pwd);
	}
	public void clickonLoginbttn() {
		driver.findElement(loginSubmit).click();
	}
	
	public HomePage doLogin(String ph,String pwds)
	{
		System.out.println("getting login creds and logging in");
		WebDriverWait wait = new WebDriverWait(driver,60);
		WebElement el=wait.until(ExpectedConditions.elementToBeClickable(loginEntrybttn));
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", el);
		 driver.findElement(enterMobileno).sendKeys(ph);
		 driver.findElement(enterPwd).sendKeys(pwds);
		 driver.findElement(loginSubmit).click();
		 return new HomePage(driver);
	}
}
