package presenter;

import android.content.Context;

import api.ApiMethod;
import api.model.ErrorResponse;
import engine.PsiEngine;

/**
 * Created by Hexa-David.Foo on 3/18/2018.
 */

public class BasePresenter {

    public PresenterCallback presenterCallback;

    public void setCallback(PresenterCallback presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    public interface PresenterCallback {

        <J, K> void onDone(J classType, K callbackObj);

        <J> void onError(J classType, ErrorResponse errorResponse);
    }
}
