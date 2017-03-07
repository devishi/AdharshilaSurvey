package me.shubhamgoswami.adharshilasurvey;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Path;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mLoginFormView;
    String usrname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int logStatus = checkLogStatus();
        if(logStatus == 0) {
            setContentView(R.layout.activity_login);
            // Set up the login form.
            mEmailView = (EditText) findViewById(R.id.email);
            mPasswordView = (EditText) findViewById(R.id.password);
            mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                    if (id == R.id.login || id == EditorInfo.IME_NULL) {
                        attemptLogin();
                        return true;
                    }
                    return false;
                }
            });
            Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
            mEmailSignInButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    attemptLogin();
                }
            });
            mLoginFormView = findViewById(R.id.login_form);
        }
        else{
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.putExtra("username", usrname);
            startActivity(i);
        }
    }

    /**
     * check if the user have logged out or is still logged in
      **/

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase("/data/data/me.shubhamgoswami.adharshilasurvey/adharShila.db", null,
                    SQLiteDatabase.OPEN_READONLY);
            checkDB.close();
        } catch (SQLiteException e) {
            // database doesn't exist yet.
        }
        return checkDB != null;
    }

    private static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }

    private int checkLogStatus(){
        Toast.makeText(getApplicationContext(), String.valueOf(doesDatabaseExist(getApplicationContext(), "adharshila")),Toast.LENGTH_LONG);
        //Log.w("exist", String.valueOf(doesDatabaseExist(getApplicationContext(),"adharShila")));
        SQLiteDatabase db = null;
       if(!doesDatabaseExist(getApplicationContext(), "adharShila")){

           db = this.openOrCreateDatabase("adharShila",MODE_PRIVATE, null);
           db.execSQL("CREATE TABLE LOGSTATUS(ENTRY INTEGER PRIMARYKEY, USERNAME STRING NOT NULL,  STATUS INTEGER NOT NULL)");
           db.execSQL("CREATE TABLE LANGUAGE(ENTRY INTEGER PRIMARYKEY, LANG INTEGER)");
           db.execSQL("CREATE TABLE UPLOAD(ENTRY INTEGER PIMARY KEY, RESPONSE STRING NOT NULL)");
//           db.execSQL("CREATE TABLE REGISTER(STATUS INTEGER PRIMARYKEY)");
//           db.execSQL("CREATE TABLE MOBILISE(STATUS INTEGER PRIMARYKEY)");
//           db.execSQL("CREATE TABLE FEEDBACK(STATUS INTEGER PRIMARYKEY)");
           ContentValues cv = new ContentValues();
           cv.put("ENTRY", 1);
           cv.put("STATUS", 0);
           cv.put("USERNAME", "xyz");
           db.insert("LOGSTATUS",null,cv);
           ContentValues cv1 = new ContentValues();
           cv1.put("ENTRY", 1);
           cv1.put("LANG", 1);
           db.insert("LANGUAGE",null,cv1);
           db.close();
       }

        db = openOrCreateDatabase("adharShila", MODE_PRIVATE, null);


        Cursor cur = db.rawQuery("SELECT STATUS, USERNAME FROM LOGSTATUS WHERE ENTRY=1",null);
        cur.moveToFirst();
        int index = cur.getColumnIndex("STATUS");
        int usrIndex = cur.getColumnIndex("USERNAME");
        int result = 0;
        while(cur != null){
            result = cur.getInt(index);
            usrname = cur.getString(usrIndex);
            break;
        }
        db.close();
        cur.close();
        return result;
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }


        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }
            mAuthTask = new UserLoginTask(email, password);
        try {
            Boolean logStatus = mAuthTask.execute("http://shubhamgoswami.me/login").get();
            if(logStatus){
                SQLiteDatabase db = openOrCreateDatabase("adharShila",MODE_PRIVATE, null);
                db.execSQL("UPDATE LOGSTATUS SET USERNAME=\""+mEmailView.getText()+"\", STATUS=1 WHERE ENTRY=1");
                db.close();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("username", mEmailView.getText());
                i.putExtra("password", password);
                startActivity(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return true;
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 0;
    }



    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<String, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(String... params) {
            // TODO: attempt authentication against a network service.
            String result = "";
            Log.w("checkLogin","1");
            try {
                URL url = new URL(params[0]);
                Log.w("checkLogin","2");
                HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                Log.w("checkLogin","3");
                connect.setRequestMethod("POST");
                connect.setRequestProperty("Content-Type", "application/json");
                connect.setDoInput(true);
                connect.setDoOutput(true);

                JSONObject cred = new JSONObject();
                cred.put("userName", mEmail);
                cred.put("password", mPassword);


                OutputStream os = connect.getOutputStream();
                OutputStreamWriter ow = new OutputStreamWriter(os);
                ow.write(cred.toString());
                ow.flush();
                ow.close();

                InputStream is = connect.getInputStream();
                InputStreamReader ir = new InputStreamReader(is);
                int data = ir.read();
                while(data != -1){
                    char c = (char)data;
                    result += c;
                    data = ir.read();
                }

                Log.d("logStat", result);

                if(result.equals("OK"))
                    return true;
                else
                    return false;




            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            // TODO: register the new account here.
            return false;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;

            if (success) {
                Log.e("success","success");
                mPasswordView.setError("Success");
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
        }
    }
}

