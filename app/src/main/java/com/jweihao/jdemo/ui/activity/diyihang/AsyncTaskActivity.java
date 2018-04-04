package com.jweihao.jdemo.ui.activity.diyihang;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AsyncTaskActivity extends AppCompatActivity {

    @BindView(R.id.tv_async)
    TextView mTvAsync;

    private AsyncTask<Integer, Integer, String> asyncTask = new TimerAsyncTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        ButterKnife.bind(this);
    }

    public void start(View view) {

        //执行
        asyncTask.execute(100);
    }

    private class TimerAsyncTask extends AsyncTask<Integer, Integer, String> {

        //任务执行前在UI线程中使用
        //为后台任务做一些准备工作，比如绘制一个进度条控件
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(AsyncTaskActivity.this, "开始执行任务", Toast.LENGTH_SHORT).show();
        }

        /*
         * 该方法在子线程中运行，因此不能有任何修改UI的操作
         * 实现后台进程执行的具体计算
         * 该方法内使用publishProgress()方法改变当前进度值
         *
         * */
        @Override
        protected String doInBackground(Integer... integers) {

            for (int i = 0; i < integers[0]; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //发送进度
                publishProgress(i);

            }

            return "任务已经完成！";
        }

        /*
         * 在UI线程中执行，当doInBackground执行publishProgress时调用该方法
         * 对进度条控制根据进度值做出具体的响应
         * */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            mTvAsync.setText("当前进度：" + values[0]);
        }

        /*
         * 任务执行后，在UI中调用
         * result是doInBackground的返回值，如果为null，表明后台任务没有完成（被取消或者出现异常）
         * */
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Toast.makeText(AsyncTaskActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    }
}
