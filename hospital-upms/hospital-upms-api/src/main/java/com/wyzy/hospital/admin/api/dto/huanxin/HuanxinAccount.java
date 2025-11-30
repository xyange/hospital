package com.wyzy.hospital.admin.api.dto.huanxin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author aqie
 * Date on 2021/5/17  8:12
 * @Function:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HuanxinAccount {
    private String username;
    private String password;
    private String nickname;
}
