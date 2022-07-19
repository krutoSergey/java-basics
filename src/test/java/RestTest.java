import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UserPojoFull;
import utils.RestWrapper;
import utils.UserGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RestTest  {

    private static RestWrapper api;

    @BeforeAll
    public static void prepareClient() {
        api = RestWrapper.loginAs("eve.holt@reqres.in", "cityslicka");
    }

    @Test
    public void getUsers() {
////        List<UserPojo> users = given()
//        List<UserPojoFull> users = given()
//                .spec(REQ_SPEC)
//                .when().get()
//                .then().statusCode(200)
//                .extract().jsonPath().getList("data", UserPojoFull.class);
////                .body("data[0].email", equalTo("george.bluth@reqres.in"));
////                .body("data.find{it.email=='george.bluth@reqres.in'}.first_name", equalTo("George"));

//        List<UserPojoFull> users = UsersSteps.getUsers();
        assertThat(api.user.getUsers()).extracting(UserPojoFull::getEmail).contains("george.bluth@reqres.in");
    }

    @Test
    public void createUser() {
        UserRequest rq = UserGenerator.getSimpleUser();

//        CreateUserResponse rs = given()
//                .spec(REQ_SPEC)
//                .body(rq)
//                .when().post()
//                .then().extract().as(CreateUserResponse.class);

//        UsersSteps userApi = new UsersSteps();
//        CreateUserResponse rs = userApi.createUser(rq);
        CreateUserResponse rs = api.user.createUser(rq);
                assertThat(rs)
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(rq.getName());
    }
}
