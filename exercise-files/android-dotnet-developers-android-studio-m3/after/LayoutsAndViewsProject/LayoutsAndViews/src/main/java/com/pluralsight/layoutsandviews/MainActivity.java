package com.pluralsight.layoutsandviews;

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
    switch(item.getItemId()) {
      case R.id.action_other_activity:
        onClickMenuOtherActivity(item);
        break;
      case R.id.action_close:
        finish();
        break;
      default:
        super.onOptionsItemSelected(item);
    }
    return handled;
  }

  private void onClickMenuOtherActivity(MenuItem item) {
    Intent intent = new Intent(this, OtherActivity.class);
    startActivity(intent);
  }
}
