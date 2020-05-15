import com.example.alex.jarvis.Command;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This example code demonstrates how to perform simple state
 * control of a GPIO pin on the Raspberry Pi.
 *
 * @author modification mino zert
 */
public class ControlGpio {

    private ServerSocket serverSocket;
    private Socket socketConnection;
    final GpioController gpio = GpioFactory.getInstance();
    final GpioPinDigitalOutput lantaiSatu = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02); // SATU
    final GpioPinDigitalOutput lantaiDua = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03); // DUA
    final GpioPinDigitalOutput lantaiTiga = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14); // TIGA
    final GpioPinDigitalOutput lantaiEampat = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17); // EMPAT
    final GpioPinDigitalOutput lantaiLima = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27); // LIMA
    final GpioPinDigitalOutput lantaiEnam = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22); // ENAM
    final GpioPinDigitalOutput bukaPintu = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09); // BUKA
    final GpioPinDigitalOutput tutupPintu = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10); // TUTUP

    public ControlGpio(int portNumber) {

        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void order() {
        while(true){
            try {
                socketConnection = serverSocket.accept();
                //SocketConnection.getInputStream is blocking
                ObjectInputStream inFromClient = new ObjectInputStream(socketConnection.getInputStream());
                Command command = (Command) inFromClient.readObject();
                control(command);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     *
     *
     **/
    public void control(Command command) {

        switch (command.getAction()){
            case "lantai":

                switch (command.getElement()) {
                    case "satu":
                        lantaiSatu.high();
                        break;
                    case "dua":
                        lantaiDua.high();
                        break;
                    case "tiga":
                        lantaiTiga.high();
                        break;
                    case "empat":
                        lantaiEampat.high();
                        break;
                    case "lima":
                        lantaiLima.high();
                        break;
                    case "enam":
                        lantaiEnam.high();        
                }

                break;
            case "pintu":
                switch (command.getElement()) {
                    case "buka":
                        bukaPintu.high();
                        break;
                    case "tutup":
                        tutupPintu.high();
                }
                break;
        }

    }

}
