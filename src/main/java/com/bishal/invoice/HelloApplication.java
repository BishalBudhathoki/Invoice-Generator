package com.bishal.invoice;

import com.bishal.invoice.Model.Database;
import com.mysql.cj.exceptions.UnableToConnectException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException, ClassNotFoundException {
        try {
            Database db =  new Database();
            db.getDatabase();
        } catch (UnableToConnectException unableToConnectException) {
            System.out.println(unableToConnectException);
        }

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("new-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 747, 677);
        stage.setTitle("Invoice Generator");
        stage.getIcons().add(new Image("com/bishal/invoice/1.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}