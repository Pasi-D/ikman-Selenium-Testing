package Steps;

import Base.BaseUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ikmanSteps extends BaseUtil {

    //validate the price range
    public static String validatePrice(int price){
        return price>= 5000000 && price<=7500000? "" : "Not in the price range";
    }

    //validate the number of beds
    public static String validateBeds(int numberOfBeds){
        return numberOfBeds==3? "" : "Not the chosen number of beds";
    }

    private BaseUtil base;
    private String noOfSpecificAds;

    public ikmanSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the webpage$")
    public void iNavigateToTheWebpage() throws Throwable {
        //Navigate to the ikman.lk

        System.out.println("Navigating to ikman.lk \n");

        base.Driver.navigate().to("https://ikman.lk/");
    }

    @And("^I click on the Property link$")
    public void iClickOnThePropertyLink() throws Throwable {
        //Click on the property button
        String xPathToProperty = "/html/body/div[2]/div[3]/div[2]/div/div/div[1]/div[3]/h4/a/span[2]";
        WebElement propertyBtn = base.Driver.findElement(By.xpath(xPathToProperty));
        propertyBtn.click();
        System.out.println("Clicked on the property button \n");
    }

    @And("^I click on the Houses$")
    public void iClickOnTheHouses() throws Throwable {
        //Click on the Houses
        base.Driver.findElement(By.partialLinkText("Houses")).click();
        System.out.println("Clicked on the House Link \n");
    }

    @And("^I click on Colombo$")
    public void iClickOnColombo() throws Throwable {
        //Click on Colombo
        base.Driver.findElement(By.partialLinkText("Colombo")).click();
        System.out.println("Clicked on Colombo");
    }

    @And("^I Apply the price range between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iApplyThePriceRangeBetweenAnd(String minVal, String maxVal) throws Throwable {

        //Click on the Price (Rs)
        base.Driver.findElement(By.partialLinkText("Price (Rs)")).click();
        System.out.println("Clicked on the price button");

        //Set the minimum price to 5000000
        String xPathToMinValField = "//*[@id=\"filters[0][minimum]\"]";
        WebElement minValField = base.Driver.findElement(By.xpath(xPathToMinValField));

        minValField.sendKeys(minVal);
        System.out.println("Min-Val was set to 5000000 \n");

        //Set the maximum price to 7500000
        String xPathToMaxValField = "//*[@id=\"filters[0][maximum]\"]";
        WebElement maxValField = base.Driver.findElement(By.xpath(xPathToMaxValField));

        maxValField.sendKeys(maxVal);
        System.out.println("Max-Val was set to 7500000 \n");

    }

    @And("^I apply filter button$")
    public void iApplyFilterButton() throws Throwable {
        //Click on the Apply Filter Button
        WebElement applyBtn = base.Driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div.ui-accordion-item.filter-price.is-open > div > div:nth-child(6) > div > div > button"));
        applyBtn.click();
        System.out.println("Apply Button was Clicked \n");
    }

    @And("^I select number of beds as \"([^\"]*)\"$")
    public void iSelectNumberOfBedsAs(String count) throws Throwable {
        //Click on the beds expander
        base.Driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div.ui-accordion-item.filter-enum.filter-bedrooms > a")).click();

        //Click on the checkbox 3
        base.Driver.findElement(By.id("filters2values-3")).click();
        System.out.println("Selected 3 beds \n");
    }

    @Then("^I display the number of results$")
    public void iDisplayTheNumberOfResults() throws Throwable {
        //Display the number of ads on the console

        String xPathToAdResultsText = "//span[@class='t-small summary-count']";
        String resultsText = base.Driver.findElement(By.xpath(xPathToAdResultsText)).getText();

        String[] resultsArray = resultsText.split(" ");
        noOfSpecificAds = resultsArray[3];
        System.out.println("No of Ads :" + noOfSpecificAds);
    }

    @Then("^I display all the adds$")
    public void iDisplayAllTheAdds() throws Throwable {
        int specificAds = Integer.parseInt(noOfSpecificAds);

        //Label the add
        int count = 1;

        //Iterate through all the ads in pages
        for (int i = 0; i <= (specificAds/25); i++){
            //catch the filtered items
            WebElement serpItems = base.Driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-9 > div > div > div.row.lg-g > div.col-12.lg-9 > div"));
            List<WebElement> listItems = serpItems.findElements(By.className("ui-item"));

            for (WebElement item : listItems){
                System.out.println("Ad Number " + count + " Price is " + item.findElement(By.className("item-info")).getText() + " " +
                        validatePrice(Integer.parseInt(item.findElement(By.className("item-info")).getText().replace("Rs ", "").replace(",",""))) + " " +
                        validateBeds(Integer.parseInt(item.findElement(By.className("item-meta")).getText().substring(item.findElement(By.className("item-meta")).getText().indexOf("Beds")+6,item.findElement(By.className("item-meta")).getText().indexOf(",")))));
                count++;
            }
        }


    }

}
