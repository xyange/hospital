package com.wyzy.hospital.common.core.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 最大最小经纬度
 *
 * @author wrk
 * @date 2021/05/19 16:21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MinMaxLngLat {
    private double minlng;
    private double maxlng;
    private double minlat;
    private double maxlat;
}
