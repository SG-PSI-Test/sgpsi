package constants;

import android.content.Context;

import sg.psi.david.sgpsi.R;

/**
 * Created by Hexa-David.Foo on 3/18/2018.
 */

public class Constants {

    public static enum ItemIndex {
        NONE, O3_SUB_INDEX, PM10_24_HOURLY, PM10_SUB_INDEX, PM25_24_HOURLY, SO2_SUB_INDEX,
        CO_8_HOUR_MAX, NO2_1_HOUR_MAX, SO2_24_HOURLY, PM25_SUB_INDEX, PSI_24_HOURLY, O3_8_HOUR_MAX;

        public String getName(Context context){
            switch (this){
                case O3_SUB_INDEX:
                    return context.getString(R.string.particle_lbl_o3_subindex);
                case O3_8_HOUR_MAX:
                    return context.getString(R.string.particle_lbl_o3_8_hourmax);
                case CO_8_HOUR_MAX:
                    return context.getString(R.string.particle_lbl_co_8_hourmax);
                case PSI_24_HOURLY:
                    return context.getString(R.string.particle_lbl_psi_24_hourly);
                case SO2_24_HOURLY:
                    return context.getString(R.string.particle_lbl_so2_24_hourly);
                case SO2_SUB_INDEX:
                    return context.getString(R.string.particle_lbl_so2_subindex);
                case NO2_1_HOUR_MAX:
                    return context.getString(R.string.particle_lbl_no2_1_hourmax);
                case PM10_24_HOURLY:
                    return context.getString(R.string.particle_lbl_pm10_24_hourly);
                case PM10_SUB_INDEX:
                    return context.getString(R.string.particle_lbl_pm10_subindex);
                case PM25_24_HOURLY:
                    return context.getString(R.string.particle_lbl_pm25_24_hourly);
                case PM25_SUB_INDEX:
                    return context.getString(R.string.particle_lbl_pm25_subindex);
            }
            return "";
        }
    }
}
