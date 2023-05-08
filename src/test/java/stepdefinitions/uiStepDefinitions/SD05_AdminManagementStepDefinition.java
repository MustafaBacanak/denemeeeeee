package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import pages.P05_AdminManagementPage;
import pages.P09_TeacherManagementPage;
import utilities.ReusableMethods;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;



public class SD05_AdminManagementStepDefinition {




//Nurullah Taşkan - 20.Satır

    P05_AdminManagementPage adminManagementPage=new P05_AdminManagementPage();
    P09_TeacherManagementPage teacherManagementPage=new P09_TeacherManagementPage();
    Faker faker=new Faker();

    @When("Surname kutusuna {string} girilir")
    public void surname_kutusuna_valid_deger_girilir(String soyisim) {
        if(soyisim.equals("soyisim")){
            adminManagementPage.surnameBox.sendKeys(faker.name().lastName());
        }else {
            adminManagementPage.surnameBox.sendKeys(soyisim);
        }        ReusableMethods.waitFor(1);
    }
    @When("Birth Place kutusuna {string} girilir")
    public void birth_place_kutusuna_valid_deger_girilir(String dogumYeri) {
        if(dogumYeri.equals("dogum yeri")){
            adminManagementPage.birthPlaceBox.sendKeys(faker.address().country());
        }else {
            adminManagementPage.birthPlaceBox.sendKeys(dogumYeri);
        }
        ReusableMethods.waitFor(1);
    }
    @When("Username kutusuna {string} girilir")
    public void username_kutusuna_valid_deger_girilir(String kullaniciAdi) {
        if(kullaniciAdi.equals("kullanici adi")){
            adminManagementPage.usernameBox.sendKeys(faker.name().username());
        }else {
            adminManagementPage.usernameBox.sendKeys(kullaniciAdi);
        }
        ReusableMethods.waitFor(1);
    }
    @When("Password kutusuna {string} girilir")
    public void password_kutusuna_valid_deger_girilir(String sifre) {
        if(sifre.equals("sifre")){
            adminManagementPage.passwordBox.sendKeys(faker.internet().password(8,11));
        }else {
            adminManagementPage.passwordBox.sendKeys(sifre);
        }
        ReusableMethods.waitFor(1);
    }
    @When("Phone kutusuna {string} girilir")
    public void phone_kutusuna_valid_deger_girilir(String telNo) {
        if(telNo.equals("tel no")){
            adminManagementPage.phoneNumberBox.sendKeys(faker.regexify("[0-9]{3}-[0-9]{3}-[0-9]{4}"));
        }else {
            adminManagementPage.phoneNumberBox.sendKeys(telNo);
        }
        ReusableMethods.waitFor(1);
    }
    @When("SSN kutusuna {string} girilir")
    public void ssn_kutusuna_valid_deger_girilir(String kimlikNo) {
        if(kimlikNo.equals("kimlik no")){
            adminManagementPage.ssnBox.sendKeys(faker.regexify("[0-8]{3}-[0-9]{2}-[0-9]{4}"));
        }else {
            adminManagementPage.ssnBox.sendKeys(kimlikNo);
        }
        ReusableMethods.waitFor(1);
    }
    @When("Gender seçilir")
    public void gender_seçilir() {
        adminManagementPage.maleButton.click();
    }
    @When("Date Of Birth kutusuna {string} girilir")
    public void date_of_birth_kutusuna_valid_deger_girilir(String dogumTarihi) {
        if(dogumTarihi.equals("dogum tarihi")){
            Date date=faker.date().past(365*100, TimeUnit.DAYS);
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
            String formatDate=simpleDateFormat.format(date);
            adminManagementPage.dateOfBirthBox.sendKeys(formatDate);        }else {
            adminManagementPage.dateOfBirthBox.sendKeys(dogumTarihi);
        }
        ReusableMethods.waitFor(1);
    }
    @When("Submit butonuna tiklanir")
    public void submit_butonuna_tiklanir() {
       adminManagementPage.submitButton.click();
        ReusableMethods.waitFor(2);
    }
    @Then("Admin Saved pop-up mesajinin gorunur oldugu dogrulanmalidir")
    public void admin_saved_pop_up_mesajinin_gorunur_oldugu_dogrulanmalidir() {
        assertEquals("Admin Saved",adminManagementPage.adminSavedPopUp.getText());
        System.out.println("adminManagementPage.adminSavedPopUp.getText() = " + adminManagementPage.adminSavedPopUp.getText());
    }
    @And("Name kutusuna tiklanir")
    public void nameKutusunaTiklanir() {
        adminManagementPage.nameBox.click();
    }
    @Then("Name kutusunun altinda Required yazisinin gorunur oldugu dogrulanmalidir")
    public void nameKutusununAltindaRequiredYazisininGorunurOlduguDogrulanmalidir() {
        assertTrue(adminManagementPage.nameRequired.isDisplayed());
    }
    @Then("Kayit isleminin gerceklesmedigi dogrulanir")
    public void kayitIslemininGerceklesmedigiDogrulanir() {
        assertFalse(adminManagementPage.adminSavedPopUp.getText().contains("Saved"));
        //System.out.println(adminManagementPage.adminSavedPopUp.getText());
    }
    @And("Name kutusuna {string} girilir")
    public void nameKutusunaGirilir(String isim) {
        if(isim.equals("isim")){
            adminManagementPage.nameBox.sendKeys(faker.name().firstName());
        }else {
            adminManagementPage.nameBox.sendKeys(isim);
        }
    }
    @And("Surname kutusuna tiklanir")
    public void surnameKutusunaTiklanir() {
        adminManagementPage.surnameBox.click();
    }
    @Then("Surname kutusunun altinda Required yazisinin gorunur oldugu dogrulanmalidir")
    public void surnameKutusununAltindaRequiredYazisininGorunurOlduguDogrulanmalidir() {
        assertTrue(adminManagementPage.surnameRequired.isDisplayed());
    }

    @And("Birth Place kutusuna tiklanir")
    public void birthPlaceKutusunaTiklanir() {
        adminManagementPage.birthPlaceBox.click();
    }

    @Then("Birth Place kutusunun altinda Required yazisinin gorunur oldugu dogrulanmalidir")
    public void birthPlaceKutusununAltindaRequiredYazisininGorunurOlduguDogrulanmalidir() {
        assertTrue(adminManagementPage.birtPlaceRequired.isDisplayed());
    }
    @And("Username kutusuna tiklanir")
    public void usernameKutusunaTiklanir() {
        adminManagementPage.usernameBox.click();
    }
    @Then("Username kutusunun altinda Required yazisinin gorunur oldugu dogrulanmalidir")
    public void usernameKutusununAltindaRequiredYazisininGorunurOlduguDogrulanmalidir() {
        assertTrue(adminManagementPage.usernameRequired.isDisplayed());
    }
    @And("Password kutusuna tiklanir")
    public void passwordKutusunaTiklanir() {
        adminManagementPage.passwordBox.click();
    }
    @Then("Password kutusunun altinda Required yazisinin gorunur oldugu dogrulanmalidir")
    public void passwordKutusununAltindaRequiredYazisininGorunurOlduguDogrulanmalidir() {
        ReusableMethods.waitFor(1);
        assertTrue(adminManagementPage.passwordRequired.isDisplayed());
    }
    @And("Phone kutusuna tiklanir")
    public void phoneKutusunaTiklanir() {
        adminManagementPage.phoneNumberBox.click();
    }
    @Then("Phone kutusunun altinda Required yazisinin gorunur oldugu dogrulanmalidir")
    public void phoneKutusununAltindaRequiredYazisininGorunurOlduguDogrulanmalidir() {
        assertTrue(adminManagementPage.phoneRequired.isDisplayed());
    }
    @And("SSN kutusuna tiklanir")
    public void ssnKutusunaTiklanir() {
        adminManagementPage.ssnBox.click();
    }
    @Then("SSN kutusunun altinda Required yazisinin gorunur oldugu dogrulanmalidir")
    public void ssnKutusununAltindaRequiredYazisininGorunurOlduguDogrulanmalidir() {
        assertTrue(adminManagementPage.ssnRequired.isDisplayed());
    }
    @Then("Kayit islemi olmadigi dogrulanir")
    public void kayitIslemiOlmadigiDogrulanir() {
        assertTrue(adminManagementPage.adminSavedPopUp.isDisplayed());
    }

    @And("Female butonuna tiklanir")
    public void femaleButonunaTiklanir() {
        adminManagementPage.femaleButton.click();
        ReusableMethods.waitFor(1);
    }

    @And("Male butonuna tiklanir")
    public void maleButonunaTiklanir() {
        adminManagementPage.maleButton.click();
    }

    @Then("Female butonunun secili olmadigi dogrulanir")
    public void femaleButonununSeciliOlmadigiDogrulanir() {
        assertFalse(adminManagementPage.femaleButton.isSelected());
    }

    @And("Date Of Birth kutusuna tiklanir")
    public void dateOfBirthKutusunaTiklanir() {
        adminManagementPage.dateOfBirthBox.click();
    }

    @Then("Date Of Birth kutusunun altinda Required yazisinin gorunur oldugu dogrulanmalidir")
    public void dateOfBirthKutusununAltindaRequiredYazisininGorunurOlduguDogrulanmalidir() {
        assertTrue(adminManagementPage.dateOfBirthRequired.isDisplayed());
    }

    @Then("Gender alani altinda Required yazisinin olmadigi dogrulanir")
    public void genderAlaniAltindaRequiredYazisininOlmadigiDogrulanir() {
        assertTrue(teacherManagementPage.genderField.getText().contains(teacherManagementPage.requiredMesaji.getText()));
    }


    //Nurullah Taşkan - 120.Satır


}
