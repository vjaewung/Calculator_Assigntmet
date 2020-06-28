package com.example.calculator_assigntmet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.calculator_assigntmet.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    boolean isFirstInput = true;
    boolean isOperatorClick = false;
    double resultNumber = 0;
    double inputNumber = 0;
    String operator = "＋";
    String lastOperator = "＋";
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
            isFirstInput = false;
        }
        else {
            if(activityMainBinding.resultTextView.getText().toString().equals("0")) {
                Toast.makeText(this, "0으로 시작되는 숫자는 없습니다.", Toast.LENGTH_SHORT).show();
                isFirstInput = true;
            }
            activityMainBinding.resultTextView.append(getButtonText);
        }
    }

    public void operatorClick (View view) {

        //÷, ×, ＋, -
        isOperatorClick = true;
        lastOperator = view.getTag().toString();

        inputNumber = Double.parseDouble(activityMainBinding.resultTextView.getText().toString());
        Log.e("calculator", resultNumber + " " + inputNumber + " " + operator);

        resultNumber = calculator(resultNumber, inputNumber, operator);
        Log.e("calculator111111", resultNumber + " " + inputNumber + " " + operator);

        activityMainBinding.resultTextView.setText(String.valueOf(resultNumber));
        isFirstInput = true;
        operator = view.getTag().toString();
        activityMainBinding.mathTextView.append(inputNumber + " " + operator + " ");
    }

    public  void equalsButtonClick (View view) {
/*
        if(isFirstInput) {
            if(isOperatorClick) {
                activityMainBinding.mathTextView.setText(resultNumber + " " + lastOperator + " " + inputNumber + " =");
                resultNumber = calculator(resultNumber, inputNumber, lastOperator);
                activityMainBinding.resultTextView.setText(String.valueOf(resultNumber));
            }
        }
        else {
 */
            inputNumber = Double.parseDouble(activityMainBinding.resultTextView.getText().toString());

            resultNumber = calculator(resultNumber, inputNumber, operator);
            activityMainBinding.resultTextView.setText(String.valueOf(resultNumber));
            isFirstInput = true;

            operator = view.getTag().toString();
            activityMainBinding.mathTextView.append(inputNumber + " " + operator + " ");
       // }
    }

    private double calculator(double resultNumber, double inputNumber, String operator) {

        Log.e("calculator--->", resultNumber + " " + inputNumber + " " + operator);

        if(operator.equals("=")) {
            resultNumber = inputNumber;
            Log.e("A--->", resultNumber + " " + inputNumber + " " + operator);
        }
        else if(operator.equals("＋")) {
            resultNumber = resultNumber + inputNumber;
            Log.e("B--->", resultNumber + " " + inputNumber + " " + operator);
        }
        else if(operator.equals("＋")) {
            resultNumber = resultNumber - inputNumber;
            Log.e("C--->", resultNumber + " " + inputNumber + " " + operator);
        }
        else if(operator.equals("＋")) {
            resultNumber = resultNumber * inputNumber;
            Log.e("D--->", resultNumber + " " + inputNumber + " " + operator);
        }
        else if(operator.equals("＋")) {
            resultNumber = resultNumber / inputNumber;
            Log.e("E--->", resultNumber + " " + inputNumber + " " + operator);
        }

        /*
            case "=" :
                resultNumber = inputNumber;
                Log.e("A--->", resultNumber + " " + inputNumber + " " + operator);
                break;
            case "＋" :
                resultNumber = resultNumber + inputNumber;
                Log.e("B--->", resultNumber + " " + inputNumber + " " + operator);
            case "-" :
                resultNumber = resultNumber - inputNumber;
                Log.e("C--->", resultNumber + " " + inputNumber + " " + operator);
            case "×" :
                resultNumber = resultNumber * inputNumber;
                Log.e("D--->", resultNumber + " " + inputNumber + " " + operator);
            case "÷" :
                resultNumber = resultNumber / inputNumber;
                Log.e("E--->", resultNumber + " " + inputNumber + " " + operator);


            default :
                Log.e("calculator", resultNumber + " " + inputNumber + " " + operator);
                break;
                }
         */


//        switch (operator) {
//
//            case "=" :
//                resultNumber = inputNumber;
//                Log.e("A--->", resultNumber + " " + inputNumber + " " + operator);
//                break;
//            case "＋" :
//                resultNumber = resultNumber + inputNumber;
//                Log.e("B--->", resultNumber + " " + inputNumber + " " + operator);
//            case "-" :
//                resultNumber = resultNumber - inputNumber;
//                Log.e("C--->", resultNumber + " " + inputNumber + " " + operator);
//            case "×" :
//                resultNumber = resultNumber * inputNumber;
//                Log.e("D--->", resultNumber + " " + inputNumber + " " + operator);
//            case "÷" :
//                resultNumber = resultNumber / inputNumber;
//                Log.e("E--->", resultNumber + " " + inputNumber + " " + operator);
//
//
//            default :
//                Log.e("calculator", resultNumber + " " + inputNumber + " " + operator);
//                break;
//        }
        return resultNumber;
    }

    public void allClearButtonClick (View view) {

        activityMainBinding.resultTextView.setText(("0"));
        activityMainBinding.mathTextView.setText("");
        resultNumber = 0;
        operator = "＋";
        isFirstInput = true;
    }

    public void pointButtonClick (View view) {
        if(isFirstInput) {
            activityMainBinding.resultTextView.setText("0" + view.getTag().toString());
            isFirstInput = false;
        }
        else {
            if(activityMainBinding.resultTextView.toString().contains(".")) {
                Toast.makeText(this, "이미 소숫점이 존재합니다", Toast.LENGTH_SHORT).show();
            }
            else {
                activityMainBinding.resultTextView.append(view.getTag().toString());
            }
        }
    }

}
