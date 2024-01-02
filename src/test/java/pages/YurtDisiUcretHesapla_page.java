package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class YurtDisiUcretHesapla_page {
    public YurtDisiUcretHesapla_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='popup-close']//*[@xmlns='http://www.w3.org/2000/svg']")
    public WebElement popUpClose_button;
    @FindBy(xpath = "//*[@href='/kargo-ucreti-hesaplama']")
    public WebElement ucretHesapla_button;
    @FindBy(xpath = "//*[@class='area-select']//*[contains(.,'Yurt D')]")
    public WebElement yurtDisi_button;
    @FindBy(xpath = "//mat-option[@role='option']")
    public List<WebElement> ulkeIsimleri_list;
    @FindBy(xpath = "//*[@class='selectable-box' and contains(.,'Dosya')]")
    public WebElement dosyaEvrak_button;
    @FindBy(xpath = "//*[@class='item-total-price']")
    public WebElement itemTotalPrice_text;
    @FindBy(xpath = "//*[@class='selectable-box_title' and contains(.,'Kutu')]")
    public WebElement kutuKoli_button;
    @FindBy(xpath = "(//input[@type='text'])[5]")
    public WebElement nereye_textBox;
    @FindBy(xpath = "(//input[@type='number'])[1]")
    public WebElement agirlik_textBox;
    @FindBy(xpath = "(//input[@type='number'])[2]")
    public WebElement boy_textBox;
    @FindBy(xpath = "(//input[@type='number'])[3]")
    public WebElement yukseklik_textBox;
    @FindBy(xpath = "(//input[@type='number'])[4]")
    public WebElement en_textBox;
    @FindBy(xpath = "//*[contains(text(),'Kg Hesapla')]")
    public WebElement dsKgHesapla_button;
    @FindBy(xpath = "//button[.='Yeni Hesaplama Yap']")
    public WebElement yeniHesaplamaYap_button;
    @FindBy(xpath = "//*[@class='detail-pages-hero__title' and contains(.,'Teslim süreleri ve ücret hesaplama')]")
    public WebElement ucretHesaplamaSayfasi_text;
    @FindBy(xpath = "//input[@type='number' and @aria-invalid='true']")
    public WebElement invalidInput_sign;
    @FindBy(xpath = "//*[@class='item-total-price']")
    public List<WebElement> itemTotalPrice_list;
    @FindBy(xpath = "//small[@class='error-block ng-star-inserted']")
    public WebElement agirlikInvalidMsg_text;

}
