package engine;

import android.content.Context;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

import api.ApiMethod;
import api.model.ErrorResponse;
import api.model.GetPsiResponse;
import okhttp3.HttpUrl;

/**
 * Created by Hexa-David.Foo on 11/21/2017.
 */

public class PsiEngine extends BaseEngine {
    private static String LOG_TAG = PsiEngine.class.getName();

    private EngCallback engCallback;

    public static class Format {
        private static final String PSI_DATE = "yyyy-MM-dd";
        private static final String PSI_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss";
    }

    public PsiEngine(Context context, EngCallback engCallback) {
        super(context);
        this.engCallback = engCallback;
    }

    public void getPsiByDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(Format.PSI_DATE);
        String dateString = formatter.format(date);
        HttpUrl httpUrl = HttpUrl.parse(ApiMethod.GET_PSI.getPath()).newBuilder().addQueryParameter("date", dateString).build();
        super.getApi(httpUrl, new GetPsiResponse(), new ResponseCallback<GetPsiResponse>(GetPsiResponse.class) {

            @Override
            public void successfulResponse(GetPsiResponse response) {
                startCallback(response, ApiMethod.GET_PSI);
            }

            @Override
            public void failedResponse(ErrorResponse errorResponse) {
                startCallback(errorResponse, ApiMethod.GET_PSI);
            }
        });
    }

    public void getPsiByDateTime(Date dateTime) {
        SimpleDateFormat formatter = new SimpleDateFormat(Format.PSI_DATE_TIME);
        String dateTimeString = formatter.format(dateTime);
        HttpUrl httpUrl = HttpUrl.parse(ApiMethod.GET_PSI.getPath()).newBuilder().addQueryParameter("date_time", dateTimeString).build();
        super.getApi(httpUrl, new GetPsiResponse(), new ResponseCallback<GetPsiResponse>(GetPsiResponse.class) {

            @Override
            public void successfulResponse(GetPsiResponse response) {
                startCallback(response, ApiMethod.GET_PSI);
            }

            @Override
            public void failedResponse(ErrorResponse errorResponse) {
                startCallback(errorResponse, ApiMethod.GET_PSI);
            }
        });
    }


    public <T> void startCallback(T response, ApiMethod apiMethod) {
        if (engCallback != null) {
            if (response instanceof ErrorResponse) {
                engCallback.failedResponse((ErrorResponse) response, apiMethod);
            } else {
                engCallback.successfulResponse(response, apiMethod);
            }
        } else {
            Log.e(LOG_TAG, "engCallback= null");
        }
    }

    public static abstract class ResponseCallback<T> {
        private final Class<T> type;

        public ResponseCallback(Class<T> type) {
            this.type = type;
        }

        public Class<T> getType() {
            return type;
        }

        public abstract void successfulResponse(T response);

        public abstract void failedResponse(ErrorResponse errorResponse);
    }

    public interface EngCallback {

        public <T> void successfulResponse(T response, ApiMethod apiMethod);

        public void failedResponse(ErrorResponse errorResponse, ApiMethod apiMethod);
    }
}
