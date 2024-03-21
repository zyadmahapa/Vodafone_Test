package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void search(String query) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void goToNextPage() {
      driver.findElement(By.linkText("Next")).click();
    }

    public int countResults() {
        return driver.findElements(By.className("b_algo")).size();
    }
}
