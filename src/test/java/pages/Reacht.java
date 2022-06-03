

package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;
public class Reacht {
    public Reacht() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@tabindex='1']")
    public List<WebElement> ürünlistesi;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/main/div/div/p")
    public List<WebElement> ürünIsmi;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/main/div/div/button")
    public List<WebElement> randomListe;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/button/span")
    public WebElement butonTiklama;
    @FindBy(xpath = "//p[@class='sc-124al1g-6 ljgnQL']")
    public List<WebElement> fiyatListesi;
    @FindBy (xpath = "//*[@id=\"root\"]/div/div/button/div")
    public WebElement sepet;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[3]/div/p[1]")
    public WebElement toplamFiyat;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[3]/button")
    public WebElement checkbutton;
}
