package tests.day21_reusableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_WindowHandle_ReusableMethods {

    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        String ilkSayfaWindowHandleDegeri=Driver.getDriver().getWindowHandle();

        //● Click Here butonuna basın.
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        Set<String> windowHandleseti= Driver .getDriver().getWindowHandles();

        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti
        ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWindowHandleDegeri);

        System.out.println(Driver.getDriver().getTitle());
        // acilan yeni tab'in title'inin "New Window" olduğunu test edin
        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void test02() {

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        String ilkSayfaWindowHandleDegeri=Driver.getDriver().getWindowHandle();

        //● Click Here butonuna basın.
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        // acilan yeni tab'in title'inin "New Window" olduğunu test edin

        ReusableMethods.switchToWindow("New Window");

        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        Driver.closeDriver();

    }
}
