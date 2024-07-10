package com.example.shoppingmallsystem.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shoppingmallsystem.R;
import com.example.shoppingmallsystem.adapter.BaseRecyclerHolder;
import com.example.shoppingmallsystem.adapter.BaseRecyclerViewAdater;
import com.example.shoppingmallsystem.bean.GoodsArrayBean;
import com.example.shoppingmallsystem.util.AppContext;
import com.example.shoppingmallsystem.util.MyDialog;
import com.example.shoppingmallsystem.util.MySQLiteHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * 商家商品信息的fragment
 */
public class StoreGoodsFragment extends Fragment {

    public static GoodsArrayBean goodsArrayBean;
    private LAdapter lAdapter;
    public static RAdapter rAdapter;
    private final Gson gson;
    private final String json;
    private RelativeLayout re_shoppingCar ;
    private List<GoodsArrayBean.ItemR> dialogData = new ArrayList<>();
    private  static ImageView iv_car ;
    private static TextView tv_car ;
    public static TextView tv_total ;
    public static double total;
    private static BigDecimal b1 ;
    private static BigDecimal b2 ;
    private static BigDecimal b3 ;
    private static BigDecimal result ;
    private static BigDecimal one ;
    private static double a ;
    private MyDialog dialog;


    //通过handler刷新数据
    public static Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 1:
                    rAdapter.notifyDataSetChanged();
                    if (rAdapter.getCurrentData().size() == 0){
                        setShoppingCarNotHaveGoods();
                    }
                    refreshTotal();
                    break;
            }
        }
    };


    public StoreGoodsFragment(String storeID) {
        gson = new Gson();
        json = MySQLiteHelper.getInstance(AppContext.getInstance()).queryGoodsFromStoreID(storeID);
        Type type = new TypeToken<GoodsArrayBean>() {}.getType();
        this.goodsArrayBean = gson.fromJson(json, type);
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_store_goods,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        //initData();
        initView();
        initListener();
    }


    private RecyclerView rvL, rvR;
    private TextView tv_head;

    private void initView() {
        tv_head = getActivity().findViewById(R.id.tv_header);
        tv_head.setText(goodsArrayBean.itemsLeft.get(0).getTitle());
        re_shoppingCar = getActivity().findViewById(R.id.re_shoppingCar);
        iv_car = getActivity().findViewById(R.id.iv_shoppingCar);
        tv_car = getActivity().findViewById(R.id.tv_shoppingCar);
        tv_total = getActivity().findViewById(R.id.tv_total_frag);


        rvL = getActivity().findViewById(R.id.rv1);
        rvR = getActivity().findViewById(R.id.rv2);
        rvR.setItemAnimator(null);
        rvL.setLayoutManager(new LinearLayoutManager(getContext()));
        rvR.setLayoutManager(new LinearLayoutManager(getContext()));
        lAdapter = new LAdapter(getContext(),R.layout.goods_left_item, goodsArrayBean.itemsLeft);
        lAdapter.bindToRecyclerView(rvL);
        rvL.setAdapter(lAdapter);
        rAdapter = new RAdapter(getContext(),R.layout.goods_right_item, goodsArrayBean.itemsRight);
        rvR.setAdapter(rAdapter);


        re_shoppingCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogData = rAdapter.getCurrentData();
                if (dialogData.size() != 0){
                    dialog = new MyDialog(getActivity(),dialogData);
                    dialog.show();
                }
            }
        });
    }

    private boolean moveToTop = false;
    private int index;
    private void initListener() {
        lAdapter.setOnItemClickListener(new BaseRecyclerViewAdater.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (rvR.getScrollState() != RecyclerView.SCROLL_STATE_IDLE)return;
                lAdapter.fromClick = true;
                lAdapter.setChecked(position);
                String tag = lAdapter.getmData().get(position).getTitle();
                for (int i = 0; i < rAdapter.getmData().size(); i++) {
                    //根据左边选中的条目获取到右面此条目Title相同的位置索引；
                    if (TextUtils.equals(tag,rAdapter.getmData().get(i).getTitle())){
                        index = i;
                        moveToPosition_R(index);
                        return;
                    }
                }
            }
        });

        rvR.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) rvR.getLayoutManager();
                if (moveToTop){ //向下滑动时，只会把改条目显示出来；我们还需要让该条目滑动到顶部；
                    moveToTop = false;
                    int m = index - layoutManager.findFirstVisibleItemPosition();
                    if (m >= 0 && m <= layoutManager.getChildCount()){
                        int top = layoutManager.getChildAt(m).getTop();
                        rvR.smoothScrollBy(0,top);
                    }
                }else {
                    int index = layoutManager.findFirstVisibleItemPosition();
                    tv_head.setText(rAdapter.getmData().get(index).getTitle());
                    lAdapter.setToPosition(rAdapter.getmData().get(index).getTitle());
                }
            }
        });

        rvR.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                lAdapter.fromClick = false;
                return false;
            }
        });
    }


    private void moveToPosition_R(int index) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) rvR.getLayoutManager();
        int f = layoutManager.findFirstVisibleItemPosition();
        int l = layoutManager.findLastVisibleItemPosition();
        if (index <= f){ //向上移动时
            layoutManager.scrollToPosition(index);
        }else if (index <= l){ //已经再屏幕上面显示时
            int m = index - f;
            if (0 <= m && m <= layoutManager.getChildCount()) {
                int top = layoutManager.getChildAt(m).getTop();
                rvR.smoothScrollBy(0, top);
            }
        }else { //向下移动时
            moveToTop = true;
            layoutManager.scrollToPosition(index);
        }
    }

    class LAdapter extends BaseRecyclerViewAdater<GoodsArrayBean.ItemL> {


        public LAdapter(Context context, int resLayout, List<GoodsArrayBean.ItemL> data) {
            super(context, resLayout, data);
        }

        @Override
        public void convert(BaseRecyclerHolder holder, final int position) {
            TextView tv = ((TextView)holder.getView(R.id.tv));
            tv.setText(getmData().get(position).getTitle());
            if (checked == position){
                tv.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
                tv.setBackgroundResource(R.color.colorfff);
            }else {
                tv.setTextColor(ContextCompat.getColor(context,R.color.black));
                tv.setBackgroundResource(R.color.orange);
            }

        }

        private int checked; //当前选中项
        public boolean fromClick; //是否是自己点击的

        public void setChecked(int checked) {
            this.checked = checked;
            notifyDataSetChanged();
        }

        //让左边的额条目选中
        public void setToPosition(String title){
            if (fromClick)return;
            if (TextUtils.equals(title,getmData().get(checked).getTitle()))return;
            if (TextUtils.isEmpty(title))return;
            for (int i = 0; i < getmData().size(); i++) {
                if (TextUtils.equals(getmData().get(i).getTitle(),title)){
                    setChecked(i);
                    moveToPosition(i);
                    return;
                }
            }

        }

        private void moveToPosition(int index){
            //如果选中的条目不在显示范围内，要滑动条目让该条目显示出来
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getRecyclerView().getLayoutManager();
            int f = linearLayoutManager.findFirstVisibleItemPosition();
            int l = linearLayoutManager.findLastVisibleItemPosition();
            if (index<=f || index >= l){
                linearLayoutManager.scrollToPosition(index);
            }

        }

    }

    class RAdapter extends BaseRecyclerViewAdater<GoodsArrayBean.ItemR>{


        public RAdapter(Context context, int resLayout, List<GoodsArrayBean.ItemR> data) {
            super(context, resLayout, data);
        }


        @Override
        public void convert(BaseRecyclerHolder holder, final int position) {
            switch (getmData().get(position).getPicNumb()){
                case "0":
                    ((ImageView)holder.getView(R.id.iv_goods)).setImageResource(R.drawable.goods_1);
                    break;
                case "1":
                    ((ImageView)holder.getView(R.id.iv_goods)).setImageResource(R.drawable.goods_2);
                    break;
                case "2":
                    ((ImageView)holder.getView(R.id.iv_goods)).setImageResource(R.drawable.goods_3);
                    break;
                case "3":
                    ((ImageView)holder.getView(R.id.iv_goods)).setImageResource(R.drawable.goods_4);
                    break;
                case "4":
                    ((ImageView)holder.getView(R.id.iv_goods)).setImageResource(R.drawable.goods_5);
                    break;
                case "5":
                    ((ImageView)holder.getView(R.id.iv_goods)).setImageResource(R.drawable.goods_6);
                    break;
                case "6":
                    ((ImageView)holder.getView(R.id.iv_goods)).setImageResource(R.drawable.goods_7);
                    break;
                case "7":
                    ((ImageView)holder.getView(R.id.iv_goods)).setImageResource(R.drawable.goods_8);
                    break;
                case "8":
                    ((ImageView)holder.getView(R.id.iv_goods)).setImageResource(R.drawable.goods_9);
                    break;
                case "9":
                    ((ImageView)holder.getView(R.id.iv_goods)).setImageResource(R.drawable.goods_10);
                    break;
            }
            ((TextView)holder.getView(R.id.tvName)).setText(getmData().get(position).getName());
            ((TextView)holder.getView(R.id.tvContant)).setText(getmData().get(position).getContent());
            ((TextView)holder.getView(R.id.tvPrice)).setText("￥:"+getmData().get(position).getPrice());
          if ( !(getmData().get(position).getNumber() == 0)){
                ((ImageView)holder.getView(R.id.iv_minus)).setVisibility(View.VISIBLE);
                ((TextView)holder.getView(R.id.tv_number)).setVisibility(View.VISIBLE);
                ((TextView)holder.getView(R.id.tv_number)).setText(getmData().get(position).getNumber()+"");
            }else {
                ((ImageView)holder.getView(R.id.iv_minus)).setVisibility(View.INVISIBLE);
                ((TextView)holder.getView(R.id.tv_number)).setVisibility(View.INVISIBLE);
            }


            //悬停的标题头
            FrameLayout headLayout = holder.getView(R.id.stick_header);
            TextView tvHead = holder.getView(R.id.tv_header);
            if (position == 0){
                headLayout.setVisibility(View.VISIBLE);
                tvHead.setText(getmData().get(position).getTitle());
            }else {
                if (TextUtils.equals(getmData().get(position).getTitle(),getmData().get(position-1).getTitle())){
                    headLayout.setVisibility(View.GONE);
                }else {
                    headLayout.setVisibility(View.VISIBLE);
                    tvHead.setText(getmData().get(position).getTitle());
                }
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(),getmData().get(position).getTitle()+getmData().get(position).getName(),Toast.LENGTH_SHORT).show();
                }
            });

            holder.getView(R.id.iv_add).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getmData().get(position).setNumber(getmData().get(position).getNumber()+1);
                    notifyItemChanged(position);
                    refreshTotal();
                  //  tv_total.setText("￥ "+ total);
                    setShoppingCarHaveGoods();
                }
            });
            holder.getView(R.id.iv_minus).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getmData().get(position).getNumber() == 0){
                        notifyItemChanged(position);
                        refreshTotal();
                     //   tv_total.setText("￥ "+ total);
                    }else {
                        getmData().get(position).setNumber(getmData().get(position).getNumber()-1);
                        notifyItemChanged(position);
                        refreshTotal();
                     //   tv_total.setText("￥ "+ total);
                    }
                    if (getCurrentData().size() == 0){
                        setShoppingCarNotHaveGoods();
                    }
                }
            });


        }

        public List<GoodsArrayBean.ItemR> getCurrentData(){
            List<GoodsArrayBean.ItemR> data = new ArrayList<>();
            //data = getmData();
            for (int i = 0 ; i<getmData().size() ; i++){
                if (!(getmData().get(i).getNumber() == 0)){
                    data.add(getmData().get(i));
                }
            }
            return data ;
        }

    }


    public void setShoppingCarHaveGoods(){
        iv_car.setImageResource(R.drawable.shoppingcar_full_64);
        tv_car.setText("去结算");
        tv_total.setVisibility(View.VISIBLE);
    }

    public static void setShoppingCarNotHaveGoods(){
        iv_car.setImageResource(R.drawable.shoppingcar_null_64);
        tv_car.setText("暂无商品");
        tv_total.setVisibility(View.INVISIBLE);
    }

    public static void refreshTotal(){
        total = 0;
        for (int i = 0 ;i <rAdapter.getCurrentData().size();i++){
            b1 = new BigDecimal(rAdapter.getCurrentData().get(i).getPrice().trim());
            b2 = new BigDecimal(rAdapter.getCurrentData().get(i).getNumber());
            b3 = new BigDecimal(total);
            result = b1.multiply(b2);
            result = result.add(b3);
            one = new BigDecimal("1");
            a = result.divide(one,2,BigDecimal.ROUND_HALF_UP).doubleValue();//保留2位数
            total = a ;
            //Log.e("total",total+"");
        }
        tv_total.setText("￥ "+ total);
        MyDialog.total = total ;
    }

}