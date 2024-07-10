package com.example.shoppingmallsystem.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingmallsystem.MainActivity;
import com.example.shoppingmallsystem.R;
import com.example.shoppingmallsystem.adapter.ChatMessageAdapter;
import com.example.shoppingmallsystem.bean.ChatMessageBean;
import com.example.shoppingmallsystem.bean.GoodsArrayBean;
import com.example.shoppingmallsystem.util.AppContext;
import com.example.shoppingmallsystem.util.DateUtill;
import com.example.shoppingmallsystem.util.MySQLiteHelper;
import com.example.shoppingmallsystem.util.ToastUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


/**
 * 评论界面的fragment
 */
public class StoreCommentFragment extends Fragment {

    private List<ChatMessageBean> chatMessageBeans = new ArrayList<>();
    private RecyclerView rv_Chat;
    private ChatMessageAdapter adapter;
    private EditText et_chat_message;
    private Button btn_message_send;
    private String messages;
    private ChatMessageBean chatMessageBean;

    private int MyUserID = MySQLiteHelper.getInstance(AppContext.getInstance()).GetUserId(MainActivity.username);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_store_comment,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
        initView();
    }

    private void initData() {

        chatMessageBeans = MySQLiteHelper.getInstance(getContext()).queryAllMessages();

        /**
         * 通过此方法，将json数据存入数据库，将数据转化为json格式存储
         */
//        GoodsArrayBean goodsArrayBean = new GoodsArrayBean();
//        goodsArrayBean.itemsLeft = new ArrayList<>();
//        goodsArrayBean.itemsRight = new ArrayList<>();
//
//        goodsArrayBean.itemsLeft.add(new GoodsArrayBean.ItemL("吉他"));
//        goodsArrayBean.itemsLeft.add(new GoodsArrayBean.ItemL("尤克里里"));
//        goodsArrayBean.itemsLeft.add(new GoodsArrayBean.ItemL("钢琴"));
//        goodsArrayBean.itemsLeft.add(new GoodsArrayBean.ItemL("长笛"));
//        goodsArrayBean.itemsLeft.add(new GoodsArrayBean.ItemL("架子鼓"));
//
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("吉他","1","吉他1","1600.50","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("吉他","2","吉他2","950.85","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("吉他","8","吉他3","1900.00","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("吉他","9","吉他4","1200.00","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("吉他","8","吉他5","2300.00","我是商品标题展示数据。。。",0));
//
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("尤克里里","6","尤克里里1","350.80","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("尤克里里","5","尤克里里2","950.88","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("尤克里里","9","尤克里里3","690.88","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("尤克里里","1","尤克里里4","950.88","我是商品标题展示数据。。。",0));
//
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("钢琴","6","钢琴1","11000.99","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("钢琴","5","钢琴2","85000.99","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("钢琴","1","钢琴3","16000.00","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("钢琴","2","钢琴4","60000.90","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("钢琴","5","钢琴5","35000.50","我是商品标题展示数据。。。",0));
//
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("长笛","9","长笛1","110.99","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("长笛","1","长笛2","150.99","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("长笛","2","长笛3","90.99","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("长笛","3","长笛4","190.99","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("长笛","9","长笛5","52.99","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("长笛","5","长笛6","150.99","我是商品标题展示数据。。。",0));
//
//
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("架子鼓","2","架子鼓1","1500.99","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("架子鼓","9","架子鼓2","1500.99","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("架子鼓","5","架子鼓3","1500.99","我是商品标题展示数据。。。",0));
//        goodsArrayBean.itemsRight.add(new GoodsArrayBean.ItemR("架子鼓","1","架子鼓4","1500.99","我是商品标题展示数据。。。",0));
//
//
//        Gson gson = new Gson();
//        String inputString = gson.toJson(goodsArrayBean);
//        Log.e("inputString=" , inputString);

    }

    private void initView() {
        rv_Chat = getActivity().findViewById(R.id.rv_chat);
        et_chat_message = getActivity().findViewById(R.id.et_chat_message);
        btn_message_send = getActivity().findViewById(R.id.btn_message_send);
        messages = et_chat_message.getText().toString();


        adapter = new ChatMessageAdapter(chatMessageBeans);
        rv_Chat.setItemAnimator(new DefaultItemAnimator());
        rv_Chat.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_Chat.setAdapter(adapter);
        rv_Chat.scrollToPosition(adapter.getItemCount()-1);

        //发送信息的判断和操作
        btn_message_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messages = et_chat_message.getText().toString();
                if (TextUtils.isEmpty(messages)){
                    ToastUtil.showShort("内容为空！");
                }else {
                    chatMessageBean = new ChatMessageBean(MyUserID,MyUserID+"",messages,MainActivity.username, DateUtill.getCurrentTime());
                    MySQLiteHelper.getInstance(getActivity()).insertMessages(chatMessageBean);
                    adapter.refreshMessages();
                    rv_Chat.scrollToPosition(adapter.getItemCount()-1);
                    ToastUtil.showShort("发送成功");
                    et_chat_message.setText("");
                }
            }
        });
    }
}
