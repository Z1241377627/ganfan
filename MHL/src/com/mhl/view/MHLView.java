package com.mhl.view;

import com.mhl.daomain.Bill;
import com.mhl.daomain.DingTable;
import com.mhl.daomain.Employee;
import com.mhl.daomain.Menu;
import com.mhl.service.BillService;
import com.mhl.service.DingTableService;
import com.mhl.service.EmployeeService;
import com.mhl.service.MenuService;
import com.mhl.utils.Utility;

import java.util.List;


public class MHLView {
    private boolean loop = true;
    private String key = "";
    private EmployeeService employeeService = new EmployeeService();
    private DingTableService dingTableService = new DingTableService();
    private MenuService menuService = new MenuService();
    private BillService billService = new BillService();

    public static void main(String[] args) {
        new MHLView().mainMenu();
    }

    //主菜单
    public void mainMenu() {
        while (loop) {
            System.out.println("============满汉楼============");
            System.out.println("\t\t1 登录满汉楼");
            System.out.println("\t\t2 退出满汉楼");
            System.out.println("请输入你的选择：");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.println("请输入员工号:");
                    String empId = Utility.readString(50);
                    System.out.println("请输入密码:");
                    String pwd = Utility.readString(50);
                    Employee employee = employeeService.getEmployeeByAndPwd(empId, pwd);
                    if (employee != null) {
                        System.out.println("==========登录成功"+"["+employee.getName()+"]"+"==========");
                        while (loop) {
                            System.out.println("==========满汉楼二级菜单==========");
                            System.out.println("\t\t1 显示餐桌状态");
                            System.out.println("\t\t2 预定餐桌");
                            System.out.println("\t\t3 显示所有菜品");
                            System.out.println("\t\t4 点餐服务");
                            System.out.println("\t\t5 查看账单");
                            System.out.println("\t\t6 结账");
                            System.out.println("\t\t9 退出满汉楼");
                            System.out.println("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    listDingTable();
                                break;
                                case "2":
                                    orderDingTable();
                                    break;
                                case "3":
                                    listMenu();
                                    break;
                                case "4":
                                    orderMenu();
                                    break;
                                case "5":
                                    listBill();
                                    break;
                                case "6":
                                    payBill();
                                    break;
                                case "9":
                                    System.out.println("\t\t9 退出满汉楼");
                                    loop = false;
                                    break;
                            }
                        }
                    }else {
                        System.out.println("登录失败");
                    }
                    break;
                case "2":
                    System.out.println("\t\t9 退出满汉楼");
                    loop = false;
                    break;
            }
        }
    }

    //显示餐桌状态
    public void listDingTable(){
        System.out.println("餐桌编号\t\t餐桌状态");
        List<DingTable> list = dingTableService.list();
        for (DingTable dingTable : list){
            System.out.println(dingTable);
        }
        System.out.println("============显示完毕=============");
    }

    //完成订座
    public void orderDingTable(){
        System.out.println("============预定餐桌=============");
        System.out.println("请选择要预定的餐桌编号(-1退出):");
        int orderId = Utility.readInt();
        if (orderId == -1){
            System.out.println("============退出预定=============");
            return;
        }
        char c = Utility.readConfirmSelection();
        if (c != 'Y'){
            System.out.println("============退出预定=============");
            return;
        }
        DingTable dingTableById = dingTableService.getDingTableById(orderId);
        if (dingTableById == null){
            System.out.println("===========餐桌不存在============");
            return;
        }
        if (!(dingTableById.getState().equals("空"))){
            System.out.println("=======该餐桌已经预定或就餐中=======");
            return;
        }
        System.out.println("预定人的名字:");
        String orderName = Utility.readString(32);
        System.out.println("预定人的电话:");
        String orderTel = Utility.readString(32);
        if (dingTableService.orderDingTable(orderId, orderName, orderTel) ){
            System.out.println("============预定成功=============");
        }else {
            System.out.println("============预定失败=============");
        }

    }

    //显示菜品
    public void listMenu(){
        System.out.println("菜品编号\t菜品名\t\t类别\t\t价格");
        List<Menu> list = menuService.list();
        for (Menu menu : list){
            System.out.println(menu);
        }
    }

    //完成点餐
    public void orderMenu(){
        System.out.println("============点餐服务============");
        System.out.println("请选择点餐的桌号(-1退出):");
        int orderDingTableId = Utility.readInt();
        if(orderDingTableId == -1){
            System.out.println("============取消点餐============");
            return;
        }
        DingTable dingTableId = dingTableService.getDingTableById(orderDingTableId);
        if (dingTableId == null){
            System.out.println("===========餐桌不存在============");
            return;
        }
        if (!(dingTableId.getState().equals("空"))){
            System.out.println("=======该餐桌已经预定或就餐中=======");
            return;
        }
        System.out.println("请选择点餐的菜品号(-1退出):");
        int orderMenuId = Utility.readInt();
        if(orderMenuId == -1){
            System.out.println("============取消点餐============");
            return;
        }
        Menu menu = menuService.getMenu(orderMenuId);
        if (menu == null){
            System.out.println("===========菜品不存在============");
        }
        System.out.println("请选择点餐的菜品量(-1退出):");
        int orderNums = Utility.readInt();
        if(orderNums == -1){
            System.out.println("============取消点餐============");
            return;
        }
        if(billService.orderMenu(orderMenuId, orderNums, orderDingTableId)){
            System.out.println("============点餐成功============");
        }else {
            System.out.println("============点餐失败============");
        }
    }

    //显示账单
    public void listBill(){
        System.out.println("编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态");
        List<Bill> bills = billService.list();
        for (Bill bill : bills){
            System.out.println(bill);
        }
        System.out.println("============显示完毕============");
    }

    //结账
    public void payBill(){
        System.out.println("============结账服务============");
        System.out.println("请选择要结账的餐桌编号(-1退出):");
        int dingTableId = Utility.readInt();
        if(dingTableId == -1){
            System.out.println("============取消结账============");
            return;
        }
        DingTable dingTable = dingTableService.getDingTableById(dingTableId);
        if (dingTable == null){
            System.out.println("===========餐桌不存在============");
            return;
        }
        if (!(billService.hasPayBillDingTableId(dingTableId))){
            System.out.println("==========该餐桌没有未结账单==========");
            return;
        }
        System.out.println("结账方式(现金/支付宝/微信)回车表示退出:");
        String payMode = Utility.readString(20, "");
        if (payMode.equals("")){
            System.out.println("============取消结账============");
            return;
        }
        char key = Utility.readConfirmSelection();
        if (key == 'Y'){
            if (billService.payBill(dingTableId, payMode)){
                System.out.println("============完成结账============");
            }else {
                System.out.println("============结账失败============");
            }
        }
    }
}
