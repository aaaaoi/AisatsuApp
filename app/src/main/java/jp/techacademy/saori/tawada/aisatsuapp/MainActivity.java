package jp.techacademy.saori.tawada.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v){
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay < 2) {
                            mTextView.setText("こんばんはー");
                        } else if (hourOfDay < 10) {
                            mTextView.setText("(｡･ω･)ﾉﾞ おはよー♡");
                        } else if (hourOfDay < 18) {
                            mTextView.setText("こんにちは！！");
                        } else {
                            mTextView.setText("こんばんはー");
                        }

                        Log.d("UI_PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    }
                },
                13,
                0,
                true);
        timePickerDialog.show();
    }

}
