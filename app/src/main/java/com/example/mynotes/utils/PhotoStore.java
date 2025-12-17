package com.example.mynotes.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.LinkedHashSet;
import java.util.Set;

public class PhotoStore {
    private static final String PREFS = "photos_prefs";
    private static final String KEY_URIS = "photo_uris";

    public static void addPhotoUri(Context ctx, String uri) {
        SharedPreferences sp = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        Set<String> current = new LinkedHashSet<>(sp.getStringSet(KEY_URIS, new LinkedHashSet<>()));
        current.add(uri);
        sp.edit().putStringSet(KEY_URIS, current).apply();
    }

    public static Set<String> getPhotoUris(Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        return sp.getStringSet(KEY_URIS, new LinkedHashSet<>());
    }
}
