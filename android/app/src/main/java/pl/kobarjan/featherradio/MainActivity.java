package pl.kobarjan.featherradio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    boolean running = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!running){
                    button.setText("stop");
                    RadioController.radioRun();
                    running = true;
                } else{
                    button.setText("play");
                    RadioController.radioStop();
                    running = false;
                }
            }
        });
    }
}
