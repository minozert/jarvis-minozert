import java.net.ServerSocket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Server Part");
        Scanner reader = new Scanner(System.in);
        System.out.println("Port number: ");
        int portNumber = reader.nextInt();
        ControlGpio controlGpio = new ControlGpio(portNumber);
        System.out.println("server instance Ok");
        //controlGpio.order();


        // Just some test waiting to get real commands via socket
        Command c1 = new Command();
        c1.setAction("switch on");
        c1.setElement("bedroom");
        controlGpio.control(c1);

        Thread.sleep(5000);

        Command c2 = new Command();
        c2.setAction("switch off");
        c2.setElement("bedroom");
        controlGpio.control(c2);

        Command c3 = new Command();
        c3.setAction("switch on");
        c3.setElement("living room");
        controlGpio.control(c3);

        Thread.sleep(2000);

        Command c4 = new Command();
        c4.setAction("switch off");
        c4.setElement("living room");
        controlGpio.control(c4);

    }
}
