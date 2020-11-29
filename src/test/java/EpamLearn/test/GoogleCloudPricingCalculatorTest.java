package EpamLearn.test;

import static org.testng.Assert.*;
import EpamLearn.model.ComputeEngine;
import EpamLearn.service.ComputeEngineCreator;
import EpamLearn.service.GoogleCloudPricingCalculatorService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleCloudPricingCalculatorTest extends CommonConditions {

  private GoogleCloudPricingCalculatorService service = new GoogleCloudPricingCalculatorService();
  private ComputeEngine computeEngine = ComputeEngineCreator.withCredentialsFromProperty();
  private Double costFromEstimatePage;
  public Double costFromMailPage;

  @BeforeClass
  public void sendAndAcceptEstimate() {
    costFromEstimatePage = service
        .openGoogleCloudPricingCalculatorPage()
        .fillOutTheCalculatorForm(computeEngine)
        .getAnEstimate();
    costFromMailPage = service.openMailPageAndSetEmailAddress()
           .sendEstimateByMail()
           .acceptLetterAndGetEstimate();
  }

  @Test(description = "Checking whether the price in the letter matches the price on the website.")
  public void comparePricesInletterAndOnWebsite() {
    assertEquals(costFromMailPage, costFromEstimatePage,
        "Цена в письме не соответствует цене на сайте.");
  }

  @Test(description = "Checking whether the price in the letter matches the expected price.")
  public void comparePriceWithExpected() {
    assertEquals(costFromMailPage, computeEngine.getExpectedEstimate(),
        "Ожидаемая цена не соответствует цене в письме.");
  }

}
