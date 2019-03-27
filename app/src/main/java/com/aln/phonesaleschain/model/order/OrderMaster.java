package com.aln.phonesaleschain.model.order;

import com.aln.phonesaleschain.model.UserInfo;

import java.util.HashMap;
import java.util.List;

public class OrderMaster {
    public String orderCode;
    public String userCode;
    public String timeBook;
    public String timeStatus;
    public String timeShip;

    public double amount;
    public String status;
    public int ranking;
    public String requestType;//ghi chú
    public UserInfo user;
    public String shopName;
    public String shopId;
    public String shopPhone;

    public String postMan;
    public boolean syncPostMan;

    public boolean synchronizedUser;
    public boolean synchronizedShop;
    public String addresShip;
    //
    public List<OrderDetail> detailslist;

    public OrderMaster() {
    }

    public String getAmount() {
        return amount + "";
    }

    public void setDonHangChiTiets(HashMap<Integer, OrderDetail> deetailist) {

        for (Integer i : deetailist.keySet()
                ) {
            detailslist.add(deetailist.get(i));
        }
    }
}
