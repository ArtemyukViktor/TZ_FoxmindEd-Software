package com.example.rangeseekbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import io.apptik.widget.MultiSlider;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    TextView tvFrom;
    TextView tvTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MultiSlider multiSlider5 = findViewById(R.id.range_slider5);
        tvFrom = findViewById(R.id.tvFrom);
        tvTo  = findViewById(R.id.tvTo);

        multiSlider5.setStep(250000);
        multiSlider5.setMax(8000000,true, true);
        multiSlider5.setKeyProgressIncrement(500);
      //  multiSlider5.getThumb(0).setValue(500000);
      //  multiSlider5.getThumb(1).setValue(700000);


        multiSlider5.setOnThumbValueChangeListener(new MultiSlider.OnThumbValueChangeListener() {
            @Override
            public void onValueChanged(MultiSlider multiSlider,
                                       MultiSlider.Thumb thumb,
                                       int thumbIndex,
                                       int value)
            {
                if (thumbIndex == 0) {
                    Log.d("hereTad", "onValueChanged: "+value);
                    tvFrom.setText(String.valueOf(value));
                  //  doSmth(String.valueOf(value));
                } else {
                    tvTo.setText(String.valueOf(value));

                    Log.d("hereTad", "onValueChanged rrrr: "+value);

                  //  doSmthElse(String.valueOf(value));
                }
            }
        });
    }

}
