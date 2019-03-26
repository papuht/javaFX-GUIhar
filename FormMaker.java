
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// this class generates the Stages

class FormMaker {

    public FormMaker() {}

    static void rentalForm() {

        Stage mainStage = new Stage();

        Group form = new Group(Grid.RentalGrid());

        Scene set = new Scene(form);
        set.setFill(Color.LIGHTGREY);
        mainStage.setTitle("Lomake asunnon vuokraamiseksi");
        mainStage.setScene(set);
        mainStage.show();


    }

    static void searchForm() {

        Stage mainStage = new Stage();

        Group form = new Group(Grid.SearchGrid());

        Scene set = new Scene(form);
        set.setFill(Color.LIGHTGREY);
        mainStage.setTitle("Lomake vuokra-asunnon etsimiseen");
        mainStage.setScene(set);
        mainStage.show();


    }

    static void returnMenu() {
        Stage mainStage = new Stage();
        Group menu = new Group(Menu.Menu());

        Scene set = new Scene(menu);
        mainStage.setTitle("Menu");
        mainStage.setScene(set);
        mainStage.show();

    }






}

