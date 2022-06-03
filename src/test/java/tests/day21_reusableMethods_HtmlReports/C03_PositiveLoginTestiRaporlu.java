package tests.day21_reusableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PositiveLoginTestiRaporlu extends TestBaseRapor {
    BrcPage brcPage=new BrcPage();

    @Test
    public void positiveLoginTest() {
        extentTest=extentReports.createTest("Pozitif Login","Gecerli username ve sifre ile giris yapabilmeli");

        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");
        //      login butonuna bas
        brcPage.ilkLoginButonu.click();
        extentTest.info("Login butonuna tiklandi");

        // test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Gecerli email yazildi");

        // test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("Gecerli password yazildi");
        // LOGİN BUTONUNA TİKLAYİN
        brcPage.ikinciLoginButonu.click();
        extentTest.info("Login butonuna tiklandi");
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        String actualUserNmae= brcPage.kullaniciProfilIsmi.getText();
        String expectedUserName=ConfigReader.getProperty("brcVliadName");
        Assert.assertEquals(actualUserNmae, expectedUserName);

        extentTest.pass("kullanici basarili sekilde giris yapti");

        Driver.closeDriver();
    }
}
