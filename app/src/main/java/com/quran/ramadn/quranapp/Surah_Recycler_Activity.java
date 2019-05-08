package com.quran.ramadn.quranapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.quran.ramadn.quranapp.RetrofitServices.InterfaceObject;
import com.quran.ramadn.quranapp.RetrofitServices.RetrofitObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Surah_Recycler_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
     Surah_Adapter adapter;
    List<Surah_Items> surahListAdapter=new ArrayList<>();
    List<Surah_Items>  surahList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surah__recycler_activity);


        RecyclerView recyclerView = findViewById(R.id.recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Surah_Recycler_Activity.this);

        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new Surah_Adapter(Surah_Recycler_Activity.this, surahListAdapter);

        recyclerView.setAdapter(adapter);

        getSurahListData();


    }
       //GET SURAH FROM API BY RETROFET:
     public  void getSurahListData(){

         Toast.makeText(this, "here", Toast.LENGTH_SHORT).show();

        RetrofitObject.getSurahApiClient().create(InterfaceObject.class).GetListSurah().enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            try {
                //1:
                surahList = new ArrayList<>();
                //2
                JSONObject RootObject=new JSONObject(response.body().toString());
                //3
                JSONArray jsonArray=RootObject.getJSONArray("data");
                //4
                for (int i=0;i<=jsonArray.length();i++){
                    //5
                    JSONObject object=jsonArray.getJSONObject(i);
                    //6
                    int number=object.getInt("number");
                    String name=object.getString("name");
                    int numberOfAyahs=object.getInt("numberOfAyahs");
                    String revelationType=object.getString("revelationType");
                    //7
                    Surah_Items surah_items=new Surah_Items(1,"fatha",7,"maka");

                    surah_items.setNumber(number);
                    surah_items.setName(name);
                    surah_items.setNumberOfAyahs(numberOfAyahs);
                    surah_items.setRevelationType(revelationType);

                    surahList.add(surah_items);
                    Toast.makeText(Surah_Recycler_Activity.this, surahList+"", Toast.LENGTH_SHORT).show();
                    Log.d("surahList",surahList+"");

                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }
            surahListAdapter.clear();
            surahListAdapter.addAll(surahList);
            adapter.notifyDataSetChanged();




        }


    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        Toast.makeText(Surah_Recycler_Activity.this, t.toString(), Toast.LENGTH_SHORT).show();

    }
});
      /* RetrofitObject.getSurahApiClient().create(InterfaceObject.class).GetListSurah().enqueue(new Callback<Surah_Items>() {
           @Override
           public void onResponse(Call<Surah_Items> call, Response<Surah_Items> response) {
               try {
                   //1:
                   surahList = new ArrayList<>();
                   //2
                   JSONObject RootObject=new JSONObject(response.body().toString());
                   //3
                   JSONArray jsonArray=RootObject.getJSONArray("data");
                   //4
                   for (int i=0;i<=jsonArray.length();i++){
                       //5
                       JSONObject object=jsonArray.getJSONObject(i);
                       //6
                       int number=object.getInt("number");
                       String name=object.getString("name");
                       int numberOfAyahs=object.getInt("numberOfAyahs");
                       String revelationType=object.getString("revelationType");
                       //7
                       Surah_Items surah_items=new Surah_Items(1,"fatha",7,"maka");

                       surah_items.setNumber(number);
                       surah_items.setName(name);
                       surah_items.setNumberOfAyahs(numberOfAyahs);
                       surah_items.setRevelationType(revelationType);

                       surahList.add(surah_items);
                       Toast.makeText(Surah_Recycler_Activity.this, surahList+"", Toast.LENGTH_SHORT).show();
                       Log.d("surahList",surahList+"");

                   }

               }
               catch (Exception e) {
                   e.printStackTrace();
               }
               surahListAdapter.clear();
               surahListAdapter.addAll(surahList);
               adapter.notifyDataSetChanged();




           }

           @Override
           public void onFailure(Call<Surah_Items> call, Throwable t) {
               Toast.makeText(Surah_Recycler_Activity.this, t.toString(), Toast.LENGTH_SHORT).show();
           }
       });*/
   }


}
