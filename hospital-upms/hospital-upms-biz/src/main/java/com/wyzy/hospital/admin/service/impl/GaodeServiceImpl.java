package com.wyzy.hospital.admin.service.impl;

import com.wyzy.hospital.admin.api.dto.gaode.GeoResponse;
import com.wyzy.hospital.admin.service.GaodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author aqie
 * Date on 2021/5/17  18:21
 * @Function:
 */
@Service
public class GaodeServiceImpl implements GaodeService {

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Override
    public GeoResponse geo(String address) {
        String url = GaodeService.geoUrl + "?key=2f3e2ff7ed1fea93106f2ce5d90c1e1e&address="+address;
        ResponseEntity<GeoResponse> response = restTemplate.getForEntity(url, GeoResponse.class);
        return response.getBody();
    }
}
