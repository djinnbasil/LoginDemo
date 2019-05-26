package com.example.logindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.FloatProperty;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import java.text.NumberFormat;

public class SecondActivity extends AppCompatActivity {

    private double bill=0.0;
    private double percent=0.15;
    private String st;
    private String st1;
    private String st2;
    private String temptext;
    private SeekBar Sbar;
    private TextView Tout;
    private TextView Fifttext;
    private EditText BillAmount;
    private double temp=0.0;
    private double temp1=0.0;
    private static final NumberFormat currencyFormat=NumberFormat.getCurrencyInstance();






    private void initializeVariables() {
        Sbar = (SeekBar) findViewById(R.id.sbar1);
        Tout = (TextView) findViewById(R.id.textView3);
        Fifttext=(TextView) findViewById(R.id.textView4);
        BillAmount=(EditText) findViewById(R.id.billamount);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initializeVariables();
        Tout.setText("Covered: " + Sbar.getProgress() + "/" + Sbar.getMax());
        BillAmount.setText("0");

        BillAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                st=Fifttext.getText().toString();
                st1=BillAmount.getText().toString();
                if(st1.isEmpty()){
                    Log.d("myTag", "Message: "+"Emptyyyyy!!!!");

                    temptext=Tout.getText().toString();
                    Tout.setText(temptext);


                }
                else{
                    Log.d("myTag", "Message: "+st1);

                    st=st.replace("Tip % : ","");
                    temp=Float.parseFloat(st);
                    temp1=Float.parseFloat(st1);
                    Tout.setText("Final Bill: "+(temp1+((float)(temp)/(float)(100))*temp1));
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                st=Fifttext.getText().toString();
                st1=BillAmount.getText().toString();
                if(st1.isEmpty()){
                    Log.d("myTag", "Message: "+"Emptyyyyy!!!!");

                    temptext=Tout.getText().toString();
                    Tout.setText(temptext);


                }
                else{
                    Log.d("myTag", "Message: "+st1);

                    st=st.replace("Tip % : ","");
                temp=Float.parseFloat(st);
                temp1=Float.parseFloat(st1);
                Tout.setText("Final Bill: "+(temp1+((float)(temp)/(float)(100))*temp1));
            }}
        });

        Sbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                st2=BillAmount.getText().toString();
                if(st2.isEmpty()){
                    st2="0";
                }
                else{
                bill=Float.parseFloat(st2);
                temp=(float)Sbar.getProgress()/(float)Sbar.getMax();

                Fifttext.setText("Tip % : "+(temp*100));
                bill=bill+(temp*bill);
                Tout.setText("Final Bill: " + bill);
            }}

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {



            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                st2=BillAmount.getText().toString();
                if(st2.isEmpty()){
                    st2="0";
                }
                else{
                bill=Float.parseFloat(st2);
                temp=(float)Sbar.getProgress()/(float)Sbar.getMax();
                Fifttext.setText("Tip % : "+(temp*100));


                bill=bill+(temp*bill);
                Tout.setText("Final Bill: " + bill);

            }}
        });

    }
}
