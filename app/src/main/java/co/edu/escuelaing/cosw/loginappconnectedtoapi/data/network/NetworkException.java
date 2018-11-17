package co.edu.escuelaing.cosw.loginappconnectedtoapi.data.network;

import java.io.IOException;

public class NetworkException extends Exception{
    public NetworkException(String message, Throwable e){
        super(message, e);
    }
}
