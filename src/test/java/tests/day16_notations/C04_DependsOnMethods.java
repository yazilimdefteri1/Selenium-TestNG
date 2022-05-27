package tests.day16_notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;


import java.time.Duration;

public class C04_DependsOnMethods {

    // extends TestBase Yapmadik
    // cunku adim adim method olusturdugumuz icin
    // afterMethodda chrome kapandigi icin diger testler calismayacaktir.


    /*
    DependsOnMethods test methoalarinin calisma siralamasina karisma
    Sadece bagli olan test, baglandigi testin sonucuna bakar
    baglandigi test Passed olmazsa, baglanan test hic calismaz(ignore)
     */
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void test01(){
        //amazon anasayfaya gidelim
        driver.get("https://www.ramazon1.com");
    }

    @Test (dependsOnMethods="test01",priority = 0)
    public void test02(){
        // Nutellaaratalim
        WebElement aramaKurutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKurutusu.sendKeys("Nutella"+ Keys.ENTER);
    }
    @Test (dependsOnMethods="test02")
    public void test03(){
        // Sonuc yazisinin Nutella icerdigini test edelim

        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));
    }
    @Test
    public void test04(){
        System.out.println("Bak bu calsiti");
    }

}
