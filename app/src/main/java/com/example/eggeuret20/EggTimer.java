package com.example.eggeuret20;

import android.os.CountDownTimer;

import java.util.ArrayList;

public class EggTimer extends Thread implements EggPresenter.View {
    public CountDownTimer timer;
    private String timeInText;
    private ArrayList<EggTimerListener> listeners = new ArrayList<EggTimerListener>();

    public void setTimeInText(String text){
        timeInText = text;
    }

    public int TimerLength() {
        int time;
        switch (timeInText) {
            case "05:00":
                time = 5 * 60000;
                break;
            case "07:00":
                time = 7 * 60000;
                break;
            case "10:00":
                time = 10 * 60000;
                break;
            default:
                time = 0;
        }
        return time;
    }


    @Override
    public void run(){

        int time = TimerLength();
        timer = new CountDownTimer (time, 1000) {

            public void onTick(long millisUntilFinished) {

                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                //mainActivity.setText(minutes + ":" + seconds);
            }

            @Override
            public void onFinish() {
                //mainActivity.changeButtonState();
                //mainActivity.setText("00:00");
            }

        }.start();


    }
    public void addListener(EggTimerListener listener) {
        listeners.add(listener);
    }


    public void removeListener(EggTimerListener listener) {
        listeners.remove(listener);
    }


    @Override
    public void onCountDown(long time) {

    }

    @Override
    public void onEggTimerStopped() {

    }
}
