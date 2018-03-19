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
public class SubIndexDetails implements Parcelable {

    @JsonProperty("west")
    private Double west;

    @JsonProperty("national")
    private Double national;

    @JsonProperty("central")
    private Double central;

    @JsonProperty("east")
    private Double east;

    @JsonProperty("south")
    private Double south;

    @JsonProperty("north")
    private Double north;

    SubIndexDetails(){

    }

    public Double getWest() {
        return west;
    }

    public void setWest(Double west) {
        this.west = west;
    }

    public Double getNational() {
        return national;
    }

    public void setNational(Double national) {
        this.national = national;
    }

    public Double getCentral() {
        return central;
    }

    public void setCentral(Double central) {
        this.central = central;
    }

    public Double getEast() {
        return east;
    }

    public void setEast(Double east) {
        this.east = east;
    }

    public Double getSouth() {
        return south;
    }

    public void setSouth(Double south) {
        this.south = south;
    }

    public Double getNorth() {
        return north;
    }

    public void setNorth(Double north) {
        this.north = north;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.west);
        dest.writeValue(this.national);
        dest.writeValue(this.central);
        dest.writeValue(this.east);
        dest.writeValue(this.south);
        dest.writeValue(this.north);
    }

    protected SubIndexDetails(Parcel in) {
        this.west = (Double) in.readValue(Double.class.getClassLoader());
        this.national = (Double) in.readValue(Double.class.getClassLoader());
        this.central = (Double) in.readValue(Double.class.getClassLoader());
        this.east = (Double) in.readValue(Double.class.getClassLoader());
        this.south = (Double) in.readValue(Double.class.getClassLoader());
        this.north = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<SubIndexDetails> CREATOR = new Parcelable.Creator<SubIndexDetails>() {
        @Override
        public SubIndexDetails createFromParcel(Parcel source) {
            return new SubIndexDetails(source);
        }

        @Override
        public SubIndexDetails[] newArray(int size) {
            return new SubIndexDetails[size];
        }
    };
}

