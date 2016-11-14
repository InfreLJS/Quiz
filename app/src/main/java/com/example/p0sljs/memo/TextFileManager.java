package com.example.p0sljs.memo;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextFileManager {
    private static final String FILE_NAME = "Memo.txt";
    Context mContext = null;

    public TextFileManager(Context context) {
        mContext = context;
    }

    public void save(String data) {
        if (data == null || data.equals("")) {
            return;
        }

        FileOutputStream out = null;

        try {
            out = mContext.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            out.write(data.getBytes());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String load() {
        try {
            FileInputStream in = mContext.openFileInput(FILE_NAME);

            byte[] memoData = new byte[in.available()];
            while (in.read(memoData) != -1) {
            }
            return new String(memoData);
        } catch (IOException e) {
        }

        return "";
    }

    public void delete() {
        mContext.deleteFile(FILE_NAME);
    }
}
