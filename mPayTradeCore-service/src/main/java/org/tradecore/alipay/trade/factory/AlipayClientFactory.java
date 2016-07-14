/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.tradecore.alipay.trade.factory;

import org.tradecore.alipay.trade.constants.ParamConstant;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;

/**
 * Alipay交易相关工厂类
 * @author HuHui
 * @version $Id: AlipayClientFactory.java, v 0.1 2016年7月13日 下午7:35:49 HuHui Exp $
 */
public class AlipayClientFactory {

    /** 支付宝交易接口 */
    private static final AlipayTradeService alipayTradeService;

    /**
     *  SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
     */
    private static final AlipayClient       alipayClient;

    static {

        //1.读取配置文件
        Configs.init("config/zfbinfo.properties");

        //2.工厂方法创建静态支付服务类
        alipayTradeService = new AlipayTradeServiceImpl.ClientBuilder().build();

        //3.实例化AlipayClient
        alipayClient = new DefaultAlipayClient(Configs.getOpenApiDomain(), Configs.getAppid(), Configs.getPrivateKey(), ParamConstant.ALIPAY_CONFIG_FORMAT,
            ParamConstant.ALIPAY_CONFIG_CHARSET, Configs.getAlipayPublicKey());
    }

    /**
     * 返回alipayClient实例
     * @return
     */
    public static AlipayClient getAlipayClientInstance() {
        return alipayClient;
    }

    /**
     * 返回alipayTradeService实例
     * @return
     */
    public static AlipayTradeService getAlipayTradeServiceInstance() {
        return alipayTradeService;
    }
}