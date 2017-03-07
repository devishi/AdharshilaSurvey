package me.shubhamgoswami.adharshilasurvey;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by hacker9500 on 10/06/16.
 */
public class Upload extends Service {



    @Override
    public void onCreate() {
        super.onCreate();


        // connectivity is first checked by the calling activity then service is started


        SQLiteDatabase db = this.openOrCreateDatabase("adharShila", MODE_PRIVATE, null);
        Cursor cur = db.rawQuery("Select ENTRY, RESPONSE FROM UPLOAD",null);

        int entryIndex = cur.getColumnIndex("ENTRY");
        int resIndex = cur.getColumnIndex("RESPONSE");

        cur.moveToFirst();

        ArrayList<Integer> done = new ArrayList<>();

        while ( cur != null ){
            int Entry = cur.getInt(entryIndex);
            String resp = cur.getString(resIndex);

            String[] data = new String[2];
            Boolean result;
            UploadIt upload = new UploadIt();
            try {
                result = upload.execute(String.valueOf(Entry), resp).get();
                if(result == false){
                    continue;
                }
                else{
                    done.add(Entry);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        cur.close();
        // delete the entries that are pushed successfully

        for (Integer s: done){
            db.execSQL("DELETE FROM UPLOAD WHERE ENTRY="+s.toString()+"");
        }

        // done

        this.stopSelf();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getApplicationContext(), "AdharShila-Survey Sync completed!!!", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "Sync started!!!", Toast.LENGTH_SHORT).show();
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    class UploadIt extends AsyncTask<String,Void,Boolean>{

        @Override
        protected Boolean doInBackground(String... params) {
            String url1 = "http://192.168.2.0:3000";

            try {
                JSONObject response = new JSONObject(params[1]);

                String to = response.getString("url");
                response.put("password",MainActivity.pass);
                URL url = new URL(url1+to);
                HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                connect.setRequestProperty("Content-Type", "application/json");
                connect.setRequestMethod("POST");
                connect.setDoInput(true);
                connect.setDoOutput(true);

                OutputStream os = connect.getOutputStream();
                OutputStreamWriter ow = new OutputStreamWriter(os);
                ow.write(response.toString());
                ow.flush();
                ow.close();

                InputStream is = connect.getInputStream();
                InputStreamReader ir = new InputStreamReader(is);

                int data = ir.read();
                String result = "";

                while(data != -1){
                    char c = (char)data;
                    result += c;
                    data = ir.read();
                }

                if(result.equals("OK"))
                    return true;
                else
                    return false;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

}
