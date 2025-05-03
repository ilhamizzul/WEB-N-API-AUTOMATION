package api.tests;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

@Test(groups = {"api"})
public class UserTest extends BaseTest{
    private String idUser = null;

    @Test(description = "Test Get Users", groups = {"api"})
    public void testGetAllUser() {
        Response res = userApi.getListUsers();
        res.then().assertThat().statusCode(200)
                .time(lessThan(2000L))
                .assertThat().body("data.firstName", hasItems("Carolina"));

        String jsonResponse = res.getBody().asString();
        idUser = JsonPath.read(jsonResponse, "$.data[0].id");
        System.out.println(idUser);
    }

    @Test(description = "Test Get 10 Users", groups = {"api"})
    public void testGetLimitedUser() {
        Map<String, String> queryParams = Map.of("limit", "10");
        Response res = userApi.getListUsers(queryParams);
        res.then().assertThat().statusCode(200)
                .time(lessThan(2000L));

        String jsonResponse = res.getBody().asString();
        var data = JsonPath.read(jsonResponse, "$.data.length()");
        Assert.assertEquals(data, 10);
    }

    @Test(description = "Test Get User By Id", groups = {"api"})
    public void testGetUserById() {
        Response res = userApi.getUserById(idUser);
        res.then().assertThat().statusCode(200)
                .time(lessThan(2000L));

        String jsonResponse = res.getBody().asString();
        Assert.assertEquals(JsonPath.read(jsonResponse, "$.id"), idUser);
    }
}
