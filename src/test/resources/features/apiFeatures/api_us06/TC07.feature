@Kozak0607API
Feature: Dean Vice Dean hesabi olusturabilmeli
  Scenario: TC07_Surname_kutusuna_noktalama_isaretleri_girilmesi
    Given Kullanici login e tiklar
    When Username kutusuna "alexdesouza" girer
    And Password kutusuna "Kral1907" girer
    And Login butonuna tiklar
    And Name kutusuna "bir isim" girer
    And Surname kutusuna ",.?!" girer
    And Birth Place "Turkey" girer
    And Gender bolumunden "Male" secenegini secer
    And Date Of Birth bolumune bir tarih girer
    And Phone kutusuna "bir telefon numarasi" girer_Koz
    And Ssn kutusuna bir numara girer_Koz
    And User Name kutusuna "bir kullanici adi" girer
    And Password kutusuna bir sifre girer
    And Submit butonuna tiklar
    Then Kayit isleminin gerceklestigini dogrular

  Scenario: TC07_Olusturulan_vicedean_API_testinde_gorunmemeli
    Given User sets the url_Koz
    When User sets the expected data_Koz
    And User sends post request and gets the response_Koz
    Then User does assertion_Koz
    And Vice Dean silinir