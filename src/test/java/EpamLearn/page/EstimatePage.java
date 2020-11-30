package EpamLearn.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class EstimatePage extends Page {

  private Logger log = LogManager.getRootLogger();

  @FindBy(xpath = "//b[contains(text(), \"Total Estimated Cost:\")]")
  private WebElement totalEstimatedCostPerMonthB;
  @FindBy(xpath = "//button[@id=\"email_quote\"]")
  private WebElement emailEstimateButton;

  public EmailEstimateFormPage sendByEmail() {
    if (driver instanceof ChromeDriver) {
      driver.switchTo().frame(0);
      driver.switchTo().frame("myFrame");
    }
    waitVisibilityOf(emailEstimateButton).click();
    log.info("Clicked the send by mail button");
    return new EmailEstimateFormPage();
  }

  public Double getCost() {
    return Double.parseDouble(
        waitVisibilityOf(totalEstimatedCostPerMonthB).getText().replace(" 1 ", "")
            .replaceAll("[^0-9.]", ""));
  }

}
