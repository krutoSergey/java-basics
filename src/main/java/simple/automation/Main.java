package simple.automation;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        new AuthorizationTests().testLogin();

//        OrderTests orderTests = new OrderTests();
//        orderTests.testCreateOrder();
//        orderTests.testListOrders(null);

        System.out.println("The end");
    }
}
