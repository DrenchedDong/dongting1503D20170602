package dongting.bwei.com.dongting1503d20170602;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * 作者:${董婷}
 * 日期:2017/6/2
 * 描述:tab展示
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    String title[]={"周二","周三","周四","周五","昨天","今天"};

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        FragmentFragment fragment=new FragmentFragment();

        return fragment;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
