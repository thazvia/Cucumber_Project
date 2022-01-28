package page;


import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;




public class BackgroundColourPage {

WebDriver driver;
	
	public BackgroundColourPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS,using = "button[onclick='myFunctionSky()']") WebElement SkyBlue_Background_Button_Element;
	@FindBy(how = How.CSS,using = "button[onclick='myFunctionWhite()']") WebElement White_Background_Button_Element;
	@FindBy(how = How.CSS,using = "body[style='background-color: white;']") WebElement White_Background_Element;
	@FindBy(how = How.CSS,using = "body[style='background-color: skyblue;']") WebElement SkyBlue_Background_Element;
	
	public void validateSkyBlueBackgroundButton() {
		boolean isEnabled=SkyBlue_Background_Button_Element.isEnabled();
		boolean isDisplayed=SkyBlue_Background_Button_Element.isDisplayed();
		
		if(isEnabled) {
			System.out.println("Button is enabled");
		}
		else
			System.out.println("Button is not enabled");
		
		
		if(isDisplayed) {
			System.out.println("Button is displayed");
		}
		else
			System.out.println("Button is not displayed");
	
	try {
		driver.findElement(By.cssSelector("button[onclick='myFunctionSky()']"));
		System.out.println("Button is exixt");
	}
	catch(NoSuchElementException e) {
		System.out.println("Button not exixt");
	}
	}
	
	public void clickSkyBlueBackgroundButton() {
		
		SkyBlue_Background_Button_Element.click();
	}
	 
	public void verifySkyBlueBackgroundColor() {
		
		//String expected="rgba(135, 206, 235, 1)";
		String expected="#87ceeb";
		
		
		String backgroundColor=SkyBlue_Background_Element.getCssValue("background-color");
		System.out.println("BackgroundColor:" + backgroundColor);
		String Backcolour1=Color.fromString(backgroundColor).asHex();
		System.out.println("BackgroundColor in hexa :"+ Backcolour1);
		String actual = Backcolour1;
		Assert.assertEquals(expected,actual);
		
	
	}
	
	public void validateWhiteBackgroundButton() {
		boolean isEnabled=White_Background_Button_Element.isEnabled();
		boolean isDisplayed=White_Background_Button_Element.isDisplayed();
		
		if(isEnabled) {
			System.out.println("Button is enabled");
		}
		else
			System.out.println("Button is not enabled");
		
		
		if(isDisplayed) {
			System.out.println("Button is displayed");
		}
		else
			System.out.println("Button is not displayed");
	
	try {
		driver.findElement(By.cssSelector("button[onclick='myFunctionWhite()']"));
		System.out.println("Button is exixt");
	}
	catch(NoSuchElementException e) {
		System.out.println("Button not exixt");
	}
	}
	
public void clickWhiteBackgroundButton() {
		
	White_Background_Button_Element.click();
	}


	public void verifyWhiteBackgroundColor() {
		
		//String expected="rgba(255, 255, 255, 1)";
		String expected="#ffffff";
		
		String bgColor = White_Background_Element.getCssValue("background-color");
		System.out.println("BackgroundColor:" + bgColor);
		String Backcolor=Color.fromString(bgColor).asHex();
		System.out.println("BackgroundColor in hexa :"+ Backcolor);
		String actual = Backcolor;
		Assert.assertEquals(expected,actual);
		
	
	}
	
	
}
