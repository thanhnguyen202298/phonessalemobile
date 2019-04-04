package com.aln.phonesaleschain.model.speaknotice;

import com.aln.phonesaleschain.customview.ItemVariable;

public class SpeakInform extends ItemVariable {
    //chatcontent
    public String ChatId;
    //informspeakContent
    public String NoticeId;
    public String FromUser;
    public String ToUser;
    public String ContentMsg;
    public String FileMsg;
    public String CreateOn;
    public String ImageUrl;
    public String NoticeName;

    @Override
    public String getIdItem() {
        if (ChatId != null)
            return ChatId;
        else return NoticeId;
    }

    @Override
    public String getLabel() {
        return NoticeName;
    }

    @Override
    public String getIdDrawer() {
        return ImageUrl;
    }
}
