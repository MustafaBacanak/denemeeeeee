@e2etestEsra6
Feature: Vice Dean ders olusturabilmelidir
  Scenario:TC05_Lesson_Name_sembol_girilmemeli
    Given Kullanici login e tiklar
    When Username kutusuna "gurkayvd" girer
    And Password kutusuna "22qw76AS*" girer
    And Login butonuna tiklar
    And Menu butonuna tiklar
    And Lesson Management butonuna tiklar
    And Lessons sekmesine tiklar
    And Lesson Name alanina "*$/" girer
    And Credit Score alanina "ders kredisini" yazar
    And Lessons sayfasindaki Submit butonuna tiklar
    Then Dersin eklenmedigini dogrular



  Scenario: TC05_Lesson_Name_sayisal_deger_kaydedilmemeli_ve_Responstaki_verilerin_ayni_oldugu_dogrulanir
    Given Kaydedilen dersin lessonId bilgisi alinir
    And Kaydedilen ders lessonId ile cagirilir
    Then Lesson bilgileri dogrulanir
#    And Kayitli lesson silinir


  Scenario: TC01_Lesson_Kayit_sirasinda_gonderilen_verilerin_DataBase_dogrulamasi_yapilir
    Given Kayitli dersin LessonId bilgisi ile sorgu yapilir
    Then Lesson bilgileri ile database dogrulamasi yapilir