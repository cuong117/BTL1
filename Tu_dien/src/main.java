import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;


public class main extends Application {
    DictionaryCommandline dcl = new DictionaryCommandline();
    @FXML
    public TextField word_target;
    public Text word_explain;
    public TextField word_explain1;
    public ListView<String> list = new ListView<String>();
    public ListView<String> show = new ListView<String>();

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        dcl.dim.insertFromFile();
        Parent root = FXMLLoader.load(getClass().getResource("add.fxml"));
        Scene scene = new Scene(root);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        primaryStage.setTitle("Từ Điển");
        ObservableList<String> l = FXCollections.observableArrayList();
        for (int i = 0; i < Dictionary.dic.size(); i++) {
            l.add(Dictionary.dic.get(i).word_target);
            if (i == 2)
                System.out.println(Dictionary.dic.get(i).word_target);
        }
        show.setItems(l);
        show.setVisible(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void search() {
        word_explain1.setPromptText(null);
        list.setVisible(false);
        word_explain.setText(dcl.dim.dictionaryLookup(word_target.getText()));
    }

    public void searcher() {
        word_target.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (!(newValue.trim().isEmpty())) {
                ArrayList<String> a = dcl.dictionarySearcher(newValue);
                if (a.size() > 0) {
                    ObservableList<String> temp = FXCollections.observableArrayList();
                    for (int i = 0; i < a.size(); i++) {
                        temp.add(a.get(i));
                    }
                    list.setItems(temp);
                    list.setVisible(true);
                }
            } else
                list.setVisible(false);
        });
    }

    public void select(MouseEvent event) {
        /*list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldvalue, String newvalue) {
                word_target.setText(newvalue);
                System.out.println(newvalue);
                list.setVisible(false);
            }
        });*/
    }


}
