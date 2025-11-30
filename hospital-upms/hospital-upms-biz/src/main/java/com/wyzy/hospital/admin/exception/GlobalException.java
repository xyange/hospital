package com.wyzy.hospital.admin.exception;

import com.wyzy.hospital.common.core.util.CodeMsg;

/**
 * @Function:
 * @Author: aqie
 * @Date: 2019/4/20 14:30
 */
public class GlobalException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private CodeMsg cm;

    public GlobalException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }
}
