/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.tradecore.common.util;

/**
 * 格式化生成结算中心的ID<br>
 * <ul>
 * <li>结算中心订单号=收单机构号+商户识别号+商户订单号。在结算中心全局唯一</li>
 * <li>结算中心商户外部编号=收单机构号+商户外部编号</li>
 * </ul>
 * @author HuHui
 * @version $Id: TradeNoFormater.java, v 0.1 2016年8月4日 下午5:16:34 HuHui Exp $
 */
public class FormaterUtil {

    /**
     * 生成结算中心订单号
     */
    public static String tradeNoFormat(String acquirerId, String merchantId, String outTradeNo) {
        return new StringBuilder(acquirerId).append(merchantId).append(outTradeNo).toString();
    }

    /**
     * 生成结算中心商户外部编号
     */
    public static String externalIdFormat(String acquirerId, String outExternalId) {
        return new StringBuilder(acquirerId).append(outExternalId).toString();
    }

}
