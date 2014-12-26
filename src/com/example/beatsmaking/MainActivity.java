package com.example.beatsmaking;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.util.HashMap;  

import com.example.beatsmaking.MainActivity;
import com.example.beatsmaking.R;

import android.media.AudioManager;  
import android.media.MediaPlayer;
import android.media.SoundPool;  
import android.media.MediaPlayer.OnCompletionListener;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;  
import android.app.Activity;  
import android.view.Menu;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;  
  
public class MainActivity extends Activity {  
  
    private Button bass1, drum1, hihit1, strings1, brass, lead1, piano1,
    			   bass2, drum2, hihit2, strings2, cello, lead2, piano2,
    			   stop1, stop2, stop3, stop4, stop5, stop6, stop7;  
    
    private Handler mThreadHandler;
    private HandlerThread mThread1;
    private HandlerThread mThread2;
    private HandlerThread mThread3;
    private HandlerThread mThread4;
    private HandlerThread mThread5;
    private HandlerThread mThread6;
    private HandlerThread mThread7;
    
    private MediaPlayer player1;
    private MediaPlayer player2;
    private MediaPlayer player3;
    private MediaPlayer player4;
    private MediaPlayer player5;
    private MediaPlayer player6;
    private MediaPlayer player7;
    
    int bass;
    int drum;
    int hihit;
    int strings;
    int brassOrCello;
    int lead;
    int piano;
    

    public void init(){  
        bass1 = (Button) findViewById(R.id.bass1);  
        drum1 = (Button) findViewById(R.id.drum1);  
        hihit1 = (Button) findViewById(R.id.hihit1);  
        strings1 = (Button) findViewById(R.id.strings1);  
        brass = (Button) findViewById(R.id.brass);  
        lead1 = (Button) findViewById(R.id.lead1);
        piano1 = (Button) findViewById(R.id.piano1);      
        bass2 = (Button) findViewById(R.id.bass2);  
        drum2 = (Button) findViewById(R.id.drum2);  
        hihit2 = (Button) findViewById(R.id.hihit2);  
        strings2 = (Button) findViewById(R.id.strings2);  
        cello = (Button) findViewById(R.id.cello);  
        lead2 = (Button) findViewById(R.id.lead2);
        piano2 = (Button) findViewById(R.id.piano2);
        stop1 = (Button) findViewById(R.id.stop1);
        stop2 = (Button) findViewById(R.id.stop2);
        stop3 = (Button) findViewById(R.id.stop3);
        stop4 = (Button) findViewById(R.id.stop4);
        stop5 = (Button) findViewById(R.id.stop5);
        stop6 = (Button) findViewById(R.id.stop6);
        stop7 = (Button) findViewById(R.id.stop7);
        
        bass1.setOnClickListener(listener);
        drum1.setOnClickListener(listener);
        hihit1.setOnClickListener(listener);
        strings1.setOnClickListener(listener);
        brass.setOnClickListener(listener);
        lead1.setOnClickListener(listener);
        piano1.setOnClickListener(listener);
        bass2.setOnClickListener(listener);
        drum2.setOnClickListener(listener);
        hihit2.setOnClickListener(listener);
        strings2.setOnClickListener(listener);
        cello.setOnClickListener(listener);
        lead2.setOnClickListener(listener);
        piano2.setOnClickListener(listener);
        stop1.setOnClickListener(listener);
        stop2.setOnClickListener(listener);
        stop3.setOnClickListener(listener);
        stop4.setOnClickListener(listener);
        stop5.setOnClickListener(listener);
        stop6.setOnClickListener(listener);
        stop7.setOnClickListener(listener);
        
        mThread1=new HandlerThread("1");
        mThread1.start();
        mThread2=new HandlerThread("2");
        mThread2.start();
        mThread3=new HandlerThread("3");
        mThread3.start();
        mThread4=new HandlerThread("4");
        mThread4.start();
        mThread5=new HandlerThread("5");
        mThread5.start();
        mThread6=new HandlerThread("6");
        mThread6.start();
        mThread7=new HandlerThread("7");
        mThread7.start();
        
        mThreadHandler=new Handler();
        
        player1 = MediaPlayer.create(MainActivity.this, R.raw.bass1);
        bass = 1;
		player1.setOnCompletionListener(comL);
		player1.setLooping(true);
		player1.setVolume(0, 0);
				
		player2 = MediaPlayer.create(MainActivity.this, R.raw.drum1);
		drum = 1;
		player2.setOnCompletionListener(comL);
		player2.setLooping(true);
		player2.setVolume(0, 0);
		
		player3 = MediaPlayer.create(MainActivity.this, R.raw.hihit1);
		hihit = 1;
		player3.setOnCompletionListener(comL);
		player3.setLooping(true);
		player3.setVolume(0, 0);
		
		player4 = MediaPlayer.create(MainActivity.this, R.raw.strings1);
		strings = 1;
		player4.setOnCompletionListener(comL);
		player4.setLooping(true);
		player4.setVolume(0, 0);

		player5 = MediaPlayer.create(MainActivity.this, R.raw.brass);
		brassOrCello = 1;
		player5.setOnCompletionListener(comL);
		player5.setLooping(true);
		player5.setVolume(0, 0);

		player6 = MediaPlayer.create(MainActivity.this, R.raw.lead1);
		lead = 1;
		player6.setOnCompletionListener(comL);
		player6.setLooping(true);
		player6.setVolume(0, 0);

		player7 = MediaPlayer.create(MainActivity.this, R.raw.piano1);
		piano = 1;
		player7.setOnCompletionListener(comL);
		player7.setLooping(true);
		player7.setVolume(0, 0);
		
		
    }  
      
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
          
