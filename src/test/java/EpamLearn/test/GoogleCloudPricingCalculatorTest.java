package EpamLearn.test;

import static org.testng.Assert.*;
import EpamLearn.model.ComputeEngine;
import EpamLearn.service.ComputeEngineCreator;
import EpamLearn.service.GoogleCloudPricingCalculatorService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleCloudPricingCalculatorTest extends CommonConditions{

  private GoogleCloudPricingCalculatorService service = new GoogleCloudPricingCalculatorService();
  private ComputeEngine computeEngine = ComputeEngineCreator.withCredentialsFromProperty();

  @BeforeMethod
  public void sendAndAcceptEstimate(){
    service
        .openGoogleCloudPricingCalculatorPage()
        .fillOutTheCalculatorForm(computeEngine)
        .getAnEstimate()
        .openMailPageAndGetEmailAddress()
        .sendEstimateByMail()
        .acceptLetterAndGetEstimate();
  }

  @Test
  public void comparePrices() {
    assertEquals(service.costFromMailPage, service.costFromEstimatePage, "Цена в письме не соответствует цене на сайте.");
  }

}
