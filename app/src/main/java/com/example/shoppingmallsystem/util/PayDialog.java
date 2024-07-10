package com.example.shoppingmallsystem.util;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
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
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingmallsystem.R;
import com.example.shoppingmallsystem.adapter.ShoppongCarGoodsAdapter;
import com.jungly.gridpasswordview.GridPasswordView;

public class PayDialog {

    private static CustomDialog dialog;
    private View view; // dialog布局
    private GridPasswordView gridPasswordView ;
    private RelativeLayout re_bottow ;
    private RecyclerView recyclerView_carGoods;
    private TextView tv_clean ;
    private TextView tv_DoShopping;
    private ImageView iv_shoppingCar ;
    private Context context;
    private ShoppongCarGoodsAdapter shoppongCarGoodsAdapter;
    public static TextView tv_total;
    public static  double total = 0;

    public PayDialog(Context context) {
        this.context = context;
        dialog = new CustomDialog(context, R.style.PayDialog);
        // dialog的样式
        view = LayoutInflater.from(context).inflate(R.layout.pay_dialog, null);
        //拿到dialog里的控件
        gridPasswordView = view.findViewById(R.id.my_passwordView);

        //设置输入密码监听
        gridPasswordView.setOnPasswordChangedListener(new GridPasswordView.OnPasswordChangedListener() {
            //正在输入密码时执行此方法
            public void onTextChanged(String psw) {
                //tv.setText("正在输入密码...");
            }
            //输入密码完成时执行此方法
            public void onInputFinish(String psw) {
                Log.e("你输入的密码为",psw);
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
    }

}