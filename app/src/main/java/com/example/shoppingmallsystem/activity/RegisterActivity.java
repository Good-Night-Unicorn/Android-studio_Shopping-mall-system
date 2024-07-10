package com.example.shoppingmallsystem.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.shoppingmallsystem.R;
import com.example.shoppingmallsystem.bean.Userinfo;
import com.example.shoppingmallsystem.util.MySQLiteHelper;
import com.example.shoppingmallsystem.util.ToastUtil;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private AlertDialog dialog;
    private EditText et_userName;
    private EditText et_password;
    private EditText et_nickName;
    private EditText et_phonNumb;
    private EditText et_schoolName;
    private EditText et_apartmentNumb;
    private Button btn_register;
    private Button btn_cancle;

    private String userName;
    private String password;
    private String nickName;
    private String phoneNumb;
    private String schoolName;
    private String apartmentNumb;

    private TextView tv_bar_title;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        setActionBar();
    }

    /*设置ActionBar*/
    private void setActionBar() {
        setSupportActionBar(toolbar);
        /*显示Home图标*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //设置不显示项目名称
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void initView() {
        et_userName = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_nickName = findViewById(R.id.et_nickName);
        et_phonNumb = findViewById(R.id.et_phoneNumb);
        et_schoolName = findViewById(R.id.et_schoolName);
        et_apartmentNumb = findViewById(R.id.et_apartmentNumb);
        btn_register = findViewById(R.id.btn_register);
        btn_cancle = findViewById(R.id.btn_cancle);

        toolbar = findViewById(R.id.toolbar);
        tv_bar_title = findViewById(R.id.tv_bar_title);
        tv_bar_title.setText("用户注册");

        btn_register.setOnClickListener(this);
        btn_cancle.setOnClickListener(this);

    }

    @Override
    //为toolbar设置返回按钮
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                userName = et_userName.getText().toString();
                password = et_password.getText().toString();
                nickName = et_nickName.getText().toString();
                phoneNumb = et_phonNumb.getText().toString();
                schoolName = et_schoolName.getText().toString();
                apartmentNumb = et_apartmentNumb.getText().toString();

                if (MySQLiteHelper.getInstance(this).queryNameisExist(userName)) {
                    ToastUtil.showShort("用户名已存在");
                    return;
                }
                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
                    ToastUtil.showShort("用户名或密码不能为空！");
                    return;
                }
                if (TextUtils.isEmpty(nickName)) {
                    ToastUtil.showShort("昵称不能为空！");
                    return;
                }
                if (TextUtils.isEmpty(phoneNumb)) {
                    ToastUtil.showShort("手机号码不能为空！");
                    return;
                }
                if (TextUtils.isEmpty(schoolName)) {
                    ToastUtil.showShort("学校名称不能为空");
                    return;
                }
                if (TextUtils.isEmpty(apartmentNumb)) {
                    ToastUtil.showShort("公寓楼号不能为空");
                    return;
                }

                final Userinfo userinfo = new Userinfo();
                userinfo.setUserName(userName);
                userinfo.setPassword(password);
                userinfo.setNickName(nickName);
                userinfo.setPhoneNumb(phoneNumb);
                userinfo.setSchoolName(schoolName);
                userinfo.setApartmentNumb(apartmentNumb);
                dialog = new AlertDialog.Builder(this).setTitle("是否确认注册？")
                        .setMessage("用户名：" + userName + '\n' + "密 码：" + password + '\n' + "昵 称：" + nickName + '\n' + "手机号：" + phoneNumb + '\n' + "学校名称：" + schoolName + '\n' + "公寓楼号：" + apartmentNumb)
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                DoInsert(userinfo);
                            }
                        })
                        .setNegativeButton("取消", null)
                        .create();
                dialog.show();
                break;
            case R.id.btn_cancle:
                RegisterActivity.this.finish();
                break;
        }
    }

    //注册成功执行方法，将对象存入sqllite
    public void DoInsert(Userinfo userinfo){
        MySQLiteHelper.getInstance(this).insertUserinfo(userinfo);
        ToastUtil.showShort("注册成功");
        RegisterActivity.this.finish();
    }

}