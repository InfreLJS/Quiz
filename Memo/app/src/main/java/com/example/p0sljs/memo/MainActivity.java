package com.example.p0sljs.memo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mMemoEdit = null;
    TextFileManager tm = new TextFileManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMemoEdit = (EditText) findViewById(R.id.memo_edit);

    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.load_btn:
                mMemoEdit.setText(tm.load());
                Toast.makeText(this, "불러오기 완료", Toast.LENGTH_LONG).show();

                break;
            case R.id.save_btn:
                tm.save(mMemoEdit.getText().toString());
                mMemoEdit.setText("");
                Toast.makeText(this, "저장하기 완료", Toast.LENGTH_LONG).show();

                break;
            case R.id.delete_btn:
                tm.delete();
                Toast.makeText(this, "삭제하기 완료", Toast.LENGTH_LONG).show();
        }
    }
}
