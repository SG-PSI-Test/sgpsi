package sg.psi.david.sgpsi.view;

import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;
import java.util.Date;

import api.ApiMethod;
import api.model.ErrorResponse;
import api.model.GetPsiResponse;
import engine.PsiEngine;
import sg.psi.david.sgpsi.R;
import util.PermissionsUtil;

public class MainActivity extends BaseActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        FragmentManager.OnBackStackChangedListener {

    PermissionsUtil permissionsUtil;

    @Override
    public void onBackStackChanged() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permissionsUtil = new PermissionsUtil(this, new PermissionsUtil.PermissionResultCallback() {
            @Override
            public void PermissionGranted(int request_code) {
                switchFragment(DashboardFragment.newInstance());
            }

            @Override
            public void PartialPermissionGranted(int request_code, ArrayList<String> granted_permissions) {
                switchFragment(DashboardFragment.newInstance());
            }

            @Override
            public void PermissionDenied(int request_code) {

            }

            @Override
            public void NeverAskAgain(int request_code) {
                    createPostivieNonCancelableDialog("", getString(R.string.permission_message_setting), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            redirectToSetting();
                            finish();
                        }
                    });

            }
        });
        permissionsUtil.checkDefaultPermission(
                getString(R.string.permission_message_default) , 1);


    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }
}
