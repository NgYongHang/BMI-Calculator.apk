package com.test.bmicalculator;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
TextView tv1,tv2,tv3,tv4,tv5,tv6;
EditText et1,et2;
VideoView vv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv5 =findViewById(R.id.tv5);
        tv6 =findViewById(R.id.tv6);
        et1 = findViewById(R.id.et1);
        et2 =findViewById(R.id.et2);
        vv1 = findViewById(R.id.videoView);

    }

    public void clickme(View v) throws IOException {

        String str1 = et1.getText().toString();
        String str2 = et2.getText().toString();
        String url = "http://slumberjer.com/android/met/Met6.mp3"; // your URL here
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setDataSource(url);
        mediaPlayer.prepare(); // might take long! (for buffering, etc)
        mediaPlayer.start();
        if(TextUtils.isEmpty(str1)){
            et1.setError("Please enter your weight");
            et1.requestFocus();

            return;
        }

        if(TextUtils.isEmpty(str2)){
            et2.setError("Please enter your height");
            et2.requestFocus();
            return;
        }
        double weight = Double.parseDouble(str1);
        double height = Double.parseDouble(str2);
        result(calcBMI(weight,height));

    }
    public double calcBMI(double weight, double height){
        double bmi = weight / (height*height);

        tv5.setText("Your BMI Result: "+String.format("%.2f",bmi));
        return bmi;
    }
    public void result(double result){
        if(result>=0 && result <18.5){
            tv6.setText("Underweight");
        }
        else if(result>=18.5 && result <25.0){
            tv6.setText("Normal");
        }
        else if(result>=25.0 && result <30.0){
            tv6.setText("Overweight");
        }
        else if(result>=30.0 && result <35.0){
            tv6.setText("Obese");
        }
        else{
            tv6.setText("Extremly Obese");
        }
    }
}
