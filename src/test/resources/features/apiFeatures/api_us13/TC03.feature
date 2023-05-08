@e2etest
Feature: TC03 | Name kutusuna sayısal bir değer girilerek kayıt yapılamamalı

  Scenario: WEB_sitesinde_name_kutusuna_sayisal_deger_girilerek_kayit_yapilamamali
    Given Kullanici login e tiklar
    When Username kutusuna "gurkayvd" girer
    And Password kutusuna "22qw76AS*" girer
    And Login butonuna tiklar
    And Menu butonuna tiklar
    And Teacher Management butonuna tiklar
    And Choose Lesson menusune tiklar
    And Choose Lesson menusunden bir ders secer
    And Name kutusuna "898" girer
    And Surname kutusuna "bir soyisim" girer
    And Birth Place "bir yer ismi" girer
    And Email kutusuna "bir eposta adresi" girer
    And Phone kutusuna "bir telefon numarasi" girer
    And Gender bolumunden "FEMALE" secenegini secer
    And Date Of Birth bolumune bir tarih girer
    And Ssn kutusuna bir numara girer
    And User Name kutusuna "bir kullanici adi" girer
    And Password kutusuna bir sifre girer
    And Submit butonuna tiklar
    Then Kayit isleminin gerceklestigini dogrular

  Scenario: API_testi_ile_web_sitesinde_yapilan_kaydin_basarisiz_oldugu_dogrulanir
    Given "Vice Dean" yetkisi ile giris yapilir
    And Kayitli ogretmenin userId bilgisi alinir
    And Kayitli ogretmen userId ile cagrilir
    Then Kaydin gerceklesmedigi dogrulanir

  Scenario: DATABASE_testi_ile_web_sitesinde_yapilan_kaydin_basarisiz_oldugu_dogrulanir
    Given Kayitli ogretmenin UserId bilgisi ile sorgu yapilir
    Then Ogretmen bilgilerinin database icinde olmadigi dogrulamasi yapilir

  Scenario: Ogretmen_kaydi_silinir
    Given Kayitli ogretmen userId ile cagrilir
    And Kayitli ogretmen silinir
    Then Ogretmen kaydinin silindigi dogrulanir