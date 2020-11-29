package EpamLearn.test;


import EpamLearn.driver.DriverSingleton;
import EpamLearn.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {

  protected WebDriver driver;

  @BeforeTest()
  public void setUp()
  {
    driver = DriverSingleton.getDriver();
  }

  @AfterTest(alwaysRun = true)
  public void stopBrowser()
  {
    DriverSingleton.closeDriver();
  }

}
