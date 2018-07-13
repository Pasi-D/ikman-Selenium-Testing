/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Pasindu
 */
public class Demo_Selenium {

    /**
     * @param args the command line arguments
     */
    private static WebDriver driver = null;
    
    //validate the price range
    public static String validatePrice(int price){
        return price>= 5000000 && price<=7500000? "" : "Not in the price range";
    }
    
    //validate the number of beds
    public static String validateBeds(int numberOfBeds){
        return numberOfBeds==3? "" : "Not the chosen number of beds";
    }
    
    public static void main(String[] args) {

        
        
    }
    
    
    public static void ikmanTest(){
        
        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");                
        driver = new ChromeDriver();
        
        String baseUrl = "https://ikman.lk/";
        
        // launch Chrome and direct it to the Base URL
        driver.get(baseUrl);
        
        //Click on the property link
        driver.findElement(By.linkText("Property")).click();
        
        //Click on the houses link
        driver.findElement(By.partialLinkText("Houses")).click();

        //Click on the colombo link
        driver.findElement(By.partialLinkText("Colombo")).click();
        
        //Click on the Price (Rs)
        driver.findElement(By.partialLinkText("Price (Rs)")).click();
        
        //Get the webelement corresponding to the minimum value 
        WebElement minVal = driver.findElement(By.id("filters[0][minimum]"));
        
        //Get the webelement corresponding to the maximum value 
        WebElement maxVal = driver.findElement(By.id("filters[0][maximum]"));
        
        //Enter the minimum value & maximum value
        minVal.sendKeys("5000000");
        maxVal.sendKeys("7500000");
        
        //Apply filter button
        driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div.ui-accordion-item.filter-price.is-open > div > div:nth-child(6) > div > div > button")).click();

        //Click on the Beds span
        driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div.ui-accordion-item.filter-enum.filter-bedrooms > a")).click();
        
        //Click on number 3 checkbox
        driver.findElement(By.id("filters2values-3")).click();
        
        //Get the number of houses with three beds
        int adHouses = Integer.parseInt(driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-9 > div > div > div:nth-child(1) > div > div > div > span")).getText().
                                  substring(driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-9 > div > div > div:nth-child(1) > div > div > div > span")).getText().
                                  indexOf("of")+3,driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-9 > div > div > div:nth-child(1) > div > div > div > span")).getText().
                                  indexOf("ads")-1));
        
        System.out.println("No of Ads Found : " + adHouses);
        
        //Label the add
        int count = 1;
        
        //iterate through pages of ads
        for (int i = 0; i < adHouses/25; i++) {
            //catch the filtered items
            WebElement serpItems = driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-9 > div > div > div.row.lg-g > div.col-12.lg-9 > div"));
            List<WebElement> listItems = serpItems.findElements(By.className("ui-item"));
            
            //print the price of each item || Validate the price and number of beds
            for (WebElement item : listItems){
                System.out.println("Ad Number " + count + " Price is " + item.findElement(By.className("item-info")).getText() + " " + 
                                    validatePrice(Integer.parseInt(item.findElement(By.className("item-info")).getText().replace("Rs ", "").replace(",",""))) + " " + 
                                    validateBeds(Integer.parseInt(item.findElement(By.className("item-meta")).getText().substring(item.findElement(By.className("item-meta")).getText().indexOf("Beds")+6,item.findElement(By.className("item-meta")).getText().indexOf(",")))));
                count++;
            }
            
            //check for the last page of ads
            if(i!=adHouses/25){
                //click next
                driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div.row.lg-g > div > div > div > div > div > a.col-6.lg-3.pag-next")).click();
            }
        }
        
        //close Chrome
        driver.close();
    }
    
}
