


import javafx.scene.text.*;
import javafx.scene.Node;

// Tässä luokassa sijaitsevat lomakkeissa käytettyjen tekstinodejen tiedot, yksinketaisesti selvyyden vuoksi.
class FoT {

    static Node pintaAla() {
        Text teksti = new Text("Pinta-ala:");


        return teksti;
    }

    static Node nimi() {
        Text teksti = new Text("Nimi:");

        return teksti;
    }

    static Node osoite() {
        Text teksti = new Text("Osoite:");

        return teksti;
    }

    static Node kohteenKuva() {
        Text teksti = new Text("Kohteen kuva:");

        return teksti;
    }

    static Node rakennusVuosi(){
        Text teksti = new Text("Rakennusvuosi:");

        return teksti;
    }

    static Node vuokraKK(){
        Text teksti = new Text("Vuokra/kk:");

        return teksti;
    }

    static Node kohteenKuvaus() {
        Text teksti = new Text("Kohteen kuvaus:");

        return teksti;
    }

    static Node ehdot() {
        Text teksti = new Text("Muut ehdot:");

        return teksti;
    }

    static Node kuntoLuokitus() {
        Text teksti = new Text("Kuntoluokitus:");

        return teksti;
    }

    static Node email() {
        Text teksti = new Text("Email:");

        return teksti;
    }

    static Node minPintaAla() {
        Text teksti = new Text("Pienin hyväksyttävä pinta-ala");
        return teksti;
    }

    static Node maxPintaAla() {
        Text teksti = new Text("Suurin haluttu pinta-ala");
        return teksti;
    }

    static Node maxVuokra() {
        Text teksti = new Text("Suurin mahdollinen vuokra/kk");
        return teksti;
    }


}
