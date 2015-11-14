package test;

import model.Album;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by abrasha on 11/14/15.
 */
public class XmlTest {

    private JAXBContext context;



    public XmlTest(){
        try{
            context = JAXBContext.newInstance(Album.class);
        } catch (JAXBException e){
            e.printStackTrace();
        }
    }



    public void writeXML() throws Exception{
        Album album = Album.getSimpleAlbum();

        File file = FileAccessor.getFile("album.xml");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(album, file);
        marshaller.marshal(album, System.out);


    }



    public void readXML() throws Exception{

        File file = FileAccessor.getFile("album.xml");
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Album album = (Album) unmarshaller.unmarshal(file);
        System.out.println(album);

    }



    public void test(){
        try{
            writeXML();
            readXML();
        } catch (Exception e){

        }
    }

}
