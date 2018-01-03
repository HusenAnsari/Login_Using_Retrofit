package com.example.gulamhusen.loginretro.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.gulamhusen.loginretro.R;
import com.example.gulamhusen.loginretro.api.model.User;
import com.example.gulamhusen.loginretro.helper.ProgressBarHelper;
import com.example.gulamhusen.loginretro.helper.SessionManager;

/**
 * Created by gulamhusen on 11-04-2017.
 */

public class ProfileActivity extends AppCompatActivity {
    User user;
    ImageView imgPic;
    TextView uname, uemail, umobile;

    ProgressBarHelper progressBarHelper;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        init();
    }

    private void init() {

        // user = new User();

        context = this;

        imgPic = (ImageView) findViewById(R.id.imageUser);
        uname = (TextView) findViewById(R.id.txtname);
        uemail = (TextView) findViewById(R.id.txtemail);
        umobile = (TextView) findViewById(R.id.txtmobile);

//        Intent i = getIntent();
//        user = (User) i.getSerializableExtra("USER");

        user = new SessionManager(context).getUserData();

        uname.setText(user.getName());
        uemail.setText(user.getEmail());
        umobile.setText(user.getMobile());
        //  name = user.getName();
        //  email = user.getEmail();
        //  phone = user.getMobile();

       /* Glide.with(ProfileActivity.this).load(user.getImagePath())
                .placeholder(R.mipmap.ic_launcher).into(imgPic);*/

        Glide.with(context).load(user.getImagePath()).asBitmap().centerCrop().into(new BitmapImageViewTarget(imgPic) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imgPic.setImageDrawable(circularBitmapDrawable);
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
            case R.id.logout:

                new SessionManager(context).logOut();
                Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
