package steps;

import pojos.CreateUserResponse;
import pojos.UserPojoFull;

import static io.restassured.RestAssured.given;

public class UsersSteps {

    private CreateUserResponse user;

    public UserPojoFull getUser() {
        return given().get("/" + user.getId()).as(UserPojoFull.class);
    }

    public static UserPojoFull getUser(int id) {
        return given().get("/" + id).as(UserPojoFull.class);
    }
}
