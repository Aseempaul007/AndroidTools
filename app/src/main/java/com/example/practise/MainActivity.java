package com.example.practise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AnalogClock;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DigitalClock;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {

    private static final String MY_TAG = "The custom messages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_9);
          //TODO Add method/methods here!!
    }

// Method 1: Adding checkbox to your android activity.

    public void addCheckBox(){
        final CheckBox checkBoxOne = (CheckBox)findViewById(R.id.ch1);
        final CheckBox checkBoxTwo = (CheckBox)findViewById(R.id.ch2);
        final CheckBox checkBoxThree = (CheckBox)findViewById(R.id.ch3);
        final CheckBox checkBoxFour = (CheckBox)findViewById(R.id.ch4);
        final CheckBox checkBoxFive = (CheckBox)findViewById(R.id.ch5);
        Button btn = (Button)findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("SpiderMan =>").append(checkBoxOne.isChecked());
                stringBuffer.append("\nSuperMan =>").append(checkBoxTwo.isChecked());
                stringBuffer.append("\nHulk =>").append(checkBoxThree.isChecked());
                stringBuffer.append("\nSinchan =>").append(checkBoxFour.isChecked());
                stringBuffer.append("\nActionKamen =>").append(checkBoxFive.isChecked());

                Toast.makeText(MainActivity.this,stringBuffer.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        // For adding onChecked Alert seperately. Try one!!
        checkBoxOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"SpiderMan => "+checkBoxOne.isChecked(),Toast.LENGTH_SHORT).show();
            }
        });
    }

// Method 2: Adding RadioButton to your android activity.

    public void radioButton(){
        RadioButton radioButtonOne = (RadioButton)findViewById(R.id.rd1);
        RadioButton radioButtonTwo = (RadioButton)findViewById(R.id.rd2);
        RadioButton radioButtonThree = (RadioButton)findViewById(R.id.rd3);
        RadioButton radioButtonFour = (RadioButton)findViewById(R.id.rd4);
        RadioButton radioButtonFive = (RadioButton)findViewById(R.id.rd5);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Doremon").append(radioButtonOne.isChecked());
        stringBuffer.append("Nobita").append(radioButtonTwo.isChecked());
        stringBuffer.append("Shizuka").append(radioButtonThree.isChecked());
        stringBuffer.append("Jian").append(radioButtonFour.isChecked());
        stringBuffer.append("Sunio").append(radioButtonFive.isChecked());
        if(radioButtonOne.isChecked()==true){
            Toast.makeText(MainActivity.this,"Doremon is checked",Toast.LENGTH_SHORT).show();

        }

        Toast.makeText(MainActivity.this,stringBuffer.toString(),Toast.LENGTH_SHORT).show();


    }

// Method 3: Adding Rating to your android activity.

    public void setRating(){
         final RatingBar ratingBar = (RatingBar)findViewById(R.id.rt);
         final Button button = (Button)findViewById(R.id.btnrt);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(MainActivity.this,(String.valueOf(ratingBar.getRating())),Toast.LENGTH_SHORT).show();
             }
         });
    }

// Method 4: Adding AlertBox to your android activity.

    public void makeAlert(){
        Button btnAlt = (Button)findViewById(R.id.btnalert);
        btnAlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alt = new AlertDialog.Builder(MainActivity.this);
                alt.setMessage("Clicking OK will take you to your homeScreen");
                alt.setCancelable(false);
                alt.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alt.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alt.create();
                alertDialog.setTitle("DANGER");
                alertDialog.show();
            }
        });


    }

// Method 5: Swipe Screens

    public void goToNext(){
        Button buttonIntent = (Button)findViewById(R.id.btnintent);
        buttonIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("http://schemas.android.com/apk/res/android");
                startActivity(intent);
            }
        });
    }

// Method 6: Adding Clock to your android activity.

    public void swapClock(){
        Button buttonSwap = (Button)findViewById(R.id.btnswap);
        final AnalogClock analogClock = (AnalogClock)findViewById(R.id.analog);
        final DigitalClock digitalClock = (DigitalClock)findViewById(R.id.digital);
        digitalClock.setVisibility(DigitalClock.GONE);
        buttonSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(analogClock.getVisibility()==DigitalClock.GONE){
                    analogClock.setVisibility(AnalogClock.VISIBLE);
                    digitalClock.setVisibility(DigitalClock.GONE);
                }else {
                    analogClock.setVisibility(AnalogClock.GONE);
                    digitalClock.setVisibility(DigitalClock.VISIBLE);

                }
            }
        });
    }

// Method 7: Adding Images to your android activity.

    public  void image(){
        final int[] images = {R.mipmap.sketchone,R.mipmap.sketchtwo,R.mipmap.sketchthree,R.mipmap.sketchfour};
       final ImageView imageView = (ImageView)findViewById(R.id.img);
        Button buttonImg = (Button)findViewById(R.id.btnimg);
        buttonImg.setOnClickListener(new View.OnClickListener() {
            int imageturn =0;
            @Override
            public void onClick(View v) {
                Log.i(MY_TAG,"Button is clicked");

                try {
                   imageturn++;
                   if(imageturn>=4){
                       imageturn=0;
                       imageView.setImageResource(images[0]);

                   }else {
                       imageView.setImageResource(images[imageturn]);
                   }
               }catch (Exception e){
                   Log.i(MY_TAG,"The exception is"+e);
               }
            }
        });
    }

// Method 8: Adding ListView to your android activity.

    public void makeList(){
        final ListView listView = (ListView)findViewById(R.id.mylist);
        String[] names = {"Spiderman","Superman","Hulk","Ben","Lolita","Pikachu","Shinchan"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,R.layout.data,names);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String)listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,"position :"+position +"name : "+ value,Toast.LENGTH_SHORT).show();
            }
        });
    }

// Method 9: Adding ProgressBar to your android activity.

    public void seekBarProgress(){
       final SeekBar seekBar = (SeekBar)findViewById(R.id.sk1);
       final TextView tvseek = (TextView)findViewById(R.id.tvseekbar);
        tvseek.setText("PROGRESS : "+seekBar.getProgress()+"/"+seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvseek.setText("PROGRESS : "+seekBar.getProgress()+"/"+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"Progres Starts!!!",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"Progres Stops!!!",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void openUrl(){
        final EditText editTextWeb = (EditText)findViewById(R.id.etwebview);
        Button buttonWeb = (Button)findViewById(R.id.btnwebview);
        final WebView webView = (WebView)findViewById(R.id.webview);
        buttonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editTextWeb.getText().toString();
                webView.loadUrl(url);
                webView.getSettings().getJavaScriptEnabled();
                webView.getSettings().setLoadsImagesAutomatically(true);
                webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webView.setWebViewClient(new WebViewClient());
                if(webView.canGoBack()){
                    webView.goBack();
                }
            }
        });
    }
}
