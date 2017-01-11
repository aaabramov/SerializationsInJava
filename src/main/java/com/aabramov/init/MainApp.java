package com.aabramov.init;

import com.aabramov.demo.*;

/**
 * @author Andrii Abramov on 11/13/15.
 */
public class MainApp {
    
    public static void main(String[] args) throws Exception {
        
        DemoExample jacksonTest = new JacksonTest();
        jacksonTest.doDemo();
        
        DemoExample gsonExample = new GsonExample();
        gsonExample.doDemo();
        
        DemoExample binaryExample = new BinaryExample();
        binaryExample.doDemo();
        
        DemoExample xmlExample = new XmlExample();
        xmlExample.doDemo();
        
        
    }
    
}
