package com.web.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author chuqian
 * @Date created in 2019/1/31 21:17
 * @describe
 */
public class AddressUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressUtils.class);

    public static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

    public static String getRealAddressByIP(String ip) {
        String address = "XX XX";
        // 内网不查询
        //if (IpUtils.internalIp())
        return "";
    }
}
