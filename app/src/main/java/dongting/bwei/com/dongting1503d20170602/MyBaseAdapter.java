package dongting.bwei.com.dongting1503d20170602;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.x;

import java.util.List;

/**
 * 作者:${董婷}
 * 日期:2017/6/2
 * 描述:界面xlistview滑动的item适配器
 */

public class MyBaseAdapter extends BaseAdapter {
    List<Bean.DataBean.ComicsBean> list;
    Context context;

    public MyBaseAdapter(List<Bean.DataBean.ComicsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //适配器getView()方法的优化
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item, null);
            viewHolder = new ViewHolder();
            viewHolder.cover_image_url = (ImageView) convertView.findViewById(R.id.item_iv);
            viewHolder.label_text = (TextView) convertView.findViewById(R.id.item_tv1);
            viewHolder.topic_title = (TextView) convertView.findViewById(R.id.item_tv2);
            viewHolder.title = (TextView) convertView.findViewById(R.id.item_name);
            viewHolder.all = (TextView) convertView.findViewById(R.id.item_all);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.label_text.setText(list.get(position).getLabel_text());
        viewHolder.topic_title.setText(list.get(position).getTopic().getTitle());
        viewHolder.title.setText(list.get(position).getTitle());

        //使用xutils加载图片
        x.image().bind(viewHolder.cover_image_url, list.get(position).getCover_image_url());

        //点击全集跳转到图2并把数据传递到图2页面
        viewHolder.all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
        return convertView;
    }

    private void start() {
        Intent intent=new Intent(context,ChannelActivity.class);
        context.startActivity(intent);
    }


    class ViewHolder {
        TextView all;
        TextView label_text;
        TextView title;
        ImageView cover_image_url;
        TextView topic_title;
    }
}
