package com.mhl.service;

import com.mhl.dao.BasicDAO;
import com.mhl.dao.BillDAO;
import com.mhl.daomain.Bill;

import java.util.List;
import java.util.UUID;

public class BillService {
    private BillDAO billDAO = new BillDAO();
    private MenuService menuService = new MenuService();
    private DingTableService dingTableService = new DingTableService();

    public boolean orderMenu(int menuId, int nums, int dingTableId) {
        String billId = UUID.randomUUID().toString();
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?, now(), '未结账')",
                 billId, menuId, nums, (menuService.getMenuById(menuId) * nums), dingTableId);
        if (update <= 0){
            return false;
        }
        return dingTableService.updateDingTableState(dingTableId, "就餐中");
    }

    //显示账单
    public List<Bill> list(){
        return billDAO.queryMulti("select * from bill", Bill.class);
    }

    //是否有未结账账单
    public boolean hasPayBillDingTableId(int dingTableId){
        Bill bill = billDAO.querySingle("select * from bill where dingTableId=? and state='未结账' LIMIT 0, 1", Bill.class, dingTableId);
        return bill != null;
    }

    //结账
    public boolean payBill(int dingTableId, String payMode){
        int update = billDAO.update("update bill set state=? where dingTableId=? and state='未结账'", payMode, dingTableId);
        if (update <= 0){
            return false;
        }
        if (!(dingTableService.updateDingTablesToFree(dingTableId,"空"))){
            return false;
        }
        return true;
    }
}
