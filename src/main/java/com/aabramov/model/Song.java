package com.aabramov.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Andrii Abramov on 11/13/15.
 */
@XmlRootElement
public class Song implements Serializable {
    
    private String name;
    private String singer;
    
    
    public Song() {
    }
    
    public Song(String name, String singer) {
        this.name = name;
        this.singer = singer;
    }
    
    @Override
    public String toString() {
        return String.format("Song{name='%s', singer='%s'}", name, singer);
    }
    
    public String getName() {
        return name;
    }
    
    
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
    
    
    public String getSinger() {
        return singer;
    }
    
    
    @XmlElement
    public void setSinger(String singer) {
        this.singer = singer;
    }
}
