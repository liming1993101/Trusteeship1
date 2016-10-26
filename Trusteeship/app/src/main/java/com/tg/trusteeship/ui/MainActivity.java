package com.tg.trusteeship.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.tg.trusteeship.R;
import com.tg.trusteeship.ui.fragment.BaseFragment;
import com.tg.trusteeship.ui.fragment.HomeFragment;
import com.tg.trusteeship.ui.fragment.PersonalFragment;
import com.tg.trusteeship.ui.widget.TabFragmentHost;

public class MainActivity extends BaseActivity {

    public TabFragmentHost mTabHost;
    // 标签
    private String[] TabTag = { "home", "personal"};
    // 自定义tab布局显示文本和顶部的图片
    private Integer[] ImgTab = { R.layout.tab_main_home,
            R.layout.tab_main_personal};

    // tab 选中的activity
    private Class[] ClassTab = { HomeFragment.class, PersonalFragment.class};

    // tab选中背景 drawable 样式图片 背景都是同一个,背景颜色都是 白色。。。
    private Integer[] StyleTab = { R.color.white, R.color.white};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initView();
        InitTabView();
    }


    private void initView() {

        // 实例化framentTabHost
        mTabHost = (TabFragmentHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(),
                android.R.id.tabcontent);

    }


    private void InitTabView() {

        // 可以传递参数 b;传递公共的userid,version,sid
        Bundle b = new Bundle();
        // 循环加入自定义的tab
        for (int i = 0; i < TabTag.length; i++) {
            // 封装的自定义的tab的样式
            View indicator = getIndicatorView(i);
            mTabHost.addTab(
                    mTabHost.newTabSpec(TabTag[i]).setIndicator(indicator),
                    ClassTab[i], b);// 传递公共参数

        }
        mTabHost.getTabWidget().setDividerDrawable(R.color.white);
    }

    // 设置tab自定义样式:注意 每一个tab xml子布局的linearlayout 的id必须一样
    private View getIndicatorView(int i) {
        // 找到tabhost的子tab的布局视图
        View v = getLayoutInflater().inflate(ImgTab[i], null);
        LinearLayout tv_lay = (LinearLayout) v.findViewById(R.id.layout_back);
        tv_lay.setBackgroundResource(StyleTab[i]);

        return v;
    }

}
