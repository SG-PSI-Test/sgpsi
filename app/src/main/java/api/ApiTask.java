package api;

import android.os.AsyncTask;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;

import api.model.BaseResponseMessage;
import api.model.ErrorResponse;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import util.ValidUtil;


public class ApiTask extends AsyncTask<Void, Void, Boolean>{
    private static String LOG_TAG = ApiTask.class.getName();
    public static final MediaType MEDIA_TYPE_TEXT_JSON = MediaType.parse("application/json; charset=utf-8");
    public static final String LBL_CONTENT_TYPE = "Content-Type";
    public static final String VALUE_CONTENT_TYPE = "text/json";

    static class StatusCode {
        public static int PASS_OK = 200;
        public static int UNKNOWN_EXECPTION = 999;
    }


    private String url;
    //private String requestJson;
    private String requestUrl;
    private TaskCallback callback;
    private boolean responsePassed;
    private Exception exceptionData;
    private String responseString;
    private int responseCode;

    public  <T> void callApi(final String requestUrl, final TaskCallback callback) {
       this.requestUrl = requestUrl;
       this.callback = callback;
       this.execute();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {


        Request request = new Request.Builder()
                .url(requestUrl)
                .build();

        OkHttpClient client = new OkHttpClient();
        //add log interceptor
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.newBuilder().addInterceptor(logging).build();
        Log.d(LOG_TAG,"requestUrl=" + requestUrl);

        // Use local json files as mock API payloads if flavor is mockIntercept
      /*  if (ConfigConstants.getInstance().isMockIntercept()) {
            client.addInterceptor(new MockInterceptor(context));
        }*/
        Response response = null;
        try {
            response = client.newCall(request).execute();

            responseCode = response.code(); // Get API's code


            if (!response.isSuccessful()) {
                responsePassed = false;
                throw new IOException("Unexpected response " + response);
            } else {
                responseString = response.body().string();
                Log.d(LOG_TAG,"response=" + responseString);
                if (StatusCode.PASS_OK == responseCode) {
                    responsePassed = true;
                } else {
                    responsePassed = false;
                }
                //Log.d(LOG_TAG, responseData);
            }
        } catch (IOException e) {
            e.printStackTrace();
            exceptionData = e;
            responsePassed = false;
            responseCode = StatusCode.UNKNOWN_EXECPTION;
        } finally {
            //Log.d("Response:", responseString + "\n\n");
        }
        return responsePassed;
    }

    @Override
    protected void onPostExecute(Boolean success) {
        if (callback != null) {
                if (success) {
                    callback.handleResponse(responseString, responseCode, callback.getType());
                } else {
                    callback.handleException(responseString, exceptionData, responseCode, callback.getType());
                }
        }
    }


    public static abstract class TaskCallback<T> {
        private final Class<T> type;

        public TaskCallback(Class<T> type) {
            this.type = type;
        }

        public Class<T> getType() {
            return type;
        }

        public abstract void handleResponse(String responseStr, int responseCode, Class<T> type);

        public abstract void handleException(String responseStr, Exception e, int responseCode, Class<T> type);

    }
}
