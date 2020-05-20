import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Scanner;

public class Game extends Application{

    //Main class
    public void start(Stage primaryStage) throws Exception{
        //read file name containing map
        Scanner cin = new Scanner(System.in);
        String name = cin.next();

        //create map
        Map map = new Map(name);
        //create player
        Player player = new MyPlayer(map);
        int n = map.getSize();
        int u = map.getUnit();

        Group root = new Group();

        root.getChildren().add(map);
        //create food
        Food food = new Food(map, player);
        //set scene size
        Scene scene = new Scene(root, u * n, u * n);

        //event handler
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case DOWN: player.moveDown();break;
                    case UP: player.moveUp();break;
                    case LEFT: player.moveLeft();break;
                    case RIGHT: player.moveRight();break;
                }
            }
        });

        primaryStage.setTitle("Eater");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
