package com.example.espino.scaneat.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.espino.scaneat.presenters.LoginPresenter;
import com.example.espino.scaneat.R;
import com.example.espino.scaneat.interfaces.IMVP;


public class LoginActivity extends AppCompatActivity implements IMVP.View{

    private IMVP.Presenter presenter;
    private TextInputLayout txiUser, txiPasswd;
    private Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);
        txiUser = (TextInputLayout) findViewById(R.id.txiUser);
        txiPasswd = (TextInputLayout) findViewById(R.id.txiPassword);
        login = (Button) findViewById(R.id.btnLogin);

    }

    @Override
    public void setMessage(String message, int idView) {
        txiUser.setError(null);
        txiPasswd.setError(null);

        switch(idView){
            case R.id.txiUser:
                txiUser.setError(message);
                txiUser.requestFocus();
                break;

            case R.id.txiPassword:
                txiPasswd.setError(message);
                txiPasswd.requestFocus();
                break;

            default:
                Toast.makeText(LoginActivity.this, R.string.login_correct, Toast.LENGTH_SHORT).show();
                Intent searchResults = new Intent(LoginActivity.this,SearchResultsActivity.class);
                startActivity(searchResults);
        }
    }

    public void login(View v){
        presenter.validateCredentials(txiUser.getEditText().getText().toString(), txiPasswd.getEditText().getText().toString());
    }
}
