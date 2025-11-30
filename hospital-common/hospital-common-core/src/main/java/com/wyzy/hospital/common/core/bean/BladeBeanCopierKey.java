package com.wyzy.hospital.common.core.bean;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @Author aqie
 * Date on 2021/4/22  20:43
 * @Function:
 */
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class BladeBeanCopierKey {
    private final Class<?> source;
    private final Class<?> target;
    private final boolean useConverter;
    private final boolean nonNull;
}
