package com.example.calculator_assigntmet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.calculator_assigntmet.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    boolean isFirstInput = true;
    double resultNumber = 0;
    String operator = "＋";
    ActivityMainBinding activityMainBinding;

    //AMB
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

    }

    public void numButtonClick (View view) {

        String getButtonText = view.getTag().toString();

        if(isFirstInput) {
            activityMainBinding.resultTextView.setText(getButtonText);
            //activityMainBinding.mathTextView.setText(getButtonText);
            isFirstInput = false;
        }
        else {
            if(activityMainBinding.resultTextView.getText().toString().equals("0")) {
                Toast.makeText(this, "0으로 시작되는 숫자는 없습니다.", Toast.LENGTH_SHORT).show();
                //Toast.makeText(context this, text:"0으로 시작되는 숫자는 없습니다", Toast.LENGTH_SHORT).show(())
                isFirstInput = true;
            }
                activityMainBinding.resultTextView.append(getButtonText);

            //activityMainBinding.mathTextView.append(getButtonText);
        }
    }

    public  void operatorClick (View view) {

        double inputNumber = Double.parseDouble(activityMainBinding.resultTextView.getText().toString());
        //operator = view.getTag().toString();
        //÷, ×, ＋, -
        //Toast.makeText(this, operator, Toast.LENGTH_SHORT).show();

        if("＋".equals(operator)) {
            //Toast.makeText(this, "A"+ " " +operator+ " " +resultNumber+ " " + inputNumber, Toast.LENGTH_SHORT).show();
            resultNumber = resultNumber + inputNumber;
        }
        else if("-".equals(operator)) {
            //Toast.makeText(this, "A"+ " " +operator+ " " +resultNumber+ " " + inputNumber, Toast.LENGTH_SHORT).show();
            resultNumber = resultNumber - inputNumber;
        }
        else if("×".equals(operator)) {
            //Toast.makeText(this, "A"+ " " +operator+ " " +resultNumber+ " " + inputNumber, Toast.LENGTH_SHORT).show();
            resultNumber = resultNumber * inputNumber;
        }
        else if("÷".equals(operator)) {
            //Toast.makeText(this, "A"+ " " +operator+ " " +resultNumber+ " " + inputNumber, Toast.LENGTH_SHORT).show();
            resultNumber = resultNumber / inputNumber;
        }

        activityMainBinding.resultTextView.setText(String.valueOf(resultNumber));
        isFirstInput = true;
        operator = view.getTag().toString();
        activityMainBinding.mathTextView.append(inputNumber + " " + operator + " ");
            //activityMainBinding.mathTextView.append(inputNumber);
            //activityMainBinding.mathTextView.append(inputNumber);
    }

    public void allClearButtonClick (View view) {

        activityMainBinding.resultTextView.setText(("0"));
        activityMainBinding.mathTextView.setText("");
        resultNumber = 0;
        operator = "＋";
        isFirstInput = true;
    }

}
