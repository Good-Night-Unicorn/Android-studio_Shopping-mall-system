package com.example.shoppingmallsystem.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import com.example.shoppingmallsystem.R;
import com.example.shoppingmallsystem.activity.PayActivity;
import com.example.shoppingmallsystem.adapter.ShoppongCarGoodsAdapter;
import com.example.shoppingmallsystem.bean.GoodsArrayBean;
import com.example.shoppingmallsystem.fragment.StoreGoodsFragment;

import java.io.Serializable;
import java.util.List;


public class MyDialog {
    private static CustomDialog dialog;
    private View view; // dialog布局
    private View animView; // 商品菜单布局
    private View dismissView; // 半透明遮罩布局
    private RelativeLayout re_bottow ;
    private RecyclerView recyclerView_carGoods;
    private TextView tv_clean ;
    private TextView tv_DoShopping;
    private ImageView iv_shoppingCar ;
    private Context context;
    private ShoppongCarGoodsAdapter shoppongCarGoodsAdapter;
    public static TextView tv_total;
    public static  double total = 0;
    private Intent intent ;


    public static Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 1:
                    dialog.dismiss();
                    break;
                case 2:
                    for (int i = 0;i< StoreGoodsFragment.goodsArrayBean.itemsRight.size() ;i++){
                        StoreGoodsFragment.goodsArrayBean.itemsRight.get(i).setNumber(0);
                    }
                    StoreGoodsFragment.handler.sendEmptyMessage(1);
                    dialog.dismiss();
            }
        }
    };


    public MyDialog(final Context context, final List<GoodsArrayBean.ItemR> dialogData) {
        this.context = context;
        dialog = new CustomDialog(context, R.style.myDialog);
        // dialog的样式
        view = LayoutInflater.from(context).inflate(R.layout.shoppcar_dialog, null);
        //拿到dialog里的控件
        animView = view.findViewById(R.id.v_anim);
        re_bottow = view.findViewById(R.id.rl);
        tv_clean = view.findViewById(R.id.tv_car_clean);
        recyclerView_carGoods = view.findViewById(R.id.re_shoppingGoods);
        tv_DoShopping = view.findViewById(R.id.tv_DoShopping);
        iv_shoppingCar = view.findViewById(R.id.iv_shoppingCar);
        tv_total =view.findViewById(R.id.tv_total_dialog);

        total = StoreGoodsFragment.total;
        tv_total.setText("￥ "+StoreGoodsFragment.total);
        iv_shoppingCar.setImageResource(R.drawable.shoppingcar_full_64);
        tv_DoShopping.setText("去结算");
        //初始化recyclerView
        recyclerView_carGoods.setItemAnimator(null);
        shoppongCarGoodsAdapter = new ShoppongCarGoodsAdapter(dialogData);
        recyclerView_carGoods.setLayoutManager(new LinearLayoutManager(AppContext.getInstance()));
        recyclerView_carGoods.setAdapter(shoppongCarGoodsAdapter);


        dialog.setContentView(view);

        dismissView = view.findViewById(R.id.v_dimiss);
        dismissView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        re_bottow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        tv_DoShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    intent = new Intent();
                    intent.setClass(context, PayActivity.class);
                    intent.putExtra("PayList",(Serializable) dialogData);
                    context.startActivity(intent);
            }
        });

        tv_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogData.clear();
                shoppongCarGoodsAdapter.notifyDataSetChanged();
                for (int i = 0;i< StoreGoodsFragment.goodsArrayBean.itemsRight.size() ;i++){
                    StoreGoodsFragment.goodsArrayBean.itemsRight.get(i).setNumber(0);
                }
                StoreGoodsFragment.handler.sendEmptyMessage(1);
                dialog.dismiss();
                ToastUtil.showShort("购物车已清空");
            }
        });

        dialog.setBeforeDismiss(new CustomDialog.IBeforeDismiss() {
            @Override
            public void onBeforeDismiss() {
                dismissAnim();
            }
        });


        // 设置dialog的位置
        Window dialogWindow = dialog.getWindow();
        dialogWindow.getDecorView().setPadding(0, 0, 0, 0);
        dialogWindow.setBackgroundDrawableResource(android.R.color.transparent);//背景透明，不然会有个白色的东东
//        dialogWindow.setWindowAnimations(R.style.dialogWindowAnim); //不使用窗口弹出动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();

        lp.width = WindowManager.LayoutParams.MATCH_PARENT; // 宽度
        lp.height = WindowManager.LayoutParams.MATCH_PARENT; // 高度
        dialogWindow.setAttributes(lp);
        // 设置dialog为底部
        dialogWindow.setGravity(Gravity.BOTTOM);
    }




    public void show() {
        dialog.show();
        showAnim();
    }

    // 出现动画
    private void showAnim() {
        TranslateAnimation animation = new TranslateAnimation(0, 0, DensityUtil.dp2px(context, 300), 0);
        animation.setDuration(300);
        animView.startAnimation(animation);
    }

    // 消失动画
    private void dismissAnim() {
        TranslateAnimation animation = new TranslateAnimation(0, 0, 0, DensityUtil.dp2px(context, 300));
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                dialog.myDismiss();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animation.setDuration(300);
        animView.startAnimation(animation);
    }

}