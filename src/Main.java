import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Server Part");
        Scanner reader = new Scanner(System.in);
        System.out.println("Port number: ");
        int portNumber = reader.nextInt();
        ControlGpio controlGpio = new ControlGpio(portNumber);
        System.out.println("server instance Ok");
        controlGpio.order();


//        // Just some test waiting to get real commands via socket
//        com.example.alex.jarvis.Command c1 = new com.example.alex.jarvis.Command("switch on bedroom");
//        controlGpio.control(c1);
//
//        Thread.sleep(5000);
//
//        com.example.alex.jarvis.Command c2 = new com.example.alex.jarvis.Command();
//        c2.setAction("switch off bedroom");
//        controlGpio.control(c2);
//
//        com.example.alex.jarvis.Command c3 = new com.example.alex.jarvis.Command("switch on living room");
//        controlGpio.control(c3);
//
//        Thread.sleep(2000);
//
//        com.example.alex.jarvis.Command c4 = new com.example.alex.jarvis.Command("switch off living room");
//        controlGpio.control(c4);

    }
}
