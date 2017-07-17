package com.webmyne.rentalapp.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.custom.TfButton;
import com.webmyne.rentalapp.custom.TfTextView;

public class ProfileActivity extends AppCompatActivity {

    private Context context;
    private ImageView imgUploadImage;
    private EditText edtName;
    private EditText edtEmail;
    private EditText edtMobile;
    private EditText edtPassword;
    private EditText edtAddress;
    private TfButton btnSubmit;
    boolean passwordPress = false;
    private Toolbar toolbar;
    private TfTextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        context = this;
        init();
    }

    private void init() {
        btnSubmit = (TfButton) findViewById(R.id.btnSubmit);
        edtAddress = (EditText) findViewById(R.id.edtAddress);
        // edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtMobile = (EditText) findViewById(R.id.edtMobile);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtName = (EditText) findViewById(R.id.edtName);
        imgUploadImage = (ImageView) findViewById(R.id.imgUploadImage);

        clickListener();

        Glide.with(context).load(R.drawable.man).asBitmap().centerCrop().into(new BitmapImageViewTarget(imgUploadImage) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imgUploadImage.setImageDrawable(circularBitmapDrawable);
            }
        });
        initToolbar();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TfTextView) toolbar.findViewById(R.id.txtTitle);
        toolbar.setTitle("");

        txtTitle.setText(R.string.personal_information);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.password:
                createDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    private void createDialog() {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_dialog);
        dialog.setCancelable(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(lp);

        MaterialEditText edtOldPassword, edtNewPassword, edtConformPassword;
        TfButton btnCancel, btnSave;

        edtOldPassword = (MaterialEditText) dialog.findViewById(R.id.edtOldPassword);
        edtNewPassword = (MaterialEditText) dialog.findViewById(R.id.edtNewPassword);
        edtConformPassword = (MaterialEditText) dialog.findViewById(R.id.edtConformPassword);
        btnSave = (TfButton) dialog.findViewById(R.id.btnSave);
        btnCancel = (TfButton) dialog.findViewById(R.id.btnCancel);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void clickListener() {

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
