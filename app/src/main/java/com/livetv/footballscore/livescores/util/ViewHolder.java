package com.livetv.footballscore.livescores.util;

import android.util.SparseArray;
import android.view.View;

public class ViewHolder {
    public static <T extends View> T get(View view, int i) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            view.setTag(sparseArray);
        }
        T t = (T) sparseArray.get(i);
        if (t != null) {
            return t;
        }
        T findViewById = view.findViewById(i);
        sparseArray.put(i, findViewById);
        return findViewById;
    }
}
