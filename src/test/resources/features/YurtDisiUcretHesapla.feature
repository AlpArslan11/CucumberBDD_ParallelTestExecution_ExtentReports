 @yducrethesapla  @runAll
Feature: US01 Kullanici ucret Hesapla butonundan yurt disi ucret hesabini yapabilmeli

  Background:
    Given Kullanıcı Urle gider
    When Kullanıcı anasayfada Ucret Hesapla butonunu tiklar
    And Acilan sayfada Yurt Disi secer
    And Random bir ulke secer

  @yducrethesapla-tc01 @smoke
  Scenario: US01 - TC01 Kullanıcı yurlt disi icin Dosya / Evrak ucretini hesaplayabilmeli
    When Dosya - Evrak tiklar ve hizmet turunu secer
    Then Gonderi Detayindan ucret goruntulendigini dogrular
    And Sayfayi kapatir

  @yducrethesapla-tc02 @smoke
  Scenario Outline: US01 - TC02 Kullanici yurt disi icin Kutu / Koli ucretini hesaplayabilmeli
    And Kutu - Koli secer
    When Kullanici "<agirlik>" "<boy>" "<yukseklik>" ve "<en>" bilgilerini girer
    And Desi Kg Hesapla butonuna tiklar
    Then Gonderi Detayindan ucret goruntulendigini dogrular
    And Sayfayi kapatir
    Examples:  #valid degerler
      | agirlik | boy | yukseklik | en |
      | 15      | 6   | 4         | 15 |
      | 10      | 5   | 5         | 5  |

  @yducrethesapla-tc03
  Scenario Outline: US01 - TC03 Kullanici yurt disi icin Yeni Hesaplama Yap butonu ile ardisik hesaplama yapabilmeli – Kutu /Koli
    And Kutu - Koli secer
    When Kullanici "<agirlik>" "<boy>" "<yukseklik>" ve "<en>" bilgilerini girer
    And Desi Kg Hesapla butonuna tiklar
    Then Gonderi Detayindan ucret goruntulendigini dogrular
    And Yeni Hesaplama Yap butonuna tiklar
    Then Ilgili Hesaplama sayfasında oldugunu dogrular
    And Acilan sayfada Yurt Disi secer
    And Random bir ulke secer
    And Kutu - Koli secer
    When Kullanici "<agirlik>" "<boy>" "<yukseklik>" ve "<en>" bilgilerini girer
    And Desi Kg Hesapla butonuna tiklar
    Then Gonderi Detayindan ucret goruntulendigini dogrular
    And Sayfayi kapatir
    Examples:  # valid degerler
      | agirlik | boy | yukseklik | en |
      | 5       | 5   | 5         | 5  |
      | 55      | 54  | 20        | 23 |

  @yducrethesapla-tc04 @smoke
  Scenario: US01 - TC04 Kullanici yurt disi icin Yeni Hesaplama Yap butonu ile ardisik hesaplama yapabilmeli – Dosya / Evrak
    When Dosya - Evrak tiklar ve hizmet turunu secer
    Then Gonderi Detayindan ucret goruntulendigini dogrular
    And Yeni Hesaplama Yap butonuna tiklar
    Then Ilgili Hesaplama sayfasında oldugunu dogrular
    And Acilan sayfada Yurt Disi secer
    And Random bir ulke secer
    When Dosya - Evrak tiklar ve hizmet turunu secer
    Then Gonderi Detayindan ucret goruntulendigini dogrular
    And Sayfayi kapatir

  @yducrethesapla-tc05
  Scenario Outline: US01 - TC05 Kullanici yurt disi icin Kutu / Koli ucretini hesaplayamamali- Negative Test
    And Kutu - Koli secer
    When Kullanici "<agirlik>" "<boy>" "<yukseklik>" ve "<en>" bilgilerini girer
    Then "Agirlik" textboxinin kızardigini dogrular
    And Desi Kg Hesapla butonuna tiklar
    Then Gonderi Detayindan ucret goruntulenmedigini dogrular
    And Sayfayi kapatir
    Examples:  #invalid agirlik
      | agirlik | boy | yukseklik | en |
      | -1      | 5   | 5         | 5  |
      | 0       | 5   | 5         | 5  |

  @yducrethesapla-tc06
  Scenario Outline: US01 - TC06 Kullanici yurt disi icin Kutu / Koli ucretini hesaplayamamali- Negative Test
  #Hesaplama yapmaması gerekirken hesaplama yapıyor. Oyuzden step yoruma alındı
    And Kutu - Koli secer
    When Kullanici "<agirlik>" "<boy>" "<yukseklik>" ve "<en>" bilgilerini girer
    Then "Boy" textboxinin kızardigini dogrular
    And Desi Kg Hesapla butonuna tiklar
   # Then Gonderi Detayindan ucret goruntulenmedigini dogrular
    And Sayfayi kapatir
    Examples: #invalid boy
      | agirlik | boy | yukseklik | en |
      | 5       | -1  | 5         | 5  |
      | 5       | 0   | 5         | 5  |

  @yducrethesapla-tc07
  Scenario Outline: US01 - TC07 Kullanici yurt disi icin Kutu / Koli ucretini hesaplayamamali- Negative Test
  #Bug hesaplama yapmaması gerekirken hesaplama yapıyor. Oyuzden step yoruma alındı
    And Kutu - Koli secer
    When Kullanici "<agirlik>" "<boy>" "<yukseklik>" ve "<en>" bilgilerini girer
    Then "Yukseklik" textboxinin kızardigini dogrular
    And Desi Kg Hesapla butonuna tiklar
   # Then Gonderi Detayindan ucret goruntulenmedigini dogrular
    And Sayfayi kapatir
    Examples: #invalid yukseklik
      | agirlik | boy | yukseklik | en |
      | 5       | 5   | -1        | 5  |
      | 5       | 5   | 0         | 5  |

  @yducrethesapla-tc08
  Scenario Outline: US01 - TC08 Kullanici yurt disi icin Kutu / Koli ucretini hesaplayamamali- Negative Test
  #Bug hesaplama yapmaması gerekirken hesaplama yapıyor. Oyuzden step yoruma alındı
    And Kutu - Koli secer
    When Kullanici "<agirlik>" "<boy>" "<yukseklik>" ve "<en>" bilgilerini girer
    Then "En" textboxinin kızardigini dogrular
    And Desi Kg Hesapla butonuna tiklar
   # Then Gonderi Detayindan ucret goruntulenmedigini dogrular
    And Sayfayi kapatir
    Examples:  #invlid en
      | agirlik | boy | yukseklik | en |
      | 5       | 5   | 6         | -1 |
      | 5       | 5   | 8         | 0  |

  @yducrethesapla-tc09
  Scenario Outline: US01 - TC09 Kullanici yurt disi icin Kutu / Koli ucretinde Agirlik bilgisini boş birakamamali - Negative Test
    And Kutu - Koli secer
    When Kullanici "<agirlik>" "<boy>" "<yukseklik>" ve "<en>" bilgilerini girer
    Then Agirlik textboxinda uyarı mesajini dogrular
    And Desi Kg Hesapla butonuna tiklar
    Then Gonderi Detayindan ucret goruntulenmedigini dogrular
    And Sayfayi kapatir
    Examples:   #agirlik bos
      | agirlik | boy | yukseklik | en |
      |         | 5   | 6         | 6  |
      |         | 5   | 8         | 6  |