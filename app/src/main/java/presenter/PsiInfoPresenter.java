package presenter;

import android.content.Context;

import java.util.Date;
import java.util.List;

import api.ApiMethod;
import api.model.ErrorResponse;
import api.model.GetPsiResponse;
import api.model.PsiItems;
import engine.PsiEngine;

/**
 * Created by Hexa-David.Foo on 3/18/2018.
 */

public class PsiInfoPresenter extends BasePresenter {

    public Context context;
    public PsiEngine psiEngine;

    public PsiInfoPresenter(Context context, final PresenterCallback presenterCallback) {
        this.context = context;
        super.setCallback(presenterCallback);
        psiEngine = new PsiEngine(context, new PsiEngine.EngCallback() {

            @Override
            public <T> void successfulResponse(T response, ApiMethod apiMethod) {
                switch (apiMethod){
                    case GET_PSI:
                        if(response instanceof GetPsiResponse){
                            if (presenterCallback != null) {
                                presenterCallback.onDone(this.getClass(), response);
                            }
                        }
                        break;
                        default:
                            if (presenterCallback != null) {
                                presenterCallback.onError(this.getClass(),
                                        createErrorResponse("Sorry, No data"));
                            }
                            break;
                }
            }

            @Override
            public void failedResponse(ErrorResponse errorResponse, ApiMethod apiMethod) {
                if (presenterCallback != null) {
                    presenterCallback.onError(this.getClass(), errorResponse);
                }
            }
        });
    }

    private ErrorResponse createErrorResponse(String msg){
        return new ErrorResponse.Builder().errorUiMsg(msg).build();
    }

    public void getPsiInfoToday() {
        psiEngine.getPsiByDateTime(new Date());
    }

    public void getPsiInfoWholeDay() {
        psiEngine.getPsiByDate(new Date());
    }
}
