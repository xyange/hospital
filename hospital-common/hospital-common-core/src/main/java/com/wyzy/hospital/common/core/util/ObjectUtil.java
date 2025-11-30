package com.wyzy.hospital.common.core.util;

import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

/**
 * @Author aqie
 * Date on 2021/4/22  20:03
 * @Function:
 */
public class ObjectUtil extends ObjectUtils {
    public ObjectUtil() {
    }

    public static boolean isNotEmpty(@Nullable Object obj) {
        return !isEmpty(obj);
    }
}
