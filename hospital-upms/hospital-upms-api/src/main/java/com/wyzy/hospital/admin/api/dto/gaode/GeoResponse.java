package com.wyzy.hospital.admin.api.dto.gaode;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/5/17  18:16
 * @Function:
 */
@NoArgsConstructor
@Data
public class GeoResponse {

    private String status;
    private String info;
    private String infocode;
    private String count;
    private List<GeocodesBean> geocodes;

    @NoArgsConstructor
    @Data
    public static class GeocodesBean {
        private String formatted_address;
        private String country;
        private String province;
        private String citycode;
        private String city;
        private String district;
        private List<?> township;
        private NeighborhoodBean neighborhood;
        private BuildingBean building;
        private String adcode;
        private String street;
        private String number;
        private String location;
        private String level;

        @NoArgsConstructor
        @Data
        public static class NeighborhoodBean {
            private List<?> name;
            private List<?> type;
        }

        @NoArgsConstructor
        @Data
        public static class BuildingBean {
            private List<?> name;
            private List<?> type;
        }
    }
}
