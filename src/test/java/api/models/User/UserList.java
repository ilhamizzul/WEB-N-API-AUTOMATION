package api.models.User;

public class UserList {
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String picture;

    public UserList(String id, String title, String firstName, String lastName, String picture) {
        id = this.id;
        title = this.title;
        firstName = this.firstName;
        lastName = this.lastName;
        picture = this.picture;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPicture() {
        return picture;
    }
}
