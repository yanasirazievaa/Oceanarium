package com.example.turkishsite;

import java.util.List;

public class Algorithm {
    public static <T> boolean find(List<T> objects, T needObject) {
        for (T object: objects) {
            if (object.equals(needObject)) {
                return true;
            }
        }

        return false;
    }
}
