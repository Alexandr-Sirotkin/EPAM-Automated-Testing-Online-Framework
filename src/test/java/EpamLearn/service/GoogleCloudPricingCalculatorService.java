package EpamLearn.service;

import EpamLearn.driver.DriverSingleton;
import EpamLearn.model.ComputeEngine;
import EpamLearn.page.CloudGooglePage;
import EpamLearn.page.EmailEstimateFormPage;
import EpamLearn.page.EstimatePage;
import EpamLearn.page.GoogleCloudPricingCalculatorPage;
import EpamLearn.page.MailPage;
import EpamLearn.page.SearchResultsForGoogleCloudPage;
import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class GoogleCloudPricingCalculatorService {

  private WebDriver driver = DriverSingleton.getDriver();
  private GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage;
  private EstimatePage estimatePage;
  private MailPage mailPage;
  private String mailHandle;
  private String mailAddress;


  public GoogleCloudPricingCalculatorService openGoogleCloudPricingCalculatorPage() {
    CloudGooglePage cloudGooglePage = new CloudGooglePage();
    cloudGooglePage.openPage();
    String request = "Google Cloud Platform Pricing Calculator";
    SearchResultsForGoogleCloudPage searchResultsForGoogleCloudPage = cloudGooglePage.findRequest(request);
    googleCloudPricingCalculatorPage = searchResultsForGoogleCloudPage.selectResult();
    return this;
  }

  public GoogleCloudPricingCalculatorService fillOutTheCalculatorForm(ComputeEngine  computeEngine) {
    googleCloudPricingCalculatorPage
        .goInTheFrame()
        .selectComputeEngine()
        .setNumberOfInstances(computeEngine.getNumberOfInstances())
        .setSoftware(computeEngine.getSoftware())
        .setMachineClass(computeEngine.getMachineClass())
        .setSeries(computeEngine.getSeries())
        .setMachineType(computeEngine.getMachineType())
        .selectAddGPUs(computeEngine.getAddGPUs(), computeEngine.getNumberOfGPUs(), computeEngine.getGPUType())
        .setLocalSSD(computeEngine.getLocalSSD())
        .setDatacenterLocation(computeEngine.getDatacenterLocation())
        .setCommittedUsage(computeEngine.getCommittedUsage());
    return this;
  }

  public Double getAnEstimate() {
    estimatePage = googleCloudPricingCalculatorPage.calculateEstimate();
    return estimatePage.getCost();
  }

  public GoogleCloudPricingCalculatorService openMailPageAndSetEmailAddress() {
    ((JavascriptExecutor) driver).executeScript("window.open()");
    ArrayList<String> tabList = new ArrayList<>(driver.getWindowHandles());
    String estimateHandle = String.valueOf(tabList.get(0));
    mailHandle = String.valueOf(tabList.get(1));
    driver.switchTo().window(mailHandle);
    mailPage = new MailPage();
    mailAddress = mailPage
        .openPage()
        .getMailAddress();
    driver.switchTo().window(estimateHandle);
    return this;
  }

  public GoogleCloudPricingCalculatorService sendEstimateByMail() {
    EmailEstimateFormPage emailEstimateFormPage = estimatePage.sendByEmail();
    emailEstimateFormPage.setEmail(mailAddress);
    emailEstimateFormPage.sendEmail();
    return this;
  }

  public Double acceptLetterAndGetEstimate() {
    driver.switchTo().window(mailHandle);
    mailPage.openLetter();
    return mailPage.getCost();
  }


}
