@e2etest @US01

@UI
Feature:Aday ögrenciler sisteme kayıt olabilmelidir
  Scenario: TC01_Kullanici_valid_degerler_ile_register_olabilmelidir
    Given Kullanici register a tiklar
    When Name kutusuna "bir isim" girer
    And Surname kutusuna "bir soyisim" girer
    And Birth Place "bir yer ismi" girer
    And Phone kutusuna "bir telefon numarasi" girer
    And Gender bolumunden bir cinsiyet secer
    And Date Of Birth bolumune bir tarih girer
    And Ssn kutusuna bir numara girer
    And User Name kutusuna bir "kullanici adi" girer
    And Password kutusuna "bir sifre" girer
    And Kullanici register butonuna tiklar
    Then Guest User Registeted Pop-Up mesajinin gorunur oldugu dogrulanir


  @API
  Scenario: TC01_Kayit_sirasinda_gonderilen_veriler_ile_Responstaki_verilerin_ayni_oldugu_dogrulanir
    Given Kayitli ogrecinin userid bilgisi alinir_Api
    Then Ogrenci bilgileri dogrulanir_z
    #And Kayitli ogrenci silinir_z

  @DB
  Scenario: TC01_Kayit_sirasinda_gonderilen_verilerin_DataBase_dogrulamasi_yapilir
    Given Kayitli ogrencinin UserId bilgileri ile sorgu yapilir
    Then Ogrenci kaydinin database dogrulamasi yapilir





