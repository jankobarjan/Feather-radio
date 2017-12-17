package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import static sample.RadioController.*;

public class Controller{

    boolean play = false;
    @FXML
    private Button button;
    @FXML
    private Slider slider;
    @FXML
    private Label titleLabel;
    public static float gain;
    @FXML
    private void handlePlayButton(ActionEvent event){
        System.out.println("clicked play button");
        if(play == false){
            radioRun();
            button.setText("stop");
            play = true;
        } else {
            radioStop();
            button.setText("play");
            play = false;
        }
    }
    public void initialize() {
        System.out.println(slider.getValue());
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (play == true) {
                    System.out.println(slider.getValue());
                    setGain((float) slider.getValue());
                    gain = (float) slider.getValue();
                }
            }
        });

    }
    void changeTitle(String title){
        titleLabel.setText(title);
    }

}
