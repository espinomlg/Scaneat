package com.example.espino.scaneat.views;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.espino.scaneat.R;
import com.example.espino.scaneat.interfaces.IMVP;
import com.example.espino.scaneat.presenters.SignUpPresenter;
import com.example.espino.scaneat.singletons.MyPreferences;

public class SignUpActivity extends AppCompatActivity implements IMVP.View{

    private IMVP.SignUpPresenter presenter;

    private TextInputLayout username,
    email,
    passwd,
    confirmPasswd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (TextInputLayout) findViewById(R.id.signup_txi_username);
        email = (TextInputLayout) findViewById(R.id.signup_txi_email);
        passwd = (TextInputLayout) findViewById(R.id.signup_txi_passwd);
        confirmPasswd = (TextInputLayout) findViewById(R.id.signup_txi_confirmPasswd);

        presenter = new SignUpPresenter(SignUpActivity.this);

    }

    public void onClickSignUp(View v){

        presenter.validateCredentials(username.getEditText().getText().toString(),
                email.getEditText().getText().toString(),
                passwd.getEditText().getText().toString(),
                confirmPasswd.getEditText().getText().toString());


        finish();
    }

    @Override
    public void setMessage(String message, int idView) {

        username.setError(null);
        email.setError(null);
        passwd.setError(null);
        confirmPasswd.setError(null);

        switch (idView){
            case R.id.signup_txi_username:
                username.setError(message);
                username.requestFocus();
                break;
            case R.id.signup_txi_email:
                email.setError(message);
                email.requestFocus();
                break;
            case R.id.signup_txi_passwd:
                passwd.setError(message);
                passwd.requestFocus();
                break;
            case R.id.signup_txi_confirmPasswd:
                confirmPasswd.setError(message);
                confirmPasswd.requestFocus();
                break;
            default:
                MyPreferences.getInstance(SignUpActivity.this).putString(MyPreferences.USERNAME,username.getEditText().getText().toString());
                MyPreferences.getInstance(SignUpActivity.this).putString(MyPreferences.EMAIL,email.getEditText().getText().toString());
                MyPreferences.getInstance(SignUpActivity.this).putString(MyPreferences.PASSWD,confirmPasswd.getEditText().getText().toString());
                break;
        }
    }
}
