@e2etestEsra13
Feature: Vice Dean ders olusturabilmelidir
  Scenario:TC13_Credit_Score_space_karakteri_girilememeli
    Given Kullanici login e tiklar
    When Username kutusuna "gurkayvd" girer
    And Password kutusuna "22qw76AS*" girer
    And Login butonuna tiklar
    And Menu butonuna tiklar
    And Lesson Management butonuna tiklar
    And Lessons sekmesine tiklar
    And Lesson Name alanina "ders adi" girer
    And Credit Score alanina "  " yazar
    And Lessons sayfasindaki Submit butonuna tiklar
    Then Dersin eklenmedigini dogrular


  Scenario: TC13_Credit_Score_space_karakteri_girilememeli_ve_Responstaki_verilerin_ayni_oldugu_dogrulanir
    Given Kaydedilen dersin lessonId bilgisi alinir
    And Kaydedilen ders lessonId ile cagirilir
    Then Lesson bilgileri dogrulanir
#    And Kayitli lesson silinir


  Scenario: TC13_Lesson_Kayit_sirasinda_gonderilen_verilerin_DataBase_dogrulamasi_yapilir
    Given Kayitli dersin LessonId bilgisi ile sorgu yapilir
    Then Lesson bilgileri ile database dogrulamasi yapilir





