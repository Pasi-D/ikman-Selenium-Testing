package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtil{
    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(){
        System.out.println("Opening the Browser : Chrome \n");

        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

        base.Driver = new ChromeDriver();
    }

    @After
    public void TearDownTest(Scenario scenario){
        if (scenario.isFailed()){
            System.out.println(scenario.getName());
        }

        System.out.println("Closing the browser : Chrome \n");
        base.Driver.close();
    }
}
