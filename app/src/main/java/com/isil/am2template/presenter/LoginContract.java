package com.isil.am2template.presenter;

/**
 * Created by AndresCyTz on 24/11/2017.
 */

public interface LoginContract {
    public interface View{
        void showLoading();
        void hideLoading();
        void gotoMain();
        void showMessage(String message);
        void saveSession(String mail,String token);

        boolean validateForm();

        String getMail();
        String getPassword();
    }
}
