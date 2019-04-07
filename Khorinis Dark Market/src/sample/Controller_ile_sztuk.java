package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import sample.EntityClass.Oferta;

import javax.security.auth.login.Configuration;
import javax.swing.plaf.synth.ColorType;


public class Controller_ile_sztuk {

    @FXML
    TextField do_wpisania;
    @FXML
    Slider slider;

    private static int ile_sztuk;

    static Slider slider_s;
    @FXML
    void initialize(){
        slider_s=slider;

    }
    @FXML
    void zatwierdz_sztuki(){
        ile_sztuk = Integer.parseInt(do_wpisania.getText());

        if(ile_sztuk>Controller.zaznaczona_oferta.getSztuki())
        {
            System.out.println("Nie ma tylu sztuk");
        }
        else{
            Controller.dodaj_do_koszyka(ile_sztuk);

            Controller.stage.close();
        }

    }

    public static int getIle_sztuk() {
        return ile_sztuk;
    }

    public static void setIle_sztuk(int ile_sztuk) {
        Controller_ile_sztuk.ile_sztuk = ile_sztuk;
    }
}
