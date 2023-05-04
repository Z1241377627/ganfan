package com.mhl.service;

import com.mhl.dao.DingTableDAO;
import com.mhl.daomain.DingTable;

import java.util.List;

public class DingTableService {
    private DingTableDAO dingTableDAO = new DingTableDAO();

    //查询餐桌状态
    public List<DingTable> list() {
        return dingTableDAO.queryMulti("select id,state from dingTable", DingTable.class);
    }

    //根据id查餐桌是否存在
    public DingTable getDingTableById(int id) {
        return dingTableDAO.querySingle("select * from dingTable where id=?", DingTable.class, id);
    }

    //预定餐桌
    public boolean orderDingTable(int id, String orderName, String orderTel) {
        int update = dingTableDAO.update("update dingTable set state='已经预定', orderName=?, orderTel=? where id=?", orderName, orderTel, id);
        return update > 0;
    }

    //更新餐桌状态
    public boolean updateDingTableState(int id, String state) {
        int update = dingTableDAO.update("update dingTable set state=? where id=?", state, id);
        return update > 0;
    }

    //餐桌设空
    public boolean updateDingTablesToFree(int id, String state) {
        int update = dingTableDAO.update("update dingTable set state=?,orderName='',orderTel='' where id=?", state, id);
        return update > 0;
    }
}