        init();  
        
    }
    
    @Override
    public void onResume(){
   	 super.onResume();
   	
    }
      
    /* 事件：启动音效 */  
    OnClickListener listener = new OnClickListener() {  
          
        public void onClick(View v) {
        	
        	player1.start();
    		player2.start();
    		player3.start();
    		player4.start();
    		player5.start();
    		player6.start();
    		player7.start();
    		
            Button btn = (Button)v;  
            switch (btn.getId()) {  
            case R.id.bass1:
            	try{
					mThreadHandler.post(r1);
				}catch(Exception e){			
				}
                break;  
            case R.id.drum1:
            	try{
					mThreadHandler.post(r2);
				}catch(Exception e){			
				}
                break;  
            case R.id.hihit1:
            	try{
					mThreadHandler.post(r3);
				}catch(Exception e){			
				}
                break;
            case R.id.strings1:
            	try{
					mThreadHandler.post(r4);
				}catch(Exception e){			
				}
                break;
            case R.id.brass:  
				try{
					mThreadHandler.post(r5);
				}catch(Exception e){			
				}
                break;
            case R.id.lead1:  
				try{
					mThreadHandler.post(r6);
				}catch(Exception e){			
				}
                break;                
            case R.id.piano1:  
				try{
					mThreadHandler.post(r7);
				}catch(Exception e){			
				}
                break;
  
                
                
            case R.id.bass2:   
            	try{
					mThreadHandler.post(r12);
				}catch(Exception e){			
				}
                break;
            case R.id.drum2:  
            	try{
					mThreadHandler.post(r22);
				}catch(Exception e){			
				}
                break;  
            case R.id.hihit2:  
            	try{
					mThreadHandler.post(r32);
				}catch(Exception e){			
				}
                break;
            case R.id.strings2:  
            	try{
					mThreadHandler.post(r42);
				}catch(Exception e){			
				}
                break;
            case R.id.cello:  
            	try{
					mThreadHandler.post(r52);
				}catch(Exception e){			
				}
                break;
            case R.id.lead2:  
            	try{
					mThreadHandler.post(r62);
				}catch(Exception e){			
				}
                break;
            case R.id.piano2:  
            	try{
					mThreadHandler.post(r72);
				}catch(Exception e){			
				}
                break;
                
                
            case R.id.stop1:
            	try{
     				mThreadHandler.post(r1stop);
     			}catch(Exception e){				
     			}
            	break;
            case R.id.stop2:
            	try{
     				mThreadHandler.post(r2stop);
     			}catch(Exception e){				
     			}
            	break;
            case R.id.stop3:
            	try{
     				mThreadHandler.post(r3stop);
     			}catch(Exception e){				
     			}
            	break;
            case R.id.stop4:
            	try{
     				mThreadHandler.post(r4stop);
     			}catch(Exception e){				
     			}
            	break;
            case R.id.stop5:
            	try{
     				mThreadHandler.post(r5stop);
     			}catch(Exception e){				
     			}
            	break;
            case R.id.stop6:
            	try{
     				mThreadHandler.post(r6stop);
     			}catch(Exception e){				
     			}
            	break;
            case R.id.stop7:
            	try{
     				mThreadHandler.post(r7stop);
     			}catch(Exception e){				
     			}
            	break;

            default:  
                break;  
            }  
        }  
    };
    private Runnable r1=new Runnable(){
        public void run(){
        	if(bass == 2){
        		int currentPosition = player2.getCurrentPosition();
        		player1.stop();
        		player1 = MediaPlayer.create(MainActivity.this, R.raw.bass1);
        		player1.setLooping(true);
                player1.start();
                player1.seekTo(currentPosition);
        		bass = 1;
        		player1.setVolume(1, 1);
			}
        	player1.setVolume(1, 1);
             //這裡放執行緒１要執行的程式。{
       		 try{
       			 player1.setVolume(1, 1);
       		 }catch(Exception e){      			 
       		 }
       	 
             //mUI_Handler.post(r2);//執行執行緒2。
        }
    };

    private Runnable r2=new Runnable(){
        public void run(){
        	if(drum == 2){
        		int currentPosition = player2.getCurrentPosition();
        		player2.stop();
        		player2 = MediaPlayer.create(MainActivity.this, R.raw.drum1);
        		player2.setLooping(true);
                player2.start();
                player2.seekTo(currentPosition);
        		drum = 1;
        		player2.setVolume(1, 1);
			}
			player2.setVolume(1, 1);
       	 //這裡放執行緒2要執行的程式。{
	   		 try{
	   			 player2.setVolume(1, 1);
	   		 }catch(Exception e){      			 
	   		 }     	 
	         }
    };
    private Runnable r3=new Runnable(){
        public void run(){
        	if(hihit == 2){
        		int currentPosition = player2.getCurrentPosition();
        		player3.stop();
        		player3 = MediaPlayer.create(MainActivity.this, R.raw.hihit1);
        		player3.setLooping(true);
                player3.start();
                player3.seekTo(currentPosition);
        		hihit = 1;
        		player3.setVolume(1, 1);
			}
			player3.setVolume(1, 1);
       	 //這裡放執行緒2要執行的程式。{
	   		 try{
	   			 player3.setVolume(1, 1);
	   		 }catch(Exception e){      			 
	   		 }    	 
	         }
    };
    private Runnable r4=new Runnable(){
        public void run(){
        	if(strings == 2){
        		int currentPosition = player2.getCurrentPosition();
        		player4.stop();
        		player4 = MediaPlayer.create(MainActivity.this, R.raw.strings1);
        		player4.setLooping(true);
                player4.start();
                player4.seekTo(currentPosition);
        		strings = 1;
        		player4.setVolume(1, 1);
			}
			player4.setVolume(1, 1);
       	 //這裡放執行緒2要執行的程式。{
	   		 try{
	   			 player4.setVolume(1, 1);
	   		 }catch(Exception e){      			 
	   		 }      	 
	         }
    };
    private Runnable r5=new Runnable(){
        public void run(){
        	if(brassOrCello == 2){
        		int currentPosition = player2.getCurrentPosition();
        		player5.stop();
        		player5 = MediaPlayer.create(MainActivity.this, R.raw.brass);
        		player5.setLooping(true);
                player5.start();
                player5.seekTo(currentPosition);
                brassOrCello = 1;
        		player5.setVolume(1, 1);
			}
			player5.setVolume(1, 1);
       	 //這裡放執行緒2要執行的程式。{
	   		 try{
	   			 player5.setVolume(1, 1);
	   		 }catch(Exception e){      			 
	   		 }     	 
	         }
    };
    private Runnable r6=new Runnable(){
        public void run(){
        	if(lead == 2){
        		int currentPosition = player2.getCurrentPosition();
        		player6.stop();
        		player6 = MediaPlayer.create(MainActivity.this, R.raw.lead1);
        		player6.setLooping(true);
                player6.start();
                player6.seekTo(currentPosition);
        		lead = 1;
        		player6.setVolume(1, 1);
			}
			player6.setVolume(1, 1);
       	 //這裡放執行緒2要執行的程式。{
	   		 try{
	   			 player6.setVolume(1, 1);
	   		 }catch(Exception e){      			 
	   		 }      	 
	         }
    };
    private Runnable r7=new Runnable(){
        public void run(){
        	if(piano == 2){
        		int currentPosition = player2.getCurrentPosition();
        		player7.stop();
        		player7 = MediaPlayer.create(MainActivity.this, R.raw.piano1);
        		player7.setLooping(true);
                player7.start();
                player7.seekTo(currentPosition);
        		piano = 1;
        		player7.setVolume(1, 1);
			}
			player7.setVolume(1, 1);
       	 //這裡放執行緒2要執行的程式。{
	   		 try{
	   			 player7.setVolume(1, 1);
	   		 }catch(Exception e){      			 
	   		 }      	 
	         }
    };
    
    private Runnable r12=new Runnable(){
        public void run(){
        	if(bass == 1){
        		int currentPosition = player2.getCurrentPosition();
        		player1.stop();
        		player1 = MediaPlayer.create(MainActivity.this, R.raw.bass2);
        		player1.setLooping(true);
                player1.start();
                player1.seekTo(currentPosition);
        		bass = 2;
        		player1.setVolume(1, 1);
			}
       	 //這裡放執行緒2要執行的程式。{
	   		 try{
	   			 player1.setVolume(1, 1);
	   		 }catch(Exception e){      			 
	   		 }      	 
	         }
    };
    
    private Runnable r22=new Runnable(){
        public void run(){
        	if(drum == 1){
        		int currentPosition = player2.getCurrentPosition();
        		player2.stop();
        		player2 = MediaPlayer.create(MainActivity.this, R.raw.drum2);
        		player2.setLooping(true);
                player2.start();
                player2.seekTo(currentPosition);
        		drum = 2;
        		player2.setVolume(1, 1);
			}
       	 //這裡放執行緒2要執行的程式。{
	   		 try{
	   			 player2.setVolume(1, 1);
	   		 }catch(Exception e){      			 
	   		 }      	 
	         }
    };
    
    private Runnable r32=new Runnable(){
        public void run(){
        	if(hihit == 1){
        		int currentPosition = player2.getCurrentPosition();
        		player3.stop();
        		player3 = MediaPlayer.create(MainActivity.this, R.raw.hihit2);
        		player3.setLooping(true);
                player3.start();
                player3.seekTo(currentPosition);
        		hihit = 2;
        		player3.setVolume(1, 1);
			}
       	 //這裡放執行緒2要執行的程式。{
	   		 try{
	   			 player3.setVolume(1, 1);
	   		 }catch(Exception e){      			 
	   		 }      	 
	         }
    };
    
    private Runnable r42=new Runnable(){
        public void run(){
        	if(strings == 1){
        		int currentPosition = player2.getCurrentPosition();
        		player4.stop();
        		player4 = MediaPlayer.create(MainActivity.this, R.raw.strings2);
        		player4.setLooping(true);
                player4.start();
                player4.seekTo(currentPosition);
        		strings = 2;
        		player4.setVolume(1, 1);
			}
       	 //這裡放執行緒2要執行的程式。{
	   		 try{
	   			 player4.setVolume(1, 1);
	   		 }catch(Exception e){      			 
	   		 }      	 
	         }
    };
    
    private Runnable r52=new Runnable(){
        public void run(){
        	if(brassOrCello == 1){
        		int currentPosition = player2.getCurrentPosition();
        		player5.stop();
        		player5 = MediaPlayer.create(MainActivity.this, R.raw.cello);
        		player5.setLooping(true);
                player5.start();
                player5.seekTo(currentPosition);
        		brassOrCello = 2;
        		player5.setVolume(1, 1);
			}
       	 //這裡放執行緒2要執行的程式。{
	   		 try{
	   			 player5.setVolume(1, 1);
	   		 }catch(Exception e){      			 
	   		 }      	 
	         }
    };
    private Runnable r62=new Runnable(){
        public void run(){
        	if(lead == 1){
        		int currentPosition = player2.getCurrentPosition();
        		player6.stop();
        		player6 = MediaPlayer.create(MainActivity.this, R.raw.lead2);
        		player6.setLooping(true);
                player6.start();
                player6.seekTo(currentPosition);
        		lead = 2;
        		player6.setVolume(1, 1);
			}
       	 //這裡放執行緒2要執行的程式。{
	   		 try{
	   			 player6.setVolume(1, 1);
	   		 }catch(Exception e){      			 
	   		 }      	 
	         }
    };
    
    private Runnable r72=new Runnable(){
        public void run(){
        	if(piano == 1){
        		int currentPosition = player2.getCurrentPosition();
        		player7.stop();
        		player7 = MediaPlayer.create(MainActivity.this, R.raw.piano2);
        		player7.setLooping(true);
                player7.start();
                player7.seekTo(currentPosition);
        		piano = 2;
        		player7.setVolume(1, 1);
        	}
       	 //這裡放執行緒2要執行的程式。{
	   		 try{
	   			 player7.setVolume(1, 1);
	   		 }catch(Exception e){      			 
	   		 }      	 
	         }
    };
    
    
    
    

    private Runnable r1stop=new Runnable(){
        public void run(){
        	
             //這裡放執行緒１要執行的程式。{
       		 try{
       			 if (player1 != null) {
       				 player1.setVolume(0, 0);
       	       }      			 
       		 }catch(Exception e){      			 
       		 }
       	 
             //mUI_Handler.post(r2);//執行執行緒2。
        }
    };
    private Runnable r2stop=new Runnable(){
        public void run(){

             //這裡放執行緒１要執行的程式。{
       		 try{       			 
       			 if (player2 != null) {
       				 player2.setVolume(0, 0);
       	       }
       			        			 
       		 }catch(Exception e){      			 
       		 }
       	 
             //mUI_Handler.post(r2);//執行執行緒2。
        }
    };
    private Runnable r3stop=new Runnable(){
        public void run(){

             //這裡放執行緒１要執行的程式。{
       		 try{       			 
       			 if (player3 != null) {
       				 player3.setVolume(0, 0);
       	       }
       			        			 
       		 }catch(Exception e){      			 
       		 }
       	 
             //mUI_Handler.post(r2);//執行執行緒2。
        }
    };
    private Runnable r4stop=new Runnable(){
        public void run(){

             //這裡放執行緒１要執行的程式。{
       		 try{       			 
       			 if (player4 != null) {
       				player4.setVolume(0, 0);
       	       }
       			        			 
       		 }catch(Exception e){      			 
       		 }
       	 
             //mUI_Handler.post(r2);//執行執行緒2。
        }
    };
    private Runnable r5stop=new Runnable(){
        public void run(){

             //這裡放執行緒１要執行的程式。{
       		 try{       			 
       			 if (player5 != null) {
       				player5.setVolume(0, 0);
       	       }
       			        			 
       		 }catch(Exception e){      			 
       		 }
       	 
             //mUI_Handler.post(r2);//執行執行緒2。
        }
    };
    private Runnable r6stop=new Runnable(){
        public void run(){

             //這裡放執行緒１要執行的程式。{
       		 try{       			 
       			 if (player6 != null) {
       				player6.setVolume(0, 0);
       	       }
       			        			 
       		 }catch(Exception e){      			 
       		 }
       	 
             //mUI_Handler.post(r2);//執行執行緒2。
        }
    };
    private Runnable r7stop=new Runnable(){
        public void run(){

             //這裡放執行緒１要執行的程式。{
       		 try{       			 
       			 if (player7 != null) {
       				player7.setVolume(0, 0);
       	       }
       			        			 
       		 }catch(Exception e){      			 
       		 }
       	 
             //mUI_Handler.post(r2);//執行執行緒2。
        }
    };
    
    
    @Override
    protected void onDestroy(){
       super.onDestroy();

       if(mThreadHandler != null){
           mThreadHandler.removeCallbacks(r1);
       }
       if(mThread1 != null){
           mThread1.quit();
       }
       if(mThread2 != null){
           mThread2.quit();
       }
       if(mThread3 != null){
           mThread3.quit();
       }
       if(mThread4 != null){
           mThread4.quit();
       }
       if(mThread5 != null){
           mThread5.quit();
       }
       if(mThread6 != null){
           mThread6.quit();
       }
       if(mThread7 != null){
           mThread7.quit();
       }
       

    }
    
    private OnCompletionListener comL = new OnCompletionListener(){
   	 @Override
   	 public void onCompletion(MediaPlayer nouse){
   		 try{
   			 player1.stop();
   			 player1.prepare();
   		 }catch(Exception e){
   			 
   		 }
   	 }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
  
  
}
