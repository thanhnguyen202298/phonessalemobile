package com.aln.phonesaleschain.model;

import com.aln.phonesaleschain.model.speaknotice.SpeakInform;

public class ChatIt extends SpeakInform {
    private boolean isChat = true;
    public String Replying;
    public String getReplying() {
        return Replying;
    }

    @Override
    public String getLabel() {
        return super.getLabel();
    }
}
