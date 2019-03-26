
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;


// This class contains the attributes and functionality of the forms.
class Grid {

    static Button back = new Button("Palaa alkuvalikkoon");


    static EventHandler<MouseEvent> goBack = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent mouseEvent) {
            FormMaker.returnMenu();

        }
    };


    static EventHandler<MouseEvent> closeWindow = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent mouseEvent) {
            ((Stage)(((Button)mouseEvent.getSource()).getScene().getWindow())).close();

        }
    };

    static ArrayList<Asunto> asunnot = new ArrayList<Asunto>();




    //this generates the grid settings for rental form
    static Node RentalGrid() {

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Button submit = new Button("Tallenna ilmoitus");
        Button clear = new Button("Pyyhi tiedot");
        Button image = new Button("Lataa kuva");

        TextField nimiField = new TextField();
        nimiField.setPromptText("Kohteen nimi");

        TextField osoiteField = new TextField();
        osoiteField.setPromptText("Kohteen osoite");

        TextField rvField = new TextField();
        rvField.setPromptText("Kohteen rakennusvuosi");
        rvField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter()));


        TextArea kuvausField = new TextArea();
        kuvausField.setPromptText("Kohteen sanallinen kuvaus");

        TextField ehtoField = new TextField();
        ehtoField.setPromptText("Muut ehdot");

        TextField vuokraField = new TextField();
        vuokraField.setPromptText("Kohteen kuukausivuokra");
        vuokraField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter()));

        TextField pintaField = new TextField();
        pintaField.setPromptText("Kohteen pinta-ala");
        pintaField.setTextFormatter(new TextFormatter<Float>(new FloatStringConverter()));

        TextField kuntoField = new TextField();
        kuntoField.setPromptText("Kohteen kunto");

        TextField emailField = new TextField();
        emailField.setPromptText("Sähköpostiosoite");

        Text ilmoitus = new Text("Kuva tulee myöhemmin");

        TextField imagePath = new TextField();
        imagePath.setPromptText("Kuvan polku tai osoite");






        Button bck = Grid.back;
        bck.addEventFilter(MouseEvent.MOUSE_CLICKED, Grid.goBack);
        bck.addEventFilter(MouseEvent.MOUSE_CLICKED, Grid.closeWindow);

        //Settings for texts in grid
        grid.add(FoT.pintaAla(), 0 ,0);
        grid.add(FoT.nimi(), 0, 1);
        grid.add(FoT.osoite(), 0 ,2);
        grid.add(FoT.kohteenKuva(), 0, 3);
        grid.add(FoT.rakennusVuosi(), 0 ,4);
        grid.add(FoT.vuokraKK(), 0, 5);
        grid.add(FoT.kohteenKuvaus(), 0 ,6);
        grid.add(FoT.ehdot(), 0, 7);
        grid.add(FoT.kuntoLuokitus(), 0 ,8);
        grid.add(FoT.email(), 0, 9);

        //Settings for textfields in grid
        grid.add(pintaField, 1 ,0);
        grid.add(nimiField, 1, 1);
        grid.add(osoiteField, 1 ,2);
        grid.add(ilmoitus, 1, 3);
        grid.add(rvField, 1 ,4);
        grid.add(vuokraField, 1, 5);
        grid.add(kuvausField, 1 ,6);
        grid.add(ehtoField, 1, 7);
        grid.add(kuntoField, 1 ,8);
        grid.add(emailField, 1, 9);

        //Setting for buttons
        grid.add(submit, 0, 12);
        grid.add(clear, 0, 11);
        grid.add(image, 0, 10);
        grid.add(bck, 0, 13);
        grid.add(imagePath, 1, 10);


        EventHandler<MouseEvent> submitEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    String[] apu = {kuvausField.getText()};

                    Asunto asunto = new Asunto();
                    asunto.setNimi(nimiField.getText());
                    asunto.setOsoite(osoiteField.getText());
                    asunto.setKuvaTiedosto(ilmoitus.getText());
                    asunto.setNeliömäärä(Float.valueOf(pintaField.getText()));
                    asunto.setSähköposti(emailField.getText());
                    asunto.setMuutEhdot(ehtoField.getText());
                    asunto.setKohteenKuvaus(apu);
                    asunto.setRakennusvuosi(Integer.valueOf(rvField.getText()));
                    asunto.setVuokra(Integer.valueOf(vuokraField.getText()));


                    asunnot.add(asunto);
                    System.out.println("Asunto lisätty:");
                    System.out.println(asunto.toString());
                }
                catch (NumberFormatException e) {
                    System.err.println("Asuntoa ei lisätty.");
                }



            }
        };

        submit.addEventFilter(MouseEvent.MOUSE_CLICKED, submitEvent);

        EventHandler<MouseEvent> clearFields = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                nimiField.clear();
                osoiteField.clear();
                ehtoField.clear();
                vuokraField.clear();
                rvField.clear();
                emailField.clear();
                pintaField.clear();
                kuntoField.clear();
                kuvausField.clear();

            }
        };

        clear.addEventFilter(MouseEvent.MOUSE_CLICKED, clearFields);


        EventHandler<MouseEvent> addPicture = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FileInputStream imageStream = new FileInputStream(imagePath.getText());
                    Image img = new Image(imageStream);
                    ImageView view = new ImageView(img);
                    view.setFitHeight(100);
                    view.setFitWidth(100);
                    grid.add(view, 1, 3);
                }
                catch(FileNotFoundException f) {
                    ilmoitus.setText("Kuvaa ei voitu ladata");


                }

            }
        };

        image.addEventFilter(MouseEvent.MOUSE_CLICKED, addPicture);


        return grid;


    }
    //attributes for the search form
    static Node SearchGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Button search = new Button("Hae asuntoja");
        Button clear = new Button("Tyhjennä hakukentät");


        Button bck = Grid.back;
        bck.addEventFilter(MouseEvent.MOUSE_CLICKED, Grid.goBack);
        bck.addEventFilter(MouseEvent.MOUSE_CLICKED, Grid.closeWindow);


        TextField osoite = new TextField();
        osoite.setPromptText("Anna haluttu osoite");

        TextField maxVuokra = new TextField();
        maxVuokra.setPromptText("Anna maksimivuokra");
        maxVuokra.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter()));

        TextField minPinta = new TextField();
        minPinta.setPromptText("Anna minimipinta-ala");
        minPinta.setTextFormatter(new TextFormatter<Float>(new FloatStringConverter()));

        TextField maxPinta  = new TextField();
        maxPinta.setPromptText("Anna maksimipinta-ala");
        maxPinta.setTextFormatter(new TextFormatter<Float>(new FloatStringConverter()));

        grid.add(FoT.osoite(), 0, 0);
        grid.add(FoT.maxVuokra(), 0, 1);
        grid.add(FoT.maxPintaAla(), 0 ,2);
        grid.add(FoT.minPintaAla(), 0, 3);


        grid.add(osoite, 1 , 0);
        grid.add(maxVuokra, 1, 1);
        grid.add(maxPinta, 1, 2);
        grid.add(minPinta, 1, 3);


        grid.add(search, 0 , 4);
        grid.add(clear, 1, 4);
        grid.add(bck, 0, 5);


        EventHandler<MouseEvent> searchEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                StringBuilder lopputulos = new StringBuilder();

                if (osoite.getText().isEmpty() || maxPinta.getText().isEmpty() ||
                        maxVuokra.getText().isEmpty() ||
                        minPinta.getText().isEmpty()) {
                    lopputulos.append(asunnot.toString());
                    searchResults(lopputulos);
                    ((Stage) (((Button) mouseEvent.getSource()).getScene().getWindow())).close();
                }

                try {
                for (int i = 0; i < asunnot.size(); i++) {

                    if (asunnot.get(i).getOsoite().equals(osoite.getText())) {
                        lopputulos.append(asunnot.get(i).toString());
                    }

                    if (asunnot.get(i).getNeliömäärä() <= Float.valueOf(maxPinta.getText()) &&
                            asunnot.get(i).getNeliömäärä() >= Float.valueOf(minPinta.getText())) {
                        lopputulos.append(asunnot.get(i).toString());


                    }
                    if (asunnot.get(i).getVuokra() <= Integer.valueOf(maxVuokra.getText())) {
                        lopputulos.append(asunnot.get(i).toString());

                    }
                }




                    searchResults(lopputulos);
                    ((Stage) (((Button) mouseEvent.getSource()).getScene().getWindow())).close();
                }
                catch(NumberFormatException e ){
                    System.err.println("Hakuehdot määritetty väärin");
                    System.out.println("Näytetään kaikki kohteet");
                }



            }
        };
        search.addEventFilter(MouseEvent.MOUSE_CLICKED, searchEvent);

        EventHandler<MouseEvent> clearEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                osoite.clear();
                maxVuokra.clear();
                maxPinta.clear();
                minPinta.clear();

            }
        };
        clear.addEventFilter(MouseEvent.MOUSE_CLICKED, clearEvent);




        return grid;
    }


    //attributes for the search results
    public static void searchResults(StringBuilder srchResults) {

        Button bck = Grid.back;
        bck.addEventFilter(MouseEvent.MOUSE_CLICKED, Grid.goBack);
        bck.addEventFilter(MouseEvent.MOUSE_CLICKED, Grid.closeWindow);
        Stage mainStage = new Stage();
        Text tulos = new Text(srchResults.toString());


        GridPane grid = new GridPane();

        ScrollPane sp = new ScrollPane(grid);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);


        grid.setVgap(10);

        grid.add(tulos, 0, 1);
        grid.add(bck, 0, 0);




        Scene set = new Scene(sp, 600, 300);
        set.setFill(Color.LIGHTGREY);
        mainStage.setTitle("Hakutulokset");
        mainStage.setScene(set);
        mainStage.show();
    }




}

