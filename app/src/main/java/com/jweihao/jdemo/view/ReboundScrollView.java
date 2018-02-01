package com.jweihao.jdemo.view;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;
/**
 * Created by weihao on 2018/1/31.
 */

public class ReboundScrollView extends ViewGroup {

    private int mScreenHeight;
    private Scroller mScroller;
    private int mLastY;
    private int mStart;

    public ReboundScrollView(Context context) {
        super(context);
    }

    public ReboundScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ReboundScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public ReboundScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        /*
        * 可用显示尺寸的绝对高度以像素为单位。
        * */
        mScreenHeight = dm.heightPixels;
        mScroller = new Scroller(context);

    }
    /*
    * 在ViewGroup能够滚动之前，需要先放置好它的子View，
    * 使用遍历的方式通知子View对自身进行测量。
    * */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            measureChild(
                    childView,
                    widthMeasureSpec,
                    heightMeasureSpec
            );
        }
    }
    /*
    * 在ViewGroup中添加滑动事件，通常可以使用scrollBy()方法来辅助滑动。
    * 只要使用scrollBy(0,dy)方法，让手指滑动的时候让ViewGroup的所有子View
    * 也跟着滚动dy即可。
    * */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                /*
                * 按下时的Y坐标
                * */
                mLastY = y;
                /*
                * 返回该视图的滚动顶部位置。
                * 这是视图显示部分的顶部边缘。
                * 你不需要在它上面绘制任何像素，因为它们是在屏幕上的视图框架之外的。
                *
                * */
                mStart = getScrollY();
                break;

            case MotionEvent.ACTION_MOVE:
                /*
                * isFinished()方法，返回scroller是否已完成滚动。
                * */
                if (!mScroller.isFinished()) {
                    /*
                    * 停止动画。
                    * 与终止动画相反，导致scroller移动到最后的x和y位置。
                    * */
                    mScroller.abortAnimation();
                }
                int dy = mLastY - y;
                if (getScrollY() < 0) {
                    dy = 0;
                }
                if (getScrollY() > getHeight() - mScreenHeight) {
                    dy = 0;
                }
                scrollBy(0, dy);
                mLastY = y;
                break;

            case MotionEvent.ACTION_UP:
                int dScrollY = checkAlignment();
                if (dScrollY > 0) {
                    if (dScrollY < mScreenHeight / 3) {
                        mScroller.startScroll(
                                0,
                                getScrollY(),
                                0,
                                -dScrollY
                        );

                    } else {
                        mScroller.startScroll(
                                0,
                                getScrollY(),
                                0,
                                mScreenHeight - dScrollY
                        );
                    }
                } else {
                    if (-dScrollY < mScreenHeight / 3) {
                        mScroller.startScroll(
                                0,
                                getScrollY(),
                                0,
                                -dScrollY
                        );

                    } else {
                        mScroller.startScroll(
                                0,
                                getScrollY(),
                                0,
                                -mScreenHeight - dScrollY
                        );
                    }
                }

                break;
            default:
                break;

        }

        postInvalidate();
        return true;
    }

    private int checkAlignment() {
        int mEnd = getScrollY();
        boolean isUp = ((mEnd - mStart) > 0) ? true : false;
        int lastPrev = mEnd % mScreenHeight;
        int lastNext = mScreenHeight - lastPrev;
        if (isUp) {
            //向上的
            return lastPrev;
        } else {
            return -lastNext;
        }

    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(
                    0,
                    mScroller.getCurrY()
            );
            postInvalidate();
        }
    }
    /*
    * 在获取了整个ViewGroup的高度之后，可以通过遍历来设定每个子View需要放置的位置，
    * 直接通过调用子View的Layout()方法，并将具体的位置作为参数传递进去即可。
    * */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        /*
        * 设置ViewGroup的高度，由于让每个子View占一屏的高度，因此整个ViewGroup的高度
        * 即子View的个数乘以屏幕的高度。
        *
        * */
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        mlp.height = mScreenHeight * childCount;
        setLayoutParams(mlp);

        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                /*
                * 将大小和位置分配给视图及其所有后代，这是布局机制的第二阶段。
                * (第一次测量)。在这个阶段，每个父节点调用其所有子节点上的布局来定位它们。
                * 这通常是使用在measure pass()中存储的子度量来完成的。
                * 派生类不应重写此方法。派生类的子类应该重写onLayout。
                * 在这种方法中，他们应该调用每个孩子的布局。
                * left,top,right,bottom
                * */
                child.layout(
                        l,
                        i * mScreenHeight,
                        r,
                        (i + 1) * mScreenHeight
                );
            }
        }
    }
}
