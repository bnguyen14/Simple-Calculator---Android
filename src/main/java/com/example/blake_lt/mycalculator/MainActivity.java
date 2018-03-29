package com.example.blake_lt.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //toClear tells if textview will reset for new numbers
    //firstOp tells if this is the first operation to do
    boolean toClear = true,firstOp = true;
    double mem = 0,val = 0;
    int operation = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public double calculate(double mem, double val, int operation)
    {
        switch(operation)
        {
            case 1:
                return (mem+val);
            case 2:
                return (mem-val);
            case 3:
                return (mem*val);
            case 4:
                return (mem/val);
        }
        return 0;
    }

    public void handleButtons(View view)
    {
        TextView text = findViewById(R.id.textView);

        if(text.length()<18)
        {
            switch(view.getId())
            {
                //depending on if textview is 0 or not, will append or settext to textview.
                case R.id.buttondot:
                    if(!text.getText().toString().contains("."))
                        text.append(".");
                    toClear=false;
                    break;
                case R.id.button0:
                    if(!toClear)
                        text.append("0");
                    else if(toClear && text.getText().toString()!="0")
                    {
                        text.setText("0");
                    }
                    break;
                case R.id.button1:
                    if(toClear)
                    {
                        text.setText("1");
                        toClear=false;
                    }else{
                        text.append("1");
                    }
                    break;
                case R.id.button2:
                    if(toClear)
                    {
                        text.setText("2");
                        toClear=false;
                    }else{
                        text.append("2");
                    }
                    break;
                case R.id.button3:
                    if(toClear)
                    {
                        text.setText("3");
                        toClear=false;
                    }else{
                        text.append("3");
                    }
                    break;
                case R.id.button4:
                    if(toClear)
                    {
                        text.setText("4");
                        toClear=false;
                    }else{
                        text.append("4");
                    }
                    break;
                case R.id.button5:
                    if(toClear)
                    {
                        text.setText("5");
                        toClear=false;
                    }else{
                        text.append("5");
                    }
                    break;
                case R.id.button6:
                    if(toClear)
                    {
                        text.setText("6");
                        toClear=false;
                    }else{
                        text.append("6");
                    }
                    break;
                case R.id.button7:
                    if(toClear)
                    {
                        text.setText("7");
                        toClear=false;
                    }else{
                        text.append("7");
                    }
                    break;
                case R.id.button8:
                    if(toClear)
                    {
                        text.setText("8");
                        toClear=false;
                    }else{
                        text.append("8");
                    }
                    break;
                case R.id.button9:
                    if(toClear)
                    {
                        text.setText("9");
                        toClear=false;
                    }else{
                        text.append("9");
                    }
                    break;

                /*
                    when an operator is pressed, the current number is saved to memory
                    any numbers pressed afterward will clear the previous number
                    set a number to operation to know what operation to perform
                 */
                case R.id.buttona:
                    operation = 1;
                    mem = Double.parseDouble(text.getText().toString());
                    toClear=true;
                    firstOp=true;
                    break;
                case R.id.buttons:
                    operation = 2;
                    mem = Double.parseDouble(text.getText().toString());
                    toClear=true;
                    firstOp=true;
                    break;
                case R.id.buttonm:
                    operation = 3;
                    mem = Double.parseDouble(text.getText().toString());
                    toClear=true;
                    firstOp=true;
                    break;
                case R.id.buttond:
                    operation = 4;
                    mem = Double.parseDouble(text.getText().toString());
                    toClear=true;
                    firstOp=true;
                    break;

                /*
                    buttone is the equals button
                    when pressed will take the number in memory and perform operation with the current number on textview
                 */
                case R.id.buttone:
                    if(firstOp==true)
                    {
                        val = Double.parseDouble(text.getText().toString());
                        mem = calculate(mem,val,operation);
                        if(mem!=Math.ceil(mem))
                            text.setText(String.valueOf(mem));
                        else
                            text.setText(String.valueOf((int)mem));
                        firstOp=false;
                    }else{
                        mem = calculate(mem,val,operation);
                        if(mem!=Math.ceil(mem))
                            text.setText(String.valueOf(mem));
                        else
                            text.setText(String.valueOf((int)mem));
                    }
                    toClear=true;
                    break;
            }
        }
        switch(view.getId())
        {
            /*
                button40 is MC
                sets textview to 0
                sets memory to 0
             */
            case R.id.button40:
                text.setText("0");
                mem = 0;
                firstOp = true;
                toClear=true;
                break;

            /*
                button41 is MR
                sets memory to textview
             */
            case R.id.button41:
                if(mem!=Math.ceil(mem))
                    text.setText(String.valueOf(mem));
                else
                    text.setText(String.valueOf((int)mem));
                toClear=true;
                break;


            //does add operation with number in memory and textview
            case R.id.button42:
                val = Double.parseDouble(text.getText().toString());
                mem = calculate(mem,val,1);
                if(mem!=Math.ceil(mem))
                    text.setText(String.valueOf(mem));
                else
                    text.setText(String.valueOf((int)mem));
                break;

            //does subtract operation with number in memory and textview
            case R.id.button43:
                val = Double.parseDouble(text.getText().toString());
                mem = calculate(mem,val,2);
                if(mem!=Math.ceil(mem))
                    text.setText(String.valueOf(mem));
                else
                    text.setText(String.valueOf((int)mem));
                break;
        }
    }
}
