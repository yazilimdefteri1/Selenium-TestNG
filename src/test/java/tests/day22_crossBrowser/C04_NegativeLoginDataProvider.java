package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginDataProvider {
    BrcPage brcPage;


    @DataProvider
    public static Object[][] kullaniciLstesi() {

        Object[][] kullaniciBilgileri={{"firuze@nehaber.com", "54678"},
                                       {"murat@benbuisibilirim.com", "65874"},
                                       {"ilyas@hollandadanselam.com", "85967"}};

        return kullaniciBilgileri;

    }


    @Test (dataProvider = "kullaniciLstesi")
    public void yanlisSifre(String userMail, String password) {
        brcPage  = new BrcPage();

        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        brcPage.ilkLoginButonu.click();
        // test data user email: dataprovider'dan alalim
        brcPage.emailTextBox.sendKeys(userMail);
        // test data password : dataprovider'dan alalim
        brcPage.passwordTextBox.sendKeys(password);
        // LOGİN BUTONUNA TİKLAYİN
        brcPage.ikinciLoginButonu.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et


        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());

        Driver.closeDriver();
        //bu class'da 2 test methodu daha olusturun
        // biri yanlisKullanici
        // digeri de yanlis sifre ve kullanici adi
    }
}
