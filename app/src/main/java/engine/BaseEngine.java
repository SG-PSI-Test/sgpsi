package engine;

import android.content.Context;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import api.ApiTask;
import api.model.BaseResponseMessage;
import api.model.ErrorResponse;
import okhttp3.HttpUrl;

/**
 * Created by Hexa-David.Foo on 12/26/2017.
 */

public class BaseEngine {


    private Context context;
    private ApiTask apiTask;
    private ObjectMapper mapper = new ObjectMapper();

    public BaseEngine(Context context) {
        this.context = context;
        this.apiTask = new ApiTask();
    }


    public <V extends BaseResponseMessage>
    void getApi(final HttpUrl requestMessage, final V responseClass,
                final PsiEngine.ResponseCallback responseCallback) {
        apiTask.callApi(requestMessage.url().toString(), new ApiTask.TaskCallback< V >((Class<V>) responseClass.getClass ()) {
            @Override
            public void handleResponse(String responseStr, int responseCode, Class<V> type) {
                V responseMessage = null;
                try {
                    responseMessage = (V) mapper.readValue(responseStr, type);
                } catch (IOException e) {
                    e.printStackTrace();
                    handleException(responseStr, e, responseCode, type);
                    return;
                }
                /*String passCode = Constant.API.ResultCode.API_PREFIX_CODE
                        + String.valueOf(Constant.API.ResultCode.PASS_OK);
                if ( ValidUtil.isEmpty(responseMessage.getResultCode())
                        || !responseMessage.getResultCode().equalsIgnoreCase(passCode)) {
                    String errorMsg = "";
                    if(!ValidUtil.isEmpty(responseMessage.getResultCode())) {
                        if(responseMessage.getResultCode().toLowerCase().contains(Constant.API.ResultCode.API_PREFIX_CODE)){
                            errorMsg += "[" + responseMessage.getResultCode().replace(Constant.API.ResultCode.API_PREFIX_CODE, "") + "] ";
                        } else {
                            errorMsg += "[" + responseMessage.getResultCode() + "] ";
                        }
                    }
                    if(responseMessage.getBody() != null) {
                        if (!ValidUtil.isEmpty(responseMessage.getMessage())) {
                            errorMsg += responseMessage.getMessage();
                        }
                        if (ValidUtil.isEmpty(errorMsg)) {
                            errorMsg = context.getString(R.string.global_lbl_error);
                        }
                    } else {
                        errorMsg = context.getString(R.string.global_lbl_error);
                    }
                    Exception exception = new Exception(errorMsg);
                    handleException(responseStr, exception, responseCode, type);
                    return;
                }*/
                responseCallback.successfulResponse(responseMessage);
            }

            @Override
            public void handleException(String responseStr, Exception e, int responseCode, Class<V> type) {
                responseCallback.failedResponse(new ErrorResponse.Builder().errorUiMsg("").build());
            }
        });
    }
}



