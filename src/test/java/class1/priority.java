package class1;

import org.testng.annotations.Test;

public class priority {
    @Test (priority = 3)
    public void Atest(){
        System.out.println("i am TestA");
    }


    @Test(priority = 1)
    public void Btest(){
        System.out.println("i am TestB");
    }


    @Test(priority = 2) //Test methods with a higher priority value are executed first.
    // If two test methods have the same priority value,
    // then they are executed in the order in which they are defined in the test class.
    public void Ctest(){
        System.out.println("i am TestC");
    }
}
