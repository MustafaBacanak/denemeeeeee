@e2etestmeryem
  Feature: Vice Dean ogrenci olusturabilmeli
    Scenario:TC01_Vice_Dean_Basarili_bir_sekilde_ogrenci_olusturabilmeli
      Given Kullanici login e tiklar
      When Username kutusuna "meryem25" girer
      And Password kutusuna "12345678" girer
      And Login butonuna tiklar
      And Menu butonuna tiklar
      And Student Management Butonuna tiklar
      And Ogernci icin Choose Advisor Teacher secer
      And Choose Advisor Teacher menusunden bir ogretmen secer
      And Name kutusuna "bir isim" girer
      And Surname kutusuna "bir soyisim" girer
      And Birth Place "bir yer ismi" girer
      And Email kutusuna "bir eposta adresi" girer
      And Phone kutusuna "bir telefon numarasi" girer
      And Gender bolumunden "FEMALE" secenegini secer
      And Date Of Birth bolumune bir tarih girer
      And Ssn kutusuna bir numara girer
      And User Name kutusuna "bir kullanici adi" girer
      And Father Name kutusuna "bir baba adi" girer
      And Mother Name kutusuna "bir anne adi" girer
      And Password kutusuna bir sifre girer
      And Submit butonuna click eder
      Then  kullanici "Student saved Successfully" basari mesajini dogrular


    Scenario: TC01_Kayit_sirasinda_gonderilen_veriler_ile_Responstaki_verilerin_ayni_oldugu_dogrulanir
      Given  Kayitli Ogrencinin Id bilgisi alinir_API
      And Kayitli Ogrenci userId ile cagirilir
      Then Ogrenci bilgileri dogrulanir
    #  And Kayitli ogrenci silinir

    Scenario: TC01_Ogrenci_kayidi_sirasinda_gonderilen_verilerin_DataBase_dogrulamasi_yapilir
      Given Kayitli ogrencinin UserId bilgisi ile sorgu yapilir
      Then Ogrenci bilgilerinin database dogrulamasi yapilir