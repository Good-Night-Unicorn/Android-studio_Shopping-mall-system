package com.example.shoppingmallsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.shoppingmallsystem.MainActivity;
import com.example.shoppingmallsystem.R;
import com.example.shoppingmallsystem.bean.Userinfo;
import com.example.shoppingmallsystem.util.MySQLiteHelper;
import java.text.DecimalFormat;

/**
 *  我的钱包activity
 */
public class MyAccountActivity extends AppCompatActivity {

    private TextView tv_bar_title;
    private Toolbar toolbar;
    private TextView tv_recharge;
    private TextView tv_userName;
    private TextView tv_money;
    private TextView tv_phoneNumb;
    private TextView tv_schoolName;
    private TextView tv_apartmentNumb;
    private ImageView iv_personal_pic;
    private Userinfo userinfo;
    private double newMoney;
    private int myUserID;
    private DecimalFormat df;
    private String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        initData();
        initView();
        setActionBar();
    }


    /**设置ActionBar**/
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

    private void initData() {
        //从数据库获取userId和user信息
        userinfo = MySQLiteHelper.getInstance(getApplicationContext()).getUserInfoFromUserName(MainActivity.username);
        myUserID = MySQLiteHelper.getInstance(getApplicationContext()).GetUserId(MainActivity.username);
    }


    private void initView() {
        //初始化控件
        toolbar = findViewById(R.id.toolbar);
        tv_bar_title = findViewById(R.id.tv_bar_title);
        tv_bar_title.setText("我的钱包");
        tv_recharge = findViewById(R.id.tv_bar_function);
        tv_recharge.setVisibility(View.VISIBLE);
        tv_userName = findViewById(R.id.tv_username_acc);
        tv_money = findViewById(R.id.tv_money);
        tv_phoneNumb = findViewById(R.id.tv_phoneNumb_acc);
        tv_schoolName = findViewById(R.id.tv_schoolName_acc);
        tv_apartmentNumb = findViewById(R.id.tv_apartmentNumb_acc);
        iv_personal_pic = findViewById(R.id.iv_personal_pic);

        tv_userName.setText(userinfo.getUserName());
        //不使用科学计数法显示double类型数据，解决显示错误问题
        df = new DecimalFormat("0.00");
        result = df.format(userinfo.getMoney());
        tv_money.setText(result+"元");
        tv_phoneNumb.setText(userinfo.getPhoneNumb());
        tv_schoolName.setText(userinfo.getSchoolName());
        tv_apartmentNumb.setText(userinfo.getApartmentNumb());

        switch (myUserID){
            case 1:
                iv_personal_pic.setImageResource(R.drawable.tx_1_48);
                break;
            case 2:
                iv_personal_pic.setImageResource(R.drawable.tx_2_48);
                break;
            case 3:
                iv_personal_pic.setImageResource(R.drawable.tx_3_48);
                break;
            case 4:
                iv_personal_pic.setImageResource(R.drawable.tx_4_48);
                break;
            case 5:
                iv_personal_pic.setImageResource(R.drawable.tx_5_48);
                break;
            case 6:
                iv_personal_pic.setImageResource(R.drawable.tx_6_48);
                break;
        }

        /**充值的点击事件 */
        tv_recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivityForResult(new Intent(MyAccountActivity.this,RechargeActivity.class),0);
            }
        });


    }

    /**
     *充值完成后，回到我的钱包界面时刷新金额数据
     */
    private void refreshMoney(){
        newMoney = MySQLiteHelper.getInstance(getApplicationContext()).getUserMoneyFromUserName(MainActivity.username);
        //不使用科学计数法显示double类型数据，解决显示错误问题
        df = new DecimalFormat("0.00");
        result = df.format(newMoney);
        tv_money.setText(result +"元");
    }

    /**
     * 接受跳转的返回值并进行操作
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1){
            refreshMoney();
        }else {
            return;
        }
    }
}