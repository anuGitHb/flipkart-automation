package qa.devnext.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import qa.devnext.factory.DriverFactory;

public class HomePage {
	private WebDriver driver;
	
	private By menuSection =  By.cssSelector("div#container .xtXmba");
	private By myaccoutnTab = By.xpath("//div[@class='exehdJ']");
	private By myprofile  = By.xpath("//div[text()='My Profile']");
	
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean isMyaccountExist()
	{
		return driver.findElement(myaccoutnTab).isDisplayed();
	}
	public void gotoMyaccountTab()
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(myaccoutnTab)).build().perform();
	}
	
	public String getMyprofilelink()
	{
		return driver.findElement(myprofile).getText();
	}
	
	public int getHomepageMenuCount()
	{
		return driver.findElements(menuSection).size();
	}
	
	public List<String> HomesectionMenu()
	{
		List<String> menuList = new ArrayList<>();
		List<WebElement> accountelement = driver.findElements(menuSection);
		
		for(WebElement e: accountelement)
		{
			String menuItem = e.getText();
			System.out.println(menuItem);
			menuList.add(menuItem);
		}
		return menuList;
	}
	
}
