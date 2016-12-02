package com.example.espino.scaneat.views;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.espino.scaneat.R;
import com.example.espino.scaneat.interfaces.IMVP;
import com.example.espino.scaneat.presenters.LoginPresenter;
import com.example.espino.scaneat.singletons.MyPreferences;


public class LoginActivity extends AppCompatActivity implements IMVP.View{

    public static final String REMEMBER_USER = "remember_user";

    private IMVP.LoginPresenter loginPresenter;
    private TextInputLayout txiUser, txiPasswd;
    private CheckBox cbremember;
    private Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(PreferenceManager.getDefaultSharedPreferences(LoginActivity.this).getBoolean(REMEMBER_USER, false)) {
            Intent search = new Intent(LoginActivity.this, SearchActivity.class);
            startActivity(search);
            finish();
        }
        else
            setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenter(this);
        txiUser = (TextInputLayout) findViewById(R.id.login_txiUser);
        txiPasswd = (TextInputLayout) findViewById(R.id.login_txiPassword);
        login = (Button) findViewById(R.id.login_btnLogin);
        cbremember = (CheckBox) findViewById(R.id.login_cbRemember);
    }

    @Override
    public void setMessage(String message, int idView) {
        txiUser.setError(null);
        txiPasswd.setError(null);

        switch(idView){
            case R.id.login_txiUser:
                txiUser.setError(message);
                txiUser.requestFocus();
                break;

            case R.id.login_txiPassword:
                txiPasswd.setError(message);
                txiPasswd.requestFocus();
                break;

            default:
                Intent search = null;
                if(checkUser(txiUser.getEditText().getText().toString(), txiPasswd.getEditText().getText().toString())) {
                    PreferenceManager.getDefaultSharedPreferences(LoginActivity.this).edit().putBoolean(REMEMBER_USER,cbremember.isChecked()).commit();
                    Toast.makeText(LoginActivity.this, R.string.login_correct, Toast.LENGTH_SHORT).show();
                    search = new Intent(LoginActivity.this, SearchActivity.class);
                    startActivity(search);
                    finish();
                }
                else
                    Toast.makeText(LoginActivity.this, R.string.login_incorrect, Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkUser(String username, String password){

        if(username.compareTo(MyPreferences.getInstance(LoginActivity.this).getString(MyPreferences.USERNAME)) == 0 &&
                password.compareTo(MyPreferences.getInstance(LoginActivity.this).getString(MyPreferences.PASSWD)) == 0)
            return true;

        return false;
    }

    public void onClickLogin(View v){
        switch (v.getId()){
            case R.id.login_btnLogin:
                loginPresenter.validateCredentials(txiUser.getEditText().getText().toString(), txiPasswd.getEditText().getText().toString());
                break;
            case R.id.login_btnSignUp:
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                finish();
                break;
        }


    }
}
