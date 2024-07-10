package com.example.shoppingmallsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingmallsystem.MainActivity;
import com.example.shoppingmallsystem.R;
import com.example.shoppingmallsystem.bean.ChatMessageBean;
import com.example.shoppingmallsystem.util.AppContext;
import com.example.shoppingmallsystem.util.MySQLiteHelper;

import java.util.List;

/**
 * 评论信息的适配器
 */
public class ChatMessageAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private List<ChatMessageBean> messageBeans;
    private int MyUserID = MySQLiteHelper.getInstance(AppContext.getInstance()).GetUserId(MainActivity.username);

    //构造方法
    public ChatMessageAdapter(List<ChatMessageBean> chatMessageBeans){
        this.messageBeans = chatMessageBeans;
    }

    //设置枚举，判断类型
    public enum ItemType {
        MY, OTHERS
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        // 给ViewHolder设置布局文件
        RecyclerView.ViewHolder holder = null;
        //根据类型，加载不同布局
        if (ItemType.MY.ordinal() == viewType) {
            View v = inflater.inflate(R.layout.chat_item_right, parent, false);
            holder = new ViewHolderMy(v);
        } else if (ItemType.OTHERS.ordinal() == viewType) {
            View v = inflater.inflate(R.layout.chat_item_left, parent, false);
            holder = new ViewHolderOther(v);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //根据holder的类型不同，显示不同的数据
        if (holder instanceof ViewHolderMy) {
            switch (messageBeans.get(position).getImg_id()){
                case "1":
                    ((ViewHolderMy) holder).iv_chat.setImageResource(R.drawable.tx_1_48);
                    break;
                case "2" :
                    ((ViewHolderMy) holder).iv_chat.setImageResource(R.drawable.tx_2_48);
                    break;
                case "3":
                    ((ViewHolderMy) holder).iv_chat.setImageResource(R.drawable.tx_3_48);
                    break;
                case "4":
                    ((ViewHolderMy) holder).iv_chat.setImageResource(R.drawable.tx_4_48);
                    break;
                case "5":
                    ((ViewHolderMy) holder).iv_chat.setImageResource(R.drawable.tx_5_48);
                    break;
                case "6":
                    ((ViewHolderMy) holder).iv_chat.setImageResource(R.drawable.tx_6_48);
                    break;
            }
         //   ((ViewHolderMy) holder).iv_chat.setImageResource(R.drawable.my_tx_48);
            ((ViewHolderMy) holder).tv_message.setText(messageBeans.get(position).getMessage());
            ((ViewHolderMy) holder).tv_rightUserName.setText(messageBeans.get(position).getUserName());
            ((ViewHolderMy) holder).tv_right_time.setText(messageBeans.get(position).getTime());
        } else if (holder instanceof ViewHolderOther) {
            switch (messageBeans.get(position).getImg_id()){
                case "1":
                    ((ViewHolderOther) holder).iv_chat.setImageResource(R.drawable.tx_1_48);
                    break;
                case "2" :
                    ((ViewHolderOther) holder).iv_chat.setImageResource(R.drawable.tx_2_48);
                    break;
                case "3":
                    ((ViewHolderOther) holder).iv_chat.setImageResource(R.drawable.tx_3_48);
                    break;
                case "4":
                    ((ViewHolderOther) holder).iv_chat.setImageResource(R.drawable.tx_4_48);
                    break;
                case "5":
                    ((ViewHolderOther) holder).iv_chat.setImageResource(R.drawable.tx_5_48);
                    break;
                case "6":
                    ((ViewHolderOther) holder).iv_chat.setImageResource(R.drawable.tx_6_48);
                    break;
            }
            ((ViewHolderOther) holder).tv_message.setText(messageBeans.get(position).getMessage());
            ((ViewHolderOther) holder).tv_leftUserName.setText(messageBeans.get(position).getUserName());
            ((ViewHolderOther) holder).tv_left_time.setText(messageBeans.get(position).getTime());
        }
    }

    @Override
    public int getItemCount() {
        return messageBeans.size();
    }

    /**
     * 拿到此位置条目的类型
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (messageBeans.get(position).getId() == MyUserID) {
            return ItemType.MY.ordinal();
        } else {
            return ItemType.OTHERS.ordinal();
        }

    }

    /**
     * 本人的view Holder
     */
    class ViewHolderMy extends RecyclerView.ViewHolder {

        private ImageView iv_chat;
        private TextView tv_message;
        private TextView tv_rightUserName;
        private TextView tv_right_time;

        public ViewHolderMy(@NonNull View itemView) {
            super(itemView);
            iv_chat = itemView.findViewById(R.id.iv_chat_imagr_right);
            tv_message = itemView.findViewById(R.id.tv_chat_me_message);
            tv_rightUserName = itemView.findViewById(R.id.tv_right_userName);
            tv_right_time = itemView.findViewById(R.id.tv_right_time);
        }
    }


    /**
     * 其他用户的viewHolder
     */
    class ViewHolderOther extends RecyclerView.ViewHolder {

        private ImageView iv_chat;
        private TextView tv_message;
        private TextView tv_leftUserName;
        private TextView tv_left_time;

        public ViewHolderOther(@NonNull View itemView) {
            super(itemView);
            iv_chat = itemView.findViewById(R.id.iv_icon);
            tv_message = itemView.findViewById(R.id.tv_message_left);
            tv_leftUserName = itemView.findViewById(R.id.tv_left_userName);
            tv_left_time = itemView.findViewById(R.id.tv_left_time);
        }
    }



    //刷新信息
    public void refreshMessages(){
        initData();
       notifyDataSetChanged();
    }

    //刷新数据源
    private  void initData(){
        messageBeans = MySQLiteHelper.getInstance(AppContext.getInstance()).queryAllMessages();
    }

}
