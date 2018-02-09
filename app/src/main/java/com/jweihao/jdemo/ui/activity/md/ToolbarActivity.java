package com.jweihao.jdemo.ui.activity.md;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import android.widget.RelativeLayout;
import android.widget.Toast;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToolbarActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.drawer_view)
    RelativeLayout mDrawerView;
    @BindView(R.id.drawer)
    DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        ButterKnife.bind(this);

        mToolbar.setLogo(R.drawable.ic_launcher);
        mToolbar.setTitle("主标题");
        mToolbar.setSubtitle("副标题");
        setSupportActionBar(mToolbar);
        //设置显示返回箭头
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*
        * 简单来说，openDrawerContentDescRes与closeDrawerContentDescRes
        * 的内容不会显示在屏幕上，但是可以通过accessibility services转换成语音为那些视力不好的人服务。
        *
        * */
        mActionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                mToolbar,
                0,
                0
        );
        //设置显示三横杠
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);

        //菜单的监听可以在toolbar里设置
        //也可以通过Activity的inOptionsItemSelected回调方法来处理
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_setting:
                        Toast.makeText(ToolbarActivity.this, "action_settings", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        //ShareActionProvider配置
        MenuItem shareItem = menu.findItem(R.id.action_share);
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        mShareActionProvider.setShareIntent(intent);
        return super.onCreateOptionsMenu(menu);
    }

}






























