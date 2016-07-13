/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.tradecore.alipay.trade.service;

import org.tradecore.alipay.trade.request.MerchantCreateRequest;
import org.tradecore.dao.domain.BizMerchantInfo;

/**
 * 商户服务接口
 * @author HuHui
 * @version $Id: MerchantService.java, v 0.1 2016年7月13日 下午7:52:27 HuHui Exp $
 */
public interface MerchantService {

    /**
     * 商户入驻接口<br>
     * 商户发交易前必须调用此方法，调用此方法，支付宝将给商户分配商户编号merchantId。此商户编号将在支付宝备案
     * @param merchantCreateRequest   请求参数
     * @return                        商户Domain对象
     */
    BizMerchantInfo create(MerchantCreateRequest merchantCreateRequest);
}
