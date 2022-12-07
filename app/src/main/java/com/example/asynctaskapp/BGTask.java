package com.example.asynctaskapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BGTask extends AsyncTask<String,Void,String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("bgtask", "onPreExecute: ran");
    }

    @Override
    protected String doInBackground(String... urls) {
        Log.d("bgtask", "doInBackground: running....");
        String result = "";
        URL url;
        HttpURLConnection conn;
        try {
            url = new URL(urls[0]);
            conn = (HttpURLConnection) url.openConnection();
            InputStream in = conn.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();
            while (data != -1) {
                char current = (char) data;
                result += current;
                data = reader.read();
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return "Something went wrong";
        }
        Log.d("bgtask", "doInBackground: completed");
        return result;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("bgtask", s);
        Log.d("bgtask", "onPostExecute: ran");


    }
}

