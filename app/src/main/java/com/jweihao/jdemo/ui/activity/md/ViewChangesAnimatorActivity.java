package com.jweihao.jdemo.ui.activity.md;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewChangesAnimatorActivity extends AppCompatActivity {


    @BindView(R.id.button_view_changes)
    Button mButtonViewChanges;
    @BindView(R.id.iamge)
    ImageView mIamge;
    private Drawable mDrawable;
    private boolean mIsCheck;
    private int[] STATE_UNCHECKED = new int[]{};
    private int[] STATE_CHECKED = new int[]{android.R.attr.state_checked};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_changes_animator);
        ButterKnife.bind(this);

        //获取图片资源
        mDrawable = ContextCompat.getDrawable(this, R.drawable.animated_selector_icon_changs);
        mIamge.setImageDrawable(mDrawable);

    }

    @OnClick({R.id.button_view_changes, R.id.iamge})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_view_changes:
                //方式二，在代码中设置
                StateListAnimator stateListAnimator = AnimatorInflater.loadStateListAnimator(this, R.drawable.animated_selector_view_changes);
                mButtonViewChanges.setStateListAnimator(stateListAnimator);
                break;
            case R.id.iamge:
                if (mIsCheck) {
                    mIamge.setImageState(STATE_UNCHECKED, true);
                    mIsCheck = false;
                } else {
                    mIamge.setImageState(STATE_CHECKED, true);
                    mIsCheck = true;
                }
                break;
            default:
                break;
        }
    }
}
