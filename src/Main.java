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


        // Just some test waiting to get real commands via socket
        com.example.alex.jarvis.Command c1 = new com.example.alex.jarvis.Command("lantai satu");
        c1.setAction("lantai satu");
        controlGpio.control(c1);
        Thread.sleep(300);
        
        com.example.alex.jarvis.Command c2 = new com.example.alex.jarvis.Command("lantai dua");
        c2.setAction("lantai dua");
        controlGpio.control(c2);
        Thread.sleep(300);
        
        com.example.alex.jarvis.Command c3 = new com.example.alex.jarvis.Command("lantai tiga");
        c3.setAction("lantai tiga");
        controlGpio.control(c3);
        Thread.sleep(300);
        
        com.example.alex.jarvis.Command c4 = new com.example.alex.jarvis.Command("lantai empat");
        c4.setAction("lantai empat");
        controlGpio.control(c4);
        Thread.sleep(300);
        
        com.example.alex.jarvis.Command c5 = new com.example.alex.jarvis.Command("lantai lima");
        c5.setAction("lantai lima");
        controlGpio.control(c5);
        Thread.sleep(300);
        
        com.example.alex.jarvis.Command c6 = new com.example.alex.jarvis.Command("lantai enam");
        c6.setAction("lantai enam");
        controlGpio.control(c6);
        Thread.sleep(300);

        com.example.alex.jarvis.Command c7 = new com.example.alex.jarvis.Command("buka pintu");
        c7.setAction("buka pintu");
        controlGpio.control(c7);
        Thread.sleep(300);
        
        com.example.alex.jarvis.Command c8 = new com.example.alex.jarvis.Command("tutup pintu");
        c8.setAction("tutup pintu");
        controlGpio.control(c8);
        Thread.sleep(300);

    }
}
