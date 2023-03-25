package class1;

import org.testng.annotations.Test;

public class dependsOn {
    @Test
    public void  Login(){
        System.out.println("i am here");
    }

    @Test(dependsOnMethods = "Login")
    public void dashboardVerification() {
        try {
            System.out.println("I am verifying dashboard after login");
            // Your dashboard verification code goes here
        } catch (Exception e) {
            System.out.println("Dashboard verification failed: " + e.getMessage());
        }}}