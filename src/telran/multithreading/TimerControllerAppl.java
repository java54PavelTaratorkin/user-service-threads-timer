package telran.multithreading;

import java.util.concurrent.TimeUnit;

public class TimerControllerAppl {
    public static void main(String[] args) throws InterruptedException {
		//figure out a solution allowing timer stop
		//as example in 5 seconds you stop the timer
		//following 5 seconds application is running with no timer
    	
        // Using advanced constructor with resolution and end delay
        long resolution = 1;
        TimeUnit resolutionUnit = TimeUnit.SECONDS;
        String timeFormat = "HH:mm:ss.SSS";
        long endDelay = 10;
        TimeUnit endUnit = TimeUnit.SECONDS;
        Timer advancedTimer = new Timer(resolution, resolutionUnit, timeFormat, endDelay, endUnit);
        advancedTimer.start();
        Thread.sleep(18000);
        // The main thread will finish after this sleep, causing the daemon timer thread to stop automatically.
    }
}