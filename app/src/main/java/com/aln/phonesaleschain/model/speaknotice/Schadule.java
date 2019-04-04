package com.aln.phonesaleschain.model.speaknotice;

import com.aln.phonesaleschain.customview.ItemVariable;

public class Schadule extends ItemVariable {
    public String SchaduleId;
    public String FromUser;
    public String ToUser;
    public String ContentMsg;
    public String CreateOn;
    public String DateOnSchadule;
    public String SchaduleName;

    @Override
    public String getIdItem() {
        return SchaduleId;
    }

    @Override
    public String getLabel() {
        return SchaduleName;
    }

    @Override
    public String getIdDrawer() {
        return null;
    }
}
