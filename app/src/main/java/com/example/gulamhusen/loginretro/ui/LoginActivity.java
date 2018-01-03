package com.example.gulamhusen.loginretro.ui;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gulamhusen.loginretro.R;
import com.example.gulamhusen.loginretro.api.ApiInterface;
import com.example.gulamhusen.loginretro.api.model.LoginRequest;
import com.example.gulamhusen.loginretro.api.model.LoginResponce;
import com.example.gulamhusen.loginretro.api.model.User;
import com.example.gulamhusen.loginretro.helper.AppConstants;
import com.example.gulamhusen.loginretro.helper.Function;
import com.example.gulamhusen.loginretro.helper.MyApplication;
import com.example.gulamhusen.loginretro.helper.ProgressBarHelper;
import com.example.gulamhusen.loginretro.helper.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class LoginActivity extends AppCompatActivity {

    EditText mobile, password;
    String mob, pass;
    TextView login;
    boolean passwordPress = false;
    LoginRequest loginRequest;
    Context context;
    public String fixMobile = "9601158411";
    public String fixPassword = "123456";
    ProgressBarHelper progressBarHelper;
    private SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        actionListener();

    }

    private void actionListener() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidation();
            }

        });


        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (password.getRight() - password.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {

                        if (passwordPress) {
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            password.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(LoginActivity.this, R.drawable.key), null, ContextCompat.getDrawable(LoginActivity.this, R.drawable.eye), null);
                            passwordPress = false;
                        } else {
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            password.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(LoginActivity.this, R.drawable.key), null, ContextCompat.getDrawable(LoginActivity.this, R.drawable.eye_off), null);
                            passwordPress = true;
                        }

                        return true;
                    }
                }

                return false;
            }
        });
    }

    private void init() {
        context = this;

        session = new SessionManager(context);

        if (session.isUserLogIn()) {
            startActivity(new Intent(context, ProfileActivity.class));
            finish();
        }

        progressBarHelper = new ProgressBarHelper(context, false);
        mobile = (EditText) findViewById(R.id.etMobile);
        password = (EditText) findViewById(R.id.etPassword);
        login = (TextView) findViewById(R.id.login);


    }

    private void checkValidation() {

        mob = mobile.getText().toString().trim();
        pass = password.getText().toString().trim();

        if (TextUtils.isEmpty(mob)) {
            Function.showToast(context, "Enter Mobile Number");
            return;
        }
        if (Function.toLength(mob) != 10) {
            Function.showToast(context, "Check Mobile number");
        }

        if (TextUtils.isEmpty(pass)) {
            Function.showToast(context, "Enter Password");
            return;
        }

        loginRequest = new LoginRequest();
        loginRequest.setMobile(mob);
        loginRequest.setPassword(pass);
        loginRequest.setDeviceId(Function.getMobileId(context));
        loginRequest.setGCMToken("");
        loginRequest.setIsRegister(0);
        loginRequest.setMobileOS("A");

        if (Function.isConnected(context)) {
            callApi();
        } else {
            Function.showToast(context, getString(R.string.internet_error));
        }


    }

    private void callApi() {
        progressBarHelper.showProgressDialog();
        ApiInterface api = MyApplication.getRetrofit().create(ApiInterface.class);
        api.get_Login(loginRequest).enqueue(new Callback<LoginResponce>() {
            @Override
            public void onResponse(Call<LoginResponce> call, Response<LoginResponce> response) {
                progressBarHelper.hideProgressDialog();
                LoginResponce loginResponce = response.body();
                if (loginResponce.getResponseCode() == AppConstants.ON_SUCCESS) {
                    User user = loginResponce.getData();
                    Log.e("res", Function.getJsonToStr(loginResponce));
                    Log.e("user", Function.getJsonToStr(user));

                    session.setUserLogin();
                    session.setUserData(response.body().getData());

                    Intent i = new Intent(context, ProfileActivity.class);
                    i.putExtra("USER", user);
                    startActivity(i);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<LoginResponce> call, Throwable t) {
                progressBarHelper.hideProgressDialog();
            }
        });
    }
}
