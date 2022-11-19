package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText prelim, midterm, endterm;
    String strng_pre, strng_mid, strng_end , graderesult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCompute = (Button) findViewById(R.id.button);

        btnCompute.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Calculating....", Toast.LENGTH_SHORT).show();
        ComputeResult();
    }

    public void ComputeResult(){
        prelim = (EditText) findViewById(R.id.prelim);
        midterm = (EditText) findViewById(R.id.midterm);
        endterm = (EditText) findViewById(R.id.endterm);

        if(prelim.getText().toString().isEmpty() || midterm.getText().toString().isEmpty() || endterm.getText().toString().isEmpty()){
            strng_pre = "0";
            strng_mid = "0";
            strng_end = "0";

        }else{
            strng_pre = prelim.getText().toString();
            strng_mid = midterm.getText().toString();
            strng_end = endterm.getText().toString();
        }
        double pre = Double.parseDouble(strng_pre);
        double mid = Double.parseDouble(strng_mid);
        double end = Double.parseDouble(strng_end);

        pre = (pre*.30);
        mid = (mid*.30);
        end = (end*.40);

        double result = pre + mid + end;


        graderesult = "Your Total Grade is:" +"  "+ result;




        // Create Bundle instance, this will allow transfer of data from Activity to DialogFragment
        Bundle args = new Bundle();
        args.putString("result", graderesult);

        // Create a dialog instance
        DialogFragmentCustom dialogFragmentImp = new DialogFragmentCustom();
        // Pass on dialog argument(args), the result
        dialogFragmentImp.setArguments(args);
        // Display the Dialog
        dialogFragmentImp.show(getSupportFragmentManager(),"Display Result");
        // Reset EditTexts
        clearEditText();
    }
    public void clearEditText(){
        prelim.getText().clear();
        midterm.getText().clear();
        endterm.getText().clear();
        prelim.requestFocus();
    }
    public double ToDecimal(double nbr){
        nbr = nbr/100;
        return nbr;
    }
}