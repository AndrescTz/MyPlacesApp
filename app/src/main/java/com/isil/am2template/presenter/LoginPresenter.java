package com.isil.am2template.presenter;

import android.util.Log;

import com.isil.am2template.storage.request.ApiClient;
import com.isil.am2template.storage.request.StorageConstant;
import com.isil.am2template.storage.request.entity.LogInRaw;
import com.isil.am2template.storage.request.entity.LogInResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AndresCyTz on 24/11/2017.
 */

public class LoginPresenter {
    private LoginContract.View view;

    public void logIn(){
        if(view.validateForm()){
            authentication();
        }
    }

    private void authentication(){
        String username= view.getMail();
        String password= view.getPassword();

        final LogInRaw logInRaw= new LogInRaw();
        logInRaw.setLogin(username);
        logInRaw.setPassword(password);

        Call<LogInResponse> call= ApiClient.getMyApiClient().logIn(
                StorageConstant.APPLICATIONID,
                StorageConstant.RESTAPIKEY,logInRaw);

        call.enqueue(new Callback<LogInResponse>() {
            @Override
            public void onResponse(Call<LogInResponse> call, Response<LogInResponse> response) {
                view.hideLoading();
                if(response!=null){
                    LogInResponse logInResponse=null;

                    if(response.isSuccessful()){
                        logInResponse=response.body();
                        if(logInResponse!=null){
                            saveSession(logInResponse);
                            view.gotoMain();
                        }
                    }else{
                        Log.v("CONSOLE", "error "+logInResponse);
                    }
                }else{
                    view.showMessage("Ocurrió un error");
                }
            }

            @Override
            public void onFailure(Call<LogInResponse> call, Throwable t) {
                view.hideLoading();
                view.showMessage(t.getMessage());
            }
        });
    }

    private void saveSession(LogInResponse logInResponse) {
        view.saveSession(logInResponse.getEmail(),logInResponse.getToken());
    }

    public void attachView(LoginContract.View view){
        this.view=view;
    }
    public void detachView(){
        this.view=null;
    }
}
