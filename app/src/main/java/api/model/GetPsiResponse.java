package api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Hexa-David.Foo on 11/21/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPsiResponse extends BaseResponseMessage {

    @JsonProperty("region_metadata")
    private List<RegionMetaData> regionMetaData;

    @JsonProperty("items")
    private List<PsiItems> items;

    @JsonProperty("api_info")
    private ApiInfo apiInfo;

    public GetPsiResponse() {
        super();
    }

    public List<RegionMetaData> getRegionMetaData() {
        return regionMetaData;
    }

    public void setRegionMetaData(List<RegionMetaData> regionMetaData) {
        this.regionMetaData = regionMetaData;
    }

    public List<PsiItems> getItems() {
        return items;
    }

    public void setItems(List<PsiItems> items) {
        this.items = items;
    }

    public ApiInfo getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(ApiInfo apiInfo) {
        this.apiInfo = apiInfo;
    }
}

