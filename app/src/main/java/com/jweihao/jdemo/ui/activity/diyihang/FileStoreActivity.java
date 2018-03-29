package com.jweihao.jdemo.ui.activity.diyihang;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.wh.customcontrol.R;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FileStoreActivity extends AppCompatActivity {

    @BindView(R.id.edit)
    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_store);
        ButterKnife.bind(this);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String inputText = mEdit.getText().toString().trim();
        save(inputText);
    }

    private void save(String inputText) {
        FileOutputStream outputStream = null;
        BufferedWriter bufferedWriter = null;
        try {
            outputStream = openFileOutput("data", Context.MODE_PRIVATE);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write(inputText);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
