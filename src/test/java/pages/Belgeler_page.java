package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Belgeler_page {

    public Belgeler_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='menu-item ng-tns-c588362358-0 ng-star-inserted' and contains(.,'Sürdürülebilirlik')]")
    public WebElement surdurulebilirlikSekmesi_ddm;
    @FindBy(xpath = "//*[@class='menu-item ng-tns-c588362358-0 ng-star-inserted' and contains(.,'Sürdürülebilirlik')]//a[contains(.,'Kalite Yönetim Sistemi')]")
    public WebElement kaliteYonetimSistemi_button;
    @FindBy(xpath = "//h3[contains(.,'Belgeler')]")
    public WebElement belgelerTitle_text;
    @FindBy(xpath = "//*[@class='file-box-grey__wrapper']")
    public List<WebElement> belgelerIsimleriWE_list;
    @FindBy(xpath = "//a[contains(.,' Belgeyi İndir ')]")
    public WebElement belgeyiIndir_button;
    @FindBy(xpath = "//img[@class='file-box-grey__image ng-star-inserted']")
    public WebElement belgeResimiWE;

}
