/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.tradecore.alipay.facade.response;

/**
 * 商户查询响应
 * @author HuHui
 * @version $Id: MerchantQueryResponse.java, v 0.1 2016年7月15日 上午9:29:48 HuHui Exp $
 */
public class MerchantQueryResponse extends BaseResponse {

    /** uid */
    private static final long serialVersionUID = 4441308626394370686L;

    private String            acquirer_id;

    private String            sub_merchant_id;

    private String            external_id;

    private String            name;

    private String            alias_name;

    private String            service_phone;

    private String            contact_name;

    private String            contact_phone;

    private String            contact_mobile;

    private String            contact_email;

    private String            category_id;

    private String            source;

    private String            memo;

    public String getAcquirer_id() {
        return acquirer_id;
    }

    public void setAcquirer_id(String acquirer_id) {
        this.acquirer_id = acquirer_id;
    }

    public String getSub_merchant_id() {
        return sub_merchant_id;
    }

    public void setSub_merchant_id(String sub_merchant_id) {
        this.sub_merchant_id = sub_merchant_id;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias_name() {
        return alias_name;
    }

    public void setAlias_name(String alias_name) {
        this.alias_name = alias_name;
    }

    public String getService_phone() {
        return service_phone;
    }

    public void setService_phone(String service_phone) {
        this.service_phone = service_phone;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getContact_mobile() {
        return contact_mobile;
    }

    public void setContact_mobile(String contact_mobile) {
        this.contact_mobile = contact_mobile;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}