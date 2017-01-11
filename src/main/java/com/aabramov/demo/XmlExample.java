package com.aabramov.demo;

import com.aabramov.model.Album;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import static com.aabramov.demo.FileAccessor.getFile;

/**
 * @author Andrii Abramov on 11/14/15.
 */
public class XmlExample implements DemoExample {
    
    private static final String FILE_NAME = "album.xml";
    
    private JAXBContext context;
    
    
    public XmlExample() {
        try {
            context = JAXBContext.newInstance(Album.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
    
    public void writeXML() {
        Album album = Album.getSimpleAlbum();
        
        try {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(album, getFile(FILE_NAME));
            marshaller.marshal(album, System.out);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        
    }
    
    
    public void readXML() {
        
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Album album = (Album) unmarshaller.unmarshal(getFile("album.xml"));
            System.out.println(album);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    
    @Override
    public void doDemo() {
        writeXML();
        readXML();
    }
}
