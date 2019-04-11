package com.aln.phonesaleschain.model.product;

import java.util.ArrayList;
import java.util.List;

public class MyListItem<T> {
    public List<T> list;
    public boolean select;

    public MyListItem() {
        this.list = new ArrayList<>();
    }
}
