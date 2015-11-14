package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by abrasha on 11/13/15.
 */

@XmlRootElement
public class Album implements Serializable {

    private String name;
    private String singer;
    private Set<Song> songs;

    private int realeaseYear;



    public static Album getSimpleAlbum(){
        Album album = new Album();
        album.setName("Meat");
        album.setSinger("King and clown");
        album.setRealeaseYear(2002);

        Set<Song> songs = new HashSet<Song>(5);

        songs.add(new Song("Прыгну со скалы", "King and clown"));
        songs.add(new Song("Лесник", "King and clown"));
        songs.add(new Song("Охотник", "King and clown"));
        songs.add(new Song("Проклятый старый дом", "King and clown"));
        songs.add(new Song("Тяни", "King and clown"));

        album.setSongs(songs);
        return album;
    }



    @Override
    public String toString(){
        return "Album{" +
                "name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                ", realeaseYear=" + realeaseYear +
                ", songs=" + songs +
                '}';
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



    public int getRealeaseYear(){
        return realeaseYear;
    }



    @XmlElement
    public void setRealeaseYear(int realeaseYear){
        this.realeaseYear = realeaseYear;
    }



    public Set<Song> getSongs(){
        return songs;
    }



    @XmlElement(name = "song")
    public void setSongs(Set<Song> songs){
        this.songs = songs;
    }


}
