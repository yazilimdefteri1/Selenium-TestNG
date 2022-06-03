package tests.day18_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Reacht;
import utilities.ConfigReader;
import utilities.Driver;
import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
public class K01_TechPro {
    @Test
    public void test01() throws InterruptedException {
        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("reactUrl"));
        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        Reacht rs = new Reacht();
        for (int i = 0; i < rs.ürünlistesi.size(); i++) {
            System.out.println(i + 1 + ".Ürün :" + rs.ürünlistesi.get(i).getText());
        }
        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        for (WebElement each : rs.ürünIsmi
        ) {
            System.out.println(each.getText());
        }
// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        //   WebDriverWait wait=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15) );
// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
// (Her ürün 1 defadan fazla eklenemez!)
        Random rnd = new Random();
        int secim = 5;
        List<String> fiyat = new ArrayList<>();
        for (int i = 0; i < secim; i++) {
            int index = rnd.nextInt(rs.randomListe.size());
            rs.randomListe.get(index).click();
            System.out.println("********" + rs.ürünIsmi.get(index).getText());
            Thread.sleep(2000);
            rs.butonTiklama.click();
            // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
            System.out.println(rs.fiyatListesi.get(index).getText());
            fiyat.add(rs.fiyatListesi.get(index).getText());
        }
        System.out.println("Fiyat Toplami :" + fiyat.stream().map(t -> t.substring(1)).map(Double::valueOf).reduce(Double::sum));
        Optional opt = fiyat.stream().map(t -> t.substring(1)).map(Double::valueOf).reduce(Double::sum);
        System.out.println(opt.get());
        double expectedToplam = (double) opt.get();
        DecimalFormat df = new DecimalFormat("#.##");
        df.format(expectedToplam);
        // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
        // 7.Checkout'a tıklayın
        rs.sepet.click();
        double dubledeger = Double.parseDouble(rs.toplamFiyat.getText().substring(2));
        System.out.println(dubledeger);
        // Assert.assertTrue(rs.toplamFiyat.getText().contains(opt.get().toString()));
        Assert.assertEquals(expectedToplam, dubledeger);
        rs.checkbutton.click();
        Driver.getDriver().switchTo().alert().accept();
    }
}