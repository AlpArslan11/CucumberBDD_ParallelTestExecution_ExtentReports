package stepDefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Belgeler_page;

import static utilities.ReusableMethods.*;

public class Belgeler_StepDefs {
    Belgeler_page belgeler_page = new Belgeler_page();


    @When("Kullanici Surdurulebilirlik sekmesinden Kalite Yonetim Sistemini tiklar")
    public void kullaniciSurdurulebilirlikSekmesindenKaliteYonetimSisteminiTiklar() {
        hover(belgeler_page.surdurulebilirlikSekmesi_ddm);
        belgeler_page.kaliteYonetimSistemi_button.click();
    }

    @Then("Kullanici {int} tane Belge goruntulendigini dogrular")
    public void kullaniciTaneBelgeGoruntulendiginiDogrular(int belgeSayisi) {
        belgeleriDogrula(belgeSayisi);

    }


}
