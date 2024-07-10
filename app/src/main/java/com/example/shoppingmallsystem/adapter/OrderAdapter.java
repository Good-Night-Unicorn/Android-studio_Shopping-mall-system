package com.example.shoppingmallsystem.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shoppingmallsystem.R;
import com.example.shoppingmallsystem.activity.OrderDetailsActivity;
import com.example.shoppingmallsystem.bean.OrderBean;
import com.example.shoppingmallsystem.util.AppContext;
import java.util.List;


/**
 * 订单界面的适配器
 */
public class OrderAdapter  extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

    private LayoutInflater inflater ;
    private List<OrderBean> data ;

    public OrderAdapter (List<OrderBean> data){
        this.data = data ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.order_item,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_time.setText(data.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_time ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_time = itemView.findViewById(R.id.tv_orderTime);

            //设置点击事件点击后跳转订单详情界面
            tv_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppContext.getInstance().startActivity(new Intent(AppContext.getInstance(), OrderDetailsActivity.class)
                        .putExtra("orderDetails",data.get(getLayoutPosition()))
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK ));
                }
            });
        }
    }
}
