package dongting.bwei.com.dongting1503d20170602;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

/**
 * 作者:${董婷}
 * 日期:2017/6/2
 * 描述:主界面实现
 */
public class MainActivity extends FragmentActivity {

    private TabLayout tabLayout;
    private ViewPager vp;
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //获取控件
        tabLayout = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);

        //进入程序做联网判断没有网跳转到设置网络页面
        if (!isNetworkAvailable()){
            Intent wifiSettingsIntent = new Intent("android.settings.WIFI_SETTINGS");
            startActivity(wifiSettingsIntent);
        }

        //使用viewpager和tablayout
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);
//        tabLayout.setTabTextColors(Color.BLACK,Color.RED);
        tabLayout.setSelectedTabIndicatorColor(Color.YELLOW);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivity = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }
}
