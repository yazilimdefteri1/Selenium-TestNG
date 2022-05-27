package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanimi {
    @Test
    public void test01() {
        FacebookPage faceBookPage= new FacebookPage();
        // facebook anasayfaya gidin
        Driver.getDriver().get("https://www.facebook.com");
        // cikarsa cookies kabul edin
        // cookies cikmiyor
        // kullanici mail kutusuna rastgele bir isim yazdirin
        Faker faker=new Faker();
        faceBookPage.mailKutusu.sendKeys(faker.internet().emailAddress());
        // kullanici sifre kutusuna rastgele bir password yazdirin
        faceBookPage.passKutusu.sendKeys(faker.internet().password());
        // login butonuna basin
        faceBookPage.loginButonu.click();
        // giris yapilamadigini test edin
        Assert.assertTrue(faceBookPage.girilemediYaziElementi.isDisplayed());
        Driver.closeDriver();

    }
}
