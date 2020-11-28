package EpamLearn.test;


import EpamLearn.driver.DriverSingleton;
import EpamLearn.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {

  protected WebDriver driver;

  @BeforeClass()
  public void setUp()
  {
    driver = DriverSingleton.getDriver();
  }

  @AfterClass(alwaysRun = true)
  public void stopBrowser()
  {
    DriverSingleton.closeDriver();
  }

}
