package EpamLearn.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPricingCalculatorPage extends Page {

  private Logger log = LogManager.getRootLogger();

  @FindBy(xpath = "//md-tab-item/div[@title=\"Compute Engine\"]")
  private WebElement computeEngineDiv;
  @FindBy(xpath = "//input[@ng-model=\"listingCtrl.computeServer.quantity\"]")
  private WebElement numberOfInstancesInput;
  @FindBy(xpath = "//md-select[@ng-model=\"listingCtrl.computeServer.os\"]")
  private WebElement softwareMdSelect;
  private String typeSoftwareMdOption = "//md-option//div[contains(text(), \"%s\")]";
  @FindBy(xpath = "//md-select[@placeholder=\"VM Class\"]")
  private WebElement machineClassMdSelect;
  private String typeMachineClassDiv = "//md-select-menu[@style] /descendant::div[contains(text(), \"%s\")]";
  @FindBy(xpath = "//md-select[@placeholder=\"Series\"]")
  private WebElement seriesMdSelect;
  private String typeSeriesDiv = "//div[contains(text(), \"%s\")]";
  @FindBy(xpath = "//md-select[@placeholder=\"Instance type\"]")
  private WebElement machineTypeMdSelect;
  private String machineTypeDiv = "//div[contains(text(), \"%s\")]";
  @FindBy(xpath = "//md-checkbox[@ng-model=\"listingCtrl.computeServer.addGPUs\"]/div[@class=\"md-container md-ink-ripple\"]")
  private WebElement addGPUsDiv;
  @FindBy(xpath = "//md-select[@placeholder=\"Number of GPUs\"]")
  private WebElement numberOfGPUsMdSelect;
  private String numberOfGPUsMdOption = "//md-select-menu[@style]//md-option[@value=\"%s\"]";
  @FindBy(xpath = "//md-select[@placeholder=\"GPU type\"]")
  private WebElement typeOfGPUsMdSelect;
  private String typeOfGPUsDiv = "//div[contains(text(), \"%s\")]";
  @FindBy(xpath = "//div[@class=\"ng-scope layout-row\"]//md-select[@placeholder=\"Local SSD\"]")
  private WebElement localSSDMDSelect;
  private String localSSDDiv = "//div[contains(text(), \"%s\")]";
  @FindBy(xpath = "//md-select[@ng-model=\"listingCtrl.computeServer.location\"]")
  private WebElement datacenterLocationMDSelect;
  private String datacenterLocationDiv = "//md-select-menu[@class=\"md-overflow\"]//div[contains(text(), \"%s\")]";
  @FindBy(xpath = "//md-select[@ng-change=\"listingCtrl.onCudChange();\"]")
  private WebElement commitedUsageMDSelect;
  private String commitedUsageMdOption = "//div[@class=\"md-select-menu-container md-active md-clickable\"]//md-option[@ng-value=\"%s\"]";
  @FindBy(xpath = "//button[@ng-click=\"listingCtrl.addComputeServer(ComputeEngineForm);\"]")
  private WebElement AddToEstimateButton;

  public GoogleCloudPricingCalculatorPage goInTheFrame() {
    driver.switchTo().frame(0);
    driver.switchTo().frame("myFrame");
    return this;
  }

  public GoogleCloudPricingCalculatorPage selectComputeEngine() {
    waitVisibilityOf(computeEngineDiv).click();
    log.info("Compute Engine selected");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setNumberOfInstances(String number) {
    waitVisibilityOf(numberOfInstancesInput).sendKeys(number);
    log.info("Set number of instance: [" + number + "]");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setSoftware(String operatingSystemValue) {
    waitVisibilityOf(softwareMdSelect).click();
    waitVisibilityOf(typeSoftwareMdOption, operatingSystemValue).click();
    log.info("Set software: [" + operatingSystemValue + "]");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setMachineClass(String machineClassValue) {
    waitVisibilityOf(machineClassMdSelect).click();
    waitVisibilityOf(typeMachineClassDiv, machineClassValue).click();
    log.info("Set Machine Class: [" + machineClassValue + "]");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setSeries(String seriesValue) {
    if (driver instanceof FirefoxDriver) {
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", waitVisibilityOf(machineClassMdSelect));
    }
    waitVisibilityOf(seriesMdSelect).click();
    waitVisibilityOf(typeSeriesDiv, seriesValue).click();
    log.info("Set Series: [" + seriesValue + "]");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setMachineType(String machineTypeValue) {
    log.info("В setMachineType!!!!!!!!!!!!!!!!!!!!!!!!!!");
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", machineTypeMdSelect);

//    waitElementToBeClickable(machineTypeMdSelect).click();
//    waitVisibilityOf(machineTypeMdSelect).click();
    log.info(" machineTypeMdSelect click!!!!!");
//    waitVisibilityOf(machineTypeMdSelect).click();
    waitVisibilityOf(machineTypeDiv, machineTypeValue).click();
    log.info("Set Machine Type: [" + machineTypeValue + "]");
    return this;
  }

  public GoogleCloudPricingCalculatorPage selectAddGPUs(boolean addGPUs, String numberOfGPUsValue, String typeOfGPUsValue) {
    if (addGPUs) {
      waitVisibilityOf(addGPUsDiv).click();
      waitVisibilityOf(numberOfGPUsMdSelect).click();
      waitVisibilityOf(numberOfGPUsMdOption, numberOfGPUsValue).click();
      waitVisibilityOf(typeOfGPUsMdSelect).click();
      waitVisibilityOf(typeOfGPUsDiv, typeOfGPUsValue).click();
      log.info("GPU selected: [ number Of GPU: " + numberOfGPUsValue + " , type Of GPU: " + typeOfGPUsValue + "]");
    }
    return this;
  }

  public GoogleCloudPricingCalculatorPage setLocalSSD(String localSSDValue) {
    if (driver instanceof FirefoxDriver) {
//      Actions actions = new Actions(driver);
//    actions.moveToElement(localSSDMDSelect);
//    actions.perform();
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", waitVisibilityOf(machineTypeMdSelect));
//    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
    }
    waitVisibilityOf(localSSDMDSelect).click();
    waitVisibilityOf(localSSDDiv, localSSDValue).click();
    log.info("Set Local SSD: [" + localSSDValue + "]");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setDatacenterLocation(String datacenterLocationValue) {
    waitVisibilityOf(datacenterLocationMDSelect).click();
    waitVisibilityOf(datacenterLocationDiv, datacenterLocationValue).click();
    log.info("Set Location: [" + datacenterLocationValue + "]");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setCommittedUsage(String commitedUsageValue) {
    waitVisibilityOf(commitedUsageMDSelect).click();
    waitVisibilityOf(commitedUsageMdOption, commitedUsageValue).click();
    log.info("Set CommittedUsage: [" + commitedUsageValue + "]");
    return this;
  }

  public EstimatePage calculateEstimate() {
    waitVisibilityOf(AddToEstimateButton).click();
    return new EstimatePage();
  }

}
