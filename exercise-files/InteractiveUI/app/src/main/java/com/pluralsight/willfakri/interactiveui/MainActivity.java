package com.pluralsight.willfakri.interactiveui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled;

        int id = item.getItemId();

        switch (id){
            case R.id.action_other:
                onClickMenuOther(item);
                handled = true;
                break;
            case R.id.action_exit:
                onClickMenuExit(item);
                handled = true;
                break;
            default:
                handled = super.onOptionsItemSelected(item);
                break;
        }
        return handled;
    }

    public void onClickMenuOther(MenuItem item){
        Toast toast = Toast.makeText(this, "Booo!", Toast.LENGTH_LONG);
        toast.show();
    }

    public void onClickMenuExit(MenuItem item){
        finish();
    }
}
