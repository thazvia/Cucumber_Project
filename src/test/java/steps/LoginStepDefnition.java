package steps;




import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.BackgroundColourPage;

import page.TestBase;

public class LoginStepDefnition extends TestBase{
	

	
	BackgroundColourPage backgroundColourPage;
	
	@Before
	public void beforeRun() {
		initDriver();
		backgroundColourPage= PageFactory.initElements(driver, BackgroundColourPage.class);
	}
	
	
	
	@Given("Set SkyBlue Background button exists")
	public void Set_SkyBlue_Background_button_exists() throws InterruptedException {
		backgroundColourPage.validateSkyBlueBackgroundButton();
		Thread.sleep(3000);
	}
	
	@Given("Set SkyWhite Background button exists")
	public void Set_SkyWhite_Background_button_exists() throws InterruptedException {
		backgroundColourPage.validateWhiteBackgroundButton();
		Thread.sleep(3000);
	}


	
	@When("I click on the {string} button")
	public void i_click_on_the_button(String button) throws InterruptedException {
		switch(button) {
		case "Set SkyBlue Background":
			backgroundColourPage.clickSkyBlueBackgroundButton();
			Thread.sleep(3000);
			break;
		case "Set SkyWhite Background":
			backgroundColourPage.clickSkyBlueBackgroundButton();
			Thread.sleep(3000);
			backgroundColourPage.clickWhiteBackgroundButton();
			Thread.sleep(3000);
			break;
		default:
			System.out.println("unable to click");
			break;
	}
}
	
	
	

	@Then("the background color will change to sky blue")
	public void the_background_color_will_change_to_sky_blue() throws IOException {
		backgroundColourPage.verifySkyBlueBackgroundColor();
		takeScreenShot(driver);
	}
	
	@Then("the background color will change to white")
	public void the_background_color_will_change_to_white()  {
		backgroundColourPage.verifyWhiteBackgroundColor();
	}


	
	
	
	
	
	
	
	
	@After
	public void tearDown() {
		driver.close();
		//driver.quit();
	}
	

}
