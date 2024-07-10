package com.example.shoppingmallsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shoppingmallsystem.activity.HomeAllStoresActivity;
import com.example.shoppingmallsystem.activity.RegisterActivity;
import com.example.shoppingmallsystem.bean.Userinfo;
import com.example.shoppingmallsystem.util.MySQLiteHelper;
import com.example.shoppingmallsystem.util.ShareUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_password;
    private EditText et_username;
    private Button btn_login;
    private Button btn_register;
    public static String username;
    private String password;
    private CheckBox rember;
    private CheckBox autologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        et_password = (EditText) findViewById(R.id.et_password);
        et_username = (EditText) findViewById(R.id.et_username);
        btn_login = (Button)findViewById(R.id.M_login);
        btn_register = (Button)findViewById(R.id.M_register);
        rember = (CheckBox) findViewById(R.id.remenberpw);
        autologin = (CheckBox)findViewById(R.id.autologin);

        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);

        //清除表中所有数据
        //   MySQLiteHelper.getInstance(this).deleateAllUserInfo();

        //打印所有用户名和密码记录信息
        List<Userinfo> userinfoList = MySQLiteHelper.getInstance(this).queryAlluserInfo();
        //Log.e("userinfoList", userinfoList.toString());


        if (ShareUtils.getRember().equals("1")) {
            rember.setChecked(true);
            et_username.setText(ShareUtils.getUserName());
            et_password.setText(ShareUtils.getPassword());
        }else {
            rember.setChecked(false);
        }


        if (ShareUtils.getAuto_Login().equals("1")) {
            autologin.setChecked(true);
            if (TextUtils.isEmpty(et_username.getText()) || TextUtils.isEmpty(et_password.getText())) {
                Toast.makeText(this, "用户名密码为空", Toast.LENGTH_SHORT).show();
            } else {
                //登陆成功进入的页面
                startActivity(new Intent(this, HomeAllStoresActivity.class));
                username = ShareUtils.getUserName();
                this.finish();
            }
        }else {
            autologin.setChecked(false);
        }



        rember.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (rember.isChecked()){
                    //System.out.println("记住密码已被选中");
                    ShareUtils.putRember("1");
                }else {
                    //System.out.println("记住密码没有被选中");
                    ShareUtils.putRember("0");
                }
            }

        });


        autologin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (autologin.isChecked()){
                    //System.out.println("自动登录被选中");
                    ShareUtils.putAuto_Login("1");
                }else {
                    //System.out.println("自动登录没有被选中");
                    ShareUtils.putAuto_Login("0");
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.M_login:
                username = et_username.getText().toString();
                password = et_password.getText().toString();
                //            Log.e("password   " ,password);
                //            Log.e("username   " ,username);
                if (TextUtils.isEmpty(username)  || TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (MySQLiteHelper.getInstance(this).queryUseristrue(username,password)){
                    if (rember.isChecked()){
                        ShareUtils.putUserName(username);
                        ShareUtils.putPassword(password);
                    }
                    Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, HomeAllStoresActivity.class));
                    MainActivity.this.finish();
                }else {
                    Toast.makeText(MainActivity.this, "登录失败,用户名或密码错误", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            case R.id.M_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }

    }

}