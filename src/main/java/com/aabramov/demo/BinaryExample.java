package com.aabramov.demo;

import com.aabramov.model.Album;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static com.aabramov.demo.FileAccessor.getFile;

/**
 * @author Andrii Abramov on 11/13/15.
 */
public class BinaryExample implements DemoExample {
    
    public void binaryWrite() {
        Album album = Album.getSimpleAlbum();
        
        String filename = "album.ser";
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(getFile(filename));
                ObjectOutputStream output = new ObjectOutputStream(fileOutputStream)
        ) {
            output.writeObject(album);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Java serialization to %s done.\n", filename);
    }
    
    
    public void binaryRead() {
        String filename = "album.ser";
        try (
                FileInputStream fileInputStream = new FileInputStream(getFile(filename));
                ObjectInputStream input = new ObjectInputStream(fileInputStream)
        ) {
            Album album = (Album) input.readObject();
            System.out.println(album);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    
    
    @Override
    public void doDemo() {
        binaryWrite();
        binaryRead();
    }
    
}
