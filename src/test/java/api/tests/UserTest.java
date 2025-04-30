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
    @Epic("User Management")
    @Feature("Get Users")
    @Story("Valid Get User List")
    @Severity(SeverityLevel.NORMAL)
//    @Step("Sending GET request to /user")
    public void testGetAllUser() {
        Response res = userApi.getListUsers();
        Assert.assertEquals(res.getStatusCode(), 200);
        System.out.println(res.getBody().prettyPrint());
//        UserResponse[] users = res.getBody().as(UserResponse[].class);
//        Assert.assertTrue(users.length > 0);

    }
}
