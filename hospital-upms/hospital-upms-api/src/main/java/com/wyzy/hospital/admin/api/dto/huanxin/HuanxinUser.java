package com.wyzy.hospital.admin.api.dto.huanxin;

import lombok.Data;

/**
 * @Author aqie
 * Date on 2021/5/17  8:32
 * @Function:
 */
@Data
public class HuanxinUser {

    /**
     * uuid : ba2e7d00-b6a5-11eb-9e6d-83032f7d1e7e
     * type : user
     * created : 1621210847445
     * modified : 1621210847445
     * username : 17732563921
     * activated : true
     * nickname : bqie
     */

    private String uuid;
    private String type;
    private long created;
    private long modified;
    private String username;
    private boolean activated;
    private String nickname;

}
