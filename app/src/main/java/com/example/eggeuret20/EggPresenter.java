package com.example.eggeuret20;

import android.os.CountDownTimer;

public class EggPresenter implements EggTimerListener {

    private View view;
EggTimer eggTimer = new EggTimer();

    public EggPresenter(View view){
        this.view = view;
        eggTimer.addListener(this);
    }
    public void stop(){
        
    }

    public void start(long timeToCook){
        eggTimer.start();

    }
    @Override
    public void onCountDown(long timeLeft) {
view.onCountDown(timeLeft);
    }

    @Override
    public void onEggTimerStopped() {
        view.onEggTimerStopped();
    }
    public interface View {

        void onCountDown(long time);
        void  onEggTimerStopped();

    }
}
