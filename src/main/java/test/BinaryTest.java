package test;

import model.Album;

import java.io.*;

/**
 * Created by abrasha on 11/13/15.
 */
public class BinaryTest {

    public void binaryWrite() throws Exception{
        Album album = Album.getSimpleAlbum();
        File file = FileAccessor.getFile("album.ser");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
        output.writeObject(album);
        output.close();
        fileOutputStream.close();
        System.out.printf("Java serialization to %s done.\n", file.getPath());
    }



    public void binaryRead() throws Exception{

        File file = FileAccessor.getFile("album.ser");
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream input = new ObjectInputStream(fileInputStream);
        Album album = (Album) input.readObject();
        input.close();
        fileInputStream.close();
        System.out.println(album);
    }



    public void test(){
        try{
            binaryWrite();
            binaryRead();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
