package api.models.User;

public class UserResponse {
    private java.util.List<UserList> users;
    private int total;
    private int page;
    private int limit;

    public UserResponse(java.util.List<UserList> users, int total, int page, int limit) {
        this.users = users;
        this.total = total;
        this.page = page;
        this.limit = limit;
    }

    public java.util.List<UserList> getUsers() {
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

