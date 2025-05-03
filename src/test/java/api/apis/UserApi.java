package api.apis;

import api.base.BaseApi;
import io.restassured.response.Response;

import java.util.Map;

public class UserApi extends BaseApi {

    public Response getListUsers() {
        return get("user", null);
    }

    public Response getListUsers(Map<String, String> params) {
        return get("user", params);
    }

    public Response getUserById(String id) {
        return get("user/" + id, null);
    }

    public Response createUser(Object body) {
        return post("user/create", body);
    }


}
