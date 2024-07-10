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
import java.util.List;

/**
 * 付款界面recyclerView的适配器
 */
public class PayRVAdapter  extends RecyclerView.Adapter<PayRVAdapter.ViewHolder> {

    //设置数据源
    private LayoutInflater inflater ;
    private List<GoodsArrayBean.ItemR> data;

    //适配器的构造方法
    public PayRVAdapter(List<GoodsArrayBean.ItemR> data){
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.pay_order_goods_item,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
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
        holder.tv_number.setText("X "+data.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{


        private ImageView iv_pic;
        private TextView tv_name ;
        private TextView tv_price ;
        private TextView tv_number ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_pic = itemView.findViewById(R.id.iv_pay_goods);
            tv_name = itemView.findViewById(R.id.tv_pay_Name);
            tv_price = itemView.findViewById(R.id.tv_pay_Price);
            tv_number = itemView.findViewById(R.id.tv_pay_number);
        }
    }
}
