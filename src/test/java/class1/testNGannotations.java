package class1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class testNGannotations {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am the method biachezz");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am the after method:(");
    }
    @Test(groups = "regression")
    public void aFirstTesCase(){
        System.out.println("I am the first test case");
    }
@Test
    public void bSecondTestCase(){
    System.out.println("I am the second test case");
}
@Test
    public void cThirdTestCase(){
    System.out.println("I am the third test case");
}

// Alphabetic order
}

