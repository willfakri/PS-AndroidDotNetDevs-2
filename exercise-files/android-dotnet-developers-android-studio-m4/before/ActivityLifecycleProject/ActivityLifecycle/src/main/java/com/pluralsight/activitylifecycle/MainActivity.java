package com.pluralsight.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

  TextView mTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    LogHelper.LogCallback(this, "onCreate");

    setupViews();
  }

  private void setupViews() {
    Button button1 = (Button) findViewById(R.id.button1);
    Button button2 = (Button) findViewById(R.id.button2);

    button1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onButton1Click((Button) view);
      }
    });

    button2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onButton2Click((Button) view);
      }
    });
  }

  void onButton1Click(Button button) {
    mTextView = (TextView) findViewById(R.id.textView);
    mTextView.setText("Click 1");

    Button button2 = (Button) findViewById(R.id.button2);
    button2.setEnabled(true);
  }

  void onButton2Click(Button button) {
    mTextView.setText("Click 2");

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem menuItem) {
    boolean handled = true;

    int id = menuItem.getItemId();
    switch (id) {
      case R.id.action_showActivity02:
        onClickMenuShowActivityO2(menuItem);
        break;
      default:
        handled = super.onOptionsItemSelected(menuItem);
    }
    return handled;
  }

  void onClickMenuShowActivityO2(MenuItem menuItem) {
    Intent intent = new Intent(this, Activity02.class);
    startActivity(intent);
  }

//<editor-fold desc="lifecycle callbacks">

  @Override
  protected void onStart() {
    super.onStart();
    LogHelper.LogCallback(this, "onStart");
  }

  @Override
  protected void onResume() {
    super.onResume();
    LogHelper.LogCallback(this, "onResume");
  }

  @Override
  protected void onPause() {
    super.onPause();
    LogHelper.LogCallback(this, "onPause");
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    LogHelper.LogCallback(this, "onSaveInstanceState");
  }

  @Override
  protected void onStop() {
    super.onStop();
    LogHelper.LogCallback(this, "onStop");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    LogHelper.LogCallback(this, "onDestroy");
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

// </editor-fold>

}
