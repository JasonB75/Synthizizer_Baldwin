package com.superking75.synthizizer_baldwin;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    private final int WHOLE_NOTE = 2000;
    private final int HALF_NOTE = WHOLE_NOTE/2;

    private Button button1;
    private Button button2;
    private Button noteNumberButton;
    private NumberPicker noteNumber;
    private NumberPicker notePicker;

    private MediaPlayer mpA;
    private MediaPlayer mpB;
    private MediaPlayer mpBb;
    private MediaPlayer mpC;
    private MediaPlayer mpCs;
    private MediaPlayer mpD;
    private MediaPlayer mpDs;
    private MediaPlayer mpE;
    private MediaPlayer mpF;
    private MediaPlayer mpFs;
    private MediaPlayer mpG;
    private MediaPlayer mpGs;
    private MediaPlayer mpHighE;
    private MediaPlayer mpHighF;
    private MediaPlayer mpHighFs;
    private MediaPlayer mpHighG;
    int noteNoteNumber = 1;
    int notepicked = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        noteNumberButton = (Button)findViewById(R.id.noteNumberButton);
        final TextView main = (TextView) findViewById(R.id.text1);
        noteNumber = (NumberPicker) findViewById(R.id.np);
        notePicker = (NumberPicker) findViewById(R.id.note);
        final String[] noteValues = {"a", "b", "Bb", "C", "C#", "d", "d#", "e", "f", "f#", "g", "g#", "High E", "High F#", "High G"};
        notePicker.setMinValue(0);
        notePicker.setMaxValue(noteValues.length-1);
        notePicker.setDisplayedValues(noteValues);
        notePicker.setWrapSelectorWheel(true);

       // mpE = MediaPlayer.create(this, R.raw.scalee);
        //mpF = MediaPlayer.create(this, R.raw.scalef);

        mpA= MediaPlayer.create(this, R.raw.scalea);
          mpB= MediaPlayer.create(this, R.raw.scaleb);
          mpBb= MediaPlayer.create(this, R.raw.scalebb);
          mpC=MediaPlayer.create(this, R.raw.scalec);
          mpCs=MediaPlayer.create(this, R.raw.scalecs);
          mpD= MediaPlayer.create(this, R.raw.scaled);
          mpDs= MediaPlayer.create(this, R.raw.scaleds);
          mpE= MediaPlayer.create(this, R.raw.scalee);
          mpF= MediaPlayer.create(this, R.raw.scalef);
          mpFs= MediaPlayer.create(this, R.raw.scalefs);
          mpG= MediaPlayer.create(this, R.raw.scaleg);
          mpGs= MediaPlayer.create(this, R.raw.scalegs);
          mpHighE= MediaPlayer.create(this, R.raw.scalehighe);
          mpHighF= MediaPlayer.create(this, R.raw.scalehighf);
         mpHighFs= MediaPlayer.create(this, R.raw.scalehighfs);
          mpHighG= MediaPlayer.create(this, R.raw.scalehighg);
        final MediaPlayer[] noteList ={mpA, mpB, mpBb, mpC, mpCs, mpD, mpDs, mpE, mpF, mpFs,mpG, mpGs, mpHighE, mpHighFs, mpHighG};
        final MediaPlayer[] twinkleArray = {mpA, mpB};

        noteNumber.setMinValue(1);
        noteNumber.setMaxValue(10);
        noteNumber.setWrapSelectorWheel(true);

        noteNumber.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                noteNoteNumber = newVal;
                //main.setText(newVal);
            }
        });

        notePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected value from picker
                notepicked= newVal ;
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpE.seekTo(0);
                Log.e(  TAG, "Button 1 clicked");
                mpE.start();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int stepper = 0;

                Log.e(  TAG, "Button 2 clicked");
                while (stepper < noteList.length-1)
                {
                    noteList[stepper].seekTo(0);
                    noteList[stepper].start();
                    delayPlaying(WHOLE_NOTE);
                    //  temp[notepicked].stop();
                    stepper++;

                }

            }
        });

        noteNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int stepper = 0;
                //MediaPlayer[] noteList ={mpA, mpB, mpBb, mpC, mpCs, mpD, mpDs, mpE, mpF, mpFs,mpG, mpGs, mpHighE, mpHighFs, mpHighG};

                while (stepper < noteNoteNumber)
                {
                    noteList[notepicked].seekTo(0);
                    noteList[notepicked].start();
                    delayPlaying(WHOLE_NOTE);
                  //  temp[notepicked].stop();
                    stepper++;

                }

            }
        });


    }
    private void delayPlaying(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Log.e("SynthesizerActivity","Audio playback interrupted");
        }
    }

}
