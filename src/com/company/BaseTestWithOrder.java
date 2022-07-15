package com.company;

public class BaseTestWithOrder extends BaseTestWithAuthorization{

    public BaseTestWithOrder() {
        System.out.println("Create order");
    }

    public void testCreateOrder(){

        System.out.println("Check order was created");
    }

    public void testListOrders(){
        System.out.println("List orders");
        System.out.println("Check order is displayed");
    }
}
