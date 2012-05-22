package in.j605.android.wiktionaryapp;

import android.app.Activity;
//import android.widget.LinearLayout;
import android.os.Bundle;
import android.os.Environment;
//import android.view.ViewGroup;
//import android.widget.Button;
import android.view.View;
//import android.view.View.OnClickListener;
//import android.content.Context;
import android.util.Log;
import android.media.MediaRecorder;
//import android.media.MediaPlayer;

import java.io.IOException;




public class PronunciationActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    private static String mFilename = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test.3gp";
            
    private MediaRecorder mRecorder = null;
    
    private boolean onRecord = false;
    
    public void startRecording(View view) {
    	onRecord = true;
    	mRecorder = new MediaRecorder();
    	mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
    	mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
    	mRecorder.setOutputFile(mFilename);
    	mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
    	
    	try {
    		mRecorder.prepare();
    	} catch (IOException e) {
    		Log.e("Recording", "prepare() failed");
    	}
    	
    	mRecorder.start();
    }
    
    public void stopRecording(View view) {
    	if (onRecord) {
    		mRecorder.stop();
    		mRecorder.release();
    		mRecorder = null;
    		onRecord = false;
    	}
    }   
}