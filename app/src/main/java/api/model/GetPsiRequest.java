package api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONObject;

/**
 * Created by Hexa-David.Foo on 11/21/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPsiRequest {

    @JsonProperty("date")
    private String date;


    public GetPsiRequest() {

    }

    private GetPsiRequest(Builder builder) {
        setDate(builder.date);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public static final class Builder {
        private String date;

        public Builder() {
        }

        public Builder date(String val) {
            date = val;
            return this;
        }

        public GetPsiRequest build() {
            return new GetPsiRequest(this);
        }
    }
}
