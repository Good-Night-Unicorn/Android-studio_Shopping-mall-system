package com.example.shoppingmallsystem.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.shoppingmallsystem.MainActivity;
import com.example.shoppingmallsystem.R;
import com.example.shoppingmallsystem.adapter.PayRVAdapter;
import com.example.shoppingmallsystem.adapter.ShoppongCarGoodsAdapter;
import com.example.shoppingmallsystem.bean.GoodsArrayBean;
import com.example.shoppingmallsystem.bean.OrderBean;
import com.example.shoppingmallsystem.fragment.StoreGoodsFragment;
import com.example.shoppingmallsystem.util.AppContext;
import com.example.shoppingmallsystem.util.DateUtill;
import com.example.shoppingmallsystem.util.MyDialog;
import com.example.shoppingmallsystem.util.MySQLiteHelper;
import com.example.shoppingmallsystem.util.ToastUtil;
import com.google.gson.Gson;

import java.math.BigDecimal;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.List;


/**
 * 付款界面的activity
 */
public class PayActivity extends AppCompatActivity {

    private TextView tv_bar_title;
    private Toolbar toolbar;

    private List<GoodsArrayBean.ItemR> data =new ArrayList<>();
    private RecyclerView rv_pay;
    private TextView tv_pay_total;
    private TextView tv_submitOrder;
    private PayRVAdapter payRVAdapter;
    private double total = 0;
    private  BigDecimal b1 ;
    private  BigDecimal b2 ;
    private  BigDecimal b3 ;
    private  BigDecimal result ;
    private  BigDecimal one ;
    private  double a ;
    private Dialog dialog;
    private double accountMoney;
    private OrderBean orderBean;
    private Gson gson;
    private String goodsJson;

    private  BigDecimal a1 ;
    private  BigDecimal a2 ;
    private  BigDecimal result1 ;
    private  double resultMoney ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        data = (ArrayList<GoodsArrayBean.ItemR>) getIntent().getSerializableExtra("PayList");
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
        rv_pay = findViewById(R.id.rv_pay);
        tv_pay_total = findViewById(R.id.tv_pay_total);
        tv_submitOrder = findViewById(R.id.tv_submitOrder);
        toolbar = findViewById(R.id.toolbar);
        tv_bar_title = findViewById(R.id.tv_bar_title);
        tv_bar_title.setText("提交订单");

        //初始化recyclerView
        rv_pay.setItemAnimator(null);
        payRVAdapter = new PayRVAdapter(data);
        rv_pay.setLayoutManager(new LinearLayoutManager(AppContext.getInstance()));
        rv_pay.setAdapter(payRVAdapter);


        /**
         * 循环获得总价格
         */
        for (int i= 0;i<data.size();i++){
            b1 = new BigDecimal(data.get(i).getPrice().trim());
            b2 = new BigDecimal(data.get(i).getNumber());
            b3 = new BigDecimal(total);
            result = b1.multiply(b2);
            result = result.add(b3);
            one = new BigDecimal("1");
            a = result.divide(one,2,BigDecimal.ROUND_HALF_UP).doubleValue();//保留2位数
            total = a ;
            //Log.e("total",total+"");
        }

        tv_pay_total.setText("￥"+ total);

        tv_submitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ToastUtil.showShort("总金额"+total);
                dialog = new AlertDialog.Builder(PayActivity.this).setTitle("是否确认购买？")
                        .setMessage("总金额：" + total)
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                doInsertOrder();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .create();
                dialog.show();


            }
        });

    }


    /**
     * 进行插入订单的判定和操作
     */
    private void doInsertOrder(){
        accountMoney = MySQLiteHelper.getInstance(PayActivity.this).getUserMoneyFromUserName(MainActivity.username);
        //判断账户余额是否足够
        if (total > accountMoney){
            ToastUtil.showShort("账户余额不足，请先充值");
            dialog.dismiss();
        }else {
            //解决double精度丢失问题
            a1 = new BigDecimal(accountMoney);
            a2 = new BigDecimal(total);
            result1 = a1.subtract(a2);
            one = new BigDecimal("1");
            resultMoney =  result1.divide(one,2,BigDecimal.ROUND_HALF_UP).doubleValue();//保留2位数

            MySQLiteHelper.getInstance(PayActivity.this).RechargeMoney(MainActivity.username,resultMoney);
            gson = new Gson();
            goodsJson = gson.toJson(data);
            //Log.e("inputString=" , inputString);
            orderBean = new OrderBean(MainActivity.username, DateUtill.getCurrentTime(),goodsJson);
            //Log.e("order",orderBean.toString());
            //Log.e("时间",DateUtill.getCurrentTime());
            MySQLiteHelper.getInstance(PayActivity.this).insertOrderInfo(orderBean);
            ToastUtil.showShort("下单成功!");
            //通过handler通知刷新购物车界面
            MyDialog.handler.sendEmptyMessage(2);
            PayActivity.this.finish();
        }

    }
}