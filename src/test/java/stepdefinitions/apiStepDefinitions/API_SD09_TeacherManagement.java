package stepdefinitions.apiStepDefinitions;

import com.google.gson.Gson;
import io.cucumber.java.en.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import pojos.TeacherPojo;

import java.util.List;

import static base_url.ManagementSchoolBaseUrl.setup;
import static base_url.ManagementSchoolBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static stepdefinitions.uiStepDefinitions.SD09_TeacherManagementStepDefinition.teacherObjectPojo;

public class API_SD09_TeacherManagement {

    Response response;
    JsonPath jsonPath;
    TeacherPojo expectedData;

    @Given("{string} yetkisi ile giris yapilir")
    public void yetkisiIleGirisYapılır(String str) {
        if (str.equals("Vice Dean")){
            setup("gurkayvd", "22qw76AS*");
            System.out.println("Vice Dean yetkisi ile giriş yapıldı.");
        } else if (str.equals("Admin")) {
            setup("gurkayadm", "22qw76AS*");
            System.out.println("Admin yetkisi ile giriş yapıldı.");
        }else {
            System.out.println("Hatalı veri girdiniz.");
        }
    }
    @And("Kayitli ogretmenin userId bilgisi alinir")
    public void kayitliOgretmeninUserIdBilgisiAlinir() {
        spec.pathParams("first", "teachers", "second", "getAll");
        response = given(spec).get("{first}/{second}");

        jsonPath = response.jsonPath();
        List<Integer> userIdList = jsonPath.getList("findAll{it.email=='" + teacherObjectPojo.getEmail() + "'}.userId");
        teacherObjectPojo.setUserId(userIdList.get(0));
        System.out.println("Kayıtlı öğretmen userId bilgisi alındı: " + teacherObjectPojo.getUserId());
    }

    @And("Kayitli ogretmen userId ile cagrilir")
    public void kayitliOgretmenUserIdIleCagrilir() {
        spec.pathParams("first", "teachers", "second", "getSavedTeacherById", "third", teacherObjectPojo.getUserId());
        response = given(spec).get("{first}/{second}/{third}");
        System.out.println("Kayıtlı öğretmen " + teacherObjectPojo.getUserId() + " nolu userId ile çağrıldı.");
        response.prettyPrint();
        jsonPath = response.jsonPath();
    }

    @Then("Ogretmen bilgileri dogrulanir")
    public void ogretmenBilgileriDogrulanir() {
        expectedData = new TeacherPojo(teacherObjectPojo, "Teacher successfully found", "OK");

        TeacherPojo actualDataPojoGson = new Gson().fromJson(response.asString(), TeacherPojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getObject().getUsername(), actualDataPojoGson.getObject().getUsername());
        assertEquals(expectedData.getObject().getName(), actualDataPojoGson.getObject().getName());
        assertEquals(expectedData.getObject().getSurname(), actualDataPojoGson.getObject().getSurname());
        assertEquals(expectedData.getObject().getBirthDay(), actualDataPojoGson.getObject().getBirthDay());
        assertEquals(expectedData.getObject().getSsn(), actualDataPojoGson.getObject().getSsn());
        assertEquals(expectedData.getObject().getBirthPlace(), actualDataPojoGson.getObject().getBirthPlace());
        assertEquals(expectedData.getObject().getPhoneNumber(), actualDataPojoGson.getObject().getPhoneNumber());
        assertEquals(expectedData.getObject().getGender(), actualDataPojoGson.getObject().getGender());
        assertEquals(expectedData.getObject().getEmail(), actualDataPojoGson.getObject().getEmail());

        assertEquals(expectedData.getMessage(), actualDataPojoGson.getMessage());
        assertEquals(expectedData.getHttpStatus(), actualDataPojoGson.getHttpStatus());
        System.out.println(teacherObjectPojo.getUserId() + " userId nolu öğretmen bilgileri doğrulandı.");
    }

    @Then("Birden fazla ders secildigi dogrulanir")
    public void birdenFazlaDersSecildigiDogrulanir() {
        if (jsonPath.getString("object").contains("lessonPrograms")) {
            List<Object> lessons = jsonPath.getList("object.lessonPrograms");
            int numOfLessons = lessons.size();
            assertTrue(numOfLessons > 1);
            System.out.println(numOfLessons + " adet ders secildi.");
        }else {
            assertTrue(jsonPath.getString("object").contains("lessonPrograms"));
            System.out.println("Response'ta lessonPrograms bilgisi yoktur.");
        }
    }

    @Then("Kaydin gerceklesmedigi dogrulanir")
    public void kaydinGerceklesmedigiDogrulanir() {
        assertEquals(404, response.statusCode());
        assertEquals("Error: User with SSN "+teacherObjectPojo.getUserId()+" not found", response.jsonPath().getString("message"));
    }

    @Then("Kayitli ogretmen silinir")
    public void kayitli_ogretmen_silinir() {
        spec.pathParams("first", "teachers", "second", "delete", "third", teacherObjectPojo.getUserId());
        response = given(spec).delete("{first}/{second}/{third}");
        System.out.println(teacherObjectPojo.getUserId() + " userId nolu öğretmen bilgileri silindi.");
        response.prettyPrint();
    }

    @Then("Ogretmen kaydinin silindigi dogrulanir")
    public void ogretmenKaydininSilindigiDogrulanir() {
        assertEquals(200, response.statusCode());
        assertEquals("Teacher Deleted", response.jsonPath().getString("message"));
        assertEquals("OK", response.jsonPath().getString("httpStatus"));
        System.out.println(teacherObjectPojo.getUserId() + " userId nolu öğretmen kaydının silindiği doğrulandı.");
    }



}
