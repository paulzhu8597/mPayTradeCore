/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.tradecore.alipay.facade.response;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 商户查询响应
 * @author HuHui
 * @version $Id: MerchantQueryResponse.java, v 0.1 2016年7月15日 上午9:29:48 HuHui Exp $
 */
public class MerchantQueryResponse extends BaseResponse {

    /** uid */
    private static final long serialVersionUID = 4441308626394370686L;

    private String            acquirer_id;

    private String            merchant_id;

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

    /**
     * 商户营业执照编号
     */
    private String            business_license;

    /**
     * 商户身份证编号
     */
    private String            id_card;

    /**
     * 商户所在省份编码
     */
    private String            province_code;

    /**
     * 商户所在城市编码
     */
    private String            city_code;

    /**
     * 商户所在区县编码
     */
    private String            district_code;

    /**
     * 商户详细经营地址
     */
    private String            address;

    private String            memo;

    public String getAcquirer_id() {
        return acquirer_id;
    }

    public void setAcquirer_id(String acquirer_id) {
        this.acquirer_id = acquirer_id;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
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

    public String getBusiness_license() {
        return business_license;
    }

    public void setBusiness_license(String business_license) {
        this.business_license = business_license;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getProvince_code() {
        return province_code;
    }

    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getDistrict_code() {
        return district_code;
    }

    public void setDistrict_code(String district_code) {
        this.district_code = district_code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 将不为空的参数放入TreeMap，用于签名
     */
    public Map<String, Object> buildSortedParaMap() {
        Map<String, Object> paraMap = super.buildSortedParaMap();

        if (StringUtils.isNotBlank(acquirer_id)) {
            paraMap.put("acquirer_id", acquirer_id);
        }
        if (StringUtils.isNotBlank(merchant_id)) {
            paraMap.put("merchant_id", merchant_id);
        }
        if (StringUtils.isNotBlank(external_id)) {
            paraMap.put("external_id", external_id);
        }
        if (StringUtils.isNotBlank(name)) {
            paraMap.put("name", name);
        }
        if (StringUtils.isNotBlank(alias_name)) {
            paraMap.put("alias_name", alias_name);
        }
        if (StringUtils.isNotBlank(service_phone)) {
            paraMap.put("service_phone", service_phone);
        }
        if (StringUtils.isNotBlank(contact_name)) {
            paraMap.put("contact_name", contact_name);
        }
        if (StringUtils.isNotBlank(contact_phone)) {
            paraMap.put("contact_phone", contact_phone);
        }
        if (StringUtils.isNotBlank(contact_mobile)) {
            paraMap.put("contact_mobile", contact_mobile);
        }
        if (StringUtils.isNotBlank(contact_email)) {
            paraMap.put("contact_email", contact_email);
        }
        if (StringUtils.isNotBlank(category_id)) {
            paraMap.put("category_id", category_id);
        }
        if (StringUtils.isNotBlank(source)) {
            paraMap.put("source", source);
        }
        if (StringUtils.isNotBlank(memo)) {
            paraMap.put("memo", memo);
        }

        if (StringUtils.isNotBlank(business_license)) {
            paraMap.put("business_license", business_license);
        }
        if (StringUtils.isNotBlank(id_card)) {
            paraMap.put("id_card", id_card);
        }
        if (StringUtils.isNotBlank(province_code)) {
            paraMap.put("province_code", province_code);
        }
        if (StringUtils.isNotBlank(city_code)) {
            paraMap.put("city_code", city_code);
        }
        if (StringUtils.isNotBlank(district_code)) {
            paraMap.put("district_code", district_code);
        }
        if (StringUtils.isNotBlank(address)) {
            paraMap.put("address", address);
        }

        return paraMap;
    }
}
