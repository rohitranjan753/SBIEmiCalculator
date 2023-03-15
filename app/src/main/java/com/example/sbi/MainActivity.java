package com.example.sbi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout mName, mCity, mPhone, mAmount;
    private TextView mAlldetils;
    private RadioGroup mGender;
    private Spinner mLoanType,mTenureMonth;
    private Button mSbumitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (TextInputLayout) findViewById(R.id.textView3);
        mCity = (TextInputLayout) findViewById(R.id.textView4);
        mPhone = (TextInputLayout) findViewById(R.id.textView5);
        mAmount = (TextInputLayout) findViewById(R.id.textView7);
        mGender = (RadioGroup) findViewById(R.id.radioGroup);
        mLoanType = (Spinner) findViewById(R.id.loanSpinner);
        mTenureMonth = (Spinner) findViewById(R.id.tenureSpinner);
        mAlldetils = (TextView) findViewById(R.id.allDetails);
        mSbumitButton = (Button) findViewById(R.id.submitButton);



        List<String> listLoantype = new ArrayList<String>();
        listLoantype.add(0,"Select Loan type");
        listLoantype.add("Education Loan");
        listLoantype.add("Home Loan");
        listLoantype.add("Car Loan");
        listLoantype.add("Business Loan");
        listLoantype.add("Gold Loan");

        ArrayAdapter<String> emptyArrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, listLoantype);
        emptyArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLoanType.setAdapter(emptyArrayAdapter);

        mLoanType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Loan Type")){
                }
                else{
                    mLoanType.setSelection(position);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        List<String> listTenure = new ArrayList<String>();
        listTenure.add(0,"Select Months");
        listTenure.add("1");
        listTenure.add("2");
        listTenure.add("3");
        listTenure.add("4");
        listTenure.add("5");
        listTenure.add("6");
        listTenure.add("7");
        listTenure.add("8");
        listTenure.add("9");
        listTenure.add("10");
        listTenure.add("11");
        listTenure.add("12");
        listTenure.add("13");
        listTenure.add("14");
        listTenure.add("15");
        listTenure.add("16");
        listTenure.add("17");
        listTenure.add("18");
        listTenure.add("19");
        listTenure.add("20");
        listTenure.add("21");
        listTenure.add("22");
        listTenure.add("23");
        listTenure.add("24");
        listTenure.add("25");
        listTenure.add("26");
        listTenure.add("27");
        listTenure.add("28");
        listTenure.add("29");
        listTenure.add("30");
        listTenure.add("31");
        listTenure.add("32");
        listTenure.add("33");
        listTenure.add("34");
        listTenure.add("35");
        listTenure.add("36");
        listTenure.add("37");
        listTenure.add("38");
        listTenure.add("39");
        listTenure.add("40");
        listTenure.add("41");
        listTenure.add("42");
        listTenure.add("43");
        listTenure.add("44");
        listTenure.add("45");
        listTenure.add("46");
        listTenure.add("47");
        listTenure.add("48");


        ArrayAdapter<String> tenureArrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, listTenure);
        tenureArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mTenureMonth.setAdapter(tenureArrayAdapter);

        mTenureMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Select Months")){
                }
                else{
                    mTenureMonth.setSelection(position);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mSbumitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = mName.getEditText().getText().toString();
                final String city = mCity.getEditText().getText().toString();
                final String mobile = mPhone.getEditText().getText().toString();
                final String getLoanType = mLoanType.getSelectedItem().toString();
                final String getTenuremonth = mTenureMonth.getSelectedItem().toString();
                double rateofInterest=0,emiRate,rInterest,sumInterest,power;
                String amount = mAmount.getEditText().getText().toString();
                double amountValue = Double.parseDouble(amount);

                int selectedId = mGender.getCheckedRadioButtonId();
                final RadioButton radioButton = (RadioButton) findViewById(selectedId);
                final String gender = radioButton.getText().toString();

                if (mLoanType.getSelectedItemPosition() == 1){
                    rateofInterest=9.05;
                }
                else if (mLoanType.getSelectedItemPosition() == 2){
                    rateofInterest=7.55;
                }
                else if (mLoanType.getSelectedItemPosition() == 3){
                    rateofInterest=7.45;
                }
                else if (mLoanType.getSelectedItemPosition() == 4){
                    rateofInterest=11.2;
                }
                else if (mLoanType.getSelectedItemPosition() == 5){
                    rateofInterest=7.8;
                }

                rInterest=rateofInterest/1200;
                sumInterest = (1+rInterest);
                power = Math.pow(sumInterest,mTenureMonth.getSelectedItemPosition());
                emiRate = amountValue * rInterest * (power/(power-1));
                emiRate = Math.round(emiRate);

                final String alldetils = "Name: "+name+'\n'+"City: "+city+'\n'+"Mobile No.: "+mobile+'\n'+"Loan Type: "+getLoanType+'\n'+"Tenure Month: "+getTenuremonth+'\n'+"Rate of Interest: "+rateofInterest+'\n'+"Gender: "+gender+'\n'+"Amount: "+amountValue+'\n'+"EMI Rate: "+emiRate+" per month";
                mAlldetils.setText(alldetils);

            }
        });
    }
}