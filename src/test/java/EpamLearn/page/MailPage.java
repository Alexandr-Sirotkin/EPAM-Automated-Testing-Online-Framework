package EpamLearn.page;

import EpamLearn.wait.PageLoadingConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends Page {


  private static final String PAGE_URL = "https://10minutemail.com";
  @FindBy(xpath = "//input[@id=\"mail_address\"]")
  private WebElement fieldMailAddressInput;
  @FindBy(xpath = "//span[text()=\"Google Cloud Platform Price Estimate\"]")
  private WebElement messageFromEstimatePageSpan;
  @FindBy(xpath = "//table//h3[contains(text(),\"USD\")]")
  private WebElement totalEstimatedCostPerMonthH3;


  public MailPage openPage() {
    driver.get(PAGE_URL);
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(PageLoadingConditions.jQueryAJAXsCompleted());
    return this;
  }

  public String getMailAddress() {
    String mailAddress;
    do {
      mailAddress = waitVisibilityOf(fieldMailAddressInput).getAttribute("value");
    } while (!(mailAddress.contains("@")));
    return mailAddress;
  }

  public MailPage openLetter() {
    waitVisibilityOf(messageFromEstimatePageSpan).click();
    return this;
  }

  public Double getCost() {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
        waitVisibilityOf(totalEstimatedCostPerMonthH3));
    return Double.parseDouble(
        waitVisibilityOf(totalEstimatedCostPerMonthH3).getText().replaceAll("[^0-9.]", ""));
  }

}
