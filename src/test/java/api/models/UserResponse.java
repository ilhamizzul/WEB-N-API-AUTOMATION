package api.models;

import java.util.List;

public class UserResponse {
    private List<UserList> users;
    private int total;
    private int page;
    private int limit;

    public UserResponse(List<UserList> users, int total, int page, int limit) {
        this.users = users;
        this.total = total;
        this.page = page;
        this.limit = limit;
    }

    public List<UserList> getUsers() {
        return users;
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }
}

