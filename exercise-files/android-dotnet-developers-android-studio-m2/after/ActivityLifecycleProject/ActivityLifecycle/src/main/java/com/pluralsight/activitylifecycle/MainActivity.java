package com.pluralsight.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    Boolean handled = true;

    int id = item.getItemId();
    switch (id) {
      case R.id.action_showActivity2:
        onClickMenuShowActivity2(item);
        break;
      case R.id.action_showActivity3:
        onClickMenuShowActivity3(item);
        break;
      case R.id.action_exit:
        onClickMenuExit(item);
        break;
      default:
        handled = super.onOptionsItemSelected(item);
    }
    return handled;
  }

  void onClickMenuShowActivity2(MenuItem item) {
    Intent intent = new Intent(this, Activity2.class);
    startActivity(intent);
  }

  void onClickMenuShowActivity3(MenuItem item) {
    Intent intent = new Intent(this, Activity3.class);
    startActivity(intent);
  }

  void onClickMenuExit(MenuItem item) {
    finish();
  }

}
