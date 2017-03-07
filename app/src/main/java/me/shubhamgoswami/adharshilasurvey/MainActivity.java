package me.shubhamgoswami.adharshilasurvey;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
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


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Toolbar.OnMenuItemClickListener {


    Fragment current;
    int index;

    static int subCount;

    static int lang = 0;

    SharedPreferences sp;

    static String user = "xyz";
    static String pass = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.setTitle("DashBoard");



        sp = this.getSharedPreferences("me.shubhamgoswami.adharshilasurvey", Context.MODE_PRIVATE);
        subCount = sp.getInt("entry",0);

        SQLiteDatabase db = this.openOrCreateDatabase("adharShila",MODE_PRIVATE,null);
        Cursor cu = db.rawQuery("SELECT LANG FROM LANGUAGE WHERE ENTRY=1",null);
        int ind = cu.getColumnIndex("LANG");
        cu.moveToFirst();
        while(cu != null){
            lang = cu.getInt(ind);
            break;
        }
        cu.close();
        db.close();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int res;
                switch(index){
                    case 1:
                        res = ((Register)current).save();
                        if(res == 0) {
                            subCount++;
                            sp.edit().putInt("entry",subCount);
                            Toast.makeText(getApplicationContext(),"Saved Successfully !!!" , Toast.LENGTH_SHORT).show();
                        }
                        else if(res == 1)
                            Toast.makeText(getApplicationContext(),"All Questions are mandatory !!!" , Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getApplicationContext(), "Sorry!! Please Try Again", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        res = ((Mobilise)current).save();
                        if(res == 0) {
                            subCount++;
                            sp.edit().putInt("entry",subCount);
                            Toast.makeText(getApplicationContext(),"Saved Successfully !!!" , Toast.LENGTH_SHORT).show();
                        }
                        else if(res == 1)
                            Toast.makeText(getApplicationContext(),"All Questions are mandatory !!!" , Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getApplicationContext(), "Sorry!! Please Try Again", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        res = ((Feedback)current).save();
                        if(res == 0) {
                            subCount++;
                            sp.edit().putInt("entry",subCount);
                            Toast.makeText(getApplicationContext(),"Saved Successfully !!!" , Toast.LENGTH_SHORT).show();
                        }
                        else if(res == 1)
                            Toast.makeText(getApplicationContext(),"All Questions are mandatory !!!" , Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getApplicationContext(), "Sorry!! Please Try Again", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Log.d("default", "default");
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = getLayoutInflater().inflate(R.layout.nav_header_main, null);
        TextView tv = (TextView) header.findViewById(R.id.username);
        tv.setText(getIntent().getStringExtra("username"));
        user = getIntent().getStringExtra("username");
        pass = getIntent().getStringExtra("password");
        navigationView.addHeaderView(header);

        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        //Register reg = new Register();
        Mobilise reg = new Mobilise();
        trans.replace(R.id.fragment_container, reg);  // replace feed with reg
        trans.commit();

        current = reg;
        index = 1;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            SQLiteDatabase db = openOrCreateDatabase("adharShila",MODE_PRIVATE, null);
            db.execSQL("UPDATE LOGSTATUS SET USERNAME=\"xyz\", STATUS=0 WHERE ENTRY=1");
            db.close();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        if (id == R.id.register) {
            // Handle the camera action
            Register reg = new Register();
            trans.replace(R.id.fragment_container, reg);
            trans.commit();
            current = reg;
            index = 2;
        } else if (id == R.id.mobilise) {
            Mobilise mob = new Mobilise();
            trans.replace(R.id.fragment_container, mob);
            trans.commit();
            current = mob;
            index = 1;
        } else if (id == R.id.feedback) {
            Feedback feed = new Feedback();
            trans.replace(R.id.fragment_container, feed);
            trans.commit();
            current = feed;
            index = 3;
        } else if (id == R.id.english) {
            switch(index){
                case 1:
                    Register reg = (Register)current;
                    reg.toEnglish();
                    break;
                case 2:
                    Mobilise mob = (Mobilise)current;
                    mob.toEnglish();
                    break;
                case 3:
                    Feedback feed = (Feedback)current;
                    feed.toEnglish();
                    break;
                default:
                    Log.d("default","default");
            }
            SQLiteDatabase db = openOrCreateDatabase("adharShila",MODE_PRIVATE,null);
            lang = 1;
            db.execSQL("UPDATE LANGUAGE SET LANG=1 WHERE ENTRY=1");
        } else if (id == R.id.hindi) {
            switch(index){
                case 1:
                    Register reg = (Register)current;
                    reg.toHindi();
                    break;
                case 2:
                    Mobilise mob = (Mobilise)current;
                    mob.toHindi();
                    break;
                case 3:
                    Feedback feed = (Feedback)current;
                    feed.toHindi();
                    break;
                default:
                    Log.d("default","default");
            }
            SQLiteDatabase db = openOrCreateDatabase("adharShila",MODE_PRIVATE,null);
            lang = 2;
            db.execSQL("UPDATE LANGUAGE SET LANG=2 WHERE ENTRY=1");
        }
        else if (id == R.id.sync){
            // the synchronisation code willl be here
            if(isNetworkAvailable()){
                // start the Upload service
                //startService(new Intent(this,Upload.class));
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
                    cur.moveToNext();
                }
                cur.close();
                // delete the entries that are pushed successfully

                for (Integer s: done){
                    db.execSQL("DELETE FROM UPLOAD WHERE ENTRY="+s.toString()+"");
                }

            }
            else {
                Toast.makeText(getApplicationContext(), "You are currently \"OFFLINE\" Sync-failed!!!", Toast.LENGTH_LONG).show();
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connMgr = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
    class UploadIt extends AsyncTask<String,Void,Boolean>{

        @Override
        protected Boolean doInBackground(String... params) {
            String url1 = "http://shubhamgoswami.me";

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
