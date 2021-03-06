/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.tradecore.common.util;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tradecore.common.config.AlipayConfigs;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;

/**
 * 安全工具类
 * @author HuHui
 * @version $Id: SecureUtil.java, v 0.1 2016年7月19日 下午8:42:34 HuHui Exp $
 */
public class SecureUtil {

    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(SecureUtil.class);

    /**
     * 对响应进行签名<br>
     * @param sortedParaMap    必须传进来的参数是TreeMap
     * @return
     */
    public static String sign(Map<String, Object> sortedParaMap) {

        String sign = null;

        try {
            sign = AlipaySignature.rsaSign(JSON.toJSONString(sortedParaMap), AlipayConfigs.getPrivateKey(), StandardCharsets.UTF_8.displayName());
        } catch (Exception e) {
            LogUtil.error(e, logger, "加签发生异常,paraMap={0}", JSON.toJSONString(sortedParaMap));
            throw new RuntimeException("加签发生异常");
        }

        return sign;
    }

    /**
     * 对给收单机构的异步通知进行加签
     * @param sortedParaMap
     * @return
     */
    public static String signNotify(Map<String, String> sortedParaMap) {

        String sign = null;
        try {
            sign = AlipaySignature.rsaSign(sortedParaMap, AlipayConfigs.getPrivateKey(), StandardCharsets.UTF_8.displayName());
        } catch (Exception e) {
            LogUtil.error(e, logger, "加签发生异常,paraMap={0}", JSON.toJSONString(sortedParaMap));
            throw new RuntimeException("加签发生异常");
        }
        return sign;
    }

    /**
     * 对支付宝的异步通知进行验签
     * @throws AlipayApiException 
     */
    public static boolean verifyAlipayNotify(Map<String, String> paraMap) {
        try {
            return AlipaySignature.rsaCheckV1(paraMap, AlipayConfigs.getAlipayPublicKey(), StandardCharsets.UTF_8.displayName());
        } catch (AlipayApiException e) {
            LogUtil.error(e, logger, "验证支付宝异步通知签名失败");
        }
        return false;
    }

}
