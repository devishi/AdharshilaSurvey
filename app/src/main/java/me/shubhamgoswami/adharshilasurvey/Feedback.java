package me.shubhamgoswami.adharshilasurvey;


import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class Feedback extends Fragment {

    public String[][] ques = new String[63][3];

    View[] tv = new View[63];

    View vi;


    public Feedback() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vi = inflater.inflate(R.layout.fragment_feedback, container, false);

        addQuestion();
        getTextView();
        setTextView();
        setViews();

        return vi;
    }

    EditText t1,t2,t3,t4,t5,t7,t8,t9,t10, t11, t12, t13, t14, t15, t16, t17;
    RatingBar rb1, rb2, rb3, rb4, rb5, rb6;
    RadioGroup rg1, rg2,rg3,rg4,rg5,rg6,rg7,rg8;
    Switch s1;
    RadioButton r1, r2, r3;


    public void setViews(){
        t1 = (EditText) vi.findViewById(R.id.i101);
        t2 = (EditText) vi.findViewById(R.id.i102);
        t3 = (EditText) vi.findViewById(R.id.i109);
        t4 = (EditText)vi.findViewById(R.id.i110);
        t5 = (EditText)vi.findViewById(R.id.i1110);
        s1 = (Switch) vi.findViewById(R.id.i112);
        t7 = (EditText)vi.findViewById(R.id.i113);
        t8 = (EditText)vi.findViewById(R.id.i114);
        t9 = (EditText)vi.findViewById(R.id.i115);
        t10 = (EditText)vi.findViewById(R.id.i116);
        t11 = (EditText)vi.findViewById(R.id.i117);
        t12 = (EditText)vi.findViewById(R.id.i1180);
        t13 = (EditText)vi.findViewById(R.id.i1190);
        t14 = (EditText)vi.findViewById(R.id.i120);
        t15 = (EditText)vi.findViewById(R.id.i123);
        t16 = (EditText)vi.findViewById(R.id.i125);
        t17 = (EditText)vi.findViewById(R.id.i126);

        rg1 = (RadioGroup)vi.findViewById(R.id.i111);
        rg2 = (RadioGroup)vi.findViewById(R.id.i118);
        rg3 = (RadioGroup)vi.findViewById(R.id.i119);
        rg4 = (RadioGroup)vi.findViewById(R.id.i121);
        rg5 = (RadioGroup)vi.findViewById(R.id.i122);
        rg6 = (RadioGroup)vi.findViewById(R.id.i124);
        rg7 = (RadioGroup)vi.findViewById(R.id.i127);
        rg8 = (RadioGroup)vi.findViewById(R.id.i128);


        r1 = (RadioButton)vi.findViewById(R.id.tv19);
        r2 = (RadioButton)vi.findViewById(R.id.tv30);
        r3 = (RadioButton)vi.findViewById(R.id.tv34);

        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    t5.setEnabled(true);
                } else {
                    t5.setEnabled(false);
                }
            }
        });

        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    t12.setEnabled(true);
                } else {
                    t12.setEnabled(false);
                }
            }
        });

        r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    t13.setEnabled(true);
                } else {
                    t13.setEnabled(false);
                }
            }
        });

        rb1 = (RatingBar)vi.findViewById(R.id.i103);
        rb2 = (RatingBar)vi.findViewById(R.id.i104);
        rb3 = (RatingBar)vi.findViewById(R.id.i105);
        rb4 = (RatingBar)vi.findViewById(R.id.i106);
        rb5 = (RatingBar)vi.findViewById(R.id.i107);
        rb6 = (RatingBar)vi.findViewById(R.id.i108);

    }

    public Boolean notEmpty(){
        if(t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty() || t3.getText().toString().isEmpty() ||
                t4.getText().toString().isEmpty() || t7.getText().toString().isEmpty() ||
                t8.getText().toString().isEmpty() || t9.getText().toString().isEmpty() || t10.getText().toString().isEmpty() ||
                t11.getText().toString().isEmpty() ||
                t14.getText().toString().isEmpty() || t15.getText().toString().isEmpty() || t16.getText().toString().isEmpty() ||
                t17.getText().toString().isEmpty())
            return false;
        else if(r1.isChecked() && t5.getText().toString().isEmpty())
            return false;
        else if(r2.isChecked() && t12.getText().toString().isEmpty())
            return false;
        else if(r3.isChecked() && t13.getText().toString().isEmpty())
            return false;
        return true;
    }

    public void toHindi(){
        // converting to hindi
        for (int i=0;i < 63; i++){
            try {
                ((TextView)tv[i]).setText(ques[i][2]);
            } catch (Exception e){
                try {
                    ((RadioButton) tv[i]).setText(ques[i][2]);
                }
                catch(Exception ex){
                    ((android.support.v7.widget.AppCompatTextView) tv[i]).setText(ques[i][2]);
                }
            }
        }
    }

    public void toEnglish(){
        for (int i=0;i< 63;i++){
            try {
                ((TextView)tv[i]).setText(ques[i][1]);
            } catch (Exception e){
                try {
                    ((RadioButton) tv[i]).setText(ques[i][1]);
                }
                catch(Exception ex){
                    ((android.support.v7.widget.AppCompatTextView) tv[i]).setText(ques[i][1]);
                }
            }
        }
    }

    public void getTextView(){
        tv[0] = vi.findViewById(R.id.tv0);
        tv[1] = vi.findViewById(R.id.tv1);
        tv[2] = vi.findViewById(R.id.tv2);
        tv[3] = vi.findViewById(R.id.tv3);
        tv[4] = vi.findViewById(R.id.tv4);
        tv[5] = vi.findViewById(R.id.tv5);
        tv[6] = vi.findViewById(R.id.tv6);
        tv[7] = vi.findViewById(R.id.tv7);
        tv[8] = vi.findViewById(R.id.tv8);
        tv[9] = vi.findViewById(R.id.tv9);
        tv[10] = vi.findViewById(R.id.tv10);
        tv[11] = vi.findViewById(R.id.tv11);
        tv[12] = vi.findViewById(R.id.tv12);
        tv[13] = vi.findViewById(R.id.tv13);
        tv[14] = vi.findViewById(R.id.tv14);
        tv[15] = vi.findViewById(R.id.tv15);
        tv[16] = vi.findViewById(R.id.tv16);
        tv[17] = vi.findViewById(R.id.tv17);
        tv[18] = vi.findViewById(R.id.tv18);
        tv[19] = vi.findViewById(R.id.tv19);
        tv[20] = vi.findViewById(R.id.tv20);
        tv[21] = vi.findViewById(R.id.tv21);
        tv[22] = vi.findViewById(R.id.tv22);
        tv[23] = vi.findViewById(R.id.tv23);
        tv[24] = vi.findViewById(R.id.tv24);
        tv[25] = vi.findViewById(R.id.tv25);
        tv[26] = vi.findViewById(R.id.tv26);
        tv[27] = vi.findViewById(R.id.tv27);
        tv[28] = vi.findViewById(R.id.tv28);
        tv[29] = vi.findViewById(R.id.tv29);
        tv[30] = vi.findViewById(R.id.tv30);
        tv[31] = vi.findViewById(R.id.tv31);
        tv[32] = vi.findViewById(R.id.tv32);
        tv[33] = vi.findViewById(R.id.tv33);
        tv[34] = vi.findViewById(R.id.tv34);
        tv[35] = vi.findViewById(R.id.tv35);
        tv[36] = vi.findViewById(R.id.tv36);
        tv[37] = vi.findViewById(R.id.tv37);
        tv[38] = vi.findViewById(R.id.tv38);
        tv[39] = vi.findViewById(R.id.tv39);
        tv[40] = vi.findViewById(R.id.tv40);
        tv[41] = vi.findViewById(R.id.tv41);
        tv[42] = vi.findViewById(R.id.tv42);
        tv[43] = vi.findViewById(R.id.tv43);
        tv[44] = vi.findViewById(R.id.tv44);
        tv[45] = vi.findViewById(R.id.tv45);
        tv[46] = vi.findViewById(R.id.tv46);
        tv[47] = vi.findViewById(R.id.tv47);
        tv[48] = vi.findViewById(R.id.tv48);
        tv[49] = vi.findViewById(R.id.tv49);
        tv[50] = vi.findViewById(R.id.tv50);
        tv[51] = vi.findViewById(R.id.tv51);
        tv[52] = vi.findViewById(R.id.tv52);
        tv[53] = vi.findViewById(R.id.tv53);
        tv[54] = vi.findViewById(R.id.tv54);
        tv[55] = vi.findViewById(R.id.tv55);
        tv[56] = vi.findViewById(R.id.tv56);
        tv[57] = vi.findViewById(R.id.tv57);
        tv[58] = vi.findViewById(R.id.tv58);
        tv[59] = vi.findViewById(R.id.tv59);
        tv[60] = vi.findViewById(R.id.tv60);
        tv[61] = vi.findViewById(R.id.tv61);
        tv[62] = vi.findViewById(R.id.tv62);
    }

    public void setTextView(){

        // setting the text
        for(int i=0; i<63;i++)
            try {
                ((TextView)tv[i]).setText(ques[i][MainActivity.lang]);
            } catch (Exception e){
                try {
                    ((RadioButton) tv[i]).setText(ques[i][MainActivity.lang]);
                }
                catch(Exception ex){
                    ((android.support.v7.widget.AppCompatTextView) tv[i]).setText(ques[i][MainActivity.lang]);
                }
            }
    }

    public int save(){
        // save th data to the database
        toEnglish();
        if(!notEmpty()) {
            setTextView();
            return 1;
        }
        JSONObject send = new JSONObject();
        try {
            JSONArray ja = new JSONArray();
            JSONObject[] response = new JSONObject[50];

            for(int i=0;i <50; i++)
                response[i] = new JSONObject();

            response[0].put("qid",101);
            response[0].put("response", t1.getText().toString());

            response[1].put("qid",102);
            response[1].put("response", t2.getText().toString());

            response[2].put("qid",103);
            response[2].put("response", String.valueOf(rb1.getRating()));

            response[3].put("qid",104);
            response[3].put("response", String.valueOf(rb2.getRating()));

            response[4].put("qid",105);
            response[4].put("response", String.valueOf(rb3.getRating()));

            response[5].put("qid",106);
            response[5].put("response", String.valueOf(rb4.getRating()));

            response[6].put("qid",107);
            response[6].put("response", String.valueOf(rb5.getRating()));

            response[7].put("qid",108);
            response[7].put("response", String.valueOf(rb6.getRating()));

            response[8].put("qid",109);
            response[8].put("response", t3.getText().toString());

            response[9].put("qid",110);
            response[9].put("response", t4.getText().toString());

            RadioButton rb = null;

            rb = (RadioButton) vi.findViewById(rg1.getCheckedRadioButtonId());
            response[10].put("qid",111);
            if(!r1.isChecked())
                response[10].put("response", rb.getText().toString());
            else
                response[10].put("response", t5.getText().toString());

            response[11].put("qid",112);
            if(s1.isActivated())
                response[11].put("response", "Yes");
            else
                response[11].put("response", "No");

            response[12].put("qid",113);
            response[12].put("response", t7.getText().toString());

            response[13].put("qid",114);
            response[13].put("response", t8.getText().toString());

            response[14].put("qid",115);
            response[14].put("response", t9.getText().toString());

            response[15].put("qid",116);
            response[15].put("response", t10.getText().toString());

            response[16].put("qid",117);
            response[16].put("response", t11.getText().toString());

            rb = (RadioButton) vi.findViewById(rg2.getCheckedRadioButtonId());
            response[17].put("qid",118);
            if(!r2.isChecked())
                response[17].put("response", rb.getText().toString());
            else
                response[17].put("response", t12.getText().toString());

            rb = (RadioButton) vi.findViewById(rg3.getCheckedRadioButtonId());
            response[18].put("qid",119);
            if(!r3.isChecked())
                response[18].put("response", rb.getText().toString());
            else
                response[18].put("response", t13.getText().toString());

            response[19].put("qid",120);
            response[19].put("response", t14.getText().toString());

            rb = (RadioButton) vi.findViewById(rg4.getCheckedRadioButtonId());
            response[20].put("qid",121);
            response[20].put("response", rb.getText().toString());

            rb = (RadioButton) vi.findViewById(rg5.getCheckedRadioButtonId());
            response[21].put("qid",122);
            response[21].put("response", rb.getText().toString());

            response[22].put("qid",123);
            response[22].put("response", t1.getText().toString());

            rb = (RadioButton) vi.findViewById(rg6.getCheckedRadioButtonId());
            response[23].put("qid",124);
            response[23].put("response", rb.getText().toString());

            response[24].put("qid",125);
            response[24].put("response", t1.getText().toString());

            response[25].put("qid",126);
            response[25].put("response", t1.getText().toString());

            rb = (RadioButton) vi.findViewById(rg7.getCheckedRadioButtonId());
            response[26].put("qid",127);
            response[26].put("response", rb.getText().toString());

            rb = (RadioButton) vi.findViewById(rg8.getCheckedRadioButtonId());
            response[27].put("qid",128);
            response[27].put("response", rb.getText().toString());

            for(int i=0;i<28;i++){
                ja.put(response[i]);
            }
            send.put("answers",ja);
            send.put("url","/newFeedback");
            send.put("userName",MainActivity.user);
            SQLiteDatabase db = getContext().openOrCreateDatabase("adharShila", Context.MODE_PRIVATE,null);
            ContentValues cv = new ContentValues();
            cv.put("ENTRY",String.valueOf(MainActivity.subCount+1));
            cv.put("RESPONSE",send.toString());
            cv.put("DONE", 0);
            db.insert("UPLOAD",null,cv);
            setTextView();
            return 0;
        } catch (JSONException e) {
            setTextView();
            e.printStackTrace();
            return 2;
        }
    }

    public void addQuestion(){

        // question ID
        ques[0][0] = "";
        ques[1][0] = "";
        ques[2][0] = "";
        ques[3][0] = "";
        ques[4][0] = "";
        ques[5][0] = "";
        ques[6][0] = "";
        ques[7][0] = "";
        ques[8][0] = "";
        ques[9][0] = "";
        ques[10][0] = "";
        ques[11][0] = "";
        ques[12][0] = "";
        ques[13][0] = "";
        ques[14][0] = "";
        ques[15][0] = "";
        ques[16][0] = "";
        ques[17][0] = "";
        ques[18][0] = "";
        ques[19][0] = "";
        ques[20][0] = "";
        ques[21][0] = "";
        ques[22][0] = "";
        ques[23][0] = "";
        ques[24][0] = "";
        ques[25][0] = "";
        ques[26][0] = "";
        ques[27][0] = "";
        ques[28][0] = "";
        ques[29][0] = "";
        ques[30][0] = "";
        ques[31][0] = "";
        ques[32][0] = "";
        ques[33][0] = "";
        ques[34][0] = "";
        ques[35][0] = "";
        ques[36][0] = "";
        ques[37][0] = "";
        ques[38][0] = "";
        ques[39][0] = "";
        ques[40][0] = "";
        ques[41][0] = "";
        ques[42][0] = "";
        ques[43][0] = "";
        ques[44][0] = "";
        ques[45][0] = "";
        ques[46][0] = "";
        ques[47][0] = "";
        ques[48][0] = "";
        ques[49][0] = "";
        ques[50][0] = "";
        ques[51][0] = "";
        ques[52][0] = "";
        ques[53][0] = "";
        ques[54][0] = "";
        ques[55][0] = "";
        ques[56][0] = "";
        ques[57][0] = "";
        ques[58][0] = "";
        ques[59][0] = "";
        ques[60][0] = "";
        ques[61][0] = "";
        ques[62][0] = "";

        // English
        ques[0][1] = "About the Program:";
        ques[1][1] = "What was the reason for joining this program? ";
        ques[2][1] = "Do you think your motivations for joining the program have been fulfilled?";
        ques[3][1] = "Please rate the class on the following: (from 1 - 5, with 1 being the lowest)";
        ques[4][1] = "Learning atmosphere";
        ques[5][1] = "Testing";
        ques[6][1] = "Appropriate and relevant materials";
        ques[7][1] = "Please rate the teacher on the following:(from 1 - 5, with 1 being the lowest)";
        ques[8][1] = "Clarity of instruction";
        ques[9][1] = "Availability";
        ques[10][1] = "Commitment to answering your questions";
        ques[11][1] = "If you were to enroll in this program again, what additional skills would you like to be taught that would help you gain more opportunities? This will help us structure the program better in the future for incoming students.";
        ques[12][1] = "Any other suggestions:";
        ques[13][1] = "About yourself:";
        ques[14][1] = "Who is the primary breadwinner in your family?";
        ques[15][1] = "Father";
        ques[16][1] = "Mother";
        ques[17][1] = "Husband";
        ques[18][1] = "Self";
        ques[19][1] = "Other (please specify)";
        ques[20][1] = "Were you employed during the program? Yes/No";
        ques[21][1] = "Please provide your most recent employment history:";
        ques[22][1] = "Designation/Post:";
        ques[23][1] = "Description:";
        ques[24][1] = "Name of company and contact details:";
        ques[25][1] = "Duration: From  20__ - To 20__";
        ques[26][1] = "Last salary drawn (Per month, in numeric value only): Rs. ______/=";
        ques[27][1] = "Are you comfortable commuting outside your neighborhood for work?";
        ques[28][1] = "Yes";
        ques[29][1] = "No";
        ques[30][1] = "Depends on (please elaborate in 20 words)";
        ques[31][1] = "Will your family support your decision to work outside your neighborhood?";
        ques[32][1] = "Yes";
        ques[33][1] = "No";
        ques[34][1] = "Depends on (please elaborate in 20 words)";
        ques[35][1] = "What is your monthly income level after completion of the program? (This is confidential and will not be shared with anyone. But it will help us assess the success of our program and train the future students better. )";
        ques[36][1] = "Has your income increased after enrolling in this course?";
        ques[37][1] = "Yes";
        ques[38][1] = "No";
        ques[39][1] = "Do you have a sewing machine at home?";
        ques[40][1] = "Yes";
        ques[41][1] = "No";
        ques[42][1] = "What type of sewing machine is it? (Brand and type) For example: Gold brand, Umbrella machine";
        ques[43][1] = "What are your plans after completing the program?";
        ques[44][1] = "Full time job in a factory";
        ques[45][1] = "Part time job in a factory";
        ques[46][1] = "Sew clothes for myself and my family";
        ques[47][1] = "Start my own boutique/Entrepreneurship";
        ques[48][1] = "Work at a boutique";
        ques[49][1] = "Work from home";
        ques[50][1] = "No remunerative plans/learning as a hobby";
        ques[51][1] = "Will you recommend this program to others? If you have already recommended the program to others, please name the students who enrolled/completed the program on your suggestion. (You may come back later to fill this in after students that you have recommended completed the program, even if it is after a few years)";
        ques[52][1] = "What was your single biggest learning from the program? This may or may not be related to the skill that was being taught in the class.";
        ques[53][1] = "Have you applied for any jobs as yet?";
        ques[54][1] = "Yes";
        ques[55][1] = "No";
        ques[56][1] = "What are the major hurdles you face in getting a job?";
        ques[57][1] = "Lack of family support";
        ques[58][1] = "Lack of qualification";
        ques[59][1] = "Lack of skill";
        ques[60][1] = "Cultural barriers such as gender inequality";
        ques[61][1] = "Distance from home";
        ques[62][1] = "Lack of opportunities";
        // Hindi
        ques[0][2] = "कार्यक्रम के बारे में";
        ques[1][2] = "इस कार्यक्रम में शामिल होने का क्या कारण था?";
        ques[2][2] = "क्या आपको लगता है कार्यक्रम में शामिल होने के आपके इरादे पुरे हुए?";
        ques[3][2] = "निम्न वर्ग पर कृपया मूल्यांकन करें: (1 से 5, 1 सबसे कम है)";
        ques[4][2] = "वातावरण में सीखना";
        ques[5][2] = "परिक्षण";
        ques[6][2] = "उचित और प्रासंगिक सामग्री";
        ques[7][2] = "कृपया निम्नलिखित पर शिक्षक को मूल्यांकन करें: (1 से 5, 1 सबसे कम है)";
        ques[8][2] = "शिक्षा की स्पष्टता";
        ques[9][2] = "उपलब्धता";
        ques[10][2] = "आपके सवालों का जवाब देने के लिए प्रतिबद्धता";
        ques[11][2] = "यदि आप फिर से इस कार्यक्रम में नामांकन के लिए आना चाहते हैं तो क्या अतिरिक्त कौशल सीखना पसंद करेंगे जो आपको और अधिक अवसर हासिल करने में मदद करेगा? इस से भविष्य में आने वाले छात्रों के लिए हमारे कार्यक्रम की बेहतर संरचना में मदद मिलेगी।";
        ques[12][2] = "कोई अन्य सुझाव:";
        ques[13][2] = "अपने बारे में:";
        ques[14][2] = "अपने परिवार में प्राथमिक कमानेवाला कौन है?";
        ques[15][2] = "पिता";
        ques[16][2] = "मां";
        ques[17][2] = "पति";
        ques[18][2] = "स्वयं";
        ques[19][2] = "अन्य (कृपया निर्दिष्ट करें)";
        ques[20][2] = "क्या आप कार्यक्रम के दौरान कार्यरत थे? हाँ / नही";
        ques[21][2] = "अपने सबसे हाल ही रोजगार के इतिहास प्रदान करें:";
        ques[22][2] = "पदनाम / पोस्ट:";
        ques[23][2] = "विवरण:";
        ques[24][2] = "कंपनी और संपर्क विवरण का नाम:";
        ques[25][2] = "अवधि: 20__ से - 20__ करने के लिए";
        ques[26][2] = "अंतिम वेतन (प्रति माह, संख्यात्मक मूल्य में केवल):";
        ques[27][2] = "आप काम के लिए अपने पड़ोस के बाहर जा सकते है?";
        ques[28][2] = "हाँ";
        ques[29][2] = "नहीं";
        ques[30][2] = "निर्भर करता है (20 शब्दों में विस्तृत कृपया)";
        ques[31][2] = "क्या आपके पड़ोस के बाहर काम करने के लिए आपके परिवार का समर्थन है?";
        ques[32][2] = "हाँ";
        ques[33][2] = "नहीं";
        ques[34][2] = "निर्भर करता है (20 शब्दों में विस्तृया)";
        ques[35][2] = "कार्यक्रम के पूरा होने के बाद आपकी मासिक आय स्तर क्या है? (यह गोपनीय है और किसी के साथ साझा नहीं किया जाएगा। लेकिन यह हमें हमारे कार्यक्रम की सफलता का आकलन करने और भविष्य के लिए छात्रों को बेहतर प्रशिक्षित करने में मदद करेगा।)";
        ques[36][2] = "क्या इस कोर्स में दाखिले  के बाद आपकी आय वृद्धि हुई है?";
        ques[37][2] = "हाँ";
        ques[38][2] = "नहीं";
        ques[39][2] = "यदि आपके घर पर एक सिलाई मशीन है?";
        ques[40][2] = "हाँ";
        ques[41][2] = "नहीं";
        ques[42][2] = "यह सिलाई मशीन किस तरह की है? (ब्रांड और प्रकार) उदाहरण के लिए: गोल्ड ब्रांड, अम्ब्रेला मशीन";
        ques[43][2] = "कार्यक्रम पूरा करने के बाद आपकी क्या योजनाएं हैं?";
        ques[44][2] = "एक कारखाने में पूर्णकालिक नौकरी";
        ques[45][2] = "एक कारखाने में आंशिक समय नौकरी";
        ques[46][2] = "खुद को और अपने परिवार के लिए कपड़े सिलाई";
        ques[47][2] = "मेरे अपने बुटीक / उद्यमिता शुरू";
        ques[48][2] = "एक बुटीक में काम";
        ques[49][2] = "घर से काम / घर - घर के काम";
        ques[50][2] = "कोई लाभकारी योजनाओं / एक शौक के रूप में सीखने";
        ques[51][2] = "क्या आप दूसरों को इस कार्यक्रम की सिफारिश करेंगे? अगर आपने पहले से ही दूसरों के लिए कार्यक्रम की सिफारिश की है, तो जीन छात्रों ने आपके सुझाव पर दाखिला लिया और कार्यक्रम पूरा किया कृपया उनका नाम बताये?";
        ques[52][2] = "कार्यक्रम से अपनी सबसे बड़ी एकल क्या सीखा? यह जो पढ़ाया कक्षा कक्षा उससे सम्बंदित हो सकता है या नहीं भी.";
        ques[53][2] = "क्या अपने अभी तक किसी काम के लिए आवेदन किया है ";
        ques[54][2] = "हाँ";
        ques[55][2] = "नहीं";
        ques[56][2] = "प्रमुख बाधाओं एक नौकरी प्राप्त करने में आप सामना कर रहे हैं?";
        ques[57][2] = "परिवार के समर्थन का अभाव ";
        ques[58][2] = "योग्यता का अभाव";
        ques[59][2] = "कौशल की कमी";
        ques[60][2] = "लैंगिक असमानता के रूप में सांस्कृतिक बाधाओं";
        ques[61][2] = "घर से दूरी";
        ques[62][2] = "अवसरों की कमी";

    }
}
