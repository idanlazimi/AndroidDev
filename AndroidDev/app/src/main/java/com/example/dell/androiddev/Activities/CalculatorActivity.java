package com.example.dell.androiddev.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.androiddev.R;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private Double arg1 = 0.0, arg2 = 0.0;
    private Button addButton;
    private Button subtractButton;
    private Button divideButton;
    private Button multiplyButton;
    private Button equalsButton;
    private Button ACButton;

    private Operation op = Operation.DEAD;
    private boolean isOperatorChosen = false;
    private boolean resIsSet = false;

    private TextView resultField;
    private TextView opDisplay ;

    private Double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_layout);

        //init buttons

        addButton = findViewById(R.id.operPlus);
        addButton.setOnClickListener(this);
        subtractButton = findViewById(R.id.operMin);
        subtractButton.setOnClickListener(this);
        divideButton = findViewById(R.id.operDiv);
        divideButton.setOnClickListener(this);
        multiplyButton = findViewById(R.id.operMult);
        multiplyButton.setOnClickListener(this);
        equalsButton = findViewById(R.id.operEq);
        equalsButton.setOnClickListener(this);
        ACButton = findViewById(R.id.operAc);
        ACButton.setOnClickListener(this);

        resultField = findViewById(R.id.resultView);
        opDisplay = findViewById(R.id.opView);

        findViewById(R.id.digit0).setOnClickListener(this);
        findViewById(R.id.digit1).setOnClickListener(this);
        findViewById(R.id.digit2).setOnClickListener(this);
        findViewById(R.id.digit3).setOnClickListener(this);
        findViewById(R.id.digit4).setOnClickListener(this);
        findViewById(R.id.digit5).setOnClickListener(this);
        findViewById(R.id.digit6).setOnClickListener(this);
        findViewById(R.id.digit7).setOnClickListener(this);
        findViewById(R.id.digit8).setOnClickListener(this);
        findViewById(R.id.digit9).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if ( isDigit(view)){

            Button btn = (Button)view;
            Double pressedVal = Double.parseDouble(btn.getText().toString());

            // if isOperatorChosen == true, second operand comes into play
            if(isOperatorChosen || resIsSet) {
                arg2 = (arg2 * 10) + pressedVal;
                resultField.setText(arg2.toString());
            }
            else {
                arg1 = (arg1 * 10) + pressedVal;
                resultField.setText(arg1.toString());
            }

        }
        else{
            //view is an operator
            isOperatorChosen = true;
            int chodenOperatorID = view.getId();
            switch(chodenOperatorID){
                case R.id.operPlus:
                    op = Operation.PLUS;
                    //Toast.makeText(getBaseContext(), "op chaned to PLUS", Toast.LENGTH_LONG).show();
                    opDisplay.setText( arg1.toString() + " +");
                    break;
                case R.id.operMin:
                    op = Operation.MINUS;
                    opDisplay.setText( arg1.toString() + " -");
                    break;
                case R.id.operMult:
                    op = Operation.MUL;
                    opDisplay.setText( arg1.toString() + " *");
                    break;
                case R.id.operDiv:
                    op = Operation.DIV;
                    opDisplay.setText( arg1.toString() + " /");
                    break;
                case R.id.operAc:
                    reset();
                    break;
                case R.id.operEq:
                    calcAndDisplay();
                    break;

            }

        }

    }

    private void reset() {

        arg1 = arg2 = 0.0;
        isOperatorChosen = false;
        resIsSet = false;
        resultField.setText("0.0");
        opDisplay.setText("");
        op = Operation.DEAD;
        result = 0.0;

    }

    private void calcAndDisplay() {


        switch(op) {
            case PLUS:
                //Toast.makeText(this, "arg1:" + arg1.toString() + " arg2:" + arg2.toString(), Toast.LENGTH_LONG).show();
                result = arg1 + arg2;
                break;
            case MINUS:
                result = arg1 - arg2;
                break;
            case MUL:
                result = arg1*arg2;
                break;
            case DIV:
                if ( arg2 != 0 ) result = arg1/arg2;
                else {
                    Toast.makeText(this, "Cannot Divide by 0!", Toast.LENGTH_LONG).show();
                    reset();
                    return;
                }
                break;

        }

        //while AC is not pressed, result acts as first operand to be computed with arg2
        arg1 = result;
        arg2 = 0.0;
        resIsSet = true;
        opDisplay.setText("");
        resultField.setText(result.toString());
    }

    private boolean isDigit(View view){

        Button button = (Button) view;
        if(     view.getId() == R.id.digit0     ||
                view.getId() == R.id.digit1     ||
                view.getId() == R.id.digit2     ||
                view.getId() == R.id.digit3     ||
                view.getId() == R.id.digit4     ||
                view.getId() == R.id.digit5     ||
                view.getId() == R.id.digit6     ||
                view.getId() == R.id.digit7     ||
                view.getId() == R.id.digit8     ||
                view.getId() == R.id.digit9     ) return true;
        else return false;
    }

    public enum Operation { PLUS, MINUS, MUL, DIV, EQ, DEAD}
}
