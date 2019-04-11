package com.aln.phonesaleschain.model.speaknotice;

import com.aln.phonesaleschain.customview.ItemVariable;
import com.aln.phonesaleschain.customview.MyVariable;

public class Schadule implements MyVariable {
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
