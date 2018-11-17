package co.edu.escuelaing.cosw.loginappconnectedtoapi.data.network;

import co.edu.escuelaing.cosw.loginappconnectedtoapi.data.entities.LoginWrapper;
import co.edu.escuelaing.cosw.loginappconnectedtoapi.data.entities.Token;

public interface Network
{
    void login(LoginWrapper loginWrapper, RequestCallback<Token> requestCallback );
}