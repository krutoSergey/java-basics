package simple.automation;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@Smoke
public class OrderTestsIT {

    @BeforeEach
    public void createOrder() {
        System.out.println("Create order");
    }

    enum Roles {
        MANAGER("manager"),
        SENIOR_MANAGER("manager of managers"),
        LEAD_MANAGER("manager of manager of managers"),
        HEAD_WORKER("just a worker");

        Roles(String description) {
            this.description = description;
        }

        private String description;
        public String getDescription() {
            return description;
        }
    }

    static Stream<Roles> getRoles() {
        return Stream.of(Roles.MANAGER, Roles.SENIOR_MANAGER);
    }

    static Stream<Arguments> testListOrdersAsManager() {
        return Stream.of(
                arguments(Roles.MANAGER, "orders for managers"),
                arguments(Roles.SENIOR_MANAGER, "orders for senior")
        );
    }

    @Test
    public void testCreateOrder(){
        Assumptions.assumeTrue(true);
        System.out.println("Check order was created");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            throw new NullPointerException("ex");
        });
        Assertions.assertEquals("test", "test");
        Assertions.assertAll(
                () -> Assertions.assertTrue(false),
                () -> Assertions.assertFalse(true)
        );
    }

    @ParameterizedTest
//    @ValueSource(strings = {"manager", "manager of managers", "manager of manager of managers"})
//    @EnumSource(mode = EnumSource.Mode.MATCH_ALL, names = {".*MANAGER"})
    @MethodSource("getRoles")
    public void testListOrders(Roles role){
        System.out.println("List orders as " + role.getDescription());
        System.out.println("Check order is displayed");
    }

    @Tag("create")
    @ParameterizedTest
    @MethodSource
    public void testListOrdersAsManager(Roles role, String orderType){
        System.out.println("List orders as " + role.getDescription());
        System.out.println("Check order is displayed for " +  orderType);
    }

    @AfterEach
    public void deleteOrder() {
        System.out.println("Delete order");
    }
}
