package io.gentjankolicaj.data.transform.cache;


public class LocalCache {

    private static final LocalCache INSTANCE = new LocalCache();

    private LocalCache() {
    }

    public static LocalCache getInstance() {
        return INSTANCE;
    }
}
