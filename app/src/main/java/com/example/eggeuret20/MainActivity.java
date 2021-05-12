package com.example.eggeuret20;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements EggPresenter.View, EggTimerListener{
    private CountDownTimer timer;
    private boolean started = false;

    private EggTimer eggTimer = new EggTimer();
    EggPresenter eggPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eggTimer.addListener(this);
        eggPresenter=new EggPresenter(this);
    }
    public void onButtonEggSelectedClicked(View view) {
        TextView txtview = findViewById(R.id.Clock);
        Button btn = findViewById(R.id.StartClock);
        switch (view.getId()) {
            case R.id.SoftBoiled:
                btn.setEnabled(true);
                txtview.setText("05:00");
                break;
            case R.id.Smiling:
                btn.setEnabled(true);
                txtview.setText("07:00");
                break;
            case R.id.HardBoiled:
                btn.setEnabled(true);
                txtview.setText("10:00");
                break;
            default:
                throw new RuntimeException("Unknow button ID");
        }
    }
   // public void onButtonStartTime(View view) {


      //  }

        public void changeButtonState(){
            ImageButton soft =findViewById(R.id.SoftBoiled);
            ImageButton medium =findViewById(R.id.Smiling);
            ImageButton hard =findViewById(R.id.HardBoiled);
            if (soft.isEnabled()==true){
                soft.setEnabled(false);
                medium.setEnabled(false);
                hard.setEnabled(false);
            }else{
                soft.setEnabled(true);
                medium.setEnabled(true);
                hard.setEnabled(true);
            }
        }
        public void setText(String text){
            TextView txtview = findViewById(R.id.Clock);
            txtview.setText(text);
        }



    @Override
    public void onCountDown(long time) {
        changeButtonState();

        TextView txtview = findViewById(R.id.Clock);
        eggTimer.setTimeInText(txtview.getText().toString());
        eggPresenter.start(eggTimer.TimerLength());

        Button stop = findViewById(R.id.StartClock);
        stop.setText("stop");
    }


    @Override
    public void onEggTimerStopped() {
        TextView txtview = findViewById(R.id.Clock);
        eggTimer.timer.cancel();


        changeButtonState();

        Button start = findViewById(R.id.StartClock);
        start.setText("start");
        txtview.setText("00:00");
    }


}