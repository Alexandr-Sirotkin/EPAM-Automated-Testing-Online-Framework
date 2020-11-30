package EpamLearn.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailEstimateFormPage extends Page {

  private Logger log = LogManager.getRootLogger();

  @FindBy(xpath = "//input[@type=\"email\"]")
  private WebElement fieldEmailInput;
  @FindBy(xpath = "//button[@aria-label=\"Send Email\"]")
  private WebElement buttonSendEmailButton;

  public EmailEstimateFormPage setEmail(String address) {
    waitVisibilityOf(fieldEmailInput).sendKeys(address);
    log.info("Email address set");
    return this;
  }

  public EmailEstimateFormPage sendEmail() {
    waitVisibilityOf(buttonSendEmailButton).click();
    log.info("Email send");
    return this;
  }

}
