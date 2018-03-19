package api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Hexa-David.Foo on 11/21/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class PsiItems {

    @JsonProperty("timestamp")
    private String timeStamp;

    @JsonProperty("update_timestamp")
    private String updateTimeStamp;


    @JsonProperty("readings")
    private Readings readings;

    PsiItems(){

    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(String updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    public Readings getReadings() {
        return readings;
    }

    public void setReadings(Readings readings) {
        this.readings = readings;
    }
}

