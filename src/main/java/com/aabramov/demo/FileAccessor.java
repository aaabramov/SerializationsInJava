package com.aabramov.demo;

import java.io.File;

/**
 * @author Andrii Abramov on 11/13/15.
 */
public class FileAccessor {
    
    public static File getFile(String name) throws Exception {
        
        File file = new File(name);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
    
}
