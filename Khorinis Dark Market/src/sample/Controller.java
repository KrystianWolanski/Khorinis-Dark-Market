package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.EntityClass.*;
import sun.plugin2.util.ColorUtil;
import sun.security.util.BitArray;

import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    TableView<Oferta> tabela, tabela2, tabela3;
    @FXML
    TableColumn<Oferta, String> sprzedawca_nazwa, sprzedawca_nazwa2, sprzedawca_koszyk;
    @FXML
    TableColumn<Oferta, String> przedmiot_nazwa, przedmiot_nazwa2, przedmiot_koszyk;
    @FXML
    TableColumn<Oferta, Double> cena, cena2, cena_razem_koszyk;
    @FXML
    TableColumn<Oferta, Integer> sztuki, sztuki2, sztuki_koszyk;

    //Lista zamówień
    @FXML
    TableView<Zamowienie> tabela_zamowienia;
    @FXML
    TableColumn<Zamowienie, Integer> nr_zamowienia_kolumna;
    @FXML
    TableColumn<Zamowienie, String> sprzedawca_kolumna, przedmiot_kolumna;
    @FXML
    TableColumn<Zamowienie, Double> cena_kolumna;
    @FXML
    TableColumn<Zamowienie, Integer> sztuki_kolumna;


    @FXML
    Text brylki, za_malo_rudy;

    @FXML
    Text razem_do_zaplaty_text;

    static Text razem_do_zaplaty_text_s;

    ///DODAWANIE OFERT PANEL

    @FXML
    ChoiceBox<Handlarz> sprzedawca_choice;
    @FXML
    ChoiceBox<Przedmiot> przedmiot_choice;

    @FXML
    TextField cena_dodaj_oferte, sztuki_dodaj_oferte;

    //Image
    @FXML
    ImageView image_view;

    @FXML
    TextField brylki_do_ustawienia;


    @FXML
    void initialize() {

        //DODAWAWNIE OFERT PANEL
        for (Handlarz sprzedawca : Main.lista_handlarzy) {
            sprzedawca_choice.getItems().add(sprzedawca);

        }
        for (Przedmiot przedmiot : Main.lista_przedmiotow) {
            przedmiot_choice.getItems().add(przedmiot);
        }

        przedmiot_choice.valueProperty().addListener(new ChangeListener<Przedmiot>() {
            @Override
            public void changed(ObservableValue<? extends Przedmiot> observable, Przedmiot oldValue, Przedmiot newValue) {
                Przedmiot przedmiot = przedmiot_choice.getValue();
                image_view.setImage(przedmiot.getImage());

            }
        });

        za_malo_rudy_s = za_malo_rudy;
        tabela2_s = tabela2;
        tabela3_s = tabela3;
        tabela_s = tabela;
        brylki_s = brylki;
        razem_do_zaplaty_text_s = razem_do_zaplaty_text;

        TypedQuery query = Main.entityManager.createQuery("select ofer from sample.EntityClass.Oferta ofer", Oferta.class);
        ObservableList<Oferta> oferty = FXCollections.observableArrayList(
                //query.getResultList()
                Main.lista_ofert
        );

        sprzedawca_nazwa.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Oferta, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Oferta, String> param) {
                return new ObservableValueBase<String>() {
                    @Override
                    public String getValue() {
                        return param.getValue().getHandlarz().getImie();
                    }
                };
            }
        });

        przedmiot_nazwa.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Oferta, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Oferta, String> param) {
                return new ObservableValueBase<String>() {
                    @Override
                    public String getValue() {
                        return param.getValue().getPrzedmiot().getNazwa();
                    }
                };
            }
        });
        cena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        sztuki.setCellValueFactory(new PropertyValueFactory<>("sztuki"));

        sprzedawca_nazwa2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Oferta, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Oferta, String> param) {
                return new ObservableValueBase<String>() {
                    @Override
                    public String getValue() {
                        return param.getValue().getHandlarz().getImie();
                    }
                };
            }
        });

        przedmiot_nazwa2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Oferta, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Oferta, String> param) {
                return new ObservableValueBase<String>() {
                    @Override
                    public String getValue() {
                        return param.getValue().getPrzedmiot().getNazwa();
                    }
                };
            }
        });
        cena2.setCellValueFactory(new PropertyValueFactory<>("cena"));
        sztuki2.setCellValueFactory(new PropertyValueFactory<>("sztuki"));

        tabela.setItems(oferty);
        tabela3.setItems(oferty);

        sprzedawca_koszyk.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Oferta, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Oferta, String> param) {
                return new ObservableValueBase<String>() {
                    @Override
                    public String getValue() {
                        return param.getValue().getHandlarz().getImie();
                    }
                };
            }
        });
        przedmiot_koszyk.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Oferta, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Oferta, String> param) {
                return new ObservableValueBase<String>() {
                    @Override
                    public String getValue() {
                        return param.getValue().getPrzedmiot().getNazwa();
                    }
                };
            }
        });
        //cena_koszyk.setCellValueFactory(new PropertyValueFactory<>("cena"));
        sztuki_koszyk.setCellValueFactory(new PropertyValueFactory<>("sztuki_w_koszyku"));
        cena_razem_koszyk.setCellValueFactory(new PropertyValueFactory<>("cena_razem"));


    }

    boolean x = true;

    @FXML
    void dodaj_oferte_button() {
        double cena = Double.parseDouble(cena_dodaj_oferte.getText());
        int sztuki = Integer.parseInt(sztuki_dodaj_oferte.getText());
        Handlarz sprzedawca = sprzedawca_choice.getValue();
        Przedmiot przedmiot = przedmiot_choice.getValue();


        Oferta oferta = new Oferta(sprzedawca, przedmiot, sztuki, cena);

        for (Oferta o : Main.lista_ofert) {
            if (o.getHandlarz() == sprzedawca && o.getPrzedmiot() == przedmiot && o.getCena() == cena && o.isAktywna()) {
                Main.session.beginTransaction();
                o.setSztuki(o.getSztuki() + sztuki);
                Main.session.getTransaction().commit();
                x = false;
                break;
            }


        }
        if (x) {
            Main.session.beginTransaction();
            Main.session.save(oferta);
            Main.session.getTransaction().commit();
            Main.lista_ofert.add(oferta);

            tabela.getItems().add(oferta);
        }
        x = true;
        tabela.refresh();
        tabela3.refresh();
    }

    static Double brylki_rudy;
    static Oferta zaznaczona_oferta;
    static Text za_malo_rudy_s;
    static TableView<Oferta> tabela_s, tabela2_s, tabela3_s;
    static Text brylki_s;

    static double cena_calosc;
    static Double razem_do_zaplaty;

    @FXML
    void cofnij_button() {
        if (!tabela2.getSelectionModel().isEmpty()) {
            zaznaczona_oferta = tabela2.getSelectionModel().getSelectedItem();

            zaznaczona_oferta.setSztuki_w_koszyku(zaznaczona_oferta.getSztuki_w_koszyku() - 1);
            zaznaczona_oferta.setCena_razem(zaznaczona_oferta.getCena_razem() - zaznaczona_oferta.getCena());
            tabela2.refresh();
            razem_do_zaplaty -= zaznaczona_oferta.getCena();

            razem_do_zaplaty_text_s.setText(Double.toString(razem_do_zaplaty));

            if (tabela.getItems().contains(zaznaczona_oferta)) {
                zaznaczona_oferta.setSztuki(zaznaczona_oferta.getSztuki() + 1);
                tabela.refresh();
            } else {
                zaznaczona_oferta.setSztuki(1);
                tabela.getItems().add(zaznaczona_oferta);
            }


            if (zaznaczona_oferta.getSztuki_w_koszyku() == 0)
                tabela2.getItems().remove(zaznaczona_oferta);
        }
    }

    static void dodaj_do_koszyka(int sztuki) {
        cena_calosc = zaznaczona_oferta.getCena() * sztuki;

        zaznaczona_oferta.setSztuki(zaznaczona_oferta.getSztuki() - sztuki);
        zaznaczona_oferta.setSztuki_w_koszyku(zaznaczona_oferta.getSztuki_w_koszyku() + sztuki);
        zaznaczona_oferta.setCena_razem(zaznaczona_oferta.getCena_razem() + zaznaczona_oferta.getCena() * sztuki);
        za_malo_rudy_s.setText("Dodano do koszyka");
        za_malo_rudy_s.setFill(Color.valueOf("#388e3c"));
        za_malo_rudy_s.setVisible(true);

        tabela_s.refresh();
        tabela3_s.refresh();


        if (!tabela2_s.getItems().contains(zaznaczona_oferta))
            tabela2_s.getItems().add(zaznaczona_oferta);
        tabela2_s.refresh();

        razem_do_zaplaty = Double.parseDouble(razem_do_zaplaty_text_s.getText());
        razem_do_zaplaty += cena_calosc;
        razem_do_zaplaty_text_s.setText(Double.toString(razem_do_zaplaty));


        if (zaznaczona_oferta.getSztuki() == 0) {
            tabela_s.getItems().remove(zaznaczona_oferta);
            tabela_s.refresh();
        }


    }

    @FXML
    void dodaj_do_koszyka_action() {

        if (!tabela.getSelectionModel().isEmpty()) {
            zaznaczona_oferta = tabela.getSelectionModel().getSelectedItem();

            if (zaznaczona_oferta.getSztuki() == 1) {
                dodaj_do_koszyka(1);
            } else
                pokaz_okienko();

        }
    }

    @FXML
    void zamow_action() {
        brylki_rudy = Double.parseDouble(brylki.getText());

        if (brylki_rudy >= razem_do_zaplaty) {
            brylki_rudy -= razem_do_zaplaty;
            brylki.setText(Double.toString(brylki_rudy));
            razem_do_zaplaty = 0.0;

            List<Oferta> lista_ofert_koszyk = tabela2.getItems();
            List<Zamowienie> lista_zamowien = new ArrayList<>();


            Main.session.beginTransaction();


            for (Oferta oferta : lista_ofert_koszyk) {
                Main.lista_ofert.get(oferta.getId_oferty() - 1).setSztuki(oferta.getSztuki());
                Zamowienie z = new Zamowienie(oferta, oferta.getSztuki_w_koszyku(), oferta.getCena_razem());
                oferta.setSztuki_w_koszyku(0);
                lista_zamowien.add(z);


                if (oferta.getSztuki() == 0)
                    Main.lista_ofert.get(oferta.getId_oferty() - 1).setAktywna(false);
                Main.session.save(z);
            }



            Main.session.getTransaction().commit();

            tabela2.getItems().clear();

            TypedQuery query = Main.entityManager.createQuery("select ofer from sample.EntityClass.Zamowienie ofer", Zamowienie.class);
            ObservableList zamowienia = FXCollections.observableArrayList(
                    query.getResultList()
                    //query.getResultList()
            );
            nr_zamowienia_kolumna.setCellValueFactory(new PropertyValueFactory<>("id_zamowienia"));
            sprzedawca_kolumna.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Zamowienie, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Zamowienie, String> param) {
                    return new ObservableValueBase<String>() {
                        @Override
                        public String getValue() {
                            return param.getValue().getOferta().getHandlarz().getImie();
                        }
                    };
                }
            });
            przedmiot_kolumna.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Zamowienie, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Zamowienie, String> param) {
                    return new ObservableValueBase<String>() {
                        @Override
                        public String getValue() {
                            return param.getValue().getOferta().getPrzedmiot().getNazwa();
                        }
                    };
                }
            });
            sztuki_kolumna.setCellValueFactory(new PropertyValueFactory<>("ilosc_sztuk"));

            cena_kolumna.setCellValueFactory(new PropertyValueFactory<>("cena_razem"));

            razem_do_zaplaty_text_s.setText("0");


            for (Zamowienie z : lista_zamowien) {
                tabela_zamowienia.getItems().add(z);
            }
            za_malo_rudy.setText("Zamówiono");
            za_malo_rudy.setFill(Color.valueOf("#388e3c"));
            za_malo_rudy.setVisible(true);

        } else {
            za_malo_rudy.setText("Za mało bryłek rudy!");
            za_malo_rudy.setFill(Color.valueOf("#b90606"));
            za_malo_rudy.setVisible(true);
        }


    }

    static Stage stage;

    void pokaz_okienko() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("ile_sztuk_window.fxml"));
        stage = new Stage();

        try {
            Parent root1 = (Parent) loader.load();
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void ustaw_brylki_action() {
        int brylki_rudy = Integer.parseInt(brylki_do_ustawienia.getText());
        System.out.println(brylki_rudy);
        brylki.setText(Double.toString(brylki_rudy));
    }
}
