package stepDefinitions;


import io.cucumber.java.en.*;
import pages.ChatBot_page;
import utilities.Driver;
import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.*;



public class ChatBot_StepDef {

    ChatBot_page chatBot_page = new ChatBot_page();

    @Given("Kullanıcı Urle gider")
    public void kullanıcıUrleGider() {
        navigateToUrl();
        closePopUp();
        closeCookies();
    }

    @And("Anasayfada Size Nasıl Yardimci olabilirim PopUpa tiklar")
    public void anasayfadaSizeNasılYardimciOlabilirimPopUpaTiklar() {
        chatBot_page.chatBot_icon.click();
    }

    @When("Acilan pencereden Devam butonuna tiklar")
    public void acilanPenceredenDevamButonunaTiklar() {
        switchToWindow(1);
        Driver.getDriver().manage().window().maximize();
        chatBot_page.devam_button.click();
    }

    @And("Valid random ad soyad bilgilerini girer ve gonder butonuna tiklar")
    public void validRandomAdSoyadBilgileriniGirerVeGonderButonunaTiklar() {
        chatBot_page.adSoyad_textBox.sendKeys(validAdSoyadGetir());
        chatBot_page.gonder_button.click();
    }

    @And("Valid random telefon numarası girer ve gonder butonuna tiklar")
    public void validRandomTelefonNumarasıGirerVeGonderButonunaTiklar() {
        chatBot_page.telNo_textBox.sendKeys(validTelNoOlustur());
        chatBot_page.gonder_button.click();
    }

    @And("Random valid mail adresi bilgisini girer ve gonder butonuna tiklar")
    public void randomValidMailAdresiBilgisiniGirerVeGonderButonunaTiklar() {
        chatBot_page.mailAdresi_textBox.sendKeys(validMailOlustur());
        chatBot_page.gonder_button.click();
    }

    @And("Kullanici random islem numarasi girer")
    public void kullaniciRandomIslemNumarasiGirer() {
        chatBot_page.islemNo_textBox.sendKeys(randomIslemNoOlustur(chatBot_page.islemMetni_list));
        chatBot_page.gonder_button.click();
    }

    @Then("Ilgili soruya yönlendirildigini dogrular")
    public void ilgiliSoruyaYönlendirildiginiDogrular() {
        assertTrue("It is not the correct menu", chatBot_page.ilgiliMenuNo_text.isDisplayed());
    }

    @And("Sayfalari kapatir")
    public void sayfalariKapatir() {
        Driver.quitDriver();
    }

    @And("Kullanici {string} girer")
    public void kullaniciInvalidIsimGirer(String invalidIsim) {
        chatBot_page.adSoyad_textBox.sendKeys(invalidIsim);
        chatBot_page.gonder_button.click();
    }

    @Then("Uyarı mesajini dogrular")
    public void uyariMesajiniDogrular() {
        assertTrue("Error message is not displayed", chatBot_page.hataMesaji_text.isDisplayed());
        waitFor(2);
    }

    @And("Kullanici {string}numarasi girer")
    public void kullaniciInvalidTelNumarasiGirer(String invalidTelNo) {
        chatBot_page.telNo_textBox.sendKeys(invalidTelNo);
        chatBot_page.gonder_button.click();
    }

    @And("Kullanici {string} girer ve gonderir")
    public void kullaniciGirerVeGonderir(String invalidMail) {
        chatBot_page.mailAdresi_textBox.sendKeys(invalidMail);
        chatBot_page.gonder_button.click();
    }

    @And("Isleme devam eder gonder tusuna basar")
    public void islemeDevamEderGonderTusunaBasar() {
        chatBot_page.islemDevam_textBox.sendKeys("1");
        chatBot_page.gonder_button.click();
    }

    @And("Kullanici Cikis yazar ve gondere basar")
    public void kullaniciCikisYazarVeGondereBasar() {
        chatBot_page.textBox.sendKeys("Çıkış");
        chatBot_page.gonder_button.click();
    }

    @Then("Ilgili mesaji dogrular")
    public void ilgiliMesajiDogrular() {
        assertTrue(chatBot_page.tesekkurMesaji_text.getText().contains("teşekkür"));
    }
}


