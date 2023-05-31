package com.livetv.footballscore.livescores.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CollectionUtils {
    public static List toList(Object... objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object collection : objArr) {
            if (collection != null) {
                if (collection.getClass().isArray()) {
                    arrayList.addAll(toListCheckingType(collection));
                } else if (collection instanceof Collection) {
                    arrayList.addAll((Collection) collection);
                } else if (collection instanceof Map) {
                    arrayList.addAll(((Map) collection).entrySet());
                } else {
                    arrayList.add(collection);
                }
            }
        }
        return arrayList;
    }

    private static List toListCheckingType(Object obj) {
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls == short[].class) {
            return toListFromShort((short[]) obj);
        }
        if (cls == int[].class) {
            return toListFromInt((int[]) obj);
        }
        if (obj instanceof Object[]) {
            return toList((Object[]) obj);
        }
        throw new IllegalArgumentException("Unsupported Type: " + obj.getClass());
    }

    public static List<Short> toListFromShort(short... sArr) {
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short valueOf : sArr) {
            arrayList.add(Short.valueOf(valueOf));
        }
        return arrayList;
    }

    public static List<Integer> toListFromInt(int... iArr) {
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return arrayList;
    }

    public static List<? extends Comparable> toSortedList(Collection<? extends Comparable> collection) {
        if (isEmpty((Collection) collection)) {
            return null;
        }
        LinkedList linkedList = new LinkedList(collection);
        Collections.sort(linkedList);
        return linkedList;
    }

    public static int[] toIntArray(Collection<Integer> collection) {
        int[] iArr = new int[collection.size()];
        if (!isEmpty((Collection) collection)) {
            int i = 0;
            for (Integer intValue : collection) {
                iArr[i] = intValue.intValue();
                i++;
            }
        }
        return iArr;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    public static boolean isEmpty(int[] iArr) {
        return iArr == null || iArr.length == 0;
    }

    public static boolean containsAny(Collection collection, Collection collection2) {
        if (collection == null) {
            return false;
        }
        for (Object contains : collection2) {
            if (collection.contains(contains)) {
                return true;
            }
        }
        return false;
    }
}
