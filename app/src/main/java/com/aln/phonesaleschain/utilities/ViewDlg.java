package com.aln.phonesaleschain.utilities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.customview.ItemImageText;
import com.aln.phonesaleschain.screen.Presentation.PresentActivity;
import com.aln.phonesaleschain.screen.homepage.HomePage;
import com.aln.phonesaleschain.screen.main.ListItem;

public class ViewDlg implements View.OnClickListener {
    Dialog dialog;
    ItemImageText productbtn, newsbtn, acountbtn, chatbtn, noticebtn, branchbtn;
    Context ctx;

    public void showMenuDlg(Activity activity) {
        dialog = new Dialog(activity);
        ctx = activity;
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.menu_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        setup(dialog);
        dialog.show();
    }

    private void setup(Dialog dialog) {

        productbtn = new ItemImageText(dialog, R.id.product, this);
        newsbtn = new ItemImageText(dialog, R.id.news, this);
        acountbtn = new ItemImageText(dialog, R.id.account, this);
        chatbtn = new ItemImageText(dialog, R.id.chat, this);
        noticebtn = new ItemImageText(dialog, R.id.notice, this);
        branchbtn = new ItemImageText(dialog, R.id.branchs, this);

        productbtn.setIdDrawerable(R.drawable.ic_tablet);
        productbtn.setLabel(R.string.products_menu);
        newsbtn.setIdDrawerable(R.drawable.ic_newspaper);
        newsbtn.setLabel(R.string.news_menu);
        acountbtn.setIdDrawerable(R.drawable.ic_users);
        acountbtn.setLabel(R.string.account_menu);
        chatbtn.setIdDrawerable(R.drawable.ic_chat);
        chatbtn.setLabel(R.string.chat_menu);
        noticebtn.setIdDrawerable(R.drawable.ic_director);
        noticebtn.setLabel(R.string.notice_menu);
        branchbtn.setIdDrawerable(R.drawable.ic_family_tree);
        branchbtn.setLabel(R.string.branch_menu);

    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()) {
            case R.id.product:
                it = new Intent(ctx, ListItem.class);
                it.putExtra(Constants.KEY_SCREEN, "prod");
                it.putExtra(Constants.KEY_Label_Screen, ctx.getResources().getString(R.string.products_menu));

                break;
            case R.id.notice:
                it = new Intent(ctx, ListItem.class);
                it.putExtra(Constants.KEY_SCREEN, "notic");
                it.putExtra(Constants.KEY_Label_Screen, ctx.getResources().getString(R.string.notice_menu));

                break;

            case R.id.news:
                it = new Intent(ctx, ListItem.class);
                it.putExtra(Constants.KEY_SCREEN, "news");
                it.putExtra(Constants.KEY_Label_Screen, ctx.getResources().getString(R.string.news_menu));

                break;
            case R.id.branchs:
                it = new Intent(ctx, ListItem.class);
                it.putExtra(Constants.KEY_SCREEN, "branch");

                break;
            case R.id.account:
                it = new Intent(ctx, ListItem.class);
                it.putExtra(Constants.KEY_SCREEN, "acco");
                it.putExtra(Constants.KEY_Label_Screen, ctx.getResources().getString(R.string.account_menu));

                break;

//            case R.id.chat:
//                it = new Intent(ctx, ListItem.class);
//                it.putExtra(Constants.KEY_SCREEN, "chat");
//                ctx.startActivity(it);
//                break;

        }

        if (it.getStringExtra(Constants.KEY_SCREEN) != null)
            ctx.startActivity(it);
        dialog.dismiss();
    }
}