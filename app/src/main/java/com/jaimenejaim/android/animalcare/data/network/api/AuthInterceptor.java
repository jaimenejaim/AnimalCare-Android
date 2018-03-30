package com.jaimenejaim.android.animalcare.data.network.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Auth;
import com.jaimenejaim.android.animalcare.data.pref.Session;
import com.jaimenejaim.android.animalcare.ui.signin.SignInActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by jaimenejaim on 26/03/2018.
 */

public class AuthInterceptor implements Interceptor {

    private Context context;
    private static final String TAG = AuthInterceptor.class.getSimpleName();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public AuthInterceptor(Context context){
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Log.i(TAG, "intercept(Chain chain)");

        String accessToken = Session.get(context).getAccess_token();

        Request request = chain.request();

        //Build new request
        Request.Builder builder = request.newBuilder();
        setAuthHeader(builder, accessToken);

        request = builder.build(); //overwrite old request
        Response response = chain.proceed(request); //perform request, here original request will be executed

        if (response.code() == 401) { //if unauthorized

                int code = refreshToken() / 100; //refresh token
                if(code != 2) { //if refresh token failed for some reason
                    if(code == 4 || code == 5) //only if response is 400, 500 might mean that token was not updated
                        logout(); //go to login screen
                    return response; //if token refresh failed - show error to user
                }else{

                    setAuthHeader(builder, accessToken); //set auth token to updated
                    request = builder.build();
                    return chain.proceed(request); //repeat request with new token

                }

        }

        return response;
    }

    private void setAuthHeader(Request.Builder builder, String token) {
        Log.i(TAG, "setAuthHeader(Request.Builder builder, String token)");
        if (token != null) //Add Auth token to each request if authorized
            builder.header("Authorization", String.format("Bearer %s", token));

        Log.i(TAG, "setAuthHeader, token = " + String.format("Bearer %s", token));
    }

    private int refreshToken() {
        Log.i(TAG, "refreshToken()");

        RequestBody body = RequestBody.create(JSON, "{}");

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .header("Authorization", Session.get(context).getAccess_token())
                .url(Network.REFRESH_TOKEN)
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();

            if(response.code() == 200){

                String responseBody = response.body().string();

                JSONObject jsonObject = new JSONObject(responseBody);

                Auth auth = new Auth();
                auth.setToken_type(jsonObject.getString("token_type"));
                auth.setAccess_token(jsonObject.getString("access_token"));
                auth.setExpired_at(jsonObject.getString("expired_at"));
                auth.setRefresh_expired_at(jsonObject.getString("refresh_expired_at"));

                Session.make(context, auth);

            }

            return response.code();

        } catch (IOException | JSONException i) {
            i.printStackTrace();

        }

        return 500;

    }

    private int logout() {
        //logout your user
        Log.i(TAG, "logout()");

        Session.destroy(context);

        Intent intent = new Intent(context, SignInActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        ((Activity)context).finish();
        context.startActivity(intent);

        return 0;
    }


}