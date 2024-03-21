package Tests;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ExelReader;



public class test {

    private WebDriver driver;
    private HomePage homePage;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome-win64\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);

    }

    @DataProvider(name = "testData")
    public Object[][] testData() {
        ExelReader reader = new ExelReader("src/test/resources/test data.xlsx");
        return reader.readTestData();
    }

    @Test(dataProvider = "testData")
    public void testBingSearch(String url, String searchQuery) {
        homePage.open(url);
        homePage.search(searchQuery);

        homePage.scrollDown();
        homePage.goToNextPage();

        int numOfResultsPage2 = homePage.countResults();

        homePage.scrollDown();
        homePage.goToNextPage();

        int numOfResultsPage3 = homePage.countResults();
        Assert.assertEquals(numOfResultsPage2, numOfResultsPage3, "Number of results on page 2 is not equal to page 3");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }


}
