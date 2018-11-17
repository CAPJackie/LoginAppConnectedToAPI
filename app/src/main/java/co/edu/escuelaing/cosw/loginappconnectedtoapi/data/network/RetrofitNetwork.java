package co.edu.escuelaing.cosw.loginappconnectedtoapi.data.network;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import co.edu.escuelaing.cosw.loginappconnectedtoapi.data.entities.LoginWrapper;
import co.edu.escuelaing.cosw.loginappconnectedtoapi.data.entities.Token;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitNetwork implements Network {

    private static final String BASE_URL = "http://10.2.67.80:8090/";

    private NetworkService networkService;

    private ExecutorService backgroundExecutor = Executors.newFixedThreadPool( 1 );

    public RetrofitNetwork()
    {
        Retrofit retrofit =
                new Retrofit.Builder().baseUrl( BASE_URL ).addConverterFactory( GsonConverterFactory.create() ).build();
        networkService = retrofit.create( NetworkService.class );
    }

    @Override
    public void login(final LoginWrapper loginWrapper, final RequestCallback<Token> requestCallback )
    {
        backgroundExecutor.execute( new Runnable()
        {
            @Override
            public void run()
            {
                Call<Token> call = networkService.login( loginWrapper );
                try
                {
                    Response<Token> execute = call.execute();
                    requestCallback.onSuccess( execute.body() );
                }
                catch ( IOException e )
                {
                    requestCallback.onFailed( new NetworkException( null, e ) );
                }
            }
        } );

    }

}
