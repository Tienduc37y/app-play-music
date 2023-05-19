package com.example.zmp3.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

//import com.example.zmp3.Activity.DanhsachbaihatActivity;
//import com.example.zmp3.Activity.DanhsachtatcachudeActivity;
//import com.example.zmp3.Activity.DanhsachtheloaitheochudeActivity;
import com.example.zmp3.Activity.DanhsachbaihatActivity;
import com.example.zmp3.Activity.DanhsachtatcachudeActivity;
import com.example.zmp3.Activity.DanhsachtheloaitheochudeActivity;
import com.example.zmp3.Adapter.PlaylistAdapter;
import com.example.zmp3.Model.ChuDe;
import com.example.zmp3.Model.TheLoai;
import com.example.zmp3.Model.TheLoaiTrongNgay;
import com.example.zmp3.Model.Playlist;
import com.example.zmp3.R;
import com.example.zmp3.Service.APIService;
import com.example.zmp3.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ChuDe_TheLoai_Today extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    TextView txtviewxemthemchudetheloai;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_chude_theloai_today,container,false);
        horizontalScrollView=view.findViewById(R.id.horizontalScrollview);
        txtviewxemthemchudetheloai=view.findViewById(R.id.textviewxemthem);
        txtviewxemthemchudetheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), DanhsachtatcachudeActivity.class);
                startActivity(intent);
            }
        });
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<TheLoaiTrongNgay> callback = dataservice.GetDataChuDeVaTheLoai();
        callback.enqueue(new Callback<TheLoaiTrongNgay>() {
            @Override
            public void onResponse(Call<TheLoaiTrongNgay> call, Response<TheLoaiTrongNgay> response) {

                TheLoaiTrongNgay theLoaiTrongNgay = response.body();
                //add all có thêm mảng cùng kiểu dữ liệu vào trong mảng chủ đề

                final ArrayList<ChuDe> chuDeArrayList=new ArrayList<>();
                chuDeArrayList.addAll(theLoaiTrongNgay.getChuDe());

                final ArrayList<TheLoai> theLoaiArrayList=new ArrayList<>();
                theLoaiArrayList.addAll(theLoaiTrongNgay.getTheLoai());

                LinearLayout linearLayout=new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams layout=new LinearLayout.LayoutParams(600,300);
                layout.setMargins(35,20,0,20);

                // hiện số lượng cần hiện
                for (int i=0; i< (chuDeArrayList.size());i++){

                    CardView cardView=new CardView(getActivity());
                    //bo viền xung quanh
                    cardView.setRadius(15);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (chuDeArrayList.get(i).getHinhChuDe() !=null){
                        Picasso.with(getActivity()).load(chuDeArrayList.get(i).getHinhChuDe()).into(imageView);

                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                    final int finalI = i;
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(getActivity(), DanhsachtheloaitheochudeActivity.class);
                            intent.putExtra("chude",chuDeArrayList.get(finalI));
                            startActivity(intent);
                        }
                    });

                }

                for (int j=0; j< (theLoaiArrayList.size());j++){

                    CardView cardView=new CardView(getActivity());
                    //bo viền xung quanh
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (theLoaiArrayList.get(j).getHinhTheLoai() !=null){
                        Picasso.with(getActivity()).load(theLoaiArrayList.get(j).getHinhTheLoai()).into(imageView);

                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);

                    // sự kiện click thể loại
                   final int finalJ = j;
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(getActivity(), DanhsachbaihatActivity.class);
                            intent.putExtra("idtheloai",theLoaiArrayList.get(finalJ));
                            startActivity(intent);
                        }
                    });
                }
                horizontalScrollView.addView(linearLayout);
            }



            @Override
            public void onFailure(Call<TheLoaiTrongNgay> call, Throwable t) {
                Log.d("chudevatheloai",t.getMessage());

            }
        });
    }
}
