package com.example.shoppingmallsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shoppingmallsystem.MainActivity;
import com.example.shoppingmallsystem.R;
import com.example.shoppingmallsystem.adapter.AllStoresAdapter;
import com.example.shoppingmallsystem.bean.StoreBean;
import com.example.shoppingmallsystem.util.MySQLiteHelper;
import com.example.shoppingmallsystem.util.ShareUtils;
import com.example.shoppingmallsystem.util.ToastUtil;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.List;


/**
 * 主页所有商店的activity
 *
 */
public class HomeAllStoresActivity extends AppCompatActivity implements View.OnClickListener {


    /*创建一个Drawerlayout和Toolbar联动的开关*/
    private ActionBarDrawerToggle toggle ;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView tv_bar_title;
    private TextView tv_main_userName;
    private ImageView iv_head;

    private AllStoresAdapter allStoresAdapter;
    //private SearchView mySearchView;
    private RecyclerView rv_stores;
    private List<StoreBean> storeBeans;
    private LinearLayout headerView;
    private int UserID ;

    //初始化数据
    private void initData(){
        storeBeans = new ArrayList<>();
        storeBeans = MySQLiteHelper.getInstance(getApplicationContext()).queryAllStores();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_all_stores);
        //加载数据
        initData();
        //初始化View
        ininView();
        //隐藏滑动条
        hideScrollBar();
        //设置ActionBar
        setActionBar();
        /*设置Drawerlayout开关*/
        setDrawerToggle();
        /*设置监听器*/
        setListener();
    }

    /*初始化View*/
    private void ininView() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar);
        tv_bar_title = findViewById(R.id.tv_bar_title);
        tv_bar_title.setText("商家列表");

        //获取头布局
        headerView = (LinearLayout) navigationView.getHeaderView(0);
        tv_main_userName = headerView.findViewById(R.id.tv_header_userName);
        iv_head = headerView.findViewById(R.id.iv_head);
        tv_main_userName.setText(MainActivity.username);
        UserID = MySQLiteHelper.getInstance(getApplicationContext()).GetUserId(MainActivity.username);
        switch (UserID){
            case 1:
                iv_head.setImageResource(R.drawable.tx_1_48);
                break;
            case 2:
                iv_head.setImageResource(R.drawable.tx_2_48);
                break;
            case 3:
                iv_head.setImageResource(R.drawable.tx_3_48);
                break;
            case 4:
                iv_head.setImageResource(R.drawable.tx_4_48);
                break;
            case 5:
                iv_head.setImageResource(R.drawable.tx_5_48);
                break;
            case 6:
                iv_head.setImageResource(R.drawable.tx_6_48);
                break;
        }


        rv_stores = findViewById(R.id.rv_stores);
        allStoresAdapter = new AllStoresAdapter(storeBeans);
        //初始化recyclerView
        rv_stores.setItemAnimator(new DefaultItemAnimator());
        rv_stores.setLayoutManager(new LinearLayoutManager(this));
        rv_stores.setAdapter(allStoresAdapter);

        //设置item点击事件
        allStoresAdapter.setOnItemClickListener(new AllStoresAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position, StoreBean storeBean) {
                //ToastUtil.showShort("您点击的下标"+position+"商家："+storeBean.getStoreName());
                startActivity(new Intent(HomeAllStoresActivity.this,StoreGoodsActivity.class).putExtra("storeID",storeBean.getID()));
            }
        });

    }

    /*去掉navigation中的滑动条*/
    private void hideScrollBar() {
        navigationView.getChildAt(0).setVerticalScrollBarEnabled(false);
    }

    /*设置ActionBar*/
    private void setActionBar() {
        setSupportActionBar(toolbar);
        /*显示Home图标*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //设置不显示项目名称
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    /*设置Drawerlayout的开关,并且和Home图标联动*/
    private void setDrawerToggle() {
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);
        drawerLayout.addDrawerListener(toggle);
        /*同步drawerlayout的状态*/
        toggle.syncState();
    }

    /*设置监听器*/
    private void setListener() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.single_1:
                        startActivity(new Intent(HomeAllStoresActivity.this,OrderActivity.class));
                        break;
                    case R.id.single_2:
                        startActivity(new Intent(HomeAllStoresActivity.this, MyAccountActivity.class));
                        break;
                    case R.id.single_3:
                        startActivity(new Intent(HomeAllStoresActivity.this,PersonalCenterActivity.class));
                        break;
                    case R.id.single_4:
                        startActivity(new Intent(HomeAllStoresActivity.this, MainActivity.class));
                        ShareUtils.putAuto_Login("0");
                        HomeAllStoresActivity.this.finish();
                        break;

                }
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
        }
    }


    /**
     * 设置返回两次退出程序的方法
     */
    protected long exitTime ; //记录第一次点击的时间
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if ((System.currentTimeMillis() - exitTime) > 2000 ){
                Toast.makeText(HomeAllStoresActivity.this,"再按一次退出商城",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }else {
                HomeAllStoresActivity.this.finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }

}