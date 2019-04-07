package sample.EntityClass;

import javax.persistence.*;

@Entity
@Table(name="Handlarze")
public class Handlarz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_handlarza;

    private String imie;

    @ManyToOne
    @JoinColumn(name="id_obozu")
    private Oboz oboz;

    public Handlarz(String imie, Oboz oboz) {
        this.imie = imie;
        this.oboz = oboz;
    }
    public Handlarz(){}


    public int getId_handlarza() {
        return id_handlarza;
    }

    public void setId_handlarza(int id_handlarza) {
        this.id_handlarza = id_handlarza;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Oboz getOboz() {
        return oboz;
    }

    public void setOboz(Oboz oboz) {
        this.oboz = oboz;
    }

    @Override
    public String toString(){
        return imie;
    }
}
