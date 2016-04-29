package com.pluralsight.layoutsandviews;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jim on 6/11/13.
 */
public class OtherActivity extends Activity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_other);

    setupUiEvents();
  }

  void setupUiEvents() {
    Button theButton = (Button) findViewById(R.id.topSectionButton);
    theButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        OtherActivity.this.handleButton1Click((Button) view);
      }
    });

    Button theButton2 = (Button) findViewById(R.id.button2);
    theButton2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        handleButton2Click((Button) view);
      }
    });
  }

  void handleButton1Click(Button button) {
    TextView textView = (TextView) findViewById(R.id.firstTopTextView);
    textView.setText("Click 1");
  }

  void handleButton2Click(Button button) {
    TextView textView = (TextView) findViewById(R.id.firstTopTextView);
    textView.setText("Click 2");
  }
}