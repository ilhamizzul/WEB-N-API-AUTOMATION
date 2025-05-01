package api.tests;

import api.apis.UserApi;
import api.models.User.UserResponse;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"api"})
public class UserTest {
    private UserApi userApi = new UserApi();

    @Test(description = "Test Get Users", groups = {"api"})
    public void testGetAllUser() {
        Response res = userApi.getListUsers();
        res.then().assertThat().statusCode(200);

    }
}
