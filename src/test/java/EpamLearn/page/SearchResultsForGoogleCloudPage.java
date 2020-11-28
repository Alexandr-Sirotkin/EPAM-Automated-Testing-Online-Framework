package EpamLearn.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsForGoogleCloudPage extends Page {

  private Logger log = LogManager.getRootLogger();

  @FindBy(xpath = "//div[@class=\"gs-title\"]/a[@href=\"https://cloud.google.com/products/calculator\"]")
  private WebElement requiredSearchResultA;

  public GoogleCloudPricingCalculatorPage selectResult() {
    waitVisibilityOf(requiredSearchResultA).click();
    log.info("Clicked on the Google Cloud Platform Pricing Calculator" );
    return new GoogleCloudPricingCalculatorPage();
  }

}
