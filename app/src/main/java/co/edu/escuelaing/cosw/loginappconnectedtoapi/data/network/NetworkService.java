package co.edu.escuelaing.cosw.loginappconnectedtoapi.data.network;


import co.edu.escuelaing.cosw.loginappconnectedtoapi.data.entities.LoginWrapper;
import co.edu.escuelaing.cosw.loginappconnectedtoapi.data.entities.Token;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

interface NetworkService
{

    @POST( "user/login" )
    Call<Token> login(@Body LoginWrapper user );
}