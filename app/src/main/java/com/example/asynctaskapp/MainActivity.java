package com.example.asynctaskapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        InnerAsyncTask innerAsyncTask = new InnerAsyncTask();
        innerAsyncTask.execute(20);
    }

    private class InnerAsyncTask extends AsyncTask<Integer, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView = findViewById(R.id.tv_number);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            //example background task, can be replaced with any other background activity

            for (int i = integers[0]; i >= 0; i--) {
                textView.setText("Background Task is Running" + i);
                SystemClock.sleep(1000);
            }
            return "Background Task Completed";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);
        }
    }
}