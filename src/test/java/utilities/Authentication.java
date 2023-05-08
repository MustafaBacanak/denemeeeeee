package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static void main(String[] args) {
        String guncelToken = generateToken();
        System.out.println(guncelToken);
    }

    public static String generateToken() {
        String username = "Team61";
        String password = "MedunnaTeam61*";

        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        map.put("rememberme", true);

        String endPoint = "https://www.medunna.com/api/authenticate";
        Response response1 = given().contentType(ContentType.JSON).body(map).when().post(endPoint);
        JsonPath token = response1.jsonPath();
        return token.getString("id_token");
    }

    public static RequestSpecification spec;

    public static String generateToken(String username, String password) {
        String url= ConfigReader.getProperty("base_url") + "/auth/login";
        Map<String, Object>token=new HashMap<>();
        token.put( "password", password);
        token.put("username", username);
        Response response=given().contentType(ContentType.JSON).body(token).post(url);
        response.prettyPrint();
        return response.jsonPath().getString("token");

    }

}