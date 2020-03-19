package framework.webPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;
import java.util.ArrayList;
import java.util.List;

public class DarkSkyHP extends BasePage {

//SCENARIO 1: Verify current Temperature should not be greater or less than the temperature from Daily Timeline
    private By CurrentTemp = By.xpath("//span[@class='summary swap']");
    private By tempElements = By.className("temps");

    public int currentTemp(){                                                                        //String number = "10";
                                                                                                    //	Integer result = Integer.valueOf(number);
                                                                                                    //	System.out.println(result)
        String Temp = getTextFromElement(CurrentTemp);
        Integer result = Integer.valueOf(Temp);
        return result;
    }
    public void sortTemp(){
        List<WebElement> temp = new ArrayList<>();
        temp = SharedSD.getDriver().findElements(tempElements);
            for(WebElement element:temp){
            element.getText();
        }
    }


//SCENARIO 2: Scenario: Verify timeline is displayed in correct format
    private By CurrentTimeline = By.xpath("//div[@class='scroll-container']//following::div[@id='timeline']//child::div[@class='timeline']//child::div[@class='hours']");


    public void CheckCurrentTimeline(){
        List<WebElement>  timelineHours = new ArrayList<>();
        timelineHours = SharedSD.getDriver().findElements(CurrentTemp);
        for(WebElement element:timelineHours){
            element.getText();
        }

    }


//SCENARIO 3:  Verify individual day temperature timeline
    private By LowTemp = By.xpath("//div[@id='week']//following::a[@class='day revealed']//child::span[@class='tempRange']//child::span[@class='minTemp']");
    private By HighTemp = By.xpath("//div[@id='week']//following::a[@class='day revealed']//child::span[@class='tempRange']//child::span[@class='maxTemp']");
    private By LowTemp1 = By.xpath("//div[@class='dayDetails revealed']//child::span[@class='highTemp swip']//child::span[@class='temp']");
    private By HighTemp1 = By.xpath("//div[@class='dayDetails revealed']//child::div[@class='dayExtras']//child::span[@class='lowTemp swap']//child::span[@class='temp']");

    public String lowTemperature(){
        return getTextFromElement(LowTemp);
    }
    public String lowTemperature1(){
        return getTextFromElement(LowTemp1);
    }
    public String highTemperature(){
        return getTextFromElement(HighTemp);
    }
    public String highTemperature1(){
        return getTextFromElement(HighTemp1);
    }


//SCENARIO 4: Verify invalid Signup error message
    private By TodayTimeline = By.xpath("//a[@data-day='0']//span[@class='open']");
    private By API = By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");
    private By SignUp = By.xpath("//a[@class='button filled']");
    private By RegHead = By.xpath("//h1[@class='stand-alone title']");

    public void clickTodayTimeline(){
        clickOn(TodayTimeline);
    }
    public void clickRegPage(){
        clickOn(API);
    }
    public void clickSignUp(){
        clickOn(SignUp);
    }
    public String getRegHead(){
        return getTextFromElement(RegHead);
    }
}
