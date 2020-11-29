package EpamLearn.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EstimatePage extends Page{

//  @FindBy(xpath = "//div[contains(text(), \"VM class:\")]")
//  private WebElement vmClassDiv;
//  @FindBy(xpath = "//div[contains(text(), \"Instance type:\")]")
//  private WebElement instanceTypeDiv;
//  @FindBy(xpath = "//div[contains(text(), \"Region:\")]")
//  private WebElement regionDiv;
//  @FindBy(xpath = "//div[contains(text(), \"Total available local\")]")
//  private WebElement localSSDDiv;
//  @FindBy(xpath = "//div[contains(text(), \"Commitment term:\")]")
//  private WebElement commitmentTermDiv;
  @FindBy(xpath = "//b[contains(text(), \"Total Estimated Cost:\")]")
  private WebElement totalEstimatedCostPerMonthB;
  @FindBy(xpath = "//button[@id=\"email_quote\"]")
  private WebElement emailEstimateButton;

//  public String getTextVMClass() {
//    return waitVisibilityOf(vmClassDiv).getText();
//  }
//
//  public String getTextInstanceType() {
//    return waitVisibilityOf(instanceTypeDiv).getText();
//  }
//
//  public String getTextRegion() {
//    return waitVisibilityOf(regionDiv).getText();
//  }
//
//  public String getTextLocalSSD() {
//    return waitVisibilityOf(localSSDDiv).getText();
//  }
//
//  public String getTextCommitmentTerm() {
//    return waitVisibilityOf(commitmentTermDiv).getText();
//  }
//
//  public String getTextTotalEstimatedCostPerMonth() {
//    return waitVisibilityOf(totalEstimatedCostPerMonthB).getText();
//  }

  public EmailEstimateFormPage sendByEmail() {
    driver.switchTo().frame(0);
    driver.switchTo().frame("myFrame");
    waitVisibilityOf(emailEstimateButton).click();
    return new EmailEstimateFormPage();
  }

  public Double getCost() {
    return Double.parseDouble(
        waitVisibilityOf(totalEstimatedCostPerMonthB).getText().replace(" 1 ", "")
            .replaceAll("[^0-9.]", ""));
  }

}
