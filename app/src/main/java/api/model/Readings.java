package api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Hexa-David.Foo on 11/21/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Readings implements Parcelable {

    @JsonProperty("o3_sub_index")
    private SubIndexDetails o3SubIndex;

    @JsonProperty("pm10_twenty_four_hourly")
    private SubIndexDetails pm10_24hourly;

    @JsonProperty("pm10_sub_index")
    private SubIndexDetails pm10SubIndex;

    @JsonProperty("pm25_twenty_four_hourly")
    private SubIndexDetails pm25_24Hourly;

    @JsonProperty("so2_sub_index")
    private SubIndexDetails so2SubIndex;

    @JsonProperty("co_eight_hour_max")
    private SubIndexDetails co8HourMax;

    @JsonProperty("no2_one_hour_max")
    private SubIndexDetails no2_1HourMax;

    @JsonProperty("so2_twenty_four_hourly")
    private SubIndexDetails so2_24Hourly;

    @JsonProperty("pm25_sub_index")
    private SubIndexDetails pm25SubIndex;

    @JsonProperty("psi_twenty_four_hourly")
    private SubIndexDetails psi_24Hourly;

    @JsonProperty("o3_eight_hour_max")
    private SubIndexDetails o3_8HourMax;


    Readings(){

    }

    public SubIndexDetails getO3SubIndex() {
        return o3SubIndex;
    }

    public void setO3SubIndex(SubIndexDetails o3SubIndex) {
        this.o3SubIndex = o3SubIndex;
    }

    public SubIndexDetails getPm10_24hourly() {
        return pm10_24hourly;
    }

    public void setPm10_24hourly(SubIndexDetails pm10_24hourly) {
        this.pm10_24hourly = pm10_24hourly;
    }

    public SubIndexDetails getPm10SubIndex() {
        return pm10SubIndex;
    }

    public void setPm10SubIndex(SubIndexDetails pm10SubIndex) {
        this.pm10SubIndex = pm10SubIndex;
    }

    public SubIndexDetails getPm25_24Hourly() {
        return pm25_24Hourly;
    }

    public void setPm25_24Hourly(SubIndexDetails pm25_24Hourly) {
        this.pm25_24Hourly = pm25_24Hourly;
    }

    public SubIndexDetails getSo2SubIndex() {
        return so2SubIndex;
    }

    public void setSo2SubIndex(SubIndexDetails so2SubIndex) {
        this.so2SubIndex = so2SubIndex;
    }

    public SubIndexDetails getCo8HourMax() {
        return co8HourMax;
    }

    public void setCo8HourMax(SubIndexDetails co8HourMax) {
        this.co8HourMax = co8HourMax;
    }

    public SubIndexDetails getNo2_1HourMax() {
        return no2_1HourMax;
    }

    public void setNo2_1HourMax(SubIndexDetails no2_1HourMax) {
        this.no2_1HourMax = no2_1HourMax;
    }

    public SubIndexDetails getSo2_24Hourly() {
        return so2_24Hourly;
    }

    public void setSo2_24Hourly(SubIndexDetails so2_24Hourly) {
        this.so2_24Hourly = so2_24Hourly;
    }

    public SubIndexDetails getPm25SubIndex() {
        return pm25SubIndex;
    }

    public void setPm25SubIndex(SubIndexDetails pm25SubIndex) {
        this.pm25SubIndex = pm25SubIndex;
    }

    public SubIndexDetails getPsi_24Hourly() {
        return psi_24Hourly;
    }

    public void setPsi_24Hourly(SubIndexDetails psi_24Hourly) {
        this.psi_24Hourly = psi_24Hourly;
    }

    public SubIndexDetails getO3_8HourMax() {
        return o3_8HourMax;
    }

    public void setO3_8HourMax(SubIndexDetails o3_8HourMax) {
        this.o3_8HourMax = o3_8HourMax;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.o3SubIndex, flags);
        dest.writeParcelable(this.pm10_24hourly, flags);
        dest.writeParcelable(this.pm10SubIndex, flags);
        dest.writeParcelable(this.pm25_24Hourly, flags);
        dest.writeParcelable(this.so2SubIndex, flags);
        dest.writeParcelable(this.co8HourMax, flags);
        dest.writeParcelable(this.no2_1HourMax, flags);
        dest.writeParcelable(this.so2_24Hourly, flags);
        dest.writeParcelable(this.pm25SubIndex, flags);
        dest.writeParcelable(this.psi_24Hourly, flags);
        dest.writeParcelable(this.o3_8HourMax, flags);
    }

    protected Readings(Parcel in) {
        this.o3SubIndex = in.readParcelable(SubIndexDetails.class.getClassLoader());
        this.pm10_24hourly = in.readParcelable(SubIndexDetails.class.getClassLoader());
        this.pm10SubIndex = in.readParcelable(SubIndexDetails.class.getClassLoader());
        this.pm25_24Hourly = in.readParcelable(SubIndexDetails.class.getClassLoader());
        this.so2SubIndex = in.readParcelable(SubIndexDetails.class.getClassLoader());
        this.co8HourMax = in.readParcelable(SubIndexDetails.class.getClassLoader());
        this.no2_1HourMax = in.readParcelable(SubIndexDetails.class.getClassLoader());
        this.so2_24Hourly = in.readParcelable(SubIndexDetails.class.getClassLoader());
        this.pm25SubIndex = in.readParcelable(SubIndexDetails.class.getClassLoader());
        this.psi_24Hourly = in.readParcelable(SubIndexDetails.class.getClassLoader());
        this.o3_8HourMax = in.readParcelable(SubIndexDetails.class.getClassLoader());
    }

    public static final Parcelable.Creator<Readings> CREATOR = new Parcelable.Creator<Readings>() {
        @Override
        public Readings createFromParcel(Parcel source) {
            return new Readings(source);
        }

        @Override
        public Readings[] newArray(int size) {
            return new Readings[size];
        }
    };
}

