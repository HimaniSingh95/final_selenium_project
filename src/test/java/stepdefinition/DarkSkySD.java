package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyHP;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class DarkSkySD {
    private DarkSkyHP darkskyHP = new DarkSkyHP();

    @Given("^I am on Darksky Home Page$")
    public void iAmOnHomePage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Dark Sky - West 30th Street, New York, NY");
    }

//Scenario 1: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
    @When ("^I verify current temp is not greater or less then temps from daily timeline$")
    public void VerifycurrentTemperature(){
        darkskyHP.currentTemp();
    }







//SCENARIO 3 :Verify individual day temp timeline
    @When("^I expand today's timeline$")
    public void clickOnTodayTimeline() throws InterruptedException {
        JavascriptExecutor jsScrollBy = (JavascriptExecutor)SharedSD.getDriver();
        jsScrollBy.executeScript("scrollBy(0,400);");
        Thread.sleep(5000);
        darkskyHP.clickTodayTimeline();
    }
    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void VerifyTemp(){
        Assert.assertEquals(darkskyHP.lowTemperature(),darkskyHP.lowTemperature1());
        Assert.assertEquals(darkskyHP.highTemperature(),darkskyHP.highTemperature1());
    }


//SCENARIO 4:Verify invalid Signup error message
    @When("^I click on darksky (API|Sign Up)$")
    public void clickOnButton(String button){

        switch (button){
            case "API":
                darkskyHP.clickRegPage();
                break;
            case "Sign Up":
                darkskyHP.clickSignUp();
                break;
        }
    }
    @Then("^I verify I am on register page by asserting Register header$")
    public void verifyRegisterHeader(){
        Assert.assertEquals(darkskyHP.getRegHead(),"Register");
    }



}
