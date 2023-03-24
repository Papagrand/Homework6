package com.example.homework6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Locale locale = new Locale("ru", "RU");
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        Resources res = getResources();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        String text2TaskTop = getString(R.string.formating_message1,"задание",2);
        String text2TaskBot = getString(R.string.formating_message2,year,month,day,hour,minute);

        TextView topSec = findViewById(R.id.textViewTop);
        TextView botSec = findViewById(R.id.textViewBot);

        topSec.setText(text2TaskTop);
        botSec.setText(text2TaskBot);


        String rose = getResources().getQuantityString(R.plurals.flowers, 2, 2);
        System.out.printf(rose);
        TextView TextPlur = findViewById(R.id.TextPlurId);
        TextPlur.setText(rose);


        Resources res2 = getResources();
        String[] languages = res.getStringArray(R.array.languages);
        String allLangs = "";
        for (String lang: languages) {
            allLangs += lang + " ";
        }
        TextView textLang = findViewById(R.id.TextLang);
        textLang.setText(allLangs);
    }
    public static boolean isNumeric(String str) {
        return str != null && str.matches("-?\\d+(\\.\\d+)?");
    }

    public void onClickAgreePlum(View view){
        EditText editText = findViewById(R.id.EditPlurId);
        String textFromEditText=editText.getText().toString();
        if(textFromEditText==""){
            String rose = getResources().getQuantityString(R.plurals.flowers, 1, 1);
            TextView TextPlur = findViewById(R.id.TextPlurId);
            TextPlur.setText(rose);
        }
        else if(isNumeric(textFromEditText)){
            int num = Integer.parseInt(textFromEditText);
            if (num!=0) {
                String rose = getResources().getQuantityString(R.plurals.flowers, num, num);
                TextView TextPlur = findViewById(R.id.TextPlurId);
                TextPlur.setText(rose);
            }
        }
        editText.setText("");
    }
}