package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBaseCross {

    protected WebDriver driver;

    @Parameters("browser") // buraya Parameters notasyonu ekliyoruz
                        // bunula birlikte testNG de yapmak zorunlu olan  beforeMethod taki
                        // setup methodu içerisine (@Optional String browser)
                       //  optional notasyonu ile String browser parametresini gönderiyoruz

    @BeforeMethod()
    public void setUp(@Optional String browser){
        // WebDriverManager.chromedriver().setup();
        // TestBase'den bir farkı da bu satiri siliyoruz
        // cunku burada chromedriver oldugu için
        // driver'a istediğimiz browser i gönderebilmek için
        driver=CrossDriver.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterMethod()
    public void tearDown(){

        CrossDriver.closeDriver(); // bit farkı da Driver'i miz CrossDriver olduğu için
                                    // driver'in kapanması için CrossDriver üzerinden
                                    // driver'i kapatiyoruz
    }
}
