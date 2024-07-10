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

import com.example.shoppingmallsystem.MainActivity;
import com.example.shoppingmallsystem.R;
import com.example.shoppingmallsystem.util.MySQLiteHelper;
import com.example.shoppingmallsystem.util.ToastUtil;


/**
 * 充值界面的activity
 */
public class RechargeActivity extends AppCompatActivity {

    private TextView tv_bar_title;
    private Toolbar toolbar;
    private EditText et_rechargeMoney;
    private Button btn_doRecharge;
    private String money1;
    private double currentAccountMoney;
    private AlertDialog dialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
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
            setResult(1);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        //获取当前账户的金额
        currentAccountMoney = MySQLiteHelper.getInstance(getApplicationContext()).getUserMoneyFromUserName(MainActivity.username);

        toolbar = findViewById(R.id.toolbar);
        tv_bar_title = findViewById(R.id.tv_bar_title);
        tv_bar_title.setText("充值");
        et_rechargeMoney= findViewById(R.id.et_rechargeMoney);
        btn_doRecharge = findViewById(R.id.btn_doRecharge);
        //充值到账户的点击事件
        btn_doRecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money1 =et_rechargeMoney.getText().toString();
                if (money1.equals("0")){
                    ToastUtil.showShort("金额不能为0");
                }else if (TextUtils.isEmpty(money1)) {
                    ToastUtil.showShort("金额不能为空");
                }else {
                    double m1 = Double.parseDouble(money1);
                    currentAccountMoney = currentAccountMoney + m1;
                    dialog1 = new AlertDialog.Builder(RechargeActivity.this).setTitle("是否确认充值")
                            .setMessage("充值账户：" + MainActivity.username + '\n' + "金  额：" + money1 +"元")
                            .setIcon(R.mipmap.ic_launcher)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    MySQLiteHelper.getInstance(getBaseContext()).RechargeMoney(MainActivity.username, currentAccountMoney);
                                    ToastUtil.showShort("充值成功");
                                    et_rechargeMoney.setText("");
                                }
                            })
                            .setNegativeButton("取消", null)
                            .create();
                    dialog1.show();
                }
            }
        });

    }
}