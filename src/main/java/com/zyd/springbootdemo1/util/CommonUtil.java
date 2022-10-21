package com.zyd.springbootdemo1.util;


import java.util.HashSet;
import java.util.List;

public class CommonUtil {

    public static <T> void removeDuplicate (List<T> list) {
        if (list == null) {
            return;
        }
        HashSet<T> hashSet = new HashSet<T>(list);
        list.clear();
        list.addAll(hashSet);
    }

}
