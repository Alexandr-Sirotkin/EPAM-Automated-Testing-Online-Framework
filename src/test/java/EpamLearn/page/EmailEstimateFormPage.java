package EpamLearn.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailEstimateFormPage extends Page {

  @FindBy(xpath = "//input[@type=\"email\"]")
  private WebElement fieldEmailInput;
  @FindBy(xpath = "//button[@aria-label=\"Send Email\"]")
  private WebElement buttonSendEmailButton;

  public EmailEstimateFormPage setEmail() {
    waitVisibilityOf(fieldEmailInput).sendKeys(MailPage.mailAddress);
    return this;
  }

  public EmailEstimateFormPage sendEmail() {
    waitVisibilityOf(buttonSendEmailButton).click();
    return this;
  }

}
