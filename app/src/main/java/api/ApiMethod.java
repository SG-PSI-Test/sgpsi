package api;


/**
 * Created by Hexa-David.Foo on 11/21/2017.
 */

public enum ApiMethod {
    GET_PSI;

    private String getPSI = "https://api.data.gov.sg/v1/environment/psi";

    public String getPath() {
        switch (this) {
            case  GET_PSI:
                return getPSI;
        }
        return null;
    }

   /* public String getPath(String targetDate) {
        String url = "";
        String idResult = "";
        switch (this) {
            case GET_TV3_CHN:
                idResult = tv3Id;
                break;
            case GET_NTV7_CHN:
                idResult = ntv7Id;
                break;
            case GET_8TV_CHN:
                idResult = e8tvId;
                break;
        }
        if (targetDate != null || idResult != "") {
            url = Constant.API.BASE_URL + idResult + "/"
                    + Constant.API.ACTION.SCHEDULE
                    + Constant.API.PARAM.DATE + targetDate
                    + Constant.API.PARAM.AND + Constant.API.PARAM.TIME_ZONE + "1";
        }
        return url;
    }
*/

}
