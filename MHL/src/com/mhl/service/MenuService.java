package com.mhl.service;

import com.mhl.dao.MenuDAO;
import com.mhl.daomain.Menu;

import java.util.List;

public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();

    public List<Menu> list(){
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }

    //价格
    public double getMenuById(int menuId){
        Menu menu = menuDAO.querySingle("select * from menu where id=?", Menu.class, menuId);
        return menu.getPrice();
    }

    public Menu getMenu(int menuId){
        return menuDAO.querySingle("select * from menu where id=?", Menu.class, menuId);
    }
}
