package org.tradecore.dao;

import java.sql.SQLException;
import java.util.Map;

import org.tradecore.dao.domain.BizAlipayPayOrder;

public interface BizAlipayPayOrderDAO {
    int deleteByPrimaryKey(String id);

    int insert(BizAlipayPayOrder record) throws SQLException;

    int insertSelective(BizAlipayPayOrder record) throws SQLException;

    BizAlipayPayOrder selectByPrimaryKey(String id) throws SQLException;

    int updateByPrimaryKeySelective(BizAlipayPayOrder record) throws SQLException;

    int updateByPrimaryKey(BizAlipayPayOrder record) throws SQLException;

    /**
     * 普通查询单条记录<br>
     * 注意：查询参数paramMap不能为空，否则将查询整张表数据<br>
     * paramMap可任意增加查询条件，但是需要在BizAlipayPayOrderMapper.xml中增加相应的查询条件判断
     * @param paramMap
     * @return
     */
    BizAlipayPayOrder selectOrder(Map<String, Object> paramMap) throws SQLException;

    /**
     * 根据订单号查询订单<br>
     * 由于订单号全局唯一，可唯一确定一笔订单记录
     * @param tradeNo
     * @return
     */
    BizAlipayPayOrder selectByTradeNo(String tradeNo) throws SQLException;

}