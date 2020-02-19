package com.example.minitransletor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView showText;
    String[] languages = {"sem`s code", "kirpich po sem", "kirpich po vinice", "ascii"};
    Spinner spinner;
    int index;
    ImageButton methodButton;
    int anInt1 = 0;
    ClipData clipData;
    ClipboardManager clipboardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        showText = findViewById(R.id.showText);
        spinner = findViewById(R.id.spinner);
        methodButton = findViewById(R.id.methodButton);

        Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), item, Toast.LENGTH_LONG).show();
                index = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);



    }

    public void onClickText(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("", showText.getText().toString());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(getApplicationContext(),"Text Copied",Toast.LENGTH_SHORT).show();

    }

    public void onClickTransButton(View view) {
        if(anInt1 == 0){
            if(index == 0){
                semCode();
            }else if(index == 1){
                kirpSem();
            }else if(index == 2){
                kirpVinc();
            }else if(index == 3){
                ascii();
            }else if(index == 4){

            }else{
                showText.setText("");
            }
        }else if (anInt1 == 1){
            if(index == 0){
                semCodeRev();
            }else if(index == 1){
                kirpSem();
            }else if(index == 2){
                //kirpVinc();
            }else if(index == 3){
                asciiRev();
            }else if(index == 4){

            }else{
                showText.setText("");
            }
        }
    }



    public void onClickMethodButton(View view) {
        if(anInt1 == 0){
            methodButton.animate().rotation(180);
            anInt1++;
        }else if (anInt1 == 1){
            methodButton.animate().rotation(0);
            anInt1--;
        }
    }

    private void kirpVinc(){
        String text1 = String.valueOf(editText.getText());
        String text2 = "";
        String[] arr = text1.split("");
        for (int i = 0; i < arr.length; i++) {
            if(!(arr[i].equals("") || arr[i].equals(" ") || arr[i].equals("\n"))){
                if(arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")){
                    arr[i] += "s" + arr[i];
                }
            }
            text2 += arr[i];
        }
        showText.setText(text2);
    }

    private void kirpSem(){
        String text1 = String.valueOf(editText.getText());
        String text2 = "";
        String[] arrOfWords = text1.split(" ");
        for (int i = 0; i < arrOfWords.length; i++) {
            arrOfWords[i] = new StringBuffer(arrOfWords[i]).reverse().toString();
            text2 += arrOfWords[i] + " ";
        }
        showText.setText(text2);
    }

    private void semCode(){
        String[] symbols = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                "t", "u", "v", "w", "x", "y", "z", "'", " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String[] code = {"000001", "000010", "000100", "001000", "010000", "100000", "000011", "000110", "001100", "011000",
                "110000", "000111", "001110", "011100", "111000", "001111", "011110", "111100", "011111", "111110", "100001",
                "101010", "010101", "001101", "110010", "111111", "000000", "101101", "111101", "111011", "110111", "101111",
                "111001", "110011", "100111", "110001", "100011", "010010"};
        String text1 = String.valueOf(editText.getText());
        String text2 = "";
        String[] arr = text1.split("");
        for (int i = 0; i < arr.length; i++) {
            if(!(arr[i].equals("") || arr[i].equals("\n"))){
                for (int j = 0; j < symbols.length ; j++) {
                    if(arr[i].equals(symbols[j])){
                        arr[i] = code[j];
                    }
                }
                text2 += arr[i] + " ";
            }
        }
        showText.setText(text2);
    }

    private void semCodeRev(){
        String[] symbols = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                "t", "u", "v", "w", "x", "y", "z", "'", " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String[] code = {"000001", "000010", "000100", "001000", "010000", "100000", "000011", "000110", "001100", "011000",
                "110000", "000111", "001110", "011100", "111000", "001111", "011110", "111100", "011111", "111110", "100001",
                "101010", "010101", "001101", "110010", "111111", "000000", "101101", "111101", "111011", "110111", "101111",
                "111001", "110011", "100111", "110001", "100011", "010010"};
        String text1 = String.valueOf(editText.getText());
        String text2 = "";
        String[] arr = text1.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if(!(arr[i].equals("") || arr[i].equals("\n"))){
                for (int j = 0; j < symbols.length ; j++) {
                    if(arr[i].equals(code[j])){
                        arr[i] = symbols[j];
                    }
                }
                text2 += arr[i];
            }
        }
        showText.setText(text2);
    }

    private void ascii() {
        String text1 = String.valueOf(editText.getText());
        String text2 = "";
        for (int i = 0; i < text1.length(); i++) {
            text2 += (int) text1.charAt(i) + " ";
        }
        showText.setText(text2);
    }


    private void asciiRev(){
        String text1 = String.valueOf(editText.getText());
        String text2 = "";
        int k = 0;
        char a;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < text1.length(); i++) {
            arr.set(i, 0);
            for (int j = k; j < text1.length(); j++) {
                a = text1.charAt(j);
                k = j;
                if(a == '0'){
                    arr.set(i, arr.get(i)*10);
                } else if (a == '1'){
                    arr.set(i, (arr.get(i)+1)*10);
                } else if (a == '2'){
                    arr.set(i, (arr.get(i)+2)*10);
                } else if (a == '3'){
                    arr.set(i, (arr.get(i)+3)*10);
                } else if (a == '4'){
                    arr.set(i, (arr.get(i)+4)*10);
                } else if (a == '5'){
                    arr.set(i, (arr.get(i)+5)*10);
                } else if (a == '6'){
                    arr.set(i, (arr.get(i)+6)*10);
                } else if (a == '7'){
                    arr.set(i, (arr.get(i)+7)*10);
                } else if (a == '8'){
                    arr.set(i, (arr.get(i)+8)*10);
                } else if (a == '9'){
                    arr.set(i, (arr.get(i)+9)*10);
                } else if (a == ' '){
                    break;
                }
            }
            text2 += (char) (int) arr.get(i);
        }
        showText.setText(text2);
    }


}
