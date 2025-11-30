package com.wyzy.hospital.common.core.util;

/**
 * @Function:
 * @Author: aqie
 * @Date: 2019/4/5 11:45
 */
public class CodeMsg {
    private int code;
    private String msg;


    private CodeMsg() {}

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    public CodeMsg(String msg) {
        this.msg = msg;
    }

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }


    //通用
    public static CodeMsg NO_DATA = new CodeMsg(110000, "无数据");


    // 用户 1xxxxx
    public static CodeMsg USER_ID_NOT_EXIST_ERROR = new CodeMsg(100001, "指定id用户不存在");
    public static CodeMsg TOKEN_INVALID_ERROR = new CodeMsg(100002, "令牌不存在或者已经失效");
    public static CodeMsg USER_NAME_OR_PASSWORD_ERROR = new CodeMsg(100003, "用户名或密码错误");
    public static CodeMsg USER_NOT_EXIT_ERROR = new CodeMsg(100004, "用户名不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(100005, "密码错误");
    public static CodeMsg ALREADY_SEND_SMS_ERROR = new CodeMsg(100006, "您已发送过短信");
    public static CodeMsg USER_PHONE_NOT_EXIT_ERROR = new CodeMsg(100007, "该手机号用户不存在");
    public static CodeMsg ENUM_VALUE_NOT_EXIT_ERROR = new CodeMsg(100008, "指定枚举类不存在");
    public static CodeMsg ADDRESS_ID_NOT_EXIT_ERROR = new CodeMsg(100009, "用户收货地址不合法");

    // 医院 2xxxx


    // 医生 3xxxx

    // 诊所 4xxxx


    // 服务器 5xxxxx
    public static CodeMsg SERVER_ERROR = new CodeMsg(500000, "服务端异常11");
    public static CodeMsg PARAMETER_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    public static CodeMsg REQUEST_ILLEGAL = new CodeMsg(500102, "请求非法");
    public static CodeMsg ACCESS_LIMIT_REACHED = new CodeMsg(500103, "访问太频繁！");
    public static CodeMsg SMS_SERVER_ERROR = new CodeMsg(500104, "短信服务繁忙");
    public static CodeMsg MEDIA_TYPE_NOT_ACCEPT_ERROR = new CodeMsg(500105, "媒体类型不支持");
    public static CodeMsg BEAN_COPY_ERROR = new CodeMsg(500106, "实体类拷贝失败");
    public static CodeMsg NO_DATA_ERROR = new CodeMsg(500107, "暂无数据");
    public static CodeMsg NO_REQUEST_BODY_ERROR = new CodeMsg(500108, "Required request body is missing");
    public static CodeMsg NO_REQUEST_PARAM_ERROR = new CodeMsg(500109, "Required request param is missing");
    public static CodeMsg UPLOAD_FILE_ERROR = new CodeMsg(500110, "图片上传失败");

    // 数据库
    public static CodeMsg DATABASE_ERROR  = new CodeMsg(500400, "数据库执行语句异常");
    public static CodeMsg DATABASE_INTEGRITY_VIOLATION_ERROR  = new CodeMsg(500401, "数据完整性的异常 不符合约束条件");
    public static CodeMsg ACCOUNT_REGISTER_ERROR = new CodeMsg(500411, "账户注册失败");
    public static CodeMsg BIND_PUSH_ID_ERROR = new CodeMsg(500412, "绑定推送ID失败");
    public static CodeMsg USER_UPDATE_ERROR = new CodeMsg(500413, "用户更新失败");

    public static CodeMsg REDIS_CONNECT_ERROR  = new CodeMsg(5007601, "reids 连接异常");
    public static CodeMsg MYSQL_CONNECT_ERROR  = new CodeMsg(5007602, "mysql 连接异常");
    public static CodeMsg MYSQL_DATA_ACCESS_RESOURCE_FAILURE_ERROR  = new CodeMsg(5007603, "客户端未检测到服务器释放连接池连接");

    // 中医 8xxxx
    public static CodeMsg THE_NAME_ALREADY_EXISTS = new CodeMsg(800001, "名称已经存在");
    public static CodeMsg THE_NAME_PSEUDO_DELETE = new CodeMsg(800002, "名称已经伪删除");
    public static CodeMsg EBOOK_EXIT_ERROR = new CodeMsg(800003, "电子书已存在");
    public static CodeMsg THE_IDCARD_ALREADY_EXISTS = new CodeMsg(800004, "身份证号已经存在");
    public static CodeMsg THE_IDCARD_NOT_LEGAL = new CodeMsg(800005, "身份证号不合法");
    public static CodeMsg THE_PHONE_NOT_LEGAL = new CodeMsg(800006, "手机号不合法");
    public static CodeMsg TASK_COMPLETED = new CodeMsg(800007, "任务已完成");

    //就诊
    public static CodeMsg MEDICAL_INFORMATION_SUBMIT_FAIL = new CodeMsg(900001, "就诊信息上传失败");
    public static CodeMsg IMG_UPLOAD_FAIL = new CodeMsg(900002, "图片上传失败");
    public static CodeMsg IMG_SAVE_FAIL = new CodeMsg(900003, "就诊信息与图片上传成功，图片信息保存失败");

    //百科
    public static CodeMsg COMPANY_CYREAGENT_INNERST_ERROR = new CodeMsg(300001, "添加失败");
    public static CodeMsg CYCLOPEDIA_DATD_REPEAT = new CodeMsg(300001, "数据重复");

    //优惠券
    public static CodeMsg COUPON_PDATEDATE_NOAPPLY = new CodeMsg(101001, "条件约束不能修改数据");
    public static CodeMsg COUPON_INSERTDATE_ERROR = new CodeMsg(101002, "优惠券领取达到上限");
    public static CodeMsg COUPON_HAVE_NULL = new CodeMsg(101003, "优惠券已领光!");
}
