package com.pluralsight.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class Activity02 extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity02);
    LogHelper.LogCallback(this, "onCreate");
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem menuItem) {
    boolean handled = true;

    int id = menuItem.getItemId();
    switch (id) {
      case R.id.action_showActivity03:
        onClickMenuShowActivityO3(menuItem);
        break;
      default:
        handled = super.onOptionsItemSelected(menuItem);
    }
    return handled;
  }

  private void onClickMenuShowActivityO3(MenuItem menuItem) {
    Intent intent = new Intent(this, Activity03.class);
    startActivity(intent);
  }

// <editor-fold desc="lifecycle callbacks">
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
    getMenuInflater().inflate(R.menu.activity02, menu);
    return true;
  }
// </editor-fold>

}
