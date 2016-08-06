/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.tradecore.alipay.trade.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tradecore.alipay.trade.factory.AlipayClientFactory;
import org.tradecore.alipay.trade.request.BaseRequest;
import org.tradecore.common.util.LogUtil;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayRequest;
import com.alipay.api.AlipayResponse;

/**
 * 支付宝抽象服务类
 * @author HuHui
 * @version $Id: AbstractAlipayService.java, v 0.1 2016年8月4日 下午3:31:49 HuHui Exp $
 */
public abstract class AbstractAlipayService {

    /** 日志 */
    private static final Logger   logger = LoggerFactory.getLogger(AbstractAlipayService.class);

    /** 公共请求方法类 */
    protected static AlipayClient alipayClient;

    /**
     * 构造方法
     */
    public AbstractAlipayService() {

        //工厂方法创建静态AlipayClient
        alipayClient = AlipayClientFactory.getAlipayClientInstance();
    }

    /**
     * 校验请求参数是否合法
     * @param request
     */
    protected void validateRequest(BaseRequest request) {

        if (request == null) {
            throw new NullPointerException("请求参数不能为空");
        }

        request.validate();

    }

    /**
     * 远程调用支付宝
     * @param request
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected AlipayResponse getResponse(AlipayRequest request) {

        AlipayResponse response = null;

        try {
            response = alipayClient.execute(request);

            return response;
        } catch (Exception e) {
            LogUtil.error(e, logger, "调用支付宝失败,message={0}", e.getMessage());
        }

        return response;
    }

}