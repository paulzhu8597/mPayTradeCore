/**
 * Beijing Jiaotong University
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package org.tradecore.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.tradecore.alipay.enums.AlipaySceneEnum;
import org.tradecore.alipay.trade.constants.ParamConstant;
import org.tradecore.alipay.trade.request.CancelRequest;
import org.tradecore.alipay.trade.request.DefaultPayRequest;
import org.tradecore.alipay.trade.request.PayRequest;
import org.tradecore.alipay.trade.request.PrecreateRequest;
import org.tradecore.alipay.trade.request.QueryRequest;
import org.tradecore.alipay.trade.request.RefundRequest;
import org.tradecore.alipay.trade.service.TradeService;
import org.tradecore.common.util.AssertUtil;
import org.tradecore.common.util.LogUtil;
import org.tradecore.common.util.ResponseUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.alipay.demo.trade.model.ExtendParams;
import com.alipay.demo.trade.model.GoodsDetail;

/**
 * 处理支付宝交易请求
 * @author HuHui
 * @version $Id: AlipayTradeController.java, v 0.1 2016年7月15日 上午10:41:06 HuHui Exp $
 */
@Controller
@RequestMapping("/trade")
public class AlipayTradeController extends AbstractBizController {

    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(AlipayTradeController.class);

    /** 交易服务接口 */
    @Resource
    private TradeService        tradeService;

    /**
     * 处理条码支付请求
     */
    @ResponseBody
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String pay(WebRequest request, ModelMap map) {

        LogUtil.info(logger, "收到条码支付HTTP请求");

        AlipayTradePayResponse payResponse = new AlipayTradePayResponse();

        try {
            Map<String, String> paraMap = getParameters(request);

            LogUtil.info(logger, "条码支付原始报文参数paraMap={0}", paraMap);

            AssertUtil.assertTrue(verify(paraMap), "验签不通过");

            PayRequest payRequest = buildPayRequest(paraMap);

            payResponse = tradeService.pay(payRequest);
        } catch (Exception e) {
            LogUtil.error(e, logger, "条码支付HTTP调用异常,Message={0}", e.getMessage());
        }

        String body = payResponse.getBody();

        String payResponseStr = ResponseUtil.buildResponse(body, ParamConstant.ALIPAY_TRADE_PAY_RESPONSE);

        LogUtil.info(logger, "条码支付HTTP调用结果,payResponseStr={0}", payResponseStr);

        return payResponseStr;
    }

    /**
     * 处理
     */

    /**
     * 处理扫码支付请求
     */
    @ResponseBody
    @RequestMapping(value = "/precreate", method = RequestMethod.POST)
    public String precreate(WebRequest request, ModelMap map) {

        LogUtil.info(logger, "收到扫码支付HTTP请求");

        AlipayTradePrecreateResponse precreateResponse = new AlipayTradePrecreateResponse();

        try {
            Map<String, String> paraMap = getParameters(request);

            LogUtil.info(logger, "扫码支付原始报文参数paraMap={0}", paraMap);

            AssertUtil.assertTrue(verify(paraMap), "验签不通过");

            PrecreateRequest precreateRequest = buildPrecreateRequest(paraMap);

            precreateResponse = tradeService.precreate(precreateRequest);
        } catch (Exception e) {
            LogUtil.error(e, logger, "扫码支付HTTP调用异常,Message={0}", e.getMessage());
        }

        String body = precreateResponse.getBody();

        String precreateResponseStr = ResponseUtil.buildResponse(body, ParamConstant.ALIPAY_TRADE_PRECREATE_RESPONSE);

        LogUtil.info(logger, "扫码支付HTTP调用结果,precreateResponseStr={0}", precreateResponseStr);

        return precreateResponseStr;
    }

    /**
     * 处理订单查询请求
     */
    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String query(WebRequest request, ModelMap map) {

        LogUtil.info(logger, "收到订单查询HTTP请求");

        AlipayTradeQueryResponse queryResponse = new AlipayTradeQueryResponse();

        try {
            Map<String, String> paraMap = getParameters(request);

            AssertUtil.assertTrue(verify(paraMap), "验签不通过");

            QueryRequest queryRequest = buildQueryRequest(paraMap);

            queryResponse = tradeService.query(queryRequest);
        } catch (Exception e) {
            LogUtil.error(e, logger, "订单查询HTTP调用异常,Message={0}", e.getMessage());
        }

        String body = queryResponse.getBody();

        String queryResponseStr = ResponseUtil.buildResponse(body, ParamConstant.ALIPAY_TRADE_QUERY_RESPONSE);

        LogUtil.info(logger, "订单查询HTTP调用结果,queryResponse={0}", queryResponseStr);

        return queryResponseStr;

    }

    /**
     * 处理订单退款请求
     */
    @ResponseBody
    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    public String refund(WebRequest request, ModelMap map) {

        LogUtil.info(logger, "收到退款HTTP请求");

        AlipayTradeRefundResponse refundResponse = null;

        try {
            Map<String, String> paraMap = getParameters(request);

            AssertUtil.assertTrue(verify(paraMap), "验签不通过");

            RefundRequest refundRequest = buildRefundRequest(paraMap);

            refundResponse = tradeService.refund(refundRequest);
        } catch (Exception e) {
            LogUtil.error(e, logger, "退款HTTP调用异常,Message={0}", e.getMessage());
        }

        String body = refundResponse.getBody();

        String refundResponseStr = ResponseUtil.buildResponse(body, ParamConstant.ALIPAY_TRADE_REFUND_RESPONSE);

        LogUtil.info(logger, "退款HTTP调用结果,refundResponse={0}", refundResponseStr);

        return refundResponseStr;

    }

    /**
     * 处理订单撤销请求
     */
    @ResponseBody
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public String cancel(WebRequest request, ModelMap map) {

        LogUtil.info(logger, "收到撤销HTTP请求");

        AlipayTradeCancelResponse cancelResponse = null;

        try {
            Map<String, String> paraMap = getParameters(request);

            AssertUtil.assertTrue(verify(paraMap), "验签不通过");

            CancelRequest cancelRequest = buildCancelRequest(paraMap);

            cancelResponse = tradeService.cancel(cancelRequest);
        } catch (Exception e) {
            LogUtil.error(e, logger, "撤销HTTP调用异常,Message={0}", e.getMessage());
        }

        String body = cancelResponse.getBody();

        String cancelRespStr = ResponseUtil.buildResponse(body, ParamConstant.ALIPAY_TRADE_CANCEL_RESPONSE);

        LogUtil.info(logger, "撤销HTTP调用结果,cancelRespStr={0}", cancelRespStr);

        return cancelRespStr;
    }

    /**
     * 创建撤销请求
     */
    private CancelRequest buildCancelRequest(Map<String, String> paraMap) {

        LogUtil.info(logger, "收到订单撤销报文转换请求");

        CancelRequest cancelRequest = new CancelRequest();

        String bizContent = paraMap.get(ParamConstant.BIZ_CONTENT);
        String acquirerId = paraMap.get(ACQUIRER_ID);

        //解析json字段
        Map<String, String> bizParaMap = JSON.parseObject(bizContent, new TypeReference<Map<String, String>>() {
        });

        cancelRequest.setAcquirerId(acquirerId);
        cancelRequest.setMerchantId(bizParaMap.get("merchant_id"));
        cancelRequest.setOutTradeNo(bizParaMap.get("out_trade_no"));
        cancelRequest.setAlipayTradeNo(bizParaMap.get("trade_no"));
        cancelRequest.setAppAuthToken(bizParaMap.get("app_auth_token"));

        LogUtil.info(logger, "订单撤销请求参数转换完成");

        return cancelRequest;
    }

    /**
     * 创建退款请求
     */
    private RefundRequest buildRefundRequest(Map<String, String> paraMap) {

        LogUtil.info(logger, "收到订单退款报文转换请求");

        RefundRequest refundRequest = new RefundRequest();

        String bizContent = paraMap.get(ParamConstant.BIZ_CONTENT);
        String acquirerId = paraMap.get(ACQUIRER_ID);

        Map<String, String> bizParaMap = JSON.parseObject(bizContent, new TypeReference<Map<String, String>>() {
        });

        refundRequest.setAcquirerId(acquirerId);
        refundRequest.setMerchantId(bizParaMap.get("merchant_id"));
        refundRequest.setOutTradeNo(bizParaMap.get("out_trade_no"));
        refundRequest.setAlipayTradeNo(bizParaMap.get("trade_no"));
        refundRequest.setRefundAmount(bizParaMap.get("refund_amount"));
        refundRequest.setRefundReason(bizParaMap.get("refund_reason"));
        refundRequest.setOutRequestNo(bizParaMap.get("out_request_no"));
        refundRequest.setStoreId(bizParaMap.get("store_id"));
        refundRequest.setTerminalId(bizParaMap.get("terminal_id"));

        LogUtil.info(logger, "订单退款请求参数转换完成");

        return refundRequest;
    }

    /**
     * 创建订单查询请求
     */
    private QueryRequest buildQueryRequest(Map<String, String> paraMap) {

        LogUtil.info(logger, "收到订单查询报文转换请求");

        QueryRequest queryRequest = new QueryRequest();

        String bizContent = paraMap.get(ParamConstant.BIZ_CONTENT);
        String acquirerId = paraMap.get(ACQUIRER_ID);

        //解析json字段
        Map<String, String> bizParaMap = JSON.parseObject(bizContent, new TypeReference<Map<String, String>>() {
        });

        queryRequest.setAcquirerId(acquirerId);
        queryRequest.setMerchantId(bizParaMap.get("merchant_id"));
        queryRequest.setOutTradeNo(bizParaMap.get("out_trade_no"));
        queryRequest.setAlipayTradeNo(bizParaMap.get("trade_no"));
        queryRequest.setAppAuthToken(bizParaMap.get("app_auth_token"));

        LogUtil.info(logger, "订单查询请求参数转换完成");

        return queryRequest;
    }

    /**
     * 创建扫码支付请求
     */
    private PrecreateRequest buildPrecreateRequest(Map<String, String> paraMap) {

        LogUtil.info(logger, "收到扫码支付报文转换请求");

        PrecreateRequest precreateRequest = new PrecreateRequest();

        String bizContent = paraMap.get(ParamConstant.BIZ_CONTENT);
        String acquirerId = paraMap.get(ACQUIRER_ID);
        String notifyUrl = paraMap.get(OUT_NOTIFY_URL);

        Map<String, String> bizParaMap = JSON.parseObject(bizContent, new TypeReference<Map<String, String>>() {
        });

        //设置公共参数
        setCommonPayRequestParas(precreateRequest, acquirerId, bizParaMap);

        //此处统一为SCAN_CODE
        precreateRequest.setScene(AlipaySceneEnum.SCAN_CODE.getCode());

        //结算中心通知商户地址
        precreateRequest.setOutNotifyUrl(notifyUrl);

        //支付宝通知结算中心地址
        precreateRequest.setNotifyUrl(ParamConstant.NOTIFY_URL);

        LogUtil.info(logger, "扫码支付请求参数转换完成");

        return precreateRequest;
    }

    /**
     * 创建条码支付请求
     */
    private PayRequest buildPayRequest(Map<String, String> paraMap) {

        LogUtil.info(logger, "收到条码支付报文转换请求");

        PayRequest payRequest = new PayRequest();

        String bizContent = paraMap.get(ParamConstant.BIZ_CONTENT);
        String acquirerId = paraMap.get(ACQUIRER_ID);

        //解析json字段
        Map<String, String> bizParaMap = JSON.parseObject(bizContent, new TypeReference<Map<String, String>>() {
        });

        //设置公共参数
        setCommonPayRequestParas(payRequest, acquirerId, bizParaMap);

        //此处统一为BAR_CODE
        payRequest.setScene(AlipaySceneEnum.BAR_CODE.getCode());

        payRequest.setAuthCode(bizParaMap.get("auth_code"));

        LogUtil.info(logger, "条码支付请求参数转换完成");

        return payRequest;
    }

    /**
     * 设置支付请求公共参数
     * @param request
     * @param acquirerId
     * @param bizParaMap
     */
    private void setCommonPayRequestParas(DefaultPayRequest request, String acquirerId, Map<String, String> bizParaMap) {

        request.setAcquirerId(acquirerId);
        request.setMerchantId(bizParaMap.get("merchant_id"));
        request.setSubMerchantId(request.getMerchantId());

        request.setOutTradeNo(bizParaMap.get("out_trade_no"));
        request.setSellerId(bizParaMap.get("seller_id"));
        request.setTotalAmount(bizParaMap.get("total_amount"));
        request.setDiscountableAmount(bizParaMap.get("discountable_amount"));
        request.setUndiscountableAmount(bizParaMap.get("undiscountable_amount"));
        request.setSubject(bizParaMap.get("subject"));
        request.setBody(bizParaMap.get("body"));
        request.setAppAuthToken(bizParaMap.get("app_auth_token"));

        //封装成List
        if (StringUtils.isNotBlank(bizParaMap.get("goods_detail"))) {
            request.setGoodsDetailList(parseGoodsDetailList(bizParaMap.get("goods_detail")));
        }

        request.setOperatorId(bizParaMap.get("operator_id"));
        request.setStoreId(bizParaMap.get("store_id"));
        request.setAlipayStoreId(bizParaMap.get("alipay_store_id"));
        request.setTerminalId(bizParaMap.get("terminal_id"));

        if (StringUtils.isNotBlank(bizParaMap.get("extend_params"))) {
            request.setExtendParams(parseExtendParams(bizParaMap.get("extend_params")));
        }

        request.setTimeoutExpress(bizParaMap.get("timeout_express"));
    }

    /**
     * 解析GoodsDetail
     */
    private List<GoodsDetail> parseGoodsDetailList(String goodsDetailListStr) {

        List<GoodsDetail> goodsDetails = new ArrayList<GoodsDetail>();

        List<Map<String, String>> listMap = JSON.parseObject(goodsDetailListStr, new TypeReference<List<Map<String, String>>>() {
        });

        for (int i = 0; i < listMap.size(); i++) {
            Map<String, String> goodsDetailMap = listMap.get(i);
            GoodsDetail goodDetail = new GoodsDetail();
            goodDetail.setAlipayGoodsId(goodsDetailMap.get("alipay_goods_id"));
            goodDetail.setGoodsCategory(goodsDetailMap.get("goods_category"));
            goodDetail.setGoodsId(goodsDetailMap.get("goods_id"));
            goodDetail.setGoodsName(goodsDetailMap.get("goods_name"));
            if (StringUtils.isNotBlank(goodsDetailMap.get("price"))) {
                goodDetail.setPrice(Long.parseLong(goodsDetailMap.get("price")));
            }
            if (StringUtils.isNotBlank(goodsDetailMap.get("quantity"))) {
                goodDetail.setQuantity(Double.parseDouble(goodsDetailMap.get("quantity")));
            }

            goodsDetails.add(goodDetail);
        }

        return goodsDetails;
    }

    /**
     * 解析ExtendParams
     */
    private ExtendParams parseExtendParams(String extendParamsStr) {
        Map<String, String> extendParamsMap = JSON.parseObject(extendParamsStr, new TypeReference<Map<String, String>>() {
        });
        ExtendParams extendParams = new ExtendParams();
        extendParams.setSysServiceProviderId(extendParamsMap.get("sys_service _provider_id"));

        return extendParams;
    }

}
