@belgeler  @runAll
Feature: US03 Kullanıcı Sürdürülebilirlik sekmesindeki -Kalite Yönetim Sistemi- ndeki belgeleri görüntüleyebilmeli.

  @belgeler-tc01  @wip
  Scenario:US03 - TC01 Kullanıcı Sürdürülebilirlik sekmesindeki -Kalite Yönetim Sistemi- ndeki belgeleri görüntüleyebilmeli
    Given Kullanıcı Urle gider
    When Kullanici Surdurulebilirlik sekmesinden Kalite Yonetim Sistemini tiklar
    Then Kullanici 11 tane Belge goruntulendigini dogrular
    And  Sayfayi kapatir
