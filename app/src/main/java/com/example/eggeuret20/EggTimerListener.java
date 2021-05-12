package com.example.eggeuret20;

import android.os.CountDownTimer;

public interface EggTimerListener {

    public void onCountDown(long timeLeft);

    public void onEggTimerStopped();
}

