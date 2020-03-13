package com.mrdino.caesarascii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView)findViewById(R.id.dd);
        final EditText et = (EditText)findViewById(R.id.editText);
        final EditText et2 = (EditText)findViewById(R.id.editText3);
        final EditText tv = (EditText) findViewById(R.id.editText4);
        Button btn = (Button)findViewById(R.id.button);
        Button btn2 = (Button)findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int keyc = Integer.parseInt(et2.getText().toString());
                    if (keyc == 666){
                        tv.setText("get in here for more: fsoc.sh");
                        textView.setText("Password: LEAVE ME HERE");
                        et.setText("You Figured The Puzzle!");
                    }else {
                        tv.setText(Encrypt(et.getText().toString(), keyc));
                        textView.setText("Successfully Crypted!");
                    }
                } catch (Exception e){
                    textView.setText(e.getMessage());
                    textView.setText(textView.getText().toString().concat("\nTry To Put Only Numbers in Key"));
                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int keyc = Integer.parseInt(et2.getText().toString());
                    tv.setText(DecryptD(et.getText().toString(), keyc));
                    textView.setText("Successfully Decrypted!");
                } catch (Exception e){
                    textView.setText(e.getMessage());
                    textView.setText(textView.getText().toString().concat("\nTry To Put Only Numbers in Key"));
                }
            }
        });
    }

    String Encrypt(String message, int dkey){
        String result = "";
        char resc;
        for (int i = 0; i < message.length() ; i++) {
            resc = ((char)((int)(message.charAt(i)) + dkey));
            result = result + resc;
        }
        return  result;
    }

    String DecryptD(String message, int dkey){
        String result = "";
        char resc;
        for (int i = 0; i < message.length() ; i++) {
            resc = ((char)((int)(message.charAt(i)) - dkey));
            result = result + resc;
        }
        return result;
    }
}

