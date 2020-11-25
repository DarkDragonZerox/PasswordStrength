package com.i4bchile.passwordstrengthmvp.presentador;

import android.view.View;

import com.i4bchile.passwordstrengthmvp.modelo.Verifier;

public class PresenterView {

    IPresenterView view;
    Verifier verifier;


    public PresenterView(IPresenterView view) {
        this.view = view;
    }

    public int updatePasswordStrength(String pPassword) {

        return verifier.getInstance().verifyPassword(pPassword);
    }

    public void evaluatePwdStrength(int strength) {

        switch (strength) {
            case 0:
               this.view.showWeak();
               break;
            case 1:
                this.view.showMedium();
                break;
            case 2:
                this.view.showStrong();
                break;
            case 3:
                this.view.showVeryStrong();
                break;
        }

    }


}
