package com.example.shoppingmallsystem.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.shoppingmallsystem.MainActivity;
import com.example.shoppingmallsystem.R;
import com.example.shoppingmallsystem.bean.Userinfo;
import com.example.shoppingmallsystem.util.MySQLiteHelper;
import com.example.shoppingmallsystem.util.ToastUtil;


/**
 * 个人中心界面activity
 */
public class PersonalCenterActivity extends AppCompatActivity {

    private TextView tv_userName;
    private EditText et_nickName;
    private EditText et_phonNumb;
    private EditText et_schoolName;
    private EditText et_apartmentNumb;
    private Button btn_alter;
    private Button btn_cancle;

    private String nickName;
    private String phoneNumb;
    private String schoolName;
    private String apartmentNumb;

    private TextView tv_bar_title;
    private Toolbar toolbar;

    private Userinfo userinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);
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

    private void initView() {
        tv_userName = findViewById(R.id.tv_username);
        et_nickName = findViewById(R.id.et_nickName_per);
        et_phonNumb = findViewById(R.id.et_phoneNumb_per);
        et_schoolName = findViewById(R.id.et_schoolName_per);
        et_apartmentNumb = findViewById(R.id.et_apartmentNumb_per);
        btn_alter = findViewById(R.id.btn_alter);
        btn_cancle = findViewById(R.id.btn_cancle_per);

        toolbar = findViewById(R.id.toolbar);
        tv_bar_title = findViewById(R.id.tv_bar_title);
        tv_bar_title.setText("个人信息");


        //获取用户信息数据
        userinfo = MySQLiteHelper.getInstance(getApplicationContext()).getUserInfoFromUserName(MainActivity.username);

        tv_userName.setText(userinfo.getUserName());
        et_nickName.setText(userinfo.getNickName());
        et_phonNumb.setText(userinfo.getPhoneNumb());
        et_schoolName.setText(userinfo.getSchoolName());
        et_apartmentNumb.setText(userinfo.getApartmentNumb());

        btn_alter.setOnClickListener(new View.OnClickListener() {

            private Userinfo userinfo1;

            @Override
            public void onClick(View view) {
                nickName = et_nickName.getText().toString();
                phoneNumb = et_phonNumb.getText().toString();
                schoolName = et_schoolName.getText().toString();
                apartmentNumb = et_apartmentNumb.getText().toString();

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

                userinfo1 = new Userinfo();
                userinfo1.setUserName(MainActivity.username);
                userinfo1.setNickName(nickName);
                userinfo1.setPassword(userinfo.getPassword());
                userinfo1.setPhoneNumb(phoneNumb);
                userinfo1.setSchoolName(schoolName);
                userinfo1.setApartmentNumb(apartmentNumb);
                //Log.e("修改后的信息",userinfo1.toString());
                //在数据库中修改相关信息
                MySQLiteHelper.getInstance(getBaseContext()).updateUserInfo(userinfo1);
                ToastUtil.showShort("信息更新成功");
            }
        });

        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersonalCenterActivity.this.finish();
            }
        });
    }
}