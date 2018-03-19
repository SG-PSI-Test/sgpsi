package sg.psi.david.sgpsi.view;

import android.arch.lifecycle.LifecycleOwner;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import sg.psi.david.sgpsi.R;
import sg.psi.david.sgpsi.view.dialogs.CustomProgressBar;
import util.ValidUtil;


public class BaseActivity extends AppCompatActivity implements LifecycleOwner {


    private static String LOG_TAG = BaseActivity.class.getName();
    private CustomProgressBar progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // enable transitions
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        super.onCreate(savedInstanceState);
        progressDialog = new CustomProgressBar(this, getResources().getColor(android.R.color.darker_gray));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public void showProgressMeterDialog(String message) {
        if (progressDialog != null) {
            progressDialog.setIndeterminate(true);
            if (ValidUtil.isEmpty(message) == false) {
                progressDialog.setMessage(message);
            } else {
                //    progressDialog.setMessage(getLanguage(LanguagePackId.Global.LABEL_LOADING, getString(R.string.global_label_loading)));
            }
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    }

    public void updateProgressMeterDialog(String message) {
        if (progressDialog != null) {
            if (ValidUtil.isEmpty(message) == false) {
                progressDialog.setMessage(message);
            } else {
                //    progressDialog.setMessage(getLanguage(LanguagePackId.Global.LABEL_LOADING, getString(R.string.global_label_loading)));
            }
        }
    }

    public void createErrorDialog(String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.global_lbl_error);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.global_lbl_okay, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void createTextInputPostivieDialog(String title, String message, EditText et, DialogInterface.OnClickListener onPositiveClickListener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        EditText etInput = new EditText(this);
        TextView tvError = new TextView(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setView(et);
        builder.setPositiveButton(R.string.global_lbl_okay, onPositiveClickListener);
        builder.setNegativeButton(R.string.global_lbl_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void createPostivieNonCancelableDialog(String title, String message, DialogInterface.OnClickListener onPositiveClickListener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.global_lbl_okay, onPositiveClickListener);
        builder.setNegativeButton(R.string.global_lbl_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    public void createPostivieDialog(String title, String message, DialogInterface.OnClickListener onPositiveClickListener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.global_lbl_okay, onPositiveClickListener);
        builder.setNegativeButton(R.string.global_lbl_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void createTwoButtonDialog(String title, String message,
                                      DialogInterface.OnClickListener onPositiveClickListener,
                                      DialogInterface.OnClickListener onNegativeClickListener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.global_lbl_okay, onPositiveClickListener);
        builder.setNegativeButton(R.string.global_lbl_cancel, onNegativeClickListener);
        builder.show();
    }


    public void hideProgressMeterDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public void redirectToSetting(){
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);
    }

    public void createErrorAlertOneButton(String msg,
                                          String btnNameYes,
                                          String btnNameNo,
                                          DialogInterface dialogInterfaceYes,
                                          DialogInterface dialogInterfaceNo) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(msg);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                btnNameYes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder1.setNegativeButton(
                btnNameNo,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void switchFragment(Fragment fragment) {
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_main, fragment, fragment.getClass().getName()); // f1_container is your FrameLayout container
        ft.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(fragment.toString());
        ft.commit();
    }

    public void switchFragmentStateLoss(Fragment fragment) {
        /*Like commit but allows the commit to be executed after an activity's state is saved.
        This is dangerous because the commit can be lost if the activity needs to later be restored from its state,
        so this should only be used for cases where it is okay for the UI state to change unexpectedly on the user.*/
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_main, fragment, fragment.getClass().getName());
        ft.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(fragment.toString());
        ft.commitAllowingStateLoss();
    }


    public String getCurrentFragmentName() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            return getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName() == null ?
                    "" : getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName().toString();
        } else {
            return "";
        }
    }

    public void switchFragmentWithoutStack(Fragment fragment) {
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_main, fragment, fragment.getClass().getName());
        ft.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    public void popSwitchPreviousFragment() {
        getSupportFragmentManager().popBackStackImmediate();
    }

    public void clearPopStackFragment() {
        getSupportFragmentManager().popBackStack(null, getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);
        for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); ++i) {
            getSupportFragmentManager().popBackStack();
        }
    }

    public boolean isPopStackEmpty() {
        return getSupportFragmentManager().getBackStackEntryCount() > 0 ? false : true;
    }

    public boolean isPopStackHasOneCount() {
        return getSupportFragmentManager().getBackStackEntryCount() == 1 ? true : false;
    }
}

