package com.example.menupickershwaph3;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //campos
    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafe.extra.MESSAGE";
    private String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //explicit intent
                Intent intent = new Intent(MainActivity.this, activity_order.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //      .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    /**
     * Método de los toast para enviar noticifaciones emergentes sin bloquear la activity
     * @param message
     */
    public void displayToast(String message) {
        //contexto o lugar donde se necesita ver//texto del msj//duracion//.show
        // es un método para poder mostrarlo
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    /**
     * Shows a message that the froyo image was clicked.
     */
    public void showFroyoOrder(View view) {
        //llama al método displayToast, recoge el string correspondiente a la imagen seleccionada
        //displayToast(getString(R.string.froyo_order_message));
        mOrderMessage = getString(R.string.froyo_order_message);
        displayToast(mOrderMessage);
    }

    /**
     * Shows a message that the donut image was clicked.
     */
    public void showDonutOrder(View view) {
        //displayToast(getString(R.string.donut_order_message));
        mOrderMessage = getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
    }
    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    public void showIceCreamOrder(View view) {
        // displayToast(getString(R.string.ice_cream_order_message));
        mOrderMessage = getString(R.string.ice_cream_order_message);
        displayToast(mOrderMessage);
    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order:
                Intent intent = new Intent(MainActivity.this, activity_order.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
                return true;
            // case R.id.action_order:
            //   displayToast(getString(R.string.action_order_message));
            // return true;
            case R.id.action_status:
                displayToast(getString(R.string.action_status_message));
                return true;
            case R.id.action_favorites:
                displayToast(getString(R.string.action_favorites_message));
                return true;
            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                return true;
            default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);
    }
}