package com.online.video.util;

/**
 * Created by pein on 2015/12/12.
 */
public class VideoUtils {

    public static final String randomUUID() {
        String random = java.util.UUID.randomUUID().toString();
        return random.replace("-", "");
    }
}
