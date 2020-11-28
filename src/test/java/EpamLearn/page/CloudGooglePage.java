package EpamLearn.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudGooglePage extends Page {

  private Logger log = LogManager.getRootLogger();

  @FindBy(xpath = "//input[@aria-label=\"Search\"]")
  private WebElement searchFieldInput;

  public CloudGooglePage openPage() {
    driver.get("https://cloud.google.com");
    this.waitVisibilityOf(searchFieldInput);
    log.info("Opened Cloud Google page." );
    return this;
  }

  public SearchResultsForGoogleCloudPage findRequest(String request) {
    searchFieldInput.click();
    searchFieldInput.sendKeys(request);
    searchFieldInput.sendKeys(Keys.ENTER);
    log.info("Search for [" + request + "] started." );
    return new SearchResultsForGoogleCloudPage();
  }

}
