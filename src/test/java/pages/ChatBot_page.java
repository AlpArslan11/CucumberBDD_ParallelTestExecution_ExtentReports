package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ChatBot_page {
    public ChatBot_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//img[@alt='Chat bot icon'])[1]")
    public WebElement chatBot_icon;
    @FindBy(xpath = "//*[text()=' DEVAM >']")
    public WebElement devam_button;
    @FindBy(id = "pisano-text-input-9611e55f-7b0e-436b-9c29-88d7abd03910")
    public WebElement adSoyad_textBox;
    @FindBy(id = "pisano-text-input-7788fbbc-3d63-4b29-b934-79868db3ae52")
    public WebElement telNo_textBox;
    @FindBy(xpath = "//button[@class='pisano-send-button margin-top-5']")
    public WebElement gonder_button;
    @FindBy(id = "pisano-text-input-c80939ef-b825-442c-a5a2-f2102cb6eeea")
    public WebElement mailAdresi_textBox;
    @FindBy(xpath = "//p//br")
    public List<WebElement> islemMetni_list;
    @FindBy(id = "pisano-text-input-7c196174-2857-48f6-b103-c0b88a1c05ba")
    public WebElement islemNo_textBox;
    @FindBy(xpath = "//div//p[contains(.,'menü numarasını')]")
    public WebElement ilgiliMenuNo_text;
    @FindBy(xpath = "//*[@class='pisano-error']")
    public WebElement hataMesaji_text;
    @FindBy(id = "pisano-text-input-23ec80dd-36f1-41c1-9483-1d0c8816ae54")
    public WebElement islemDevam_textBox;
    @FindBy(xpath = "//input[@type='text']")
    public WebElement textBox;
    @FindBy(xpath = "//p[contains(.,'teşekkür ')]")
    public WebElement tesekkurMesaji_text;


}
