package com.test1;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(com.test1.CustomListener.class)
public class TestClass1 {

    @Parameters({"firstParameter","secondParameter"})
    @Test
    public void testNotEquals(int firstParameter, int  secondParameter) throws Exception {
        Assert.assertNotEquals(firstParameter,secondParameter);
        System.out.println("Success!");
    }

//mvn clean test -DsuiteXmlFile=testng.xml
}
