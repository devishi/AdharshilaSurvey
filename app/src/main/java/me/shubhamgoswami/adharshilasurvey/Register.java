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
public class Register extends Fragment {

    public String[][] ques = new String[152][3];

    View[] tv = new View[153];

    View vi;

    public Register() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vi = inflater.inflate(R.layout.fragment_register, container, false);
        addQuestion();
        getTextView();
        setTextView();
        getViews();

        t[23].setEnabled(false);
        t[24].setEnabled(false);
        t[25].setEnabled(false);
        t[26].setEnabled(false);
        t[27].setEnabled(false);
        t[28].setEnabled(false);

        return vi;
    }

    public void toHindi(){
        // converting to hindi
        for (int i=0;i < 152; i++){
            try {
                ((TextView)tv[i]).setText(ques[i][2]);
            } catch (Exception e){
                ((RadioButton) tv[i]).setText(ques[i][2]);
            }
        }
    }

    public void toEnglish(){
        for (int i=0;i<152;i++){
            try {
                ((TextView)tv[i]).setText(ques[i][1]);
            } catch (Exception e){
                ((RadioButton) tv[i]).setText(ques[i][1]);
            }
        }
    }

    public int save(){
        toEnglish();
        if(!validate()){
            setTextView();
            return 1;
        }
        JSONObject send = new JSONObject();
        try {
            send.put("userName", MainActivity.user);

            send.put("url","/newRegister");

            int i,j,qid = 501;
            JSONObject[] entries = new JSONObject[52];
            for(i=0;i<52;i++){
                entries[i] = new JSONObject();
            }
            j=0;
            for(i=1;i<15;i++){
                entries[i].put("qid",qid);
                entries[i].put("response",t[j].getText().toString());
                qid++;
                j++;
            }
            qid = 526;
            j=14;
            for(i=26;i<32;i++){
                if(j==19){
                    j++;
                    qid++;
                    continue;
                }
                entries[i].put("qid",qid);
                entries[i].put("response",t[j].getText().toString());
                j++;
                qid++;
            }

            entries[34].put("qid",534);
            entries[34].put("response",t[20].getText().toString());

            entries[35].put("qid",535);
            entries[35].put("response",t[21].getText().toString());

            entries[45].put("qid",545);
            entries[45].put("response",t[22].getText().toString());

            RadioButton rv;
            j=0;
            qid = 515;
            for(i=15; i<=19; i++){
                rv = (RadioButton) vi.findViewById(rg[j].getCheckedRadioButtonId());
                entries[i].put("qid",qid);
                entries[i].put("response", rv.getText().toString());
                qid++;
                j++;
            }

            rv = (RadioButton) vi.findViewById(rg[6].getCheckedRadioButtonId());
            entries[21].put("qid",521);
            entries[21].put("response", rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[7].getCheckedRadioButtonId());
            entries[22].put("qid",522);
            entries[22].put("response", rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[9].getCheckedRadioButtonId());
            entries[24].put("qid",524);
            entries[24].put("response", rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[10].getCheckedRadioButtonId());
            entries[25].put("qid",525);
            entries[25].put("response", rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[11].getCheckedRadioButtonId());
            entries[32].put("qid",532);
            entries[32].put("response", rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[12].getCheckedRadioButtonId());
            entries[33].put("qid",533);
            entries[33].put("response", rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[13].getCheckedRadioButtonId());
            entries[36].put("qid",536);
            entries[36].put("response", rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[14].getCheckedRadioButtonId());
            entries[37].put("qid",537);
            entries[37].put("response", rv.getText().toString());
            //
            rv = (RadioButton) vi.findViewById(rg[18].getCheckedRadioButtonId());
            entries[41].put("qid",541);
            entries[41].put("response", rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[19].getCheckedRadioButtonId());
            entries[42].put("qid",542);
            entries[42].put("response", rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[20].getCheckedRadioButtonId());
            entries[43].put("qid",543);
            entries[43].put("response", rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[21].getCheckedRadioButtonId());
            entries[44].put("qid",544);
            entries[44].put("response", rv.getText().toString());
            rv = (RadioButton) vi.findViewById(rg[22].getCheckedRadioButtonId());
            entries[46].put("qid",546);
            entries[46].put("response", rv.getText().toString());

            if(rb[0].isChecked()){
                entries[20].put("qid",520);
                entries[20].put("response", t[23].getText().toString());
            }
            else if(rb[1].isChecked()){
                entries[20].put("qid",520);
                entries[20].put("response", t[28].getText().toString());
            }
            else{
                rv = (RadioButton) vi.findViewById(rg[5].getCheckedRadioButtonId());
                entries[20].put("qid",520);
                entries[20].put("response", rv.getText().toString());
            }

            if(rb[2].isChecked()){
                entries[23].put("qid",523);
                entries[23].put("response", t[24].getText().toString());
            }
            else{
                rv = (RadioButton) vi.findViewById(rg[8].getCheckedRadioButtonId());
                entries[23].put("qid",523);
                entries[23].put("response", rv.getText().toString());
            }
            if(rb[3].isChecked()){
                entries[38].put("qid",538);
                entries[38].put("response", t[25].getText().toString());
            }
            else{
                rv = (RadioButton) vi.findViewById(rg[15].getCheckedRadioButtonId());
                entries[38].put("qid",538);
                entries[38].put("response", rv.getText().toString());
            }
            if(rb[4].isChecked()){
                entries[39].put("qid",539);
                entries[39].put("response", t[26].getText().toString());
            }
            else{
                rv = (RadioButton) vi.findViewById(rg[16].getCheckedRadioButtonId());
                entries[39].put("qid",539);
                entries[39].put("response", rv.getText().toString());
            }
            if(rb[5].isChecked()){
                entries[40].put("qid",540);
                entries[40].put("response", t[27].getText().toString());
            }
            else{
                rv = (RadioButton) vi.findViewById(rg[17].getCheckedRadioButtonId());
                entries[40].put("qid",540);
                entries[40].put("response", rv.getText().toString());
            }

            rv = (RadioButton) vi.findViewById(rg[23].getCheckedRadioButtonId());
            entries[47].put("qid",547);
            entries[47].put("response", rv.getText().toString());

            JSONArray ja = new JSONArray();

            for(i=1;i<48;i++){
                ja.put(entries[i]);
            }

            send.put("entries",ja);

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
        tv[140] = vi.findViewById(R.id.tv140);
        tv[141] = vi.findViewById(R.id.tv141);
        tv[142] = vi.findViewById(R.id.tv142);
        tv[143] = vi.findViewById(R.id.tv143);
        tv[144] = vi.findViewById(R.id.tv144);
        tv[145] = vi.findViewById(R.id.tv145);
        tv[146] = vi.findViewById(R.id.tv146);
        tv[147] = vi.findViewById(R.id.tv147);
        tv[148] = vi.findViewById(R.id.tv148);
        tv[149] = vi.findViewById(R.id.tv149);
        tv[150] = vi.findViewById(R.id.tv150);
        tv[151] = vi.findViewById(R.id.tv151);
    }

    public void setTextView(){
        for(int i=0;i <152; i++) {
            try {
                ((TextView) tv[i]).setText(ques[i][MainActivity.lang]);
            } catch (Exception e) {
                ((RadioButton) tv[i]).setText(ques[i][MainActivity.lang]);
            }
        }
    }

    public void addQuestion(){
        // Question ID
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
        ques[140][0] = "";
        ques[141][0] = "";
        ques[142][0] = "";
        ques[143][0] = "";
        ques[144][0] = "";
        ques[145][0] = "";
        ques[146][0] = "";
        ques[147][0] = "";
        ques[148][0] = "";
        ques[149][0] = "";
        ques[150][0] = "";
        ques[151][0] = "";

        // English
        ques[0][1] = "Name:";
        ques[1][1] = "Husband's / Father's Name /Mother’s name:";
        ques[2][1] = "Contact number";
        ques[3][1] = "Aadhaar Card #";
        ques[4][1] = "Current Address";
        ques[5][1] = "House number/Gali number";
        ques[6][1] = "Village/City";
        ques[7][1] = "District";
        ques[8][1] = "State";
        ques[9][1] = "Permanent Address";
        ques[10][1] = "House number/Gali number";
        ques[11][1] = "Village/City";
        ques[12][1] = "District";
        ques[13][1] = "State";
        ques[14][1] = "Date of birth (DD/MM/YYYY):";
        ques[15][1] = "Place of birth (Name of district and state):";
        ques[16][1] = "Educational Qualification";
        ques[17][1] = "10th (High School)";
        ques[18][1] = "12th (Intermediate)";
        ques[19][1] = "Graduate";
        ques[20][1] = "Post Graduate";
        ques[21][1] = "Other";
        ques[22][1] = "Which of the following are you currently enrolled in?";
        ques[23][1] = "Private school";
        ques[24][1] = "Government school";
        ques[25][1] = "Private college";
        ques[26][1] = "Government college";
        ques[27][1] = "NIOS (National Intitute of open learning)";
        ques[28][1] = "SOL (School of open learning)";
        ques[29][1] = "How often have you relocated in past 5 years?";
        ques[30][1] = "Once";
        ques[31][1] = "Twice";
        ques[32][1] = "Thrice or more";
        ques[33][1] = "Are you a first or second-generation migrant to this area?";
        ques[34][1] = "First generation";
        ques[35][1] = "Second generation";
        ques[36][1] = "N/A";
        ques[37][1] = "If you migrated to this area, wh did you move to the city/village with?";
        ques[38][1] = "Family";
        ques[39][1] = "Friends";
        ques[40][1] = "Self";
        ques[41][1] = "Marriage";
        ques[42][1] = "N/A";
        ques[43][1] = " If you had to relocate, what was the main reason for it?";
        ques[44][1] = "Employment";
        ques[45][1] = "Family reasons. Please elaborate.";
        ques[46][1] = "Marriage";
        ques[47][1] = "Other (please specify in under 20 words)";
        ques[48][1] = "Number of family members (including self)";
        ques[49][1] = "2";
        ques[50][1] = "3";
        ques[51][1] = "4";
        ques[52][1] = "5";
        ques[53][1] = ">5";
        ques[54][1] = "How many members of your family are working?";
        ques[55][1] = "1";
        ques[56][1] = "2";
        ques[57][1] = "3";
        ques[58][1] = "4";
        ques[59][1] = ">4";
        ques[60][1] = "Who is the primary breadwinner in your family?";
        ques[61][1] = "Father";
        ques[62][1] = "Mother";
        ques[63][1] = "Husband";
        ques[64][1] = "Self";
        ques[65][1] = "Other (please specify)";
        ques[66][1] = "What is the nature of the work he/she does?";
        ques[67][1] = "Self (Business)";
        ques[68][1] = "Private Job";
        ques[69][1] = "Government Job";
        ques[70][1] = "Others";
        ques[71][1] = "What is the estimated total monthly income of your family?";
        ques[72][1] = "Below 5000";
        ques[73][1] = "5,000 - 10,000";
        ques[74][1] = "10,000 - 20,000";
        ques[75][1] = "20,000 - 50,000";
        ques[76][1] = "Above 50,000";
        ques[77][1] = "Please provide your most recent employment history: (if applicabe)";
        ques[78][1] = "Designation/Post";
        ques[79][1] = "Description:";
        ques[80][1] = "Name of company and contact details:";
        ques[81][1] = "Duration : From - To ";
        ques[82][1] = "Last salary drawn (Per month, in numeric value only): ";
        ques[83][1] = "How many hours can you allocate to remunerative activities?";
        ques[84][1] = "2 - 4 hours";
        ques[85][1] = "4 - 6 hours";
        ques[86][1] = "6 - 8 hours";
        ques[87][1] = "Which remunerative skills do you know?";
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
        ques[98][1] = "Did you train anywhere else in the same skills before joining this program?";
        ques[99][1] = "Yes";
        ques[100][1] = "No";
        ques[101][1] = "If yes, please provide name and address of the organization and name of the course:";
        ques[102][1] = "How did you hear about this program?";
        ques[103][1] = "Neighbors/Friends";
        ques[104][1] = "Mobilizing by the organization";
        ques[105][1] = "Referred by old students (Please name them)";
        ques[106][1] = "Walk in";
        ques[107][1] = "Which time slot works for a 4-hourclass?";
        ques[108][1] = "Morning";
        ques[109][1] = "Afternoon";
        ques[110][1] = "Are you comfortable commuting outside your neighborhood for training?";
        ques[111][1] = "Yes";
        ques[112][1] = "No";
        ques[113][1] = "Depends (please elaborate in 20 words)";
        ques[114][1] = "Do you have your family's support to work outside your neighborhood?";
        ques[115][1] = "Yes";
        ques[116][1] = "No";
        ques[117][1] = "Depends (please elaborate)";
        ques[118][1] = "Do you have your family's support to work outside your neighborhood?";
        ques[119][1] = "Yes";
        ques[120][1] = "No";
        ques[121][1] = "Depends on (please elaborate in 20 words)";
        ques[122][1] = "Do you have a sewing machine at home? (If no, skip to Q32)";
        ques[123][1] = "Yes";
        ques[124][1] = "No";
        ques[125][1] = "What type of sewing machine is it?";
        ques[126][1] = "Hand machine";
        ques[127][1] = "Manual umbrella machine";
        ques[128][1] = "Motorized umbrella machine";
        ques[129][1] = "Industrial (Juki) machine";
        ques[130][1] = "What are your plans after completing the program?";
        ques[131][1] = "Full time job in a factory";
        ques[132][1] = "Part time job in a factory";
        ques[133][1] = "Sew clother for myself and my family";
        ques[134][1] = "Start my own boutique/Enterpreneurship";
        ques[135][1] = "Work at a boutique";
        ques[136][1] = "Work from home/home to home";
        ques[137][1] = "No remuneraative plans / learning as a hobby";
        ques[138][1] = "What is the reason for joining this program?";
        ques[139][1] = "Financial independence";
        ques[140][1] = "Additional household income";
        ques[141][1] = "Saving by sewing at home";
        ques[142][1] = "Hobby";
        ques[143][1] = "What are the major hurdles you face in getting a job?";
        ques[144][1] = "Lack of family support";
        ques[145][1] = "Lack of qualification";
        ques[146][1] = "Lack of skill";
        ques[147][1] = "Cultural barriers such as gender inequality";
        ques[148][1] = "Distance from home";
        ques[149][1] = "Lack of oportunities";
        ques[150][1] = "Not interested in getting a job";
        ques[151][1] = "Do you have health insurance? If yes, from where? Husband's job/Father's job,etc.)";

        // Hindi
        ques[0][2] = "नाम: ";
        ques[1][2] = "पति का / पिता का नाम / माता का नाम:";
        ques[2][2] = "संपर्क नंबर:";
        ques[3][2] = "आधार कार्ड नंबर (वैकल्पिक):";
        ques[4][2] = "स्थायी पता:";
        ques[5][2] = "हाउस नंबर / गली नंबर -";
        ques[6][2] = "ग्राम / नगर -";
        ques[7][2] = "जिला -";
        ques[8][2] = "राज्य -";
        ques[9][2] = "वर्तमान पता: (विकल्प - ऊपर के रूप में ही)";
        ques[10][2] = "हाउस नंबर / गली नंबर -";
        ques[11][2] = "ग्राम / नगर -";
        ques[12][2] = "जिला -";
        ques[13][2] = "राज्य -";
        ques[14][2] = "जन्म की तिथि (दिनांक / महीना / बर्ष):";
        ques[15][2] = "जन्म स्थान (जिला और राज्य का नाम):";
        ques[16][2] = "शैक्षिक योग्यता: (यदि अभी स्कूल में है, अगला सवाल करने के लिए आगे बढ़ें।)";
        ques[17][2] = "10 वीं (हाई स्कूल)";
        ques[18][2] = "12 वीं (इंटरमीडिएट)";
        ques[19][2] = "ग्रेजुएट";
        ques[20][2] = "पोस्ट ग्रेजुएट";
        ques[21][2] = "अन्य";
        ques[22][2] = "निम्न में से अभी आप कहा पढ़ रहे हैं?";
        ques[23][2] = "निजी स्कूल";
        ques[24][2] = "सरकारी स्कूल";
        ques[25][2] = "निजी कॉलेज";
        ques[26][2] = "सरकारी कॉलेज";
        ques[27][2] = "एनआईओएस (ओपन लर्निंग के राष्ट्रीय संस्थान)";
        ques[28][2] = "एसओएल (ओपन लर्निंग के स्कूल)";
        ques[29][2] = "कितनी बार आप पिछले 5 वर्षों में स्थानांतरित कर चुके है?";
        ques[30][2] = "एक बार";
        ques[31][2] = "दो बार";
        ques[32][2] = "तीन बार या उससे अधिक";
        ques[33][2] = "आप इस क्षेत्र के लिए पहली या दूसरी पीढ़ी के आप्रवासी हैं?";
        ques[34][2] = "पहली पीढ़ी";
        ques[35][2] = "दूसरी पीढ़ी";
        ques[36][2] = "लागू नहीं";
        ques[37][2] = "तुमने किसके साथ शहर / गांव को विस्थापित किया?";
        ques[38][2] = "परिवार";
        ques[39][2] = "दोस्त";
        ques[40][2] = "स्वयं";
        ques[41][2] = "विवाह";
        ques[42][2] = "लागू नहीं";
        ques[43][2] = "अगर आपके स्थानांतरित किया था, तो ऐसा करने का मुख्य कारण क्या था?";
        ques[44][2] = "रोजगार";
        ques[45][2] = "पारिवारिक कारण। कृपया विस्तार से बताएं";
        ques[46][2] = "विवाह";
        ques[47][2] = "अन्य (20 शब्दों के तहत निर्दिष्ट करें)";
        ques[48][2] = "परिवार के सदस्यों की संख्या (आत्म सहित)";
        ques[49][2] = "2";
        ques[50][2] = "3";
        ques[51][2] = "4";
        ques[52][2] = "5";
        ques[53][2] = ">5";
        ques[54][2] = "आपके परिवार के कितने सदस्यों काम कर रहे हैं?";
        ques[55][2] = "1";
        ques[56][2] = "2";
        ques[57][2] = "3";
        ques[58][2] = "4";
        ques[59][2] = ">4";
        ques[60][2] = "आपके परिवार में प्राथमिक कमानेवाला कौन है?";
        ques[61][2] = "पिता";
        ques[62][2] = "मां";
        ques[63][2] = "पति";
        ques[64][2] = "स्वयं";
        ques[65][2] = "अन्य (कृपया निर्दिष्ट करें)";
        ques[66][2] = "काम की प्रकृति क्या है जो वो करते है?";
        ques[67][2] = "स्वयं (बिजनेस)";
        ques[68][2] = "निजी नौकरी";
        ques[69][2] = "सरकारी नौकरी";
        ques[70][2] = "अन्य (खेती, आदि निर्दिष्ट करें)";
        ques[71][2] = "आपके परिवार की कुल अनुमानित मासिक आय क्या है?";
        ques[72][2] = "5,000 से नीचे";
        ques[73][2] = "5,000 - 10,000";
        ques[74][2] = "10,000 - 20,000";
        ques[75][2] = "20,000 - 50,000";
        ques[76][2] = "50,000 से ऊपर";
        ques[77][2] = "कृपया आपके सबसे हाल के रोजगार का विवरण प्रदान करें:";
        ques[78][2] = "पदनाम / पोस्ट:";
        ques[79][2] = "विवरण:";
        ques[80][2] = "कंपनी का नाम और संपर्क विवरण:";
        ques[81][2] = "अवधि से:";
        ques[82][2] = "अंतिम वेतन (प्रति माह, संख्यात्मक मूल्य में केवल):";
        ques[83][2] = "कितने घंटे तुम लाभकारी गतिविधियों के लिए आवंटित कर सकते हो?";
        ques[84][2] = "2 – 4 घंटे";
        ques[85][2] = "4 – 6 घंटे";
        ques[86][2] = "6 – 8 घंटे";
        ques[87][2] = "लाभकारी कौशल जो आप जानते हैं?";
        ques[88][2] = "खेती";
        ques[89][2] = "बुनना";
        ques[90][2] = "डाइंग";
        ques[91][2] = "ई बुनाई";
        ques[92][2] = "क्रोशिए";
        ques[93][2] = "कढ़ाई";
        ques[94][2] = "पैटर्न मेकिंग";
        ques[95][2] = "सिलाई";
        ques[96][2] = "ब्लॉक मुद्रण";
        ques[97][2] = "अन्य (कृपया स्पष्ट करें)";
        ques[98][2] = "क्या आपने इस कार्यक्रम में शामिल होने से पहले कौशल में कहीं भी प्रशिक्षण किया है?";
        ques[99][2] = "अगर हाँ तो प्रदान करें:";
        ques[100][2] = "नाम और संगठन का पता:";
        ques[101][2] = "पाठ्यक्रम का नाम:";
        ques[102][2] = "आपने इस कार्यक्रम के बारे में  कहा से सुना?";
        ques[103][2] = "पड़ोसियों / दोस्त";
        ques[104][2] = "संगठन द्वारा जुटाने";
        ques[105][2] = "वर्ष के छात्रों द्वारा निर्दिष्ट (उनके नाम करें)";
        ques[106][2] = "बिना नियोजित भेंट के चला आने";
        ques[107][2] = "कौन सा समय आप के लिए 4 घंटे की कक्षा के लिए काम करेगा?";
        ques[108][2] = "सुबह";
        ques[109][2] = "दोपहर";
        ques[110][2] = "आप प्रशिक्षण के लिए आपके पड़ोस के बाहर आराम से आ सकते हैं?";
        ques[111][2] = "हाँ";
        ques[112][2] = "नहीं";
        ques[113][2] = "निर्भर करता है (20 शब्दों में विस्तृत कृपया)";
        ques[114][2] = "क्या काम के लिए आपके पड़ोस के बाहर जाना आरामदायक हो पाएगा?";
        ques[115][2] = "हाँ";
        ques[116][2] = "नहीं";
        ques[117][2] = "निर्भर करता है (20 शब्दों में विस्तृत कृपया)";
        ques[118][2] = "क्या आपके पड़ोस के बाहर काम करने के लिए आपके परिवार का समर्थन है?";
        ques[119][2] = "हाँ";
        ques[120][2] = "नहीं";
        ques[121][2] = "निर्भर करता है (20 शब्दों में विस्तृतया)";
        ques[122][2] = "आपके घर पर एक सिलाई मशीन है? (यदि नहीं, Q32 को छोड़)";
        ques[123][2] = "हाँ";
        ques[124][2] = "नहीं";
        ques[125][2] = "यह सिलाई मशीन किस तरह की है?";
        ques[126][2] = "हाथ मशीन";
        ques[127][2] = "हाथ अम्ब्रेला मशीन";
        ques[128][2] = "मोटोराइज्ड अम्ब्रेला मशीन";
        ques[129][2] = "औद्योगिक (जुकी) मशीन";
        ques[130][2] = "कार्यक्रम पूरा करने के बाद आपकी क्या योजनाएं हैं?";
        ques[131][2] = "एक कारखाने में पूर्णकालिक नौकरी";
        ques[132][2] = "एक कारखाने में आंशिक समय नौकरी";
        ques[133][2] = "खुद को और अपने परिवार के लिए कपड़े सिलाई";
        ques[134][2] = "मेरे अपने बुटीक / उद्यमिता शुरू";
        ques[135][2] = "एक बुटीक में काम";
        ques[136][2] = "घर से काम / घर - घर के काम";
        ques[137][2] = "कोई लाभकारी योजनाओं / एक शौक के रूप में सीखने";
        ques[138][2] = "इस कार्यक्रम में शामिल होने का कारण क्या है?";
        ques[139][2] = "वित्तीय स्वतंत्रता";
        ques[140][2] = "अतिरिक्त घरेलू आय";
        ques[141][2] = "घर पर सिलाई की बचत";
        ques[142][2] = "शौक";
        ques[143][2] = "प्रमुख बाधाओं एक नौकरी प्राप्त करने में आप सामना कर रहे हैं?";
        ques[144][2] = "परिवार के समर्थन का अभाव";
        ques[145][2] = "योग्यता का अभाव";
        ques[146][2] = "कौशल की कमी";
        ques[147][2] = "लैंगिक असमानता के रूप में सांस्कृतिक बाधाओं";
        ques[148][2] = "घर से दूरी";
        ques[149][2] = "अवसरों की कमी";
        ques[150][2] = "एक नौकरी प्राप्त करने में कोई दिलचस्पी नहीं है";
        ques[151][2] = "आपके पास स्वास्थ्य बीमा है? अगर हां, तो कहाँ से? (पति की नौकरी / पिता की नौकरी आदि)";

    }

    EditText[] t = new EditText[29];
    RadioButton[] rb = new RadioButton[7];
    RadioGroup[] rg = new RadioGroup[24];

    public void getViews(){
        //textEdits
        t[0] = (EditText) vi.findViewById(R.id.i501);
        t[1] = (EditText) vi.findViewById(R.id.i502);
        t[2] = (EditText) vi.findViewById(R.id.i503);
        t[3] = (EditText) vi.findViewById(R.id.i504);
        t[4] = (EditText) vi.findViewById(R.id.i505);
        t[5] = (EditText) vi.findViewById(R.id.i505);
        t[6] = (EditText) vi.findViewById(R.id.i507);
        t[7] = (EditText) vi.findViewById(R.id.i508);
        t[8] = (EditText) vi.findViewById(R.id.i509);
        t[9] = (EditText) vi.findViewById(R.id.i510);
        t[10] = (EditText) vi.findViewById(R.id.i511);
        t[11] = (EditText) vi.findViewById(R.id.i512);
        t[12] = (EditText) vi.findViewById(R.id.i513);
        t[13] = (EditText) vi.findViewById(R.id.i514);
        t[14] = (EditText) vi.findViewById(R.id.i526);
        t[15] = (EditText) vi.findViewById(R.id.i527);
        t[16] = (EditText) vi.findViewById(R.id.i528);
        t[17] = (EditText) vi.findViewById(R.id.i529);
        t[18] = (EditText) vi.findViewById(R.id.i530);
        //t[19] = (EditText) vi.findViewById(R.id.i531);
        t[20] = (EditText) vi.findViewById(R.id.i534);
        t[21] = (EditText) vi.findViewById(R.id.i535);
        t[22] = (EditText) vi.findViewById(R.id.i545);
        // radio others
        t[23] = (EditText) vi.findViewById(R.id.i5200);
        t[24] = (EditText) vi.findViewById(R.id.i5230);
        t[25] = (EditText) vi.findViewById(R.id.i5380);
        t[26] = (EditText) vi.findViewById(R.id.i5390);
        t[27] = (EditText) vi.findViewById(R.id.i5400);
        t[28] = (EditText) vi.findViewById(R.id.i5201);

        //radiobutton others
        rb[0] = (RadioButton) vi.findViewById(R.id.tv45);
        rb[1] = (RadioButton) vi.findViewById(R.id.tv47);
        rb[2] = (RadioButton) vi.findViewById(R.id.tv65);
        rb[3] = (RadioButton) vi.findViewById(R.id.tv113);
        rb[4] = (RadioButton) vi.findViewById(R.id.tv117);
        rb[5] = (RadioButton) vi.findViewById(R.id.tv121);
        rb[6] = (RadioButton) vi.findViewById(R.id.tv97);

        //radio groups
        rg[0] = (RadioGroup) vi.findViewById(R.id.i515);
        rg[1] = (RadioGroup) vi.findViewById(R.id.i516);
        rg[2] = (RadioGroup) vi.findViewById(R.id.i517);
        rg[3] = (RadioGroup) vi.findViewById(R.id.i518);
        rg[4] = (RadioGroup) vi.findViewById(R.id.i519);
        rg[5] = (RadioGroup) vi.findViewById(R.id.i520);
        rg[6] = (RadioGroup) vi.findViewById(R.id.i521);
        rg[7] = (RadioGroup) vi.findViewById(R.id.i522);
        rg[8] = (RadioGroup) vi.findViewById(R.id.i523);
        rg[9] = (RadioGroup) vi.findViewById(R.id.i524);
        rg[10] = (RadioGroup) vi.findViewById(R.id.i525);
        rg[11] = (RadioGroup) vi.findViewById(R.id.i532);
        rg[12] = (RadioGroup) vi.findViewById(R.id.i533);
        rg[13] = (RadioGroup) vi.findViewById(R.id.i536);
        rg[14] = (RadioGroup) vi.findViewById(R.id.i537);
        rg[15] = (RadioGroup) vi.findViewById(R.id.i538);
        rg[16] = (RadioGroup) vi.findViewById(R.id.i539);
        rg[17] = (RadioGroup) vi.findViewById(R.id.i540);
        rg[18] = (RadioGroup) vi.findViewById(R.id.i541);
        rg[19] = (RadioGroup) vi.findViewById(R.id.i542);
        rg[20] = (RadioGroup) vi.findViewById(R.id.i543);
        rg[21] = (RadioGroup) vi.findViewById(R.id.i544);
        rg[22] = (RadioGroup) vi.findViewById(R.id.i546);
        rg[23] = (RadioGroup) vi.findViewById(R.id.i547);


        rb[0].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    t[23].setEnabled(true);
                }
                else{
                    t[23].setEnabled(false);
                }
            }
        });
        rb[1].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    t[28].setEnabled(true);
                }
                else{
                    t[28].setEnabled(false);
                }
            }
        });
        rb[2].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    t[24].setEnabled(true);
                }
                else{
                    t[24].setEnabled(false);
                }
            }
        });
        rb[3].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    t[25].setEnabled(true);
                }
                else{
                    t[25].setEnabled(false);
                }
            }
        });
        rb[4].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    t[26].setEnabled(true);
                }
                else{
                    t[26].setEnabled(false);
                }
            }
        });
        rb[5].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    t[27].setEnabled(true);
                }
                else{
                    t[27].setEnabled(false);
                }
            }
        });

        t[20].setEnabled(false);

        rb[6].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    t[20].setEnabled(true);
                }
                else{
                    t[20].setEnabled(false);
                }
            }
        });


    }

    private Boolean validate(){
        Log.d("validate","0");
        for(int i=0;i<=22;i++){
            if(i==20 || i==19)
                continue;
            if(t[i].getText().toString().isEmpty())
                return false;
        }
        Log.d("validate","1");
        if(rb[6].isChecked() && t[20].getText().toString().isEmpty())
            return false;
        Log.d("validate","2");
        if(rb[0].isChecked() && t[23].getText().toString().isEmpty())
            return false;
        Log.d("validate","3");
        if(rb[1].isChecked() && t[24].getText().toString().isEmpty())
            return false;
        Log.d("validate","4");
        if(rb[2].isChecked() && t[25].getText().toString().isEmpty())
            return false;
        Log.d("validate","5");
        if(rb[3].isChecked() && t[26].getText().toString().isEmpty())
            return false;
        Log.d("validate","6");
        if(rb[4].isChecked() && t[27].getText().toString().isEmpty())
            return false;
        Log.d("validate","7");
        if(rb[5].isChecked() && t[28].getText().toString().isEmpty())
            return false;
        Log.d("validate","8");
        return true;
    }
}
