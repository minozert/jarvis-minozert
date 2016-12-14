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
 * @author Robert Savage
 */
public class ControlGpio {

    private ServerSocket serverSocket;
    private Socket socketConnection;
    final GpioController gpio = GpioFactory.getInstance();
    final GpioPinDigitalOutput bedroomLight = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07); // RED
    final GpioPinDigitalOutput livingRoomLight = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09); // GREEN

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
            case "switch on":

                switch (command.getElement()) {
                    case "bedroom":
                        bedroomLight.high();
                        break;
                    case "living room":
                        livingRoomLight.high();
                }

                break;
            case "switch off":
                switch (command.getElement()) {
                    case "bedroom":
                        bedroomLight.low();
                        break;
                    case "living room":
                        livingRoomLight.low();
                }
                break;
        }

    }

}
