@chatbot  @runAll
Feature: US02 Kullanici Size nasil yardimci olabilirim pop-up ini kullanabilmeli.

  Background:
    Given Kullanıcı Urle gider
    And Anasayfada Size Nasıl Yardimci olabilirim PopUpa tiklar
    When Acilan pencereden Devam butonuna tiklar

  @chatbot-tc01 @smoke
  Scenario: US02 - TC01 Kullanici istenen Islem seçeneklerini secebilmeli

    And Valid random ad soyad bilgilerini girer ve gonder butonuna tiklar
    And Valid random telefon numarası girer ve gonder butonuna tiklar
    And Random valid mail adresi bilgisini girer ve gonder butonuna tiklar
    And Kullanici random islem numarasi girer
    Then Ilgili soruya yönlendirildigini dogrular
    And Sayfalari kapatir

  @chatbot-tc02
  Scenario Outline: US02 - TC02 Kullanici invalid isim bilgisi ile islem yapamamali
# INVALID ISIM GIRILIYOR HATA MESAJI VERMIYOR. xxxxxxxx
    And Kullanici "<invalidIsim>" girer
   # Then Uyarı mesajini dogrular
    And Sayfalari kapatir
    Examples:
      | invalidIsim |
      | 8551231wq   |
      | asddwq;     |
      | %+^12^2     |
      | 1558265     |

  @chatbot-tc03
  Scenario Outline: US02 - TC03 Kullanici invalid telefon no ile islem yapamamali
    And Valid random ad soyad bilgilerini girer ve gonder butonuna tiklar
    And Kullanici "<invalidTel>"numarasi girer
    Then Uyarı mesajini dogrular
    And Sayfalari kapatir
    Examples:
      | invalidTel            |
      | 1151111               |
      | 879952125544566988414 |
      | 56586899ab            |
      | 5                     |

  @chatbot-tc04
  Scenario Outline: US02 - TC04 Kullanici invalid mail adresi ile islem yapamamali
   # INVALID MAILI KABUL EDIYOR  XXXXX
    And Valid random ad soyad bilgilerini girer ve gonder butonuna tiklar
    And Valid random telefon numarası girer ve gonder butonuna tiklar
    And Kullanici "<invalidMail>" girer ve gonderir
   # Then Uyarı mesajini dogrular
    And Sayfalari kapatir
    Examples:
      | invalidMail  |
      | asdads.com   |
      | asddasads    |
      | 123123123    |
      | asdad@ds.com |
      | as^#@g       |

  @chatbot-tc05  @smoke @wip
  Scenario: US02 - TC05 Kullanici Çıkış yazarak servisten ayrılabilmeli
    And Valid random ad soyad bilgilerini girer ve gonder butonuna tiklar
    And Valid random telefon numarası girer ve gonder butonuna tiklar
    And Random valid mail adresi bilgisini girer ve gonder butonuna tiklar
    And Kullanici random islem numarasi girer
    Then Ilgili soruya yönlendirildigini dogrular
    And Isleme devam eder gonder tusuna basar
    And Kullanici Cikis yazar ve gondere basar
    Then Ilgili mesaji dogrular
    And Sayfalari kapatir



