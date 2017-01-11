package com.aabramov.demo;

import com.aabramov.model.Album;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.aabramov.demo.FileAccessor.getFile;

/**
 * @author Andrii Abramov on 11/13/15.
 */
public class JacksonTest implements DemoExample {
    private static final String FILE_NAME = "jackson_album.json";
    
    public void jsonRead() {
        
        try {
            ObjectMapper jsonReader = new ObjectMapper();
            Album album = jsonReader.readValue(getFile(FILE_NAME), Album.class);
            
            System.out.printf("Reading object from %s done.\n", FILE_NAME);
            System.out.println(album);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        
    }
    
    
    public void jsonWrite() {
        
        Album album = Album.getSimpleAlbum();
        
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            jsonMapper.writerWithDefaultPrettyPrinter().writeValue(getFile(FILE_NAME), album);
            System.out.printf("Serialization to %s done.\n", FILE_NAME);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        
    }
    
    
    @Override
    public void doDemo() {
        jsonWrite();
        jsonRead();
    }
}
