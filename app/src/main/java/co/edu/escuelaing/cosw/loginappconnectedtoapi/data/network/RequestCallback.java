package co.edu.escuelaing.cosw.loginappconnectedtoapi.data.network;

public interface RequestCallback<T>
{

    void onSuccess( T response );

    void onFailed( NetworkException e );

}
