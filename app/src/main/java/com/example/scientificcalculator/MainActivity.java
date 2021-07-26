package com.example.scientificcalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText display;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);
        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToAdd){
       String oldStr = display.getText().toString();
       int cursorPos = display.getSelectionStart();
       String leftStr = oldStr.substring(0, cursorPos);
       String rightStr = oldStr.substring(cursorPos);
       display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
       display.setSelection(cursorPos+strToAdd.length());
    }
    public void zeroBTNPUSH(View view) {
       updateText(getResources().getString(R.string.zero));
    }
    public void oneBTNPUSH(View view) {
        updateText(getResources().getString(R.string.one));
    }
    public void twoBTNPUSH(View view) {
        updateText(getResources().getString(R.string.two));
    }
    public void threeBTNPUSH(View view) {
        updateText(getResources().getString(R.string.three));
    }
    public void fourBTNPUSH(View view) {
        updateText(getResources().getString(R.string.four));
    }
    public void fiveBTNPUSH(View view) {
        updateText(getResources().getString(R.string.five));
    }
    public void sixBTNPUSH(View view) {
        updateText(getResources().getString(R.string.six));
    }
    public void sevenBTNPUSH(View view) {
        updateText(getResources().getString(R.string.seven));
    }
    public void eightBTNPUSH(View view) {
        updateText(getResources().getString(R.string.eight));
    }
    public void nineBTNPUSH(View view) {
        updateText(getResources().getString(R.string.nine));
    }
    public void openparanBTNPUSH(View view) {
        updateText(getResources().getString(R.string.openParan));
    }
    public void closeparaBTNPUSH(View view) {
        updateText(getResources().getString(R.string.closepara));
    }
    public void divideBTNPUSH(View view) {
        updateText(getResources().getString(R.string.divide));
    }
    public void multiplicationBTNPUSH(View view) {
        updateText(getResources().getString(R.string.multiplication));
    }
    public void plusBTNPUSH(View view) {
        updateText(getResources().getString(R.string.plus));
    }
    public void minusBTNPUSH(View view) {
        updateText(getResources().getString(R.string.minus));
    }
    public void dotBTNPUSH(View view) {
        updateText(getResources().getString(R.string.dot));
    }

    public void equalsBTNPUSH(View view) {
        String userExp = display.getText().toString();
        previousCalculation.setText(userExp);
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }
    public void backspaceBTNPUSH(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();
        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder)display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
    public void clearTextBTNPUSH(View view){
        display.setText("");
        previousCalculation.setText("");
    }
    public void trigSinBtnPush(View view){
        updateText("sin(");

    }
    public void trigCosBtnPush(View view){
        updateText("cos(");
    }
    public void trigTanBtnPush(View view){
        updateText("tan(");
    }
    public void trigArcSinBtnPush(View view){
        updateText("arcsin(");
    }
    public void trigArcCosBtnPush(View view){
        updateText("arccos(");
    }
    public void trigArcTanBtnPush(View view){
        updateText("arctan(");
    }
    public void naturalLogBtnPush(View view){
        updateText("ln(");
    }
    public void LogBtnPush(View view){
        updateText("log(");
    }
    public void squareRootBtnPush(View view){
        updateText("sqrt(");
    }
    public void absoluteValueBtnPush(View view){
        updateText("abs(");
    }
    public void piBtnPush(View view){
        updateText("pi");
    }
    public void eTBtnPush(View view){
        updateText("e");
    }
    public void xSquaredBtnPush(View view){
        updateText("^(2)");
    }
    public void xPowerYBtnPush(View view){
        updateText("^(");
    }
    public void isPrimeFunctionBtnPush(View view){
        updateText("ispr(");
    }


}