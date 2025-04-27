package api.apis;

import api.base.BaseApi;
import io.restassured.response.Response;

public class UserApi extends BaseApi {

    public Response getListUsers() {
        return get("user", null);
    }

    public Response getUserById(String id) {
        return get("user/" + id, null);
    }


}
