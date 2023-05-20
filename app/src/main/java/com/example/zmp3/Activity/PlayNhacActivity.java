package com.example.zmp3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zmp3.Adapter.ViewPagerPlaylistnhac;
import com.example.zmp3.Fragment.Fragment_Dia_Nhac;
import com.example.zmp3.Fragment.Fragment_Play_Danh_Sach_Cac_Bai_Hat;
import com.example.zmp3.Model.Baihat;
import com.example.zmp3.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class PlayNhacActivity extends AppCompatActivity {

    public static ArrayList<Baihat> mangbaihat = new ArrayList<>();
    public static ViewPagerPlaylistnhac adapternhac;

    Toolbar toolbarplaynhac;
    TextView txtTimesong, txtTotaltimesong;
    SeekBar sktime;
    ImageButton imgplay,imgrepeat,imgnext,imgpre,imgrandom;
    ViewPager viewPagerplaynhac;
    Fragment_Dia_Nhac fragment_dia_nhac;
    Fragment_Play_Danh_Sach_Cac_Bai_Hat fragment_play_danh_sach_cac_bai_hat;
    MediaPlayer mediaPlayer;

    int position = 0;
    boolean repeat= false;
    boolean checkrandom = false;
    boolean next =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);
        //kiểm tra tín hiệu mạng
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        GetDataFromIntent();
        init();
        eventClick();
    }

    private void eventClick() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (adapternhac.getItem(1)!= null){
                    if (mangbaihat.size()>0){
                        //gán lại hình ảnh
                        fragment_dia_nhac.Playnhac(mangbaihat.get(0).getHinhbaihat());
                        //xóa ảnh cũ
                        handler.removeCallbacks(this);
                    }
                    else {
                        //nếu không => lặp lại tuần hoàn
                        handler.postDelayed(this,300);
                    }
                }
            }
        },500);
        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    imgplay.setImageResource(R.drawable.ic_play);
                    if (fragment_dia_nhac.objectAnimator!=null){
                        fragment_dia_nhac.objectAnimator.pause();
                    }
                }
                //nếu người dùng đang nghe
                else {
                    mediaPlayer.start();
                    imgplay.setImageResource(R.drawable.ic_pause);
                    if (fragment_dia_nhac.objectAnimator!=null){
                        fragment_dia_nhac.objectAnimator.resume();
                    }
                }
            }
        });
        imgrepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (repeat==false){
                    //check đang bật randombaif
                    if (checkrandom == true){
                        checkrandom= false;
                        imgrepeat.setImageResource(R.drawable.icon_click_replay);
                        imgrandom.setImageResource(R.drawable.ic_repeat);
                    }
                    imgrepeat.setImageResource(R.drawable.icon_click_replay);
                    repeat=true;
                }
                else {
                    imgrepeat.setImageResource(R.drawable.ic_replay);
                    repeat=false;
                }
            }
        });
        imgrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkrandom==false){
                    //check đang bật randombaif
                    if (repeat == true){
                        repeat= false;
                        imgrandom.setImageResource(R.drawable.icon_click_repeat);
                        imgrepeat.setImageResource(R.drawable.ic_replay);
                    }
                    imgrandom.setImageResource(R.drawable.icon_click_repeat);
                    checkrandom=true;
                }
                else {
                    imgrandom.setImageResource(R.drawable.ic_repeat);
                    checkrandom=false;
                }
            }

        });
        sktime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //kéo ở đâu nghe ở đó :))
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mangbaihat.size() > 0 ){
                    //check music đang chạy
                    if (mediaPlayer.isPlaying() || mediaPlayer != null){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    // giới hạn next bài < số lượng bài hát trong mảng
                    if (position < (mangbaihat.size())){
                        //set dữ liệu khi chuyển bài
                        //set lại icon
                        imgplay.setImageResource(R.drawable.ic_pause);
                        position++;

                        if (repeat==true){
                            if (position ==0){
                                position=mangbaihat.size();
                            }
                            //khi next bài hát, pos tăng 1, nên muốn quay lại bài cũ cần trừ đi 1
                            position -=1;
                        }
                        if (checkrandom == true){
                            Random random = new Random();
                            int index = random.nextInt(mangbaihat.size());

                            if (index ==position){
                                position= index -1;

                            }
                            position =index;
                        }

                        //trường hợp pos vượt quá size mảng
                        if (position > (mangbaihat.size())-1){
                            position = 0;
                        }
                        //thực thi nhạc
                        new PlayMp3().execute(mangbaihat.get(position).getLinkbaihat());
                        fragment_dia_nhac.Playnhac(mangbaihat.get(position).getHinhbaihat());
                        //cập nhật tiêu đề toolbar
                        getSupportActionBar().setTitle(mangbaihat.get(position).getTenbaihat());
                        UpdateTime();
                    }
                }
                imgpre.setClickable(false);
                imgnext.setClickable(false);
                Handler handler1 = new Handler();

                //độ trễ khi next bài
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgpre.setClickable(true);
                        imgnext.setClickable(true);
                    }
                },5000);
            }
        });
        imgpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mangbaihat.size()>0){
                    //check music đang chạy
                    if (mediaPlayer.isPlaying() || mediaPlayer !=null){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer =null;
                    }
                    // giới hạn next bài < số lượng bài hát trong mảng
                    if (position<(mangbaihat.size())){
                        //set dữ liệu khi chuyển bài
                        //set lại icon
                        imgplay.setImageResource(R.drawable.ic_pause);
                        position--;
                        if (position <0){
                            position =mangbaihat.size()-1;
                        }

                        //
                        if (repeat==true){

                            if (position ==0){
                                position=mangbaihat.size();
                            }
                            //khi next bài hát, pos tăng 1, nên muốn quay lại bài cũ cần trừ đi 1

                            position +=1;
                        }
                        if (checkrandom == true){
                            Random random = new Random();
                            int index = random.nextInt(mangbaihat.size());

                            if (index ==position){
                                position= index -1;

                            }
                            position =index;
                        }


                        //thực thi nhạc
                        new PlayMp3().execute(mangbaihat.get(position).getLinkbaihat());
                        fragment_dia_nhac.Playnhac(mangbaihat.get(position).getHinhbaihat());
                        //cập nhật tiêu đề toolbar
                        getSupportActionBar().setTitle(mangbaihat.get(position).getTenbaihat());
                        UpdateTime();
                    }
                }
                imgpre.setClickable(false);
                imgnext.setClickable(false);
                Handler handler1 = new Handler();

                //độ trễ khi next bài
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgpre.setClickable(true);
                        imgnext.setClickable(true);
                    }
                },5000);
            }
        });
    }

    private void GetDataFromIntent() {
        Intent intent =getIntent();
        // tránh đè lên nhau
        mangbaihat.clear();
        //kiểm tra tồn tại intent tránh lỗi
        if (intent !=null){
            if (intent.hasExtra("cakhuc")){
                Baihat baihat = intent.getParcelableExtra("cakhuc");
                mangbaihat.add(baihat);
            }
            if (intent.hasExtra("cacbaihat")){
                ArrayList<Baihat> baihatArrayList = intent.getParcelableArrayListExtra("cacbaihat");
                mangbaihat =baihatArrayList;
            }
        }
    }

    private void init() {
        toolbarplaynhac =findViewById(R.id.toolbarplaynhac);
        txtTimesong  = findViewById(R.id.textviewtimesong);
        txtTotaltimesong  = findViewById(R.id.textviewtotaltimesong);
        sktime  = findViewById(R.id.seekbarsong);

        imgplay =findViewById(R.id.imagebuttonplay);
        imgrepeat =findViewById(R.id.imagebuttonrepeat);
        imgnext =findViewById(R.id.imagebuttonnext);
        imgrandom =findViewById(R.id.imagebuttonsuffle);
        imgpre =findViewById(R.id.imagebuttonpre);

        viewPagerplaynhac = findViewById(R.id.viewpagerplaynhac);

        setSupportActionBar(toolbarplaynhac);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarplaynhac.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                mediaPlayer.stop();
                mangbaihat.clear();
            }
        });
        toolbarplaynhac.setTitleTextColor(Color.WHITE);
        fragment_dia_nhac = new Fragment_Dia_Nhac();
        fragment_play_danh_sach_cac_bai_hat = new Fragment_Play_Danh_Sach_Cac_Bai_Hat();

        adapternhac = new ViewPagerPlaylistnhac(getSupportFragmentManager());
        adapternhac.AddFragment(fragment_play_danh_sach_cac_bai_hat);
        adapternhac.AddFragment(fragment_dia_nhac);
        viewPagerplaynhac.setAdapter(adapternhac);
        //gắn ảnh lên đĩa nhạc
        fragment_dia_nhac = (Fragment_Dia_Nhac) adapternhac.getItem(1);

        if (mangbaihat.size()>0){
            getSupportActionBar().setTitle(mangbaihat.get(0).getTenbaihat());
            new PlayMp3().execute(mangbaihat.get(0).getLinkbaihat());
            imgplay.setImageResource(R.drawable.ic_pause);
        }
    }
    class PlayMp3 extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String baihat) {
            super.onPostExecute(baihat);
            try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            });
            mediaPlayer.setDataSource(baihat);
            mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            TimeSong();
            UpdateTime();
        }
    }

    private void TimeSong() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        txtTotaltimesong.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        sktime.setMax(mediaPlayer.getDuration());
    }
    private void UpdateTime(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null){
                    sktime.setProgress(mediaPlayer.getCurrentPosition());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                    txtTimesong.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                    //0,3s cập nhật lại thanh seekbar
                    handler.postDelayed(this,300);
                    //lắng nghe khi hết bài
                    //chuyển bài tiếp theo
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            next=true;
                            try {
                                Thread.sleep(1000);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        },300);

        //lắng nghe khi chuyển bài hát thực thi thế nào
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                //ktra next nếu = true => chuyển bải
                if (next == true) {
                    if (position < (mangbaihat.size())) {
                        //set dữ liệu khi chuyển bài
                        //set lại icon
                        imgplay.setImageResource(R.drawable.ic_pause);
                        position++;

                        //
                        if (repeat == true) {

                            if (position == 0) {
                                position = mangbaihat.size();
                            }
                            //khi next bài hát, pos tăng 1, nên muốn quay lại bài cũ cần trừ đi 1

                            position -= 1;
                        }
                        if (checkrandom == true) {
                            Random random = new Random();
                            int index = random.nextInt(mangbaihat.size());

                            if (index == position) {
                                position = index - 1;

                            }
                            position = index;
                        }

                        //trường hợp pos vượt quá size mảng
                        if (position > (mangbaihat.size()) - 1) {
                            position = 0;
                        }
                        //thực thi nhạc
                        new PlayMp3().execute(mangbaihat.get(position).getLinkbaihat());
                        fragment_dia_nhac.Playnhac(mangbaihat.get(position).getHinhbaihat());
                        //cập nhật tiêu đề toolbar
                        getSupportActionBar().setTitle(mangbaihat.get(position).getTenbaihat());
                    }
                    imgpre.setClickable(false);
                    imgnext.setClickable(false);
                    Handler handler1 = new Handler();

                    //độ trễ khi next bài
                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imgpre.setClickable(true);
                            imgnext.setClickable(true);
                        }
                    }, 5000);
                    next= false;
                    handler1.removeCallbacks(this);
                }
                else {
                    //nếu next = fale vẫn tiếp tục nghe
                    handler1.postDelayed(this,1000);
                }
            }
            //thực thi sau 1s
        },1000);
    }
}