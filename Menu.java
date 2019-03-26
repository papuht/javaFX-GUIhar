

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import javafx.scene.Node;


//this class contains the start menu attributes
class Menu {



    static Node Menu() {
        GridPane grid = new GridPane();
        Button rent = new Button("Vuokraa asunto");
        Button search = new Button("Hae vuokra-asuntoja");

        EventHandler<MouseEvent> rental = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FormMaker.rentalForm();

            }
        };

        EventHandler<MouseEvent> closeWindow = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ((Stage)(((Button)mouseEvent.getSource()).getScene().getWindow())).close();
            }
        };


        EventHandler<MouseEvent> searching = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FormMaker.searchForm();
            }
        };

        rent.addEventFilter(MouseEvent.MOUSE_CLICKED, rental);
        rent.addEventFilter(MouseEvent.MOUSE_CLICKED, closeWindow);
        search.addEventFilter(MouseEvent.MOUSE_CLICKED, searching);
        search.addEventFilter(MouseEvent.MOUSE_CLICKED, closeWindow);

        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(rent, 0,0);
        grid.add(search, 1, 0);
        return grid;
    }
}
