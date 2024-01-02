@uyegirisi  @runAll
Feature: US04 Kullanıcı Uye girişi butonunu tıklayabilmeli

  @uyegirisi-tc01 @smoke  @wip
  Scenario:US04 - TC01 Kullanıcı Uye girişi butonunu tıklayabilmeli
    Given Kullanıcı Urle gider
    When Uye Girisi butonu tiklar
    Then Kullanici Adi, Sifre textboxlarının goruntulendigini dogrular
    Then Giris Yap ve Sifremi Unuttum buttonlarının goruntulendigini dogrular
    And Sayfalari kapatir