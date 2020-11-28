package EpamLearn.page;

import EpamLearn.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

  protected WebDriver driver;
  protected final int WAIT_TIMEOUT_SECONDS = 15;
  {
    driver = DriverSingleton.getDriver();
  }
  protected Page() {
    PageFactory.initElements(driver, this);
  }

  WebElement waitVisibilityOf(WebElement element) {
    return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOf(element));
  }

  WebElement waitVisibilityOf(String locator, String value) {
    return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(locator, value))));
  }

}
