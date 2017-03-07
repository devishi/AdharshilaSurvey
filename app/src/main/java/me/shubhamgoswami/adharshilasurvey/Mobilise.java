
package me.shubhamgoswami.adharshilasurvey;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class Mobilise extends Fragment {

    public String[][] ques = new String[142][3];

    View[] tv = new View[142];

    View vi;

    public Mobilise() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vi =  inflater.inflate(R.layout.fragment_mobilise, container, false);
        addQuestion();
        getTextView();
        setTextView();
        getViews();

        for(int i=26;i<=32;i++){
            t[i].setEnabled(false);
        }

        return vi;
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
        tv[63] = vi.findViewById(R.id.tv63);
        tv[64] = vi.findViewById(R.id.tv64);
        tv[65] = vi.findViewById(R.id.tv65);
        tv[66] = vi.findViewById(R.id.tv66);
        tv[67] = vi.findViewById(R.id.tv67);
        tv[68] = vi.findViewById(R.id.tv68);
        tv[69] = vi.findViewById(R.id.tv69);
        tv[70] = vi.findViewById(R.id.tv70);
        tv[71] = vi.findViewById(R.id.tv71);
        tv[72] = vi.findViewById(R.id.tv72);
        tv[73] = vi.findViewById(R.id.tv73);
        tv[74] = vi.findViewById(R.id.tv74);
        tv[75] = vi.findViewById(R.id.tv75);
        tv[76] = vi.findViewById(R.id.tv76);
        tv[77] = vi.findViewById(R.id.tv77);
        tv[78] = vi.findViewById(R.id.tv78);
        tv[79] = vi.findViewById(R.id.tv79);
        tv[80] = vi.findViewById(R.id.tv80);
        tv[81] = vi.findViewById(R.id.tv81);
        tv[82] = vi.findViewById(R.id.tv82);
        tv[83] = vi.findViewById(R.id.tv83);
        tv[84] = vi.findViewById(R.id.tv84);
        tv[85] = vi.findViewById(R.id.tv85);
        tv[86] = vi.findViewById(R.id.tv86);
        tv[87] = vi.findViewById(R.id.tv87);
        tv[88] = vi.findViewById(R.id.tv88);
        tv[89] = vi.findViewById(R.id.tv89);
        tv[90] = vi.findViewById(R.id.tv90);
        tv[91] = vi.findViewById(R.id.tv91);
        tv[92] = vi.findViewById(R.id.tv92);
        tv[93] = vi.findViewById(R.id.tv93);
        tv[94] = vi.findViewById(R.id.tv94);
        tv[95] = vi.findViewById(R.id.tv95);
        tv[96] = vi.findViewById(R.id.tv96);
        tv[97] = vi.findViewById(R.id.tv97);
        tv[98] = vi.findViewById(R.id.tv98);
        tv[99] = vi.findViewById(R.id.tv99);
        tv[100] = vi.findViewById(R.id.tv100);
        tv[101] = vi.findViewById(R.id.tv101);
        tv[102] = vi.findViewById(R.id.tv102);
        tv[103] = vi.findViewById(R.id.tv103);
        tv[104] = vi.findViewById(R.id.tv104);
        tv[105] = vi.findViewById(R.id.tv105);
        tv[106] = vi.findViewById(R.id.tv106);
        tv[107] = vi.findViewById(R.id.tv107);
        tv[108] = vi.findViewById(R.id.tv108);
        tv[109] = vi.findViewById(R.id.tv109);
        tv[110] = vi.findViewById(R.id.tv110);
        tv[111] = vi.findViewById(R.id.tv111);
        tv[112] = vi.findViewById(R.id.tv112);
        tv[113] = vi.findViewById(R.id.tv113);
        tv[114] = vi.findViewById(R.id.tv114);
        tv[115] = vi.findViewById(R.id.tv115);
        tv[116] = vi.findViewById(R.id.tv116);
        tv[117] = vi.findViewById(R.id.tv117);
        tv[118] = vi.findViewById(R.id.tv118);
        tv[119] = vi.findViewById(R.id.tv119);
        tv[120] = vi.findViewById(R.id.tv120);
        tv[121] = vi.findViewById(R.id.tv121);
        tv[122] = vi.findViewById(R.id.tv122);
        tv[123] = vi.findViewById(R.id.tv123);
        tv[124] = vi.findViewById(R.id.tv124);
        tv[125] = vi.findViewById(R.id.tv125);
        tv[126] = vi.findViewById(R.id.tv126);
        tv[127] = vi.findViewById(R.id.tv127);
        tv[128] = vi.findViewById(R.id.tv128);
        tv[129] = vi.findViewById(R.id.tv129);
        tv[130] = vi.findViewById(R.id.tv130);
        tv[131] = vi.findViewById(R.id.tv131);
        tv[132] = vi.findViewById(R.id.tv132);
        tv[133] = vi.findViewById(R.id.tv133);
        tv[134] = vi.findViewById(R.id.tv134);
        tv[135] = vi.findViewById(R.id.tv135);
        tv[136] = vi.findViewById(R.id.tv136);
        tv[137] = vi.findViewById(R.id.tv137);
        tv[138] = vi.findViewById(R.id.tv138);
        tv[139] = vi.findViewById(R.id.tv139);

        // added
        tv[140] = vi.findViewById(R.id.tv140);
        tv[141] = vi.findViewById(R.id.tv141);
    }

    public void setTextView(){
        // setting the text
        for(int i=0; i<142;i++)
            try {
                ((TextView)tv[i]).setText(ques[i][MainActivity.lang]);
            } catch (Exception e){
                try {
                    ((RadioButton) tv[i]).setText(ques[i][MainActivity.lang]);
                }
                catch(Exception ex){
                    try {
                        ((android.support.v7.widget.AppCompatTextView) tv[i]).setText(ques[i][MainActivity.lang]);
                    } catch (Exception ee){
                        Log.e("buggMob",String.valueOf(i));
                    }
                }
            }
    }

    public void toHindi(){
        // converting to hindi
        for (int i=0;i < 142; i++){
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
        for (int i=0;i< 142;i++){
            try {
                ((TextView)tv[i]).setText(ques[i][1]);
            } catch (Exception e){
                try {
                    ((RadioButton) tv[i]).setText(ques[i][1]);
                }
                catch(Exception ex){
                    try {
                        ((android.support.v7.widget.AppCompatTextView) tv[i]).setText(ques[i][1]);
                    }
                    catch (Exception ee){}
                }
            }
        }
    }

    EditText[] t = new EditText[35];
    RadioGroup[] rg = new RadioGroup[22];
    RadioButton[] rb = new RadioButton[8];

    public int save(){
        toEnglish();
        // save the data to the database
        if(!validate()) {
            setTextView();
            return 1;
        }
        JSONObject send = new JSONObject();
        try {
            send.put("url","/newMobilise");
            send.put("userName",MainActivity.user);

            JSONObject[] answers = new JSONObject[50];

            int i=0,qid=800,j=0;

            for(i=0;i<50;i++){
                answers[i] = new JSONObject();
            }

            for (i=0;i<=12;i++){
                answers[i].put("qid",qid);
                answers[i].put("response",t[i].getText());
                qid++;
            }
            answers[15].put("qid",815);
            answers[15].put("response",t[13].getText().toString());
            answers[21].put("qid",821);
            answers[21].put("response",t[14].getText().toString());
            qid = 826;
            j=15;
            for (i=26;i<=32;i++){
                answers[i].put("qid",qid);
                answers[i].put("response",t[j].getText());
                qid++;
                j++;
            }
            qid = 836;
            j=22;
            for (i=36;i<=39;i++){
                answers[i].put("qid",qid);
                answers[i].put("response",t[j].getText());
                qid++;
                j++;
            }

            RadioButton rv;
            qid = 813;
            j=0;
            for(i=13;i<=20;i++){
                if(qid == 819 ){
                    qid++;
                    j++;
                    continue;
                }
                rv = (RadioButton) vi.findViewById(rg[j].getCheckedRadioButtonId());
                answers[i].put("qid",qid);
                answers[i].put("response",rv.getText().toString());
                qid++;
                j++;
            }
            rv = (RadioButton) vi.findViewById(rg[7].getCheckedRadioButtonId());
            answers[22].put("qid",822);
            answers[22].put("response",rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[10].getCheckedRadioButtonId());
            answers[25].put("qid",825);
            answers[25].put("response",rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[12].getCheckedRadioButtonId());
            answers[34].put("qid",834);
            answers[34].put("response",rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[13].getCheckedRadioButtonId());
            answers[35].put("qid",835);
            answers[35].put("response",rv.getText().toString());

            rv = (RadioButton) vi.findViewById(rg[14].getCheckedRadioButtonId());
            answers[40].put("qid",840);
            answers[40].put("response",rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[18].getCheckedRadioButtonId());
            answers[44].put("qid",844);
            answers[44].put("response",rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[19].getCheckedRadioButtonId());
            answers[45].put("qid",845);
            answers[45].put("response",rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[20].getCheckedRadioButtonId());
            answers[46].put("qid",846);
            answers[46].put("response",rv.getText().toString());



            if(rb[0].isChecked()){
                answers[19].put("qid",819);
                answers[19].put("response",t[26].getText().toString());
            }
            else {
                rv = (RadioButton) vi.findViewById(rg[5].getCheckedRadioButtonId());
                answers[19].put("qid",819);
                answers[19].put("response",rv.getText().toString());
            }
            if(rb[1].isChecked()){
                answers[23].put("qid",823);
                answers[23].put("response",t[27].getText().toString());
            }
            else {
                rv = (RadioButton) vi.findViewById(rg[8].getCheckedRadioButtonId());
                answers[23].put("qid",823);
                answers[23].put("response",rv.getText().toString());
            }
            if(rb[2].isChecked()){
                answers[24].put("qid",824);
                answers[24].put("response",t[28].getText().toString());
            }
            else {
                rv = (RadioButton) vi.findViewById(rg[9].getCheckedRadioButtonId());
                answers[24].put("qid",824);
                answers[24].put("response",rv.getText().toString());
            }
            if(rb[3].isChecked()){
                answers[33].put("qid",833);
                answers[33].put("response",t[29].getText().toString());
            }
            else {
                rv = (RadioButton) vi.findViewById(rg[11].getCheckedRadioButtonId());
                answers[33].put("qid",833);
                answers[33].put("response",rv.getText().toString());
            }
            if(rb[4].isChecked()){
                answers[41].put("qid",841);
                answers[41].put("response",t[30].getText().toString());
            }
            else {
                rv = (RadioButton) vi.findViewById(rg[15].getCheckedRadioButtonId());
                answers[41].put("qid",841);
                answers[41].put("response",rv.getText().toString());
            }
            if(rb[5].isChecked()){
                answers[42].put("qid",842);
                answers[42].put("response",t[31].getText().toString());
            }
            else {
                rv = (RadioButton) vi.findViewById(rg[16].getCheckedRadioButtonId());
                answers[42].put("qid",842);
                answers[42].put("response",rv.getText().toString());
            }
            if(rb[6].isChecked()){
                answers[43].put("qid",843);
                answers[43].put("response",t[32].getText().toString());
            }
            else {
                rv = (RadioButton) vi.findViewById(rg[17].getCheckedRadioButtonId());
                answers[43].put("qid",843);
                answers[43].put("response",rv.getText().toString());
            }

            answers[47].put("qid",847);
            answers[47].put("response",t[33].getText().toString());
            answers[48].put("qid",848);
            answers[48].put("response",t[34].getText().toString());

            JSONArray ja = new JSONArray();
            for(i=0;i<=48;i++)
                ja.put(answers[i]);
            send.put("answers",ja);

            SQLiteDatabase db = getContext().openOrCreateDatabase("adharShila", Context.MODE_PRIVATE,null);
            ContentValues cv = new ContentValues();
            cv.put("ENTRY",String.valueOf(MainActivity.subCount+1));
            cv.put("RESPONSE",send.toString());
            db.insert("UPLOAD",null,cv);

            setTextView();
            return 0;
        } catch (JSONException e) {
            setTextView();
            e.printStackTrace();
            return 2;
        }
    }

    public void getViews(){
        t[0] = (EditText) vi.findViewById(R.id.i800);
        t[1] = (EditText) vi.findViewById(R.id.i801);
        t[2] = (EditText) vi.findViewById(R.id.i802);
        t[3] = (EditText) vi.findViewById(R.id.i803);
        t[4] = (EditText) vi.findViewById(R.id.i804);
        t[5] = (EditText) vi.findViewById(R.id.i805);
        t[6] = (EditText) vi.findViewById(R.id.i806);
        t[7] = (EditText) vi.findViewById(R.id.i807);
        t[8] = (EditText) vi.findViewById(R.id.i808);
        t[9] = (EditText) vi.findViewById(R.id.i809);
        t[10] = (EditText) vi.findViewById(R.id.i810);
        t[11] = (EditText) vi.findViewById(R.id.i811);
        t[12] = (EditText) vi.findViewById(R.id.i812);
        t[13] = (EditText) vi.findViewById(R.id.i815);
        t[14] = (EditText) vi.findViewById(R.id.i821);
        t[15] = (EditText) vi.findViewById(R.id.i826);
        t[16] = (EditText) vi.findViewById(R.id.i827);
        t[17] = (EditText) vi.findViewById(R.id.i828);
        t[18] = (EditText) vi.findViewById(R.id.i829);
        t[19] = (EditText) vi.findViewById(R.id.i830);
        t[20] = (EditText) vi.findViewById(R.id.i831);
        t[21] = (EditText) vi.findViewById(R.id.i832);
        t[22] = (EditText) vi.findViewById(R.id.i836);
        t[23] = (EditText) vi.findViewById(R.id.i837);
        t[24] = (EditText) vi.findViewById(R.id.i838);
        t[25] = (EditText) vi.findViewById(R.id.i839);

        //others radio
        t[26] = (EditText) vi.findViewById(R.id.i8190);
        t[27] = (EditText) vi.findViewById(R.id.i8230);
        t[28] = (EditText) vi.findViewById(R.id.i8240);
        t[29] = (EditText) vi.findViewById(R.id.i8330);
        t[30] = (EditText) vi.findViewById(R.id.i8410);
        t[31] = (EditText) vi.findViewById(R.id.i8420);
        t[32] = (EditText) vi.findViewById(R.id.i8430);

        t[33] = (EditText) vi.findViewById(R.id.i847);
        t[34] = (EditText) vi.findViewById(R.id.i848);

        // radio groups
        rg[0] = (RadioGroup) vi.findViewById(R.id.i813);
        rg[1] = (RadioGroup) vi.findViewById(R.id.i814);
        rg[2] = (RadioGroup) vi.findViewById(R.id.i816);
        rg[3] = (RadioGroup) vi.findViewById(R.id.i817);
        rg[4] = (RadioGroup) vi.findViewById(R.id.i818);
        rg[5] = (RadioGroup) vi.findViewById(R.id.i819);
        rg[6] = (RadioGroup) vi.findViewById(R.id.i820);
        rg[7] = (RadioGroup) vi.findViewById(R.id.i822);
        rg[8] = (RadioGroup) vi.findViewById(R.id.i823);
        rg[9] = (RadioGroup) vi.findViewById(R.id.i824);
        rg[10] = (RadioGroup) vi.findViewById(R.id.i825);
        rg[11] = (RadioGroup) vi.findViewById(R.id.i833);
        rg[12] = (RadioGroup) vi.findViewById(R.id.i834);
        rg[13] = (RadioGroup) vi.findViewById(R.id.i835);
        rg[14] = (RadioGroup) vi.findViewById(R.id.i840);
        rg[15] = (RadioGroup) vi.findViewById(R.id.i841);
        rg[16] = (RadioGroup) vi.findViewById(R.id.i842);
        rg[17] = (RadioGroup) vi.findViewById(R.id.i843);
        rg[18] = (RadioGroup) vi.findViewById(R.id.i844);
        rg[19] = (RadioGroup) vi.findViewById(R.id.i845);
        rg[20] = (RadioGroup) vi.findViewById(R.id.i846);

        rb[0] = (RadioButton) vi.findViewById(R.id.tv48);
        rb[1] = (RadioButton) vi.findViewById(R.id.tv67);
        rb[2] = (RadioButton) vi.findViewById(R.id.tv72);
        rb[3] = (RadioButton) vi.findViewById(R.id.tv97);
        rb[4] = (RadioButton) vi.findViewById(R.id.tv116);
        rb[5] = (RadioButton) vi.findViewById(R.id.tv120);
        rb[6] = (RadioButton) vi.findViewById(R.id.tv124);

        int i;
        int j=26;
        for(i=0;i<=6;i++){
            final int k = j;
            rb[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                        t[k].setEnabled(true);
                    else
                        t[k].setEnabled(false);
                }
            });
            j++;
        }

    }

    public Boolean validate(){
        for(int i=0;i<=25;i++){
            if(t[i].getText().toString().isEmpty())
                return false;
        }
        if( t[33].getText().toString().isEmpty() || t[34].getText().toString().isEmpty())
            return false;
        int i=0,j=26;
        for(i=0;i<=6;i++){
            if(rb[i].isChecked() && t[j].getText().toString().isEmpty())
                return false;
            j++;
        }
        return true;
    }

    private void addQuestion(){
        //Question ID
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
        ques[63][0] = "";
        ques[64][0] = "";
        ques[65][0] = "";
        ques[66][0] = "";
        ques[67][0] = "";
        ques[68][0] = "";
        ques[69][0] = "";
        ques[70][0] = "";
        ques[71][0] = "";
        ques[72][0] = "";
        ques[73][0] = "";
        ques[74][0] = "";
        ques[75][0] = "";
        ques[76][0] = "";
        ques[77][0] = "";
        ques[78][0] = "";
        ques[79][0] = "";
        ques[80][0] = "";
        ques[81][0] = "";
        ques[82][0] = "";
        ques[83][0] = "";
        ques[84][0] = "";
        ques[85][0] = "";
        ques[86][0] = "";
        ques[87][0] = "";
        ques[88][0] = "";
        ques[89][0] = "";
        ques[90][0] = "";
        ques[91][0] = "";
        ques[92][0] = "";
        ques[93][0] = "";
        ques[94][0] = "";
        ques[95][0] = "";
        ques[96][0] = "";
        ques[97][0] = "";
        ques[98][0] = "";
        ques[99][0] = "";
        ques[100][0] = "";
        ques[101][0] = "";
        ques[102][0] = "";
        ques[103][0] = "";
        ques[104][0] = "";
        ques[105][0] = "";
        ques[106][0] = "";
        ques[107][0] = "";
        ques[108][0] = "";
        ques[109][0] = "";
        ques[110][0] = "";
        ques[111][0] = "";
        ques[112][0] = "";
        ques[113][0] = "";
        ques[114][0] = "";
        ques[115][0] = "";
        ques[116][0] = "";
        ques[117][0] = "";
        ques[118][0] = "";
        ques[119][0] = "";
        ques[120][0] = "";
        ques[121][0] = "";
        ques[122][0] = "";
        ques[123][0] = "";
        ques[124][0] = "";
        ques[125][0] = "";
        ques[126][0] = "";
        ques[127][0] = "";
        ques[128][0] = "";
        ques[129][0] = "";
        ques[130][0] = "";
        ques[131][0] = "";
        ques[132][0] = "";
        ques[133][0] = "";
        ques[134][0] = "";
        ques[135][0] = "";
        ques[136][0] = "";
        ques[137][0] = "";
        ques[138][0] = "";
        ques[139][0] = "";

        // English
        ques[0][1] = "1. Name:";
        ques[1][1] = "2. Husband's / Father's Name / Mother’s Name:";
        ques[2][1] = "3. Contact Number: ";
        ques[3][1] = "4. Aadhaar card number (Optional):";
        ques[4][1] = "5. Permanent Address: ";
        ques[5][1] = "House number/Gali number";
        ques[6][1] = "Village/City";
        ques[7][1] = "District";
        ques[8][1] = "State";
        ques[9][1] = "6. Current Address: (Option - same as above) ";
        ques[10][1] = "House number/Gali number";
        ques[11][1] = "Village/City";
        ques[12][1] = "District ";
        ques[13][1] = "State";
        ques[14][1] = "7. Date of birth (DD/MM/YYYY):";
        ques[15][1] = "8. Place of birth (Name of district and state):";
        ques[16][1] = "9. Educational Qualification: (If currently in school, proceed to next question.)";
        ques[17][1] = "10th (High School) ";
        ques[18][1] = "12th (Intermediate)";
        ques[19][1] = "Graduate";
        ques[20][1] = "Post Graduate";
        ques[21][1] = "Other";
        ques[22][1] = "10. Which of the following are you currently enrolled in?";
        ques[23][1] = "Private school";
        ques[24][1] = "Government school";
        ques[25][1] = "Private college/University";
        ques[26][1] = "Government college";
        ques[27][1] = "NIOS (National Institute of Open Learning)";
        ques[28][1] = "SOL (School of Open Learning)";
        ques[29][1] = "11. Are you from this village or did you migrate here? (If local, skip to Q16) ";
        ques[30][1] = "12. How often have you relocated in past 5 years?";
        ques[31][1] = "Once";
        ques[32][1] = "Twice";
        ques[33][1] = "Three times or more";
        ques[34][1] = "13. Are you a first or second-generation migrant to this area?";
        ques[35][1] = "First generation";
        ques[36][1] = "Second generation";
        ques[37][1] = "N/A";
        ques[38][1] = "14. Who did you migrate to the city/village with?";
        ques[39][1] = "Family";
        ques[40][1] = "Friends";
        ques[41][1] = "Self";
        ques[42][1] = "Marriage";
        ques[43][1] = "N/A";
        ques[44][1] = "15. If you had to relocate, what was the main reason for it?";
        ques[45][1] = "Employment";
        ques[46][1] = "Family reasons. Please elaborate.";
        ques[47][1] = "Marriage";
        ques[48][1] = "Other (please specify in under 20 words)";
        ques[49][1] = "16. Number of family members (including self):";
        ques[50][1] = "2";
        ques[51][1] = "3";
        ques[52][1] = "4";
        ques[53][1] = "5";
        ques[54][1] = ">5";
        ques[55][1] = "17. Is there any member in your family who is dependable on you? If yes, then please specify?";
        ques[56][1] = "18. How many members of your family are working?";
        ques[57][1] = "1";
        ques[58][1] = "2";
        ques[59][1] = "3";
        ques[60][1] = "4";
        ques[61][1] = ">4";
        ques[62][1] = "19. Who is the primary breadwinner in your family?";
        ques[63][1] = "Father";
        ques[64][1] = "Mother";
        ques[65][1] = "Husband";
        ques[66][1] = "Self";
        ques[67][1] = "Others (Please Specify)";
        ques[68][1] = "20. What is the nature of the work he/she does?";
        ques[69][1] = "Self (Business)";
        ques[70][1] = "Private Job";
        ques[71][1] = "Government Job";
        ques[72][1] = "Others (please specify farming, etc)";
        ques[73][1] = "21. What is the estimated total monthly income of your family?";
        ques[74][1] = "Below 5000";
        ques[75][1] = "5000 – 10000";
        ques[76][1] = "10,000 – 20,000";
        ques[77][1] = "20,000 – 50,000";
        ques[78][1] = "Above 50,000";
        ques[79][1] = "22. Have you been previously employed? Yes/No (If No, skip to Q24)";
        ques[80][1] = "23. Please provide your most recent employment history:";
        ques[81][1] = "Designation /Post:";
        ques[82][1] = "Description:";
        ques[83][1] = "Name of company and contact details:";
        ques[84][1] = "Duration: From - To";
        ques[85][1] = "Last salary drawn (Per month, in numeric value only):";
        ques[86][1] = "24. Are you interested in working? Yes/No   ";
        ques[87][1] = "25. Which remunerative skills do you know?";
        ques[88][1] = "Farming";
        ques[89][1] = "Weaving";
        ques[90][1] = "Dyeing";
        ques[91][1] = "Knitting";
        ques[92][1] = "Crochet";
        ques[93][1] = "Embroidery";
        ques[94][1] = "Patternmaking";
        ques[95][1] = "Sewing";
        ques[96][1] = "Block printing";
        ques[97][1] = "Others (please specify)";
        ques[98][1] = "26. How many hours can you allocate to remunerative activities?";
        ques[99][1] = "2 – 4 hours";
        ques[100][1] = "4 – 6 hours";
        ques[101][1] = "6 – 8 hours";
        ques[102][1] = "27. Have you trained anywhere in tailoring skills before this? (If no, skip to Q28)";
        ques[103][1] = "Yes";
        ques[104][1] = "No";
        ques[105][1] = "28. Please provide:";
        ques[106][1] = "Name and address of the organization:";
        ques[107][1] = "Name of the course: ";
        ques[108][1] = "29. Would you be interested in a tailoring class where you can learn the skills to make money? Yes/No (If no, skip to Q34)";
        ques[109][1] = "30. If yes, how much would you be willing to pay for a high quality class?";
        ques[110][1] = "31. Which time slot works for you for the class?";
        ques[111][1] = "Morning";
        ques[112][1] = "Afternoon";
        ques[113][1] = "32. Are you comfortable commuting outside your neighborhood for training?";
        ques[114][1] = "Yes";
        ques[115][1] = "No";
        ques[116][1] = "Depends on (please elaborate in 20 words)";
        ques[117][1] = "33. Are you comfortable commuting outside your neighborhood for work?";
        ques[118][1] = "Yes";
        ques[119][1] = "No";
        ques[120][1] = "Depends on (please elaborate in 20 words)";
        ques[121][1] = "34. Do you have your family’s support to work outside your neighborhood?";
        ques[122][1] = "Yes";
        ques[123][1] = "No";
        ques[124][1] = "Depends on (please elaborate in 20 words)";
        ques[125][1] = "35. Do you have a sewing machine at home? (If No, skip to Q37)";
        ques[126][1] = "Yes";
        ques[127][1] = "No";
        ques[128][1] = "36. What type of sewing machine is it?";
        ques[129][1] = "Hand machine";
        ques[130][1] = "Manual umbrella machine";
        ques[131][1] = "Motorized umbrella machine";
        ques[132][1] = "Industrial (Juki) machine";
        ques[133][1] = "37. Have you faced any of the following issues before in getting employed or continuing in your job?";
        ques[134][1] = "Lack of family approval/support";
        ques[135][1] = "Lack of qualification";
        ques[136][1] = "Lack of skill";
        ques[137][1] = "Cultural barriers such as gender inequalityv";
        ques[138][1] = "Distance from home";
        ques[139][1] = "Lack of opportunities";

        // added
        ques[140][1] = "PIN Code:";
        ques[141][1] = "PIN Code:";

        // Hindi
        ques[0][2] = "1. नाम:";
        ques[1][2] = "2. पति का / पिता का नाम / माता का नाम:";
        ques[2][2] = "3. संपर्क नंबर:";
        ques[3][2] = "4. आधार कार्ड नंबर (वैकल्पिक):";
        ques[4][2] = "5. स्थायी पता:";
        ques[5][2] = "हाउस नंबर / गली नंबर - ";
        ques[6][2] = "ग्राम / नगर - ";
        ques[7][2] = "जिला - ";
        ques[8][2] = "राज्य -";
        ques[9][2] = "6. वर्तमान पता: (विकल्प - ऊपर के रूप में ही)";
        ques[10][2] = "हाउस नंबर / गली नंबर -";
        ques[11][2] = "ग्राम / नगर -";
        ques[12][2] = "जिला -";
        ques[13][2] = "राज्य -";
        ques[14][2] = "7. जन्म की तिथि (दिनांक / महीना / बर्ष):";
        ques[15][2] = "8. जन्म स्थान (जिला और राज्य का नाम):";
        ques[16][2] = "9. शैक्षिक योग्यता: (यदि अभी स्कूल में है, अगला सवाल करने के लिए आगे बढ़ें।)";
        ques[17][2] = "10 वीं (हाई स्कूल)";
        ques[18][2] = "12 वीं (इंटरमीडिएट)";
        ques[19][2] = "ग्रेजुएट";
        ques[20][2] = "पोस्ट ग्रेजुएट";
        ques[21][2] = "अन्य";
        ques[22][2] = "10. निम्न में से अभी आप कहा पढ़ रहे हैं?";
        ques[23][2] = "निजी स्कूल ";
        ques[24][2] = "सरकारी स्कूल";
        ques[25][2] = "निजी कॉलेज/विश्वविद्यालय ";
        ques[26][2] = "सरकारी कॉलेज";
        ques[27][2] = "एनआईओएस (ओपन लर्निंग के राष्ट्रीय संस्थान)";
        ques[28][2] = "एसओएल (ओपन लर्निंग के स्कूल)";
        ques[29][2] = "11. क्या आप इस गांव से हैं या आपने यहाँ विस्थापित किया? (अगर स्थानीय हैं तो प्रश्न16 छोड़ें)";
        ques[30][2] = "12. कितनी बार आप पिछले 5 वर्षों में स्थानांतरित कर चुके है?";
        ques[31][2] = "एक बार";
        ques[32][2] = "दो बार";
        ques[33][2] = "तीन बार या उससे अधिक";
        ques[34][2] = "13. आप इस क्षेत्र के लिए पहली या दूसरी पीढ़ी के आप्रवासी हैं?";
        ques[35][2] = "पहली पीढ़ी";
        ques[36][2] = "दूसरी पीढ़ी";
        ques[37][2] = "लागू नहीं";
        ques[38][2] = "14. तुमने किसके साथ शहर / गांव को विस्थापित किया?";
        ques[39][2] = "परिवार";
        ques[40][2] = "दोस्त";
        ques[41][2] = "स्वयं";
        ques[42][2] = "विवाह";
        ques[43][2] = "लागू नहीं";
        ques[44][2] = "15. अगर आपके स्थानांतरित किया था, तो ऐसा करने का मुख्य कारण क्या था? ";
        ques[45][2] = "रोजगार";
        ques[46][2] = "पारिवारिक कारण। कृपया विस्तार से बताएं।";
        ques[47][2] = "विवाह";
        ques[48][2] = "अन्य (20 शब्दों के तहत निर्दिष्ट करें)";
        ques[49][2] = "16. परिवार के सदस्यों की संख्या (आत्म सहित)। ";
        ques[50][2] = "2";
        ques[51][2] = "3";
        ques[52][2] = "4";
        ques[53][2] = "5";
        ques[54][2] = ">5";
        ques[55][2] = "17. क्या आपके परिवार में कोई है, जिस पर आपको निरंतर ध्यान देने की जरूरत है? (यदि हाँ तो कृपया विस्तार से बताएं)";
        ques[56][2] = "18. आपके परिवार के कितने सदस्यों काम कर रहे हैं?";
        ques[57][2] = "1";
        ques[58][2] = "2";
        ques[59][2] = "3";
        ques[60][2] = "4";
        ques[61][2] = ">4";
        ques[62][2] = "19. आपके परिवार में प्राथमिक कमानेवाला कौन है? ";
        ques[63][2] = "पिता";
        ques[64][2] = "मां";
        ques[65][2] = "पति";
        ques[66][2] = "स्वयं";
        ques[67][2] = "अन्य (कृपया निर्दिष्ट करें)";
        ques[68][2] = "20. काम की प्रकृति क्या है जो वो करते है?";
        ques[69][2] = "स्वयं (बिजनेस)";
        ques[70][2] = "निजी नौकरी";
        ques[71][2] = "सरकारी नौकरी";
        ques[72][2] = "अन्य (खेती, आदि निर्दिष्ट करें)";
        ques[73][2] = "21. आपके परिवार की कुल अनुमानित मासिक आय क्या है?";
        ques[74][2] = "5000 से नीचे";
        ques[75][2] = "5000 - 10000";
        ques[76][2] = "10,000 - 20,000";
        ques[77][2] = "20,000 - 50,000";
        ques[78][2] = "50,000 से ऊपर";
        ques[79][2] = "22. यदि आप पहले से नियोजित है? हां / नहीं (नहीं हैं तो प्रश्न 24 को छोड़े)";
        ques[80][2] = "23. कृपया आपके सबसे हाल के रोजगार का विवरण प्रदान करें:";
        ques[81][2] = "पदनाम / पोस्ट: ";
        ques[82][2] = "विवरण:";
        ques[83][2] = "कंपनी का नाम और संपर्क विवरण:";
        ques[84][2] = "अवधि से  ";
        ques[85][2] = "अंतिम वेतन (प्रति माह, संख्यात्मक मूल्य में केवल):";
        ques[86][2] = "24. क्या आप काम करने में रुचि रखते हैं? हाँ / नही :";
        ques[87][2] = "25. लाभकारी कौशल जो आप जानते हैं?";
        ques[88][2] = "खेती।";
        ques[89][2] = "बुनना";
        ques[90][2] = "डाइंग";
        ques[91][2] = "ई बुनाई";
        ques[92][2] = "क्रोशिए";
        ques[93][2] = "कढ़ाई";
        ques[94][2] = "पैटर्न मेकिंग ";
        ques[95][2] = "सिलाई";
        ques[96][2] = "ब्लॉक मुद्रण";
        ques[97][2] = "अन्य (कृपया स्पष्ट करें)";
        ques[98][2] = "26. कितने घंटे तुम लाभकारी गतिविधियों के लिए आवंटित कर सकते हो?";
        ques[99][2]  = "2 – 4 घंटे";
        ques[100][2] = "4 – 6 घंटे";
        ques[101][2] = "6 – 8 घंटे";
        ques[102][2] = "27. क्या आपने इस से पहले कौशल सिलाई में कहीं भी प्रशिक्षण किया है? (यदि नहीं, 28 को छोड़";
        ques[103][2] = "हां";
        ques[104][2] = "नहीं";
        ques[105][2] = "28. प्रदान करें";
        ques[106][2] = "नाम और संगठन का पता:";
        ques[107][2] = "पाठ्यक्रम का नाम:";
        ques[108][2] = "29. क्या आप एक सिलाई कक्षा में रुचि रखते है जहां पैसा कमाने का कौशल सिखाया जाता है? (यदि नहीं, Q34 को छोड़ें)";
        ques[109][2] = "30. यदि हाँ, आप एक उच्च गुणवत्ता वाले वर्ग के लिए कितना भुगतान कर सकते हो? _______";
        ques[110][2] = "31. कौन सा समय स्लॉट आप के लिए काम करेगा?";
        ques[111][2] = "सुबह";
        ques[112][2] = "दोपहर";
        ques[113][2] = "32. आप प्रशिक्षण के लिए आपके पड़ोस के बाहर आराम से आ सकते हैं?";
        ques[114][2] = "हाँ ";
        ques[115][2] = "नहीं";
        ques[116][2] = "निर्भर करता है (20 शब्दों में विस्तृत कृपया)";
        ques[117][2] = "33. क्या काम के लिए आपके पड़ोस के बाहर जाना आरामदायक हो पाएगा?";
        ques[118][2] = "हाँ ";
        ques[119][2] = "नहीं";
        ques[120][2] = "निर्भर करता है (20 शब्दों में विस्तृत कृपया)";
        ques[121][2] = "34. क्या आपके पड़ोस के बाहर काम करने के लिए आपके परिवार का समर्थन है?";
        ques[122][2] = "हाँ ";
        ques[123][2] = "नहीं";
        ques[124][2] = "निर्भर करता है (20 शब्दों में विस्तृत कृपया)";
        ques[125][2] = "35. आपके घर पर एक सिलाई मशीन है? (यदि नहीं, Q37 को छोड़)";
        ques[126][2] = "हाँ ";
        ques[127][2] = "नहीं";
        ques[128][2] = "36. यह सिलाई मशीन किस तरह की है?";
        ques[129][2] = "हाथ मशीन";
        ques[130][2] = "हाथ अम्ब्रेला मशीन";
        ques[131][2] = "मोटोराइज्ड अम्ब्रेला मशीन";
        ques[132][2] = "औद्योगिक (जुकी) मशीन";
        ques[133][2] = "37. क्या आपको निम्न में से कोई अवरोध का सामना करना पड़ा था कार्यरत या आपके काम में?";
        ques[134][2] = "परिवार अनुमोदन / समर्थन";
        ques[135][2] = "योग्यता का अभाव।";
        ques[136][2] = "कौशल की कमी";
        ques[137][2] = "सांस्कृतिक बाधा जैसा लिंग असमानता / सांस्कृतिक बाधाओं।";
        ques[138][2] = "घर से दूरी।";
        ques[139][2] = "अवसरों की कमी";

        /// added
        ques[140][2] = "पिन कोड";
        ques[141][2] = "पिन कोड";

    }
}