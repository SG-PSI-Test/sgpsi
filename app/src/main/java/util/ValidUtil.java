package util;

import android.text.TextUtils;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidUtil {

    private static final String LOG_TAG = "ValidUtil";

    private static final String REGEX_ALPHABET_SMALL_CASE = "[a-z]";
    private static final String REGEX_ALPHABET_UPPER_CASE = "[A-Z]";
    private static final String REGEX_ALPHABET_UPPER_AND_LOWER_CASE = "[a-zA-Z]";
    private static final String REGEX_NUMBERS = "[0-9]";
    private static final String NOT_ALPHANUMERIC = "[^a-zA-Z0-9]";

    public static boolean isEmpty(List<?> list) {
        return list == null || list.size() <= 0;
    }

    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static boolean isEmpty(String[] arrayString) {
        return arrayString == null || arrayString.length == 0;
    }

    public static boolean isNumberString(String string) {
        if (isEmpty(string) == false) {
            try {
                return TextUtils.isDigitsOnly(string);
            } catch (Exception e) {
                if (Log.isLoggable(LOG_TAG, Log.ERROR)) {
                    Log.e(LOG_TAG, "string=[" + string + "]", e);
                }
            }
        }
        return false;
    }
}
