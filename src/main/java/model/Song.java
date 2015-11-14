package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by abrasha on 11/13/15.
 */

@XmlRootElement
public class Song implements Serializable {

    private String name;
    private String singer;



    public Song(){
    }



    @Override
    public String toString(){
        return "Song{" +
                "name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }



    public Song(String name, String singer){
        this.name = name;
        this.singer = singer;
    }



    public String getName(){
        return name;
    }



    @XmlElement
    public void setName(String name){
        this.name = name;
    }



    public String getSinger(){
        return singer;
    }



    @XmlElement
    public void setSinger(String singer){
        this.singer = singer;
    }
}
