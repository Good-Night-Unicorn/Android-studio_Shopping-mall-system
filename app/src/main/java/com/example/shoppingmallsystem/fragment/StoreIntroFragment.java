package com.example.shoppingmallsystem.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shoppingmallsystem.R;
import com.example.shoppingmallsystem.bean.StoreBean;

/**
 * 商家信息fragment
 */
public class StoreIntroFragment extends Fragment {

    private StoreBean storeBean;
    private ImageView iv_store_pic ;
    private TextView tv_storeName ;
    private TextView tv_storeScore ;
    private TextView tv_storeSell ;
    private TextView tv_storeSign;
    private TextView tv_storeIntro;

    public StoreIntroFragment(StoreBean storeBean){
        this.storeBean = storeBean;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_store_intro,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
        initView();
    }

    private void initData() {
    }

    private void initView() {
        iv_store_pic = getActivity().findViewById(R.id.iv_store_frag);
        tv_storeName = getActivity().findViewById(R.id.tv_storeName_frag);
        tv_storeScore = getActivity().findViewById(R.id.tv_store_score_frag);
        tv_storeSell = getActivity().findViewById(R.id.tv_store_sell_frag);
        tv_storeSign = getActivity().findViewById(R.id.tv_store_sign_frag);
        tv_storeIntro = getActivity().findViewById(R.id.tv_store_intro);


        switch (storeBean.getIv_store_pic()){
            case "0":
                iv_store_pic.setImageResource(R.mipmap.store_1);
                break;
            case "1":
                iv_store_pic.setImageResource(R.mipmap.store_2);
                break;
            case "2":
                iv_store_pic.setImageResource(R.mipmap.store_3);
                break;
            case "3":
                iv_store_pic.setImageResource(R.mipmap.store_4);
                break;
            case "4":
                iv_store_pic.setImageResource(R.mipmap.store_5);
                break;
            case "5":
                iv_store_pic.setImageResource(R.mipmap.store_6);
                break;
            case "6":
                iv_store_pic.setImageResource(R.mipmap.store_7);
                break;
            case "7":
                iv_store_pic.setImageResource(R.mipmap.store_8);
                break;
            case "8":
                iv_store_pic.setImageResource(R.mipmap.store_9);
                break;
            case "9":
                iv_store_pic.setImageResource(R.mipmap.store_10);
                break;
        }
        tv_storeName.setText(storeBean.getStoreName());
        tv_storeScore.setText(storeBean.getStoreScore()+"分");
        tv_storeSell.setText(storeBean.getStoreSell()+"份");
        tv_storeSign.setText(storeBean.getStoreSign());
        tv_storeIntro.setText(storeBean.getStoreIntro());

    }
}
