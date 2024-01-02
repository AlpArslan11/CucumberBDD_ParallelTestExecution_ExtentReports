package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pages.YurtDisiUcretHesapla_page;
import utilities.Driver;

import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.*;

public class YurtDisiUcretHesapla_StepDefs {

    YurtDisiUcretHesapla_page yducret_page = new YurtDisiUcretHesapla_page();
    Actions actions;

    @When("Kullanıcı anasayfada Ucret Hesapla butonunu tiklar")
    public void kullanıcıAnasayfadaUcretHesaplaButonunuTiklar() {
        if (!yducret_page.ucretHesapla_button.isDisplayed()) {
            yducret_page.popUpClose_button.click();
        }
        clickByJS(yducret_page.ucretHesapla_button);
    }

    @And("Acilan sayfada Yurt Disi secer")
    public void acilanSayfadaYurtDisiSecer() {
        yducret_page.yurtDisi_button.click();
    }

    @And("Random bir ulke secer")
    public void randomBirUlkeSec() {
        randomUlkeSec();
    }

    @When("Dosya - Evrak tiklar ve hizmet turunu secer")
    public void dosyaEvrakTiklarVeHizmetTurunuSecer() {
        yducret_page.dosyaEvrak_button.click();
    }

    @Then("Gonderi Detayindan ucret goruntulendigini dogrular")
    public void gonderiDetayindanUcretGoruntulendiginiDogrular() {
        gonderiDetayindaUcretGoruntulendiginiDogrula();
    }

    @And("Sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }

    @And("Kutu - Koli secer")
    public void kutuKoliSecer() {
        yducret_page.kutuKoli_button.click();
    }

    @When("Kullanici {string} {string} {string} ve {string} bilgilerini girer")
    public void kullaniciAgirlikBoyYukseklikveEnBilgileriniGirer(String agirlik, String boy, String yukseklik, String en) {
        waitFor(1);
        yducret_page.agirlik_textBox.sendKeys(agirlik);
        yducret_page.boy_textBox.sendKeys(boy);
        yducret_page.yukseklik_textBox.sendKeys(yukseklik);
        yducret_page.en_textBox.sendKeys(en);
    }

    @And("Desi Kg Hesapla butonuna tiklar")
    public void desiKgHesaplaButonunaTiklar() {
        yducret_page.dsKgHesapla_button.click();
    }

    @And("Yeni Hesaplama Yap butonuna tiklar")
    public void yeniHesaplamaYapButonunaTiklar() {
        yducret_page.yeniHesaplamaYap_button.click();
        scrollIntoViewJS(yducret_page.ucretHesaplamaSayfasi_text);
    }

    @Then("Ilgili Hesaplama sayfasında oldugunu dogrular")
    public void ilgiliHesaplamaSayfasındaOldugunuDogrular() {
        assertTrue("ilgili ucret hesaplama sayfasında değil",
                yducret_page.ucretHesaplamaSayfasi_text.isDisplayed());
    }

    @Then("Gonderi Detayindan ucret goruntulenmedigini dogrular")
    public void gonderiDetayindanUcretGoruntulenmediginiDogrular() {
        gonderiDetayindanUcretGoruntulenmediginiDogrula();
    }

    @Then("{string} textboxinin kızardigini dogrular")
    public void textboxininKızardiginiDogrular(String string) {
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).perform();
        assertTrue("Should be red and warn that it is invalid input",
                yducret_page.invalidInput_sign.isDisplayed());
    }

    @Then("Agirlik textboxinda uyarı mesajini dogrular")
    public void agirlikTextboxindaUyarıMesajiniDogrular() {
        assertTrue("Error message is not visible", yducret_page.agirlikInvalidMsg_text.isDisplayed());
    }
}
