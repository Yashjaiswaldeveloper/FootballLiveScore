package com.livetv.footballscore.livescores.util;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class StringUtils {
    public static boolean isEachStringNotEmpty(String... strArr) {
        for (String isEmpty : strArr) {
            if (isEmpty(isEmpty)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String join(Object... objArr) {
        return joinWithDelimiter(", ", objArr);
    }

    public static String joinWithDelimiter(String str, Object... objArr) {
        String str2;
        List list = CollectionUtils.toList(objArr);
        StringBuilder sb = new StringBuilder("");
        for (Object next : list) {
            if (next == null) {
                str2 = null;
            } else {
                str2 = String.valueOf(next);
            }
            if (!isEmpty(str2)) {
                if (sb.length() > 0) {
                    sb.append(str);
                }
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public static SpannableString getTitleBoldSpannableText(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str2);
        spannableString.setSpan(new StyleSpan(1), 0, str.length(), 0);
        return spannableString;
    }

    public static SpannableString getTitleSpannableText(String str, String str2) {
        return new SpannableString(str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str2);
    }

    public static String getStringFromBytes(byte[] bArr) {
        return bArr == null ? "" : new String(bArr);
    }
}
