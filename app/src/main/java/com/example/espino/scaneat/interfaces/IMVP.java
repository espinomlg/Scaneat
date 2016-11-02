package com.example.espino.scaneat.interfaces;

public interface IMVP {

    interface View{
        void setMessage(String message, int idView);
    }

    interface Presenter{
        void validateCredentials(String user, String password);
    }

}
