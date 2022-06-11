package tests.day21_reusableMethods_HtmlReports;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.TrendyolPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class K01_Trendyol extends ReusableMethods{

    TrendyolPage trendyolPage= new TrendyolPage();
    @Test
    public void test01() {
        int count=0;
        Driver.getDriver().get(ConfigReader.getProperty("trendyolUrl"));
        if (trendyolPage.sepetteIndirimli.isDisplayed()){
            count++;
        }

        System.out.println(count);


        // ReusableMethods.switchToWindow("Silva Mikrofiber Mop 3lü Kampanya Seti Fiyatı, Yorumları - TRENDYOL");
       // trendyolPage.sepeteEkle.click();
        //Actions actions=new Actions(Driver.getDriver());
        //actions.click(trendyolPage.sepetteIndirimli).
        //sendKeys(Keys.TAB).
        // perform();

        Driver.closeDriver();
    }
}
