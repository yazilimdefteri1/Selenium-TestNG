package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    POM'da Driver icin TestBase class'ina extends etmek yerine
    Driver class'indan static methodlar kullanarak
    Driver oluşturup ilgili ayarlarin yapilmasi
     ve en sonunda Driver'in kapatilmasi tercih edilmistir.


     POM'de Driver Class'indeki getDriver()'nin obje olusturularak kullanilmasini engellemek icin
     Singleton pattern kullanimi benisenmistir.

     Singleton pattern: tekli kullanim, bir class'in farkli class'lardan
     obje olusturularak kullanimini engellmeke icin kullanilir.

 bunu saglamak icin yapmamiz gereken sey oldukca basit
 obje olusturmak icin kullanilan constructor'i private yaptigimizda baska class'larda
 Driver Class'indan obje olusturulmasi mumkun OLAMAZ
     */
    private Driver(){

    }

        static WebDriver driver;

    public static WebDriver getDriver(){

    if (driver==null) {
        switch(ConfigReader.getProperty("browser")){
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "safari" :
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge" :
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "headless-chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                break;
                default :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
        return driver;
    }

    public static void closeDriver(){
        if (driver!=null) {
            driver.close();
            driver=null;
        }

    }
}
