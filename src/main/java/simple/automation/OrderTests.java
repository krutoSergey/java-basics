package simple.automation;

import org.junit.Test;

public class OrderTests extends BaseTestWithOrder{

    @Test
    public void testCreateOrder(){

        System.out.println("Check order was created");
    }

    @Test
    public void testListOrders(){
        System.out.println("List orders");
        System.out.println("Check order is displayed");
    }

}
