@uitest
Feature: Admin Deanleri görebilmeli ve silebilmeli
  Scenario: TC01_Admin_Deanlerin_Name_Gender_PhoneNumber_SSN_UserName_Bilgilerini_Gorebilmeli
    Given Kullanici login e tiklar
    When Username kutusuna "AdminB103" girer
    And Password kutusuna "12345678" girer
    And Login butonuna tiklar
    And Menu butonuna tiklar
    And Dean Management butonuna tiklar
    And DeanName kutusuna "bir isim" girer
    And DeanSurName kutusuna "bir soyisim" girer
    And DeanBirthPlace kutusuna "bir yer ismi" girer
    And DeanGender "Female" secenegini girer
    And DeanDateOfBirth kutusuna tarih girer
    And DeanPhone kutusuna "bir telefon numarasi" girer
    And DeanSSN kutusuna SSNno girer
    And DeanUserName kutusuna "bir kullanici adi" girer
    And DeanPassword kutusuna sifre girer
    And DeanSubmit butonuna tiklar
    And Dean list gorundugu dogrulanir
    And Dean list son sayfaya gider
    And Dean list son satırda eklenen deani dogrular
    And EditDean butonuna tiklar
    And DeanUpdate kutusunu gunceller
    Then EditDeanSubmit butonuna tiklar
    Then DeanUpdateSuccessfully uyarisi gorundugu dogrlanir