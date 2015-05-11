package com.mycompany.popupviewtester;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    private Button transitDemoButton;
    private Button arrivalDemoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transitDemoButton = (Button)findViewById(R.id.transitButton);
        transitDemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTransitDialog();
            }
        });
        arrivalDemoButton = (Button)findViewById(R.id.arrivalButton);
        arrivalDemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showArrivalDialog();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showTransitDialog() {
        BasePopupList basePopupList = new TransitTablePopupList(MainActivity.this);
        basePopupList.setTitle("14 NORTHBOUND");
        basePopupList.show();

    }

    private void showArrivalDialog() {
        BasePopupList basePopupList = new ArrivalPopupList(MainActivity.this);
        basePopupList.setTitle("Set Arrival");
        basePopupList.show();

    }
}
