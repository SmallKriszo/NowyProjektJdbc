package nowyProjectJdbc;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class TreadTest {
    static AtomicInteger i = new AtomicInteger();

    static Runnable job = () -> {
        while (true) {
            System.out.printf("Running from: " + Thread.currentThread().getName() + "\n");
            System.out.printf("i = " + i + "\n");
        }
    };

    @Test
    public void treadTest() {


        new Thread(job).start();
        new Thread(job).start();

    }
}
