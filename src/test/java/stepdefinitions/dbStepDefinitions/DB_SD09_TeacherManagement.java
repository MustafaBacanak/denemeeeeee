package stepdefinitions.dbStepDefinitions;

import io.cucumber.java.en.*;

import static org.junit.Assert.*;
import static stepdefinitions.uiStepDefinitions.SD09_TeacherManagementStepDefinition.teacherObjectPojo;

import java.sql.*;

public class DB_SD09_TeacherManagement {
    ResultSet resultSet;
    Connection connection;
    Statement statement;
    @Given("Kayitli ogretmenin UserId bilgisi ile sorgu yapilir")
    public void kayitli_ogretmenin_user_id_bilgisi_ile_sorgu_yapilir() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://164.92.252.42:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM teacher WHERE id = "+teacherObjectPojo.getUserId()+"");

        resultSet.next();
        System.out.println("Database sorgu işlemi tamamlandı");
    }
    @Then("Ogretmen bilgilerinin database dogrulamasi yapilir")
    public void ogretmen_bilgilerinin_database_dogrulamasi_yapilir() throws SQLException {
        assertEquals(teacherObjectPojo.getBirthDay(), resultSet.getString("birth_day"));
        assertEquals(teacherObjectPojo.getBirthPlace(), resultSet.getString("birth_place"));
        assertEquals(teacherObjectPojo.getGender(), resultSet.getString("gender"));
        assertEquals(teacherObjectPojo.getName(), resultSet.getString("name"));
        assertEquals(teacherObjectPojo.getPhoneNumber(), resultSet.getString("phone_number"));
        assertEquals(teacherObjectPojo.getSsn(), resultSet.getString("ssn"));
        assertEquals(teacherObjectPojo.getSurname(), resultSet.getString("surname"));
        assertEquals(teacherObjectPojo.getUsername(), resultSet.getString("username"));
        assertEquals(teacherObjectPojo.getEmail(), resultSet.getString("email"));

        connection.close();
        statement.close();
        resultSet.close();
        System.out.println("Database doğrulama işlemi tamamlandı");
    }

    @Then("Ogretmen bilgilerinin database icinde olmadigi dogrulamasi yapilir")
    public void ogretmenBilgilerininDatabaseDeOlmadigiDogrulamasiYapilir() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://164.92.252.42:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM teacher WHERE id = "+teacherObjectPojo.getUserId()+"");
        try {
            assertFalse(resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Database'de, aranan userId'ye sahip kayıt mevcut olduğu için doğrulama başarısız oldu: " + e.getMessage());
        }
        connection.close();
        statement.close();
        resultSet.close();
        System.out.println("Database doğrulama işlemi tamamlandı");
    }
}
