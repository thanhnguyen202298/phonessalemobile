package com.aln.phonesaleschain.model.order;

import com.aln.phonesaleschain.model.UserInfo;

import java.util.HashMap;
import java.util.List;

public class OrderMaster {

    public String OrderCode;
    public String OrderType;
    public String PostMan;
    public String Promotion;
    public int Ranking;
    public String ShipTime;
    public String ShopCode;
    public String ShopName;
    public String ShopPhone;
    public String StatusTime;
    public String UserCode;
    public String UserName;
    public String AddressTo;
    public double Amount;
    public String BookTime;
    public String CreateOn;
    public String ModifyBy;
    public String ModifyOn;
    public String TypeName;
    public String NameState;
    //
    public List<OrderDetail> detailslist;

    public OrderMaster() {
    }

    public String getAmount() {
        return Amount + "";
    }

    public void setDonHangChiTiets(HashMap<Integer, OrderDetail> deetailist) {

        for (Integer i : deetailist.keySet()) {
            detailslist.add(deetailist.get(i));
        }
    }
}
