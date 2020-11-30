package EpamLearn.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends Page {

  private Logger log = LogManager.getRootLogger();
  private static final String PAGE_URL = "https://10minutemail.com";
  @FindBy(xpath = "//input[@id=\"mail_address\"]")
  private WebElement fieldMailAddressInput;
  @FindBy(xpath = "//span[text()=\"Google Cloud Platform Price Estimate\"]")
  private WebElement messageFromEstimatePageSpan;
  @FindBy(xpath = "//table//h3[contains(text(),\"USD\")]")
  private WebElement totalEstimatedCostPerMonthH3;


  public MailPage openPage() {
    driver.get(PAGE_URL);
//    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(PageLoadingConditions.jQueryAJAXsCompleted());
    log.info("Email page is open");
    return this;
  }

  public String getMailAddress() {
    String mailAddress;
    do {
      mailAddress = waitVisibilityOf(fieldMailAddressInput).getAttribute("value");
    } while (!(mailAddress.contains("@")));
    log.info("Email address received");
    return mailAddress;
  }

  public MailPage openLetter() {
    waitVisibilityOf(messageFromEstimatePageSpan).click();
    log.info("Incoming email is open");
    return this;
  }

  public Double getCost() {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
        waitVisibilityOf(totalEstimatedCostPerMonthH3));
    log.info("The cost from the letter is taken");
    return Double.parseDouble(
        waitVisibilityOf(totalEstimatedCostPerMonthH3).getText().replaceAll("[^0-9.]", ""));
  }

}
