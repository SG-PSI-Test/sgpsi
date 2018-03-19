package api.model;

public final class ErrorResponse extends BaseMappedData{

    private String errorMsg;
    private String errorFrom;
    private String httpCall;
    private String errorUiMsg;

    private ErrorResponse(Builder builder) {
        setErrorMsg(builder.errorMsg);
        setErrorFrom(builder.errorFrom);
        httpCall = builder.httpCall;
        errorUiMsg = builder.errorUiMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorFrom() {
        return errorFrom;
    }

    public void setErrorFrom(String errorFrom) {
        this.errorFrom = errorFrom;
    }

    public static final class Builder {
        private String errorMsg;
        private String errorFrom;
        private String httpCall;
        private String errorUiMsg;

        public Builder() {
        }

        public Builder errorMsg(String val) {
            errorMsg = val;
            return this;
        }

        public Builder errorFrom(String val) {
            errorFrom = val;
            return this;
        }

        public Builder httpCall(String val) {
            httpCall = val;
            return this;
        }

        public Builder errorUiMsg(String val) {
            errorUiMsg = val;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this);
        }
    }
}
