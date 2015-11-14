package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Album;

import java.io.File;

/**
 * Created by abrasha on 11/13/15.
 */
public class JacksonTest {

    public void jsonRead() throws Exception{

        File file = FileAccessor.getFile("jackson_album.json");

        ObjectMapper jsonReader = new ObjectMapper();
        Album album = jsonReader.readValue(file, Album.class);

        System.out.printf("Reading object from %s done.\n", file.getPath());
        System.out.println(album);

    }



    public void jsonWrite() throws Exception{

        Album album = Album.getSimpleAlbum();

        File file = FileAccessor.getFile("jackson_album.json");
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.writerWithDefaultPrettyPrinter().writeValue(file, album);

        System.out.printf("Serialization to %s done.\n", file.getPath());

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
