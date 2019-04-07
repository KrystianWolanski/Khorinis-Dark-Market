package sample.EntityClass;

import javax.persistence.*;

@Entity
@Table(name="Obozy")
public class Oboz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_obozu;

    private String nazwa;

    public Oboz(String nazwa) {
        this.nazwa = nazwa;
    }
    public Oboz(){}


    public int getId_obozu() {
        return id_obozu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
