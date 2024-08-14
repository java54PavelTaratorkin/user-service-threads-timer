package telran.multithreading;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Timer extends Thread {
	// displaying time in a given format and a given resolution
    // example displaying each second, or each 5 seconds, etc.
    // Provide an option to set the end time for the timer
    private final long resolutionMillis;
    private final DateTimeFormatter formatter;
    private final LocalTime endTime;
    private boolean running = true; // Flag to control the loop execution

    // Default constructor
    public Timer() {
        setDaemon(true);
        this.resolutionMillis = 1000; // Default to 1 second
        this.formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // Default format
        this.endTime = LocalTime.MAX; // Default to no specific end time
    }

    // Advanced constructor
    public Timer(long resolution, TimeUnit resolutionUnit, String timeFormat, 
                 long endDelay, TimeUnit endUnit) {
        setDaemon(true);
        this.resolutionMillis = resolutionUnit.toMillis(resolution);
        this.formatter = DateTimeFormatter.ofPattern(timeFormat);
        this.endTime = LocalTime.now().plusNanos(endUnit.toNanos(endDelay));
    }

    public void run() {
        while (running) {
            try {
                System.out.println(LocalTime.now().format(formatter));
                sleep(resolutionMillis);
                if (LocalTime.now().isAfter(endTime)) {
                    running = false;
               }
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
        }
    }
}