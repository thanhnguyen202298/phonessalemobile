package com.aln.phonesaleschain.screen.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.customview.ItemImageText;
import com.aln.phonesaleschain.screen.Presentation.PresentActivity;
import com.aln.phonesaleschain.screen.fragment_itemlist.ProductActivity;
import com.aln.phonesaleschain.screen.homepage.HomePage;
import com.aln.phonesaleschain.utilities.Constants;
import com.aln.phonesaleschain.utilities.ViewDlg;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ItemImageText mitem1, mitem2, mitem3, mitem4;
    ImageView circleig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup toolbar
        android.support.v7.widget.Toolbar t = findViewById(R.id.actionBar);
        TextView label = t.findViewById(R.id.labelToolbar);
        label.setText(R.string.app_name);
        label.setVisibility(View.VISIBLE);

        setupMenuMain();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    void setupMenuMain() {
        //setup menu
        try {
            mitem1 = new ItemImageText(this, R.id.menuitem1, this);
            mitem2 = new ItemImageText(this, R.id.menuitem2, this);
            mitem3 = new ItemImageText(this, R.id.menuitem3, this);
            mitem4 = new ItemImageText(this, R.id.menuitem4, this);

            mitem1.setIdDrawerable(R.drawable.ic_006_home_insurance);
            mitem1.setLabel(getString(R.string.present_label));

            mitem2.setIdDrawerable(R.drawable.ic_022_gift_box);
            mitem2.setLabel(getString(R.string.promotion_label));

            mitem3.setIdDrawerable(R.drawable.ic_home);
            mitem3.setLabel(getString(R.string.home_Label));

            mitem4.setIdDrawerable(R.drawable.ic_alarm_clock);
            mitem4.setLabel(getString(R.string.schadule_Label));

            circleig = findViewById(R.id.menuitemcenter);
            circleig.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ViewDlg m = new ViewDlg();
                    m.showMenuDlg(MainActivity.this);
                }
            });
        } catch (IllegalArgumentException iae) {
            Toast.makeText(this, iae.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()) {
            case R.id.menuitem1:
                it = new Intent(this, PresentActivity.class);
                startActivity(it);
                break;

            case R.id.menuitem2:
                it = new Intent(this, ListItem.class);
                it.putExtra(Constants.KEY_SCREEN, "prom");
                startActivity(it);
                break;

            case R.id.menuitem4:
                it = new Intent(this, ListItem.class);
                it.putExtra(Constants.KEY_SCREEN, "scha");
                startActivity(it);
                break;

            case R.id.menuitem3:
                it = new Intent(this, HomePage.class);
                startActivity(it);
                break;

        }

    }
}
