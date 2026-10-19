package com.example.xylophone;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private final int NR_OF_SIMULTANEOUS_SOUNDS = 7;
    private final float LEFT_VOLUME = 1.0f;
    private final float RIGHT_VOLUME = 1.0f;
    private final int NO_LOOP = 0;
    private final int PRIORITY = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;
    private int mDoSoundID;
    private int mReSoundId;
    private int mMiSoundId;
    private int mFaSoundId;
    private int mSolSoundId;
    private int mLaSoundId;
    private int mSiSoundId;
    SoundPool mSoundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        mSoundPool = new SoundPool.Builder()
                .setMaxStreams(NR_OF_SIMULTANEOUS_SOUNDS)
                .setAudioAttributes(attributes)
                .build();

        mDoSoundID  = mSoundPool.load(this, R.raw.note1_do,  PRIORITY);
        mReSoundId  = mSoundPool.load(this, R.raw.note2_re,  PRIORITY);
        mMiSoundId  = mSoundPool.load(this, R.raw.note3_mi,  PRIORITY);
        mFaSoundId  = mSoundPool.load(this, R.raw.note4_fa,  PRIORITY);
        mSolSoundId = mSoundPool.load(this, R.raw.note5_sol, PRIORITY);
        mLaSoundId  = mSoundPool.load(this, R.raw.note6_la,  PRIORITY);
        mSiSoundId  = mSoundPool.load(this, R.raw.note7_si,  PRIORITY);
    }

    private void playNote(int soundId) {
        mSoundPool.play(soundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
    }
    public void playDo(View view)  { playNote(mDoSoundID); }
    public void playRe(View view)  { playNote(mReSoundId); }
    public void playMi(View view)  { playNote(mMiSoundId); }
    public void playFa(View view)  { playNote(mFaSoundId); }
    public void playSol(View view) { playNote(mSolSoundId); }
    public void playLa(View view)  { playNote(mLaSoundId); }
    public void playSi(View view)  { playNote(mSiSoundId); }
}