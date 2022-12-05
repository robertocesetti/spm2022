package it.unicam.spm2022;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class MyClassTest {

    /**
     * It tests the method multiply of the class MyClass
     */
    @Test
    void testMultiply(){
        MyClass tester = new MyClass();
        assertEquals(50, tester.multiply(10,5), "10x5 should be 50");
    }


}
