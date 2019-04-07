package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import sample.EntityClass.*;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    static Session session;
    static EntityManager entityManager;

    //static public List<Przedmiot> lista_przedmiotow = new ArrayList<>();
    Oboz stary_oboz, nowy_oboz, oboz_bractwa;
    //Handlarz[] handlarz = new Handlarz[1];
    static public List<Oferta> lista_ofert = new ArrayList<>();
    static public List<Przedmiot> lista_przedmiotow = new ArrayList<>();

    Przedmiot czarny_rhobar, mrok_polnocy, zew_nocy, zielony_nowicjusz, bagienne_ziele, zielony_nowicjusz_przepis;


    void dodawanie_przedmiotow(){
        File file1 = new File("C:\\Users\\Krystian\\IdeaProjects\\JavaFxHibernate\\src\\sample\\icons\\Zew_nocy.png");
        byte[] zew_nocy_bytes = new byte[(int) file1.length()];
        dodaj_image_b(file1, zew_nocy_bytes);
        Image zew_nocy_image = new Image("sample/icons/"+file1.getName());

        File file2 = new File("C:\\Users\\Krystian\\IdeaProjects\\JavaFxHibernate\\src\\sample\\icons\\bagienne_ziele.png");
        byte[] bagienne_ziele_bytes = new byte[(int) file2.length()];
        dodaj_image_b(file2, zew_nocy_bytes);
        Image bagienne_ziele_image = new Image("sample/icons/"+file2.getName());

        File file3 = new File("C:\\Users\\Krystian\\IdeaProjects\\JavaFxHibernate\\src\\sample\\icons\\zielony_nowicjusz_przepis.png");
        byte[] zielony_nowicjusz_przepis_bytes = new byte[(int) file2.length()];
        dodaj_image_b(file3, zielony_nowicjusz_przepis_bytes);
        Image zielony_nowicjusz_przepis_image = new Image("sample/icons/"+file3.getName());

        czarny_rhobar = new Przedmiot("Czarny Rhobar","Jest to popularny skręt na kontynencie.", zew_nocy_bytes, zew_nocy_image);
        mrok_polnocy = new Przedmiot("Mrok północy","Jest nieco mocniejszy od zielonego nowicjusza.",zew_nocy_bytes,zew_nocy_image);
        zew_nocy = new Przedmiot("Zew nocy","Jest to najsilniejszy ze skrętów bagiennego ziela i specjalność Obozu Bractwa.",zew_nocy_bytes,zew_nocy_image);
        zielony_nowicjusz = new Przedmiot("Zielony nowicjusz","Jest to najsłabsza odmiana bagiennego ziela występująca w Górniczej Dolinie.",zew_nocy_bytes,zew_nocy_image);
        bagienne_ziele = new Przedmiot("Bagienne ziele","Bagienne ziele opis",bagienne_ziele_bytes,bagienne_ziele_image );
        zielony_nowicjusz_przepis = new Przedmiot("Przepis na zielony nowicjusz","opis",zielony_nowicjusz_przepis_bytes,zielony_nowicjusz_przepis_image);

        lista_przedmiotow.add(czarny_rhobar);
        lista_przedmiotow.add(mrok_polnocy);
        lista_przedmiotow.add(zew_nocy);
        lista_przedmiotow.add(zielony_nowicjusz);
        lista_przedmiotow.add(bagienne_ziele);
        lista_przedmiotow.add(zielony_nowicjusz_przepis);

        session.beginTransaction();
            for(Przedmiot p:lista_przedmiotow)
                session.save(p);
        session.getTransaction().commit();

    }

    private void dodaj_image_b(File file, byte[] zew_nocy_bytes) {
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(zew_nocy_bytes);
            fileInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void dodawanie_obozow(){

        stary_oboz=new Oboz("Stary obóz");
        nowy_oboz =new Oboz("Nowy obóz");
        oboz_bractwa=new Oboz("Obóz bractwa");

        session.beginTransaction();
            session.save(stary_oboz);
            session.save(nowy_oboz);
            session.save(oboz_bractwa);
        session.getTransaction().commit();

    }

    static Handlarz milten, corristo, dexter, fisk, graham, huno, mordrag, skip, stone, torrez,
             baal_cadar, darrion, fortuno, baal_isidro, baal_kagan, cronos, lee, riordian, saturas,
             sharky, sillas, wilk;

    static List<Handlarz> lista_handlarzy = new ArrayList<>();
    void dodawanie_handlarzy(){
        milten=new Handlarz("Milten",stary_oboz);
        corristo=new Handlarz("Corristo",stary_oboz);
        dexter=new Handlarz("Dexter",stary_oboz);
        fisk=new Handlarz("Fisk",stary_oboz);
        graham=new Handlarz("Graham",stary_oboz);
        huno=new Handlarz("Huno",stary_oboz);
        mordrag=new Handlarz("Mordrag",stary_oboz);
        skip=new Handlarz("Skip",stary_oboz);
        stone=new Handlarz("Stone",stary_oboz);
        torrez=new Handlarz("Torrez",stary_oboz);

        baal_cadar=new Handlarz("Baal Cadar",oboz_bractwa);
        darrion= new Handlarz("Darrion",oboz_bractwa);
        fortuno=new Handlarz("Fortuno",oboz_bractwa);

        baal_isidro=new Handlarz("Baal Isidro",nowy_oboz);
        baal_kagan=new Handlarz("Baal Kagan",nowy_oboz);
        cronos=new Handlarz("Cronos", nowy_oboz);
        lee=new Handlarz("Lee", nowy_oboz);
        riordian=new Handlarz("Riordian",nowy_oboz);
        saturas=new Handlarz("Saturas",nowy_oboz);
        sharky=new Handlarz("Sharky",nowy_oboz);
        sillas=new Handlarz("Sillas",nowy_oboz);
        wilk=new Handlarz("Wilk",nowy_oboz);

        lista_handlarzy.add(milten);
        lista_handlarzy.add(corristo);
        lista_handlarzy.add(dexter);
        lista_handlarzy.add(fisk);
        lista_handlarzy.add(graham);
        lista_handlarzy.add(huno);
        lista_handlarzy.add(mordrag);
        lista_handlarzy.add(skip);
        lista_handlarzy.add(stone);
        lista_handlarzy.add(torrez);
        lista_handlarzy.add(baal_cadar);
        lista_handlarzy.add(darrion);
        lista_handlarzy.add(fortuno);
        lista_handlarzy.add(baal_isidro);
        lista_handlarzy.add(baal_kagan);
        lista_handlarzy.add(cronos);
        lista_handlarzy.add(lee);
        lista_handlarzy.add(riordian);
        lista_handlarzy.add(saturas);
        lista_handlarzy.add(sharky);
        lista_handlarzy.add(sillas);
        lista_handlarzy.add(wilk);

        session.beginTransaction();
            session.save(milten);
            session.save(corristo);
            session.save(dexter);
            session.save(fisk);
            session.save(graham);
            session.save(huno);
            session.save(mordrag);
            session.save(skip);
            session.save(stone);
            session.save(torrez);
            session.save(fortuno);
            session.save(baal_isidro);
            session.save(baal_kagan);
            session.save(cronos);
            session.save(lee);
            session.save(riordian);
            session.save(saturas);
            session.save(sharky);
            session.save(sillas);
            session.save(wilk);
        session.getTransaction().commit();

    }
    void dodawanie_ofert(){
        lista_ofert.add(new Oferta(fisk,czarny_rhobar,2,10));
        lista_ofert.add(new Oferta(fortuno,zew_nocy,1,20));
        lista_ofert.add(new Oferta(dexter,zielony_nowicjusz,3,15));
        lista_ofert.add(new Oferta(baal_isidro,zew_nocy,5,30));

        session.beginTransaction();
            for(Oferta o:lista_ofert)
                    session.save(o);
        session.getTransaction().commit();
    }

    static SessionFactory factory;
    @Override
    public void start(Stage primaryStage) throws Exception{

        Configuration configuration= new Configuration().configure("sample/hibernate.cfg.xml");

        configuration.addAnnotatedClass(Przedmiot.class);
        configuration.addAnnotatedClass(Oboz.class);
        configuration.addAnnotatedClass(Handlarz.class);
        configuration.addAnnotatedClass(Oferta.class);
        configuration.addAnnotatedClass(Zamowienie.class);



        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        factory = configuration.buildSessionFactory(serviceRegistry);

        session = factory.openSession();
        entityManager = factory.createEntityManager();
        dodawanie_przedmiotow();
        dodawanie_obozow();
        dodawanie_handlarzy();
        dodawanie_ofert();


       /* session.close();
        factory.close();*/

       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("sample.fxml"));
        StackPane stackpane = loader.load();
        Scene scene = new Scene(stackpane);
        scene.getStylesheets().add("sample/Style.css");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Khorinis Dark Market");
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
        session.close();
        factory.close();

    }

}
