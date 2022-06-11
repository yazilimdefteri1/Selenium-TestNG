package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TrendyolPage {

       public TrendyolPage(){
            PageFactory.initElements(Driver.getDriver(),this);
        }

        @FindBy(xpath = "// div[text()='Sepette İndirimli']" )
        public WebElement sepetteIndirimli;


        @FindBy(xpath = "//div[@class='add-to-basket-button-text']" )
        public WebElement sepeteEkle;
/*
        @FindBy(xpath = "//input[@name='password']" )
        public WebElement passwordTextBox;

        @FindBy(xpath = "//button[@type='submit']" )
        public WebElement ikinciLoginButonu;

        @FindBy(id = "dropdown-basic-button" )
        public WebElement kullaniciProfilIsmi;

        */

    }
