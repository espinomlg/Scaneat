package com.example.espino.scaneat.presenters;

import android.content.Context;
import android.text.TextUtils;

import com.example.espino.scaneat.R;
import com.example.espino.scaneat.ScanEatApplication;
import com.example.espino.scaneat.interfaces.IMVP;
import com.example.espino.scaneat.models.LoginUser;


public class LoginPresenter implements IMVP.Presenter{

    private IMVP.View view;

    public LoginPresenter(IMVP.View view){
        this.view = view;
    }

    @Override
    public void validateCredentials(String user, String password) {
        if(TextUtils.isEmpty(user))
            view.setMessage(((Context)view).getResources().getString(R.string.field_empty),R.id.txiUser);

        else if(TextUtils.isEmpty(password))
            view.setMessage(((Context)view).getResources().getString(R.string.field_empty),R.id.txiPassword);

        else if(!password.matches(".*(\\d).*"))
            view.setMessage(((Context)view).getResources().getString(R.string.password_incorrect_digit),R.id.txiPassword);

        else if(!password.matches(".*(\\p{Lower}).*"))
            view.setMessage(((Context)view).getResources().getString(R.string.password_incorrect_lower),R.id.txiPassword);

        else if(!password.matches(".*(\\p{Upper}).*"))
            view.setMessage(((Context)view).getResources().getString(R.string.password_incorrect_upper),R.id.txiPassword);

        else if(password.length() < 8)
            view.setMessage(((Context)view).getResources().getString(R.string.password_incorrect_length),R.id.txiPassword);

        else {
            view.setMessage(((Context) view).getResources().getString(R.string.login_correct), 0);
            ((ScanEatApplication)((Context) view).getApplicationContext()).setUser(new LoginUser(user,password));

        }
    }
}
