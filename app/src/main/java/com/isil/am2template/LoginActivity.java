package com.isil.am2template;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.isil.am2template.model.User;
import com.isil.am2template.presenter.LoginContract;
import com.isil.am2template.presenter.LoginPresenter;
import com.isil.am2template.storage.PreferencesHelper;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private Button btnLogin,btnNuevoUsuario;
    private EditText eteMail;
    private EditText etePassword;
    private String mail;
    private String password;
    private User user;

    private View flayLoading,container;

    private LoginPresenter loginPresenter;

    public LoginActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpPresenter();
        init();

    }

    private void setUpPresenter(){
        loginPresenter = new LoginPresenter();
        loginPresenter.attachView(this);
    }

    private void init(){
        eteMail = (EditText)findViewById(R.id.eteMail);
        etePassword = (EditText)findViewById(R.id.etePassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        flayLoading = findViewById(R.id.flayLoading);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.logIn();
            }
        });
    }

    @Override
    public void showLoading() {
        flayLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        flayLoading.setVisibility(View.GONE);
    }

    @Override
    public void gotoMain() {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(LoginActivity.this,
                "LogIn "+message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void saveSession(String mail, String token) {
        PreferencesHelper.saveSession(this, mail, token);
    }

    @Override
    public boolean validateForm() {
        mail = eteMail.getText().toString();
        password = etePassword.getText().toString();

        if (mail.isEmpty()){
            eteMail.setError("Invalid Mail");
            return false;
        }
        if (password.isEmpty()){
            etePassword.setError("Invalid Mail");
            return false;
        }
        return true;
    }

    @Override
    public String getMail() {
        return this.mail;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
