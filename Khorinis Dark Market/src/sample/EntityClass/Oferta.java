package sample.EntityClass;

import javax.persistence.*;
import java.util.concurrent.ExecutionException;


@Entity
@Table(name="Oferty")
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_oferty;

    @ManyToOne
    @JoinColumn(name="id_sprzedawcy")
    private Handlarz handlarz;

    @ManyToOne
    @JoinColumn(name="id_przedmiot")
    private Przedmiot przedmiot;


    private int sztuki;
    private double cena;
    private boolean aktywna;

    @Transient
    private int sztuki_w_koszyku;

    @Transient
    private double cena_razem;


    public Oferta(Handlarz handlarz, Przedmiot przedmiot, int sztuki, double cena) {
        this.handlarz = handlarz;
        this.przedmiot = przedmiot;

        if(sztuki>0)
            this.sztuki = sztuki;
        else{
            System.out.println("Nie możesz wystawić 0 lub mniej sztuk towaru");
            throw new ExceptionInInitializerError();
        }

        this.cena = cena;
        aktywna=true;
        this.sztuki_w_koszyku=0;

    }

    public int getSztuki_w_koszyku() {
        return sztuki_w_koszyku;
    }

    public void setSztuki_w_koszyku(int sztuki_w_koszyku) {
        this.sztuki_w_koszyku = sztuki_w_koszyku;
    }

    public int getSztuki() {
        return sztuki;
    }

    public void setSztuki(int sztuki) {
        this.sztuki = sztuki;
    }

    public boolean isAktywna() {
        return aktywna;
    }

    public void setAktywna(boolean aktywna) {
        this.aktywna = aktywna;
    }

    public Oferta(){

    }

    public Handlarz getHandlarz() {
        return handlarz;
    }

    public void setHandlarz(Handlarz handlarz) {
        this.handlarz = handlarz;
    }

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getId_oferty() {
        return id_oferty;
    }

    public double getCena_razem() {
        return cena_razem;
    }

    public void setCena_razem(double cena_razem) {
        this.cena_razem = cena_razem;
    }
}
