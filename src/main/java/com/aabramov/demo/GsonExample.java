package com.aabramov.demo;

import com.aabramov.model.Album;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import static com.aabramov.demo.FileAccessor.getFile;

/**
 * @author Andrii Abramov on 11/13/15.
 */
public class GsonExample implements DemoExample {
    
    private Gson gson;
    private static final String FILE_NAME = "gson_album.json";
    
    public GsonExample() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    
    public void jsonWrite() {
        Album album = Album.getSimpleAlbum();
        String json = gson.toJson(album);
        
        try (FileWriter writer = new FileWriter(getFile(FILE_NAME))) {
            writer.write(json);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public void jsonRead() {
        try (BufferedReader br = new BufferedReader(new FileReader(getFile(FILE_NAME)))) {
            Album album = gson.fromJson(br, Album.class);
            System.out.println(album);
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
