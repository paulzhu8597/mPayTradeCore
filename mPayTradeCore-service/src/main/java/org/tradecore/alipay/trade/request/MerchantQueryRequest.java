/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.tradecore.alipay.trade.request;

import org.tradecore.common.util.AssertUtil;

/**
 * 商户信息查询请求
 * @author HuHui
 * @version $Id: MerchantQueryRequest.java, v 0.1 2016年7月13日 下午9:21:54 HuHui Exp $
 */
public class MerchantQueryRequest extends BaseRequest {

    /**  */
    private static final long serialVersionUID = -1718235311954569610L;

    /**
     * 收单机构编号
     */
    private String            acquirer_id;

    /**
     * (必填)商户外部编号
     */
    private String            external_id;

    /**
     * (必填)商户标识号<br>
     * 含义和merchantId相同，此处使用sub_merchant_id而不是merchant_id是为了方便转换为支付宝请求参数
     */
    private String            sub_merchant_id;

    /**
     * 非空参数校验
     * @return
     */
    public boolean validate() {

        AssertUtil.assertNotEmpty(acquirer_id, "收单机构编号不能为空");

        AssertUtil.assertNotEmpty(external_id, "商户外部编号不能为空");

        AssertUtil.assertNotEmpty(sub_merchant_id, "商户标识号不能为空");

        return true;
    }

    public String getAcquirer_id() {
        return acquirer_id;
    }

    public void setAcquirer_id(String acquirer_id) {
        this.acquirer_id = acquirer_id;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public String getSub_merchant_id() {
        return sub_merchant_id;
    }

    public void setSub_merchant_id(String sub_merchant_id) {
        this.sub_merchant_id = sub_merchant_id;
    }

}