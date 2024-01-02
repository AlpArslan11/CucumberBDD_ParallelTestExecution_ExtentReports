package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import pages.Belgeler_page;
import pages.YurtDisiUcretHesapla_page;
import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class ReusableMethods {


    //   HARD WAIT WITH THREAD.SLEEP
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void clickByJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void switchToWindow(int windowNumber) {
        List<String> list = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(list.get(windowNumber));
    }

    //========Hover Over=====//
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    // Services
    public static void navigateToUrl() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        waitFor(1);
    }

    public static void closePopUp() {
        try {

            Driver.getDriver()
                    .findElement(By.xpath("//div[@class='popup-close']//*[@xmlns='http://www.w3.org/2000/svg']"))
                    .click();
        } catch (Exception e) {
        }
    }

    public static void closeCookies() {
        waitFor(1);

        try {
            SearchContext shadowRootElement =
                    Driver.getDriver().findElement(By.cssSelector(".efilli-layout-default")).getShadowRoot();
            WebElement hiddenElement =
                    shadowRootElement.findElement(By.cssSelector(".banner__accept-button"));
//            shadowRootElement.findElement(By.cssSelector("banner__reject-button"));
            hiddenElement.click();
        } catch (Exception ignored) {
        }
    }

    public static String validTelNoOlustur() {
        Random rnd = new Random();

        return String.valueOf(268) + (rnd.nextInt(999 - 100) + 100) + (rnd.nextInt(9999 - 1000) + 1000);
    }

    public static String validAdSoyadGetir() {
        Faker faker = new Faker();
        return faker.name().fullName();
    }

    public static String validMailOlustur() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String randomIslemNoOlustur(List<WebElement> islemListesi) {
        Random rnd = new Random();

        int randomIslemNo = rnd.nextInt(islemListesi.size()) + 1;
        if (randomIslemNo < 1) randomIslemNo = 1;
        if (randomIslemNo > islemListesi.size() - 2) {
            randomIslemNo = islemListesi.size() - 2;
        }
        return String.valueOf(randomIslemNo);
    }

    public static void randomUlkeSec() {
        YurtDisiUcretHesapla_page ydUcretHesapla_page = new YurtDisiUcretHesapla_page();

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        waitFor(1);
        Random rnd = new Random();
        List<WebElement> ulkelerListesi;
        int rndNumber;
        try {
            ulkelerListesi = ydUcretHesapla_page.ulkeIsimleri_list;
            rndNumber = rnd.nextInt(ulkelerListesi.size()) + 1;
            ulkelerListesi.get(rndNumber).click();
        } catch (Exception e) {
            ydUcretHesapla_page.nereye_textBox.sendKeys("a");
            ulkelerListesi = ydUcretHesapla_page.ulkeIsimleri_list;
            rndNumber = rnd.nextInt(ulkelerListesi.size()) + 1;
            ulkelerListesi.get(rndNumber).click();
        }
    }

    public static void gonderiDetayindaUcretGoruntulendiginiDogrula(){
        YurtDisiUcretHesapla_page ydUcretHesapla_page = new YurtDisiUcretHesapla_page();
        waitForVisibility(ydUcretHesapla_page.itemTotalPrice_text, 2);
        String totalPriceStr = ydUcretHesapla_page.itemTotalPrice_text.getText();

        int commaIndex;
        int itemTotalPrice=0;
        if (ydUcretHesapla_page.itemTotalPrice_text.getText().length() < 4) {
        } else {
            commaIndex = totalPriceStr.indexOf(",");
            itemTotalPrice = Integer.parseInt(totalPriceStr.substring(0, commaIndex));
        }
        waitForVisibility(ydUcretHesapla_page.itemTotalPrice_text, 2);
        assertTrue("item's total price is not as expected", itemTotalPrice > 0);
        assertTrue("item's price is not displayed", ydUcretHesapla_page.itemTotalPrice_text.isDisplayed());
    }

    public static void gonderiDetayindanUcretGoruntulenmediginiDogrula(){
        YurtDisiUcretHesapla_page ydUcretHesapla_page = new YurtDisiUcretHesapla_page();
        List<WebElement> priceList = ydUcretHesapla_page.itemTotalPrice_list;
        assertTrue("item's price is displayed", ydUcretHesapla_page.itemTotalPrice_list.isEmpty());
    }

    public static void belgeleriDogrula(int belgeSayisi){
        Belgeler_page belgeler_page = new Belgeler_page();

        scrollIntoViewJS(belgeler_page.belgelerTitle_text);
        assertEquals("Number of Belgeler are not the same as expected number.", belgeler_page.belgelerIsimleriWE_list.size(), belgeSayisi);
        Actions actions=new Actions(Driver.getDriver());
        List<WebElement>belgeIsimleriListesi = belgeler_page.belgelerIsimleriWE_list;
        int count=0;
        for (int i = 0; i < belgeIsimleriListesi.size(); i++) {
            waitFor(1);
            belgeIsimleriListesi.get(i).click();
            count++;
            waitForVisibility(belgeler_page.belgeResimiWE,2);
            assertTrue(count + " Belge Pic is not displayed",belgeler_page.belgeResimiWE.isDisplayed());
            waitForVisibility(belgeler_page.belgeyiIndir_button,2);
            assertTrue("Belgeyi indir - button isnot displayed",belgeler_page.belgeyiIndir_button.isDisplayed());
            actions.sendKeys(Keys.ESCAPE).perform();
        }
        System.out.println(count + " tane belge resimleri ile kontrol edildi.");
    }

}