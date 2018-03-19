package api.model;

import android.location.Location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Hexa-David.Foo on 11/21/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegionMetaData {

    @JsonProperty("name")
    private String name;

    @JsonProperty("label_location")
    private RegionLocation locationInfo;

    @JsonIgnore
    private Location location;

    RegionMetaData() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        this.location = new Location("");
        this.location.setLatitude(locationInfo.getLatitude());
        this.location.setLongitude(locationInfo.getLongitude());

        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
        this.locationInfo.setLatitude(location.getLatitude());
        this.locationInfo.setLongitude(location.getLongitude());
    }

    public RegionLocation getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(RegionLocation locationInfo) {
        this.locationInfo = locationInfo;
    }
}

