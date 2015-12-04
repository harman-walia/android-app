package com.labourtoday.androidapp.contractor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.labourtoday.androidapp.Constants;
import com.labourtoday.androidapp.R;

public class ContractorMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractor_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Labour Today");
        Button payment = (Button) findViewById(R.id.button_pay);

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (settings.getString(Constants.AUTH_TOKEN, "").equals("")) {
            payment.setAlpha(.5f);
            payment.setClickable(false);
            payment.setEnabled(false);
        }
    }

    /**
     * Handler for the hire button
     * @param view
     *          Reference to the button
     */
    public void launchHire(View view) {
        startActivity(new Intent(this, DatePickerActivity.class));
    }

    /**
     * Handler for the Payment button
     * @param view
     *          Reference to the button
     */
    public void launchPayment(View view) {
        startActivity(new Intent(this, PaymentActivity.class));
    }
}