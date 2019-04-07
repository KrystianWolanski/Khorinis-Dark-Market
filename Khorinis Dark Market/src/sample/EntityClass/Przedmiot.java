package sample.EntityClass;

import javafx.scene.image.Image;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name="Przedmioty")
public class Przedmiot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_przedmiotu;

    private String nazwa;
    private String opis;


    @Lob
    private byte[] image_b;

    @Transient
    private Image image;

    public Przedmiot(String nazwa, String opis, byte[] image_b, Image image) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.image_b = image_b;
        this.image = image;
    }
    public Przedmiot(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
    }
    public Przedmiot(){}

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setCena(String opis) {
        this.opis = opis;
    }

    public int getId_produktu() {
        return id_przedmiotu;
    }

    @Override
    public String toString(){
        return nazwa;
    }

    public byte[] getImage_b() {
        return image_b;
    }

    public void setImage_b(byte[] image_b) {
        this.image_b = image_b;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
