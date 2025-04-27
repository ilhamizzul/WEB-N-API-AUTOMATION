package api.tests;

import api.apis.UserApi;
import api.models.User.UserResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {
    private UserApi userApi = new UserApi();

    @Test
    public void testGetAllUser() {
        Response res = userApi.getListUsers();
        Assert.assertEquals(res.getStatusCode(), 200);
        System.out.println(res.getBody().prettyPrint());
//        UserResponse[] users = res.getBody().as(UserResponse[].class);
//        Assert.assertTrue(users.length > 0);

    }
}
