package class1;

import org.testng.annotations.Test;

public class enableDisable {
    @Test(enabled = false)//  if you want to temporarily disable a test method or group of test methods, you can set the enabled attribute to false.
    public void Atest(){
        System.out.println("1st");
    }
    @Test
public void Btest(){
        System.out.println("2nd");
    }

}



