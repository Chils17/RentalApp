package com.webmyne.rentalapp.ui;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.TfTextView;

public class MembershipActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TfTextView txtTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        init();
    }

    private void init() {

        initToolbar();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TfTextView) toolbar.findViewById(R.id.txtTitle);
        toolbar.setTitle("");

        txtTitle.setText(R.string.member_ship);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
