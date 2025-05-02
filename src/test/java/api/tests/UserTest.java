package api.tests;

import api.models.Common.PaginatedResponse;
import api.models.User.UserList;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test(groups = {"api"})
public class UserTest extends BaseTest{

    @Test(description = "Test Get Users", groups = {"api"})
    public void testGetAllUser() {
        Response res = userApi.getListUsers();
        res.then().assertThat().statusCode(200)
                .time(lessThan(2000L))
                .assertThat().body("data.firstName", hasItems("Carolina"));

        PaginatedResponse<UserList> userResponse = res.as(new TypeRef<PaginatedResponse<UserList>>() {});
        Assert.assertNotNull(userResponse, "Deserialization failed: User response is null!");

        List<UserList> users = userResponse.getData();
        Assert.assertNotNull(users, "Users list is null!");
        Assert.assertFalse(users.isEmpty(), "Users list is empty!");

    }
}
