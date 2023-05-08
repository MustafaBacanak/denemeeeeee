package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherUpdatePojo {


    private String birthDay;
    private String birthPlace;
    private String email;
    private String gender;
    private boolean isAdvisorTeacher;
    private List<Integer> lessonsIdList;
    private String name;
    private String password;
    private String phoneNumber;
    private String ssn;
    private String surname;
    private String username;


    public TeacherUpdatePojo() {
    }

    public TeacherUpdatePojo(String birthDay, String birthPlace, String email, String gender, boolean isAdvisorTeacher, List<Integer> lessonsIdList, String name, String password, String phoneNumber, String ssn, String surname, String username) {

        this.birthDay = birthDay;

        this.birthPlace = birthPlace;

        this.email = email;

        this.gender = gender;

        this.isAdvisorTeacher = isAdvisorTeacher;

        this.lessonsIdList = lessonsIdList;

        this.name = name;

        this.password = password;

        this.phoneNumber = phoneNumber;

        this.ssn = ssn;

        this.surname = surname;

        this.username = username;

    }

    public void setBirthDay(String birthDay) {

        this.birthDay = birthDay;

    }

    public String getBirthDay() {

        return this.birthDay;

    }

    public void setBirthPlace(String birthPlace) {

        this.birthPlace = birthPlace;

    }

    public String getBirthPlace() {

        return this.birthPlace;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    public String getEmail() {

        return this.email;

    }

    public void setGender(String gender) {

        this.gender = gender;

    }

    public String getGender() {

        return this.gender;

    }

    public void setIsAdvisorTeacher(boolean isAdvisorTeacher) {

        this.isAdvisorTeacher = isAdvisorTeacher;

    }

    public boolean getIsAdvisorTeacher() {

        return this.isAdvisorTeacher;

    }

    public void setLessonsIdList(List<Integer> lessonsIdList) {

        this.lessonsIdList = lessonsIdList;

    }

    public List<Integer> getLessonsIdList() {

        return this.lessonsIdList;

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getName() {

        return this.name;

    }

    public void setPassword(String password) {

        this.password = password;

    }

    public String getPassword() {

        return this.password;

    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;

    }

    public String getPhoneNumber() {

        return this.phoneNumber;

    }

    public void setSsn(String ssn) {

        this.ssn = ssn;

    }

    public String getSsn() {

        return this.ssn;

    }

    public void setSurname(String surname) {

        this.surname = surname;

    }

    public String getSurname() {

        return this.surname;

    }

    public void setUsername(String username) {

        this.username = username;

    }

    public String getUsername() {

        return this.username;

    }

    @Override
    public String toString() {
        return "TeacherUpdatePojo{" +
                "birthDay='" + birthDay + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", isAdvisorTeacher=" + isAdvisorTeacher +
                ", lessonsIdList=" + lessonsIdList +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", ssn='" + ssn + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}































