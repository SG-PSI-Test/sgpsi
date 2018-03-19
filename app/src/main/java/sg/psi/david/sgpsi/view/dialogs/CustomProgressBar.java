package sg.psi.david.sgpsi.view.dialogs;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class CustomProgressBar extends ProgressDialog {

    private int progressColor;
    private ProgressBar progress;
    private TextView progressPercent;

    public CustomProgressBar(Context context, int color) {
        super(context);
        this.progressColor = color;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    setContentView(R.layout.progressbar_fillable);
    //    RelativeLayout rlProgress = (RelativeLayout) findViewById(R.id.rl_progressbar_fillable);
    //    rlProgress.getIndeterminateDrawable().setColorFilter(progressColor, PorterDuff.Mode.SRC_IN);
        progress = (ProgressBar) findViewById(android.R.id.progress);
        progress.getIndeterminateDrawable().setColorFilter(progressColor, PorterDuff.Mode.SRC_IN);
    }

    public void update(float percent){
        if(progress!= null){

        }
         /*  CircularFillableLoaders circularFillableLoaders = (CircularFillableLoaders)findViewById(R.id.yourCircularFillableLoaders);
        // Set Progress
        circularFillableLoaders.setProgress(60);
        // Set Wave and Border Color
        circularFillableLoaders.setColor(Color.RED);
        // Set Border Width
        //circularImageView.setBorderWidth(10 * getResources().getDisplayMetrics().density);
        // Set Wave Amplitude (between 0.00f and 0.10f)
        circularFillableLoaders.setAmplitudeRatio(0.08f);*/
    }

    public void setFillColor(int colorId){
        //  circularFillableLoaders.setColor(Color.RED);
    }

    public void setAmplitudeRatio(float ratio){
        // Set Wave Amplitude (between 0.00f and 0.10f)
        //  circularFillableLoaders.setAmplitudeRatio(0.08f);*/
    }
}