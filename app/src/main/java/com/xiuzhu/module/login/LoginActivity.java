package com.xiuzhu.module.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sd.core.base.BaseActivity;
import com.xiuzhu.module.main.MainActivity;
import com.xiuzhu.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by youdeyi on 2016/10/17.
 */

public class LoginActivity extends BaseActivity implements ILoginView {

    @BindView(R.id.btn_login1)
    Button mLoginBtn1;

    @BindView(R.id.btn_login2)
    Button mLoginBtn2;

    @BindView(R.id.txt_login_password_name)
    TextView mPasswordText;

    @BindView(R.id.txt_login_user_name)
    TextView mUserNameText;

    @BindView(R.id.progressbar_login)
    ProgressBar mLoginProgressBar;

    private LoginPresenter mLoginPresenter;

    private int mode = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLoginBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode = 1;
                attemptLogin();
            }
        });
        mLoginBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode = 2;
                attemptLogin();
            }
        });
        mLoginPresenter = new LoginPresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLoginPresenter != null) {
            mLoginPresenter.detachView();
        }
    }

    @Override
    public void attemptLogin() {
        String userName = mUserNameText.getText().toString();
        String password = mPasswordText.getText().toString();

        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(this, "user name is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "password is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        mLoginPresenter.loginToServer(userName, password, mode);
    }

    @Override
    public void loginSuc() {
        Toast.makeText(LoginActivity.this, "Login success", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showErrorInfo(int code, String devMsg, String friendlyMsg) {
        Toast.makeText(LoginActivity.this, "Login fail:" + friendlyMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            mLoginProgressBar.setVisibility(View.VISIBLE);
        } else {
            mLoginProgressBar.setVisibility(View.GONE);
        }
    }
}
