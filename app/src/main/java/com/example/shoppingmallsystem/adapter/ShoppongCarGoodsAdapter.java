package com.example.shoppingmallsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shoppingmallsystem.R;
import com.example.shoppingmallsystem.bean.GoodsArrayBean;
import com.example.shoppingmallsystem.fragment.StoreGoodsFragment;
import com.example.shoppingmallsystem.util.MyDialog;
import com.example.shoppingmallsystem.util.ToastUtil;
import java.math.BigDecimal;
import java.util.List;


/**
 * 购物车dialog的recyclerView的适配器
 */
public class ShoppongCarGoodsAdapter  extends  RecyclerView.Adapter<ShoppongCarGoodsAdapter.ViewHolder>{

    //设置数据源
    private LayoutInflater inflater ;
    private List<GoodsArrayBean.ItemR> data;
    public static double total;
    private static BigDecimal b1 ;
    private static BigDecimal b2 ;
    private static BigDecimal b3 ;
    private static BigDecimal result ;
    private static BigDecimal one ;
    private static double a ;

    //适配器的构造方法
    public ShoppongCarGoodsAdapter(List<GoodsArrayBean.ItemR> data){
        this.data = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.shopping_car_goods_item,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        switch (data.get(position).getPicNumb()){
            case "0":
                holder.iv_pic.setImageResource(R.drawable.goods_1);
                break;
            case "1":
                holder.iv_pic.setImageResource(R.drawable.goods_2);
                break;
            case "2":
                holder.iv_pic.setImageResource(R.drawable.goods_3);
                break;
            case "3":
                holder.iv_pic.setImageResource(R.drawable.goods_4);
                break;
            case "4":
                holder.iv_pic.setImageResource(R.drawable.goods_5);
                break;
            case "5":
                holder.iv_pic.setImageResource(R.drawable.goods_6);
                break;
            case "6":
                holder.iv_pic.setImageResource(R.drawable.goods_7);
                break;
            case "7":
                holder.iv_pic.setImageResource(R.drawable.goods_8);
                break;
            case "8":
                holder.iv_pic.setImageResource(R.drawable.goods_9);
                break;
            case "9":
                holder.iv_pic.setImageResource(R.drawable.goods_10);
                break;
        }
        holder.tv_name.setText(data.get(position).getName());
        holder.tv_price.setText(data.get(position).getPrice());
        holder.tv_number.setText(data.get(position).getNumber()+"");

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class  ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_pic ;
        private ImageView iv_add ;
        private ImageView iv_minus ;
        private TextView tv_price ;
        private TextView tv_number ;
        private TextView tv_name ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_pic = itemView.findViewById(R.id.iv_car_goods);
            iv_add = itemView.findViewById(R.id.iv_car_add);
            iv_minus = itemView.findViewById(R.id.iv_car_minus);
            tv_price = itemView.findViewById(R.id.tv_car_Price);
            tv_number = itemView.findViewById(R.id.tv_car_number);
            tv_name = itemView.findViewById(R.id.tv_car_Name);

            iv_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    data.get(getAdapterPosition()).setNumber(data.get(getAdapterPosition()).getNumber()+1);
                    //int p = StoreGoodsFragment.goodsArrayBean.itemsRight.indexOf(data.get(getAdapterPosition()));
                    //Log.e("获取的位置",p+"");
                    //StoreGoodsFragment.goodsArrayBean.itemsRight.get(p).setNumber(StoreGoodsFragment.goodsArrayBean.itemsRight.get(p).getNumber()+1);
                    StoreGoodsFragment.handler.sendEmptyMessage(1);
                    notifyItemChanged(getAdapterPosition());
                    refreshTotal();
                }
            });

            iv_minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    data.get(getAdapterPosition()).setNumber(data.get(getAdapterPosition()).getNumber()-1);
                    //发送信息，通知商品列表刷新
                    StoreGoodsFragment.handler.sendEmptyMessage(1);
                    refreshTotal();
                    /**
                     * 判断是否已经减到了0
                     */
                    if (data.get(getAdapterPosition()).getNumber() == 0){
                        data.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        notifyDataSetChanged();
                        refreshTotal();
                    }else {
                        notifyItemChanged(getAdapterPosition());
                        refreshTotal();
                    }
                    //如果数据已为空，通知handler刷新
                    if (data.size() == 0){
                        ToastUtil.showShort("购物车已空");
                        MyDialog.handler.sendEmptyMessage(1);
                    }
                }
            });
        }
    }

    //刷新购物车底部总价格
    private void refreshTotal(){
        total = 0;
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
        MyDialog.tv_total.setText("￥ "+ total);
    }

}
