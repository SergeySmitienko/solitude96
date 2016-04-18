package anton_stoletov.coachhelper;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageButton newBtn, startBtn, stopBtn;
    private Drawing drawView;
    private Chronometer clock;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newBtn = (ImageButton)findViewById(R.id.newCanvas);
        startBtn = (ImageButton)findViewById(R.id.start);
        stopBtn = (ImageButton)findViewById(R.id.stop);
        newBtn.setOnClickListener(this);
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);

        drawView = (Drawing)findViewById(R.id.drawing);

        toast = new Toast(this);

        clock = (Chronometer)findViewById(R.id.clock);
        clock.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long elapsedMillis = SystemClock.elapsedRealtime() - clock.getBase();
                if(elapsedMillis > 50000){
                    toast.makeText(getApplicationContext(), "Тайм Аут заканчивается!", Toast.LENGTH_SHORT).show();
                    if(stopBtn.isPressed())   toast.cancel();
                }


            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newCanvas:
                drawView.Clear();
                break;
            case R.id.start:
                clock.setBase(SystemClock.elapsedRealtime());
                clock.start();
                break;
            case R.id.stop:
                clock.stop();
                clock.setBase(SystemClock.elapsedRealtime());
                break;

        }
    }

    @Override
    public void onBackPressed(){
        openQuitDialog();
    }

    private void openQuitDialog(){
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(this);
        quitDialog.setTitle("Вы уверены, что хотите выйти?");

        quitDialog.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        quitDialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        quitDialog.show();
    }
}
