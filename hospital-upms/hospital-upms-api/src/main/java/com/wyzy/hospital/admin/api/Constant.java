package com.wyzy.hospital.admin.api;

/**
 * @Author aqie
 * Date on 2021/5/22  8:34
 * @Function:
 */
public interface Constant {
    String RABBIT_ROUTE_KEY = "hospital.router.key";
    String RABBIT_EXCHANGE= "hospital.exchange";
    String RABBIT_QUEUE_HOSPITAL= "hospital.queue";
    String RABBIT_QUEUE_USER_TASK= "user.task";
    String RABBIT_QUEUE_HOSPITAL_CREATE= "hospital.queue.create";

    /**
     * wyzy
     */
    // String OSS_URL = "http://wyzy.oss-cn-beijing.aliyuncs.com";

    /**
     * wyzy-epub
      */
    String OSS_URL = "http://wyzy-epub.oss-cn-hangzhou.aliyuncs.com/";
}
