package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Album;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by abrasha on 11/13/15.
 */
public class GsonTest {

    private Gson gson;

    public GsonTest(){
        gson = new GsonBuilder().setPrettyPrinting().create();
    }



    public void jsonWrite() throws Exception{
        Album album = Album.getSimpleAlbum();
        String json = gson.toJson(album);

        FileWriter writer = new FileWriter(FileAccessor.getFile("gson_album.json"));
        writer.write(json);
        writer.close();
    }



    public void jsonRead() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(FileAccessor.getFile("gson_album.json")));

        Album album = gson.fromJson(br, Album.class);

        System.out.println(album);

    }



    public void test(){
        try{
            jsonWrite();
            jsonRead();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
