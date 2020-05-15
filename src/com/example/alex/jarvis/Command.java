package com.example.alex.jarvis;

import java.io.Serializable;

/**
 * Created by hugopiso on 03/12/2016.
 */
public class Command implements Serializable{

    private  static  final  long serialVersionUID =  1L;

        public Command(String command){
            switch (command){
                case "lantai satu":
                    action = "satu";
                    element = "lantai";
                    break;
                case "lantai dua":
                    action = "dua";
                    element = "lantai";
                    break;
                case "lantai tiga":
                    action = "tiga";
                    element = "lantai";
                    break;
                case "lantai empat":
                    action = "empat";
                    element = "lantai";
                    break;
                case "lantai lima":
                    action = "lima";
                    element = "lantai";
                    break;
                case "lantai enam":
                    action = "enam";
                    element = "lantai";
                    break;
                case "buka pintu":
                    action = "buka";
                    element = "pintu";
                    break;
                case "tutup pintu":
                    action = "tutup";
                    element = "pintu";
                    break;
            }
        }

    public Command() {
    }

    public Command(String action, String element) {
        this.action = action;
        this.element = element;
    }

    private String action;
        private String element;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getElement() {
            return element;
        }

        public void setElement(String element) {
            this.element = element;
        }

}
