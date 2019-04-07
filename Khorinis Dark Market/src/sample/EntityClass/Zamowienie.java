package sample.EntityClass;

import javax.persistence.*;
import java.util.List;

@Entity
public class Zamowienie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_zamowienia;

    @OneToOne
    @JoinColumn(name="id_oferty")
    private Oferta oferta;

    private int ilosc_sztuk;
    private double cena_razem;

    public Zamowienie(Oferta oferta, int ilosc_sztuk, double cena_razem) {
        this.oferta = oferta;
        this.ilosc_sztuk=ilosc_sztuk;
        this.cena_razem=cena_razem;
    }

    public Zamowienie(){}

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public int getId_zamowienia() {
        return id_zamowienia;
    }

    public int getIlosc_sztuk() {
        return ilosc_sztuk;
    }

    public void setIlosc_sztuk(int ilosc_sztuk) {
        this.ilosc_sztuk = ilosc_sztuk;
    }

    public double getCena_razem() {
        return cena_razem;
    }

    public void setCena_razem(double cena_razem) {
        this.cena_razem = cena_razem;
    }
}
