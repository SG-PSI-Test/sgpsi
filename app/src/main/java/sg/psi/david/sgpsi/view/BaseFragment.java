package sg.psi.david.sgpsi.view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import java.lang.reflect.Field;

/**
 * @author david.foo
 */
public class BaseFragment extends Fragment {
    private static final String LOG_TAG = BaseFragment.class.getName();

    protected InputMethodManager imm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        hideKeyboard();
    }

    @Override
    public void onResume(){
        super.onResume();

    }

    @Override
    public void onStop(){
        super.onStop();

    }

    @Override
    public void onDestroy(){
        super.onDestroy();

    }

    protected void hideProgressMeterDialog() {
        try {
            getBaseActivity().hideProgressMeterDialog();
        } catch (Exception e) {
            if (Log.isLoggable(LOG_TAG, Log.ERROR)) {
                Log.e(LOG_TAG, "hideProgressMeterDialog", e);
            }
        }
    }

    protected void showProgressMeterDialog(String msg) {
        try {
            getBaseActivity().showProgressMeterDialog( msg);
        } catch (Exception e) {
            if (Log.isLoggable(LOG_TAG, Log.ERROR)) {
                Log.e(LOG_TAG, "showProgressMeterDialog", e);
            }
        }
    }

    protected void updateProgressMeterDialog(String message){
        try {
            getBaseActivity().updateProgressMeterDialog(message);
        } catch (Exception e) {
            if (Log.isLoggable(LOG_TAG, Log.ERROR)) {
                Log.e(LOG_TAG, "updateProgressMeterDialog", e);
            }
        }
    }

    protected void createErrorDialog(String message){
        try {
            getBaseActivity().createErrorDialog(message);
        } catch (Exception e) {
            if (Log.isLoggable(LOG_TAG, Log.ERROR)) {
                Log.e(LOG_TAG, "createErrorDialog", e);
            }
        }
    }

    protected void createPositiveDialog(String title, String message, DialogInterface.OnClickListener onPositiveClickListener){
        try {
            getBaseActivity().createPostivieDialog(title , message, onPositiveClickListener);
        } catch (Exception e) {
            if (Log.isLoggable(LOG_TAG, Log.ERROR)) {
                Log.e(LOG_TAG, "createPositiveDialog", e);
            }
        }
    }

    protected void createTextInputPositiveDialog(String title, String message, EditText et, DialogInterface.OnClickListener onPositiveClickListener){
        try {
            getBaseActivity().createTextInputPostivieDialog(title , message, et, onPositiveClickListener);
        } catch (Exception e) {
            if (Log.isLoggable(LOG_TAG, Log.ERROR)) {
                Log.e(LOG_TAG, "createPositiveDialog", e);
            }
        }
    }

    protected void createTwoButtonDialog(String title, String message, DialogInterface.OnClickListener onPositiveClickListener,
                                         DialogInterface.OnClickListener onNegativeClickListener){
        try {
            getBaseActivity().createTwoButtonDialog(title , message, onPositiveClickListener, onNegativeClickListener);
        } catch (Exception e) {
            if (Log.isLoggable(LOG_TAG, Log.ERROR)) {
                Log.e(LOG_TAG, "createPositiveDialog", e);
            }
        }
    }


    protected void backToPreviousFragment() {
        try {
            getBaseActivity().popSwitchPreviousFragment();
        } catch (Exception e) {
            if (Log.isLoggable(LOG_TAG, Log.ERROR)) {
                Log.e(LOG_TAG, "backToPreviousFragment", e);
            }
        }
    }

    protected void switchFragment(Fragment fragment) {
        try {
            getBaseActivity().switchFragment(fragment);
        } catch (Exception e) {
            if (Log.isLoggable(LOG_TAG, Log.ERROR)) {
                Log.e(LOG_TAG, "fragment=[" + fragment + "]", e);
            }
        }
    }

    protected void switchFragmentWithoutStack(Fragment fragment) {
        try {
            getBaseActivity().switchFragmentWithoutStack(fragment);
        } catch (Exception e) {
            if (Log.isLoggable(LOG_TAG, Log.ERROR)) {
                Log.e(LOG_TAG, "fragment=[" + fragment + "]", e);
            }
        }
    }

    protected void setTitle(String title) {
        try {
            getBaseActivity().setTitle(title);
        } catch (Exception e) {
            if (Log.isLoggable(LOG_TAG, Log.ERROR)) {
                Log.e(LOG_TAG, "title=[" + title + "]", e);
            }
        }
    }


    public MainActivity getMainActivity() {
        try {
            FragmentActivity activity = super.getActivity();
            if (activity instanceof MainActivity) {
                return (MainActivity) super.getActivity();
            } else if (Log.isLoggable(LOG_TAG, Log.WARN)) {
                Log.w(LOG_TAG, "activity not running under MainActivity type");
            }
        } catch (Exception e) {
            if (Log.isLoggable(LOG_TAG, Log.ERROR)) {
                Log.e(LOG_TAG, "getMainActivity", e);
            }
        }
        return null;
    }

    public BaseActivity getBaseActivity() {
        try {
            return (BaseActivity) super.getActivity();
        } catch (Exception e) {
            if (Log.isLoggable(LOG_TAG, Log.WARN)) {
                Log.w(LOG_TAG, "getBaseActivity failed");
            }
        }
        return null;
    }

    protected void showKeyboard(){
        InputMethodManager imm = (InputMethodManager)   getBaseActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }


    protected void hideKeyboard(){
        InputMethodManager imm = (InputMethodManager)   getBaseActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null){
            View view = getView();
            if (view != null) {
                IBinder windowToken = view.getWindowToken();
                if (windowToken != null) {
                    imm.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        setChildFragmentsAccessible();
    }

    private void setChildFragmentsAccessible() {
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public interface OnLifeCycleChange{
        public void onStartChange();
    }
}
