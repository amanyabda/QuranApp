package com.quran.ramadn.quranapp;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Surah_Adapter  extends  RecyclerView.Adapter<Surah_Adapter.MyViewHolder>{

    private LayoutInflater inflater;
    private List<Surah_Items> SurahModelArrayList;
    private Context context;



    public Surah_Adapter(Context context, List<Surah_Items> SurahModelArrayList) {
        this.context=context;
        this.inflater = LayoutInflater.from(context);
        this.SurahModelArrayList = SurahModelArrayList;

    }



    @NonNull
    @Override
    public Surah_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.surah_items, parent, false);

        MyViewHolder holder = new MyViewHolder(view);
        return holder;

    }


    @Override
    public void onBindViewHolder(@NonNull Surah_Adapter.MyViewHolder holder, int position) {
        TextView number,numberOfAyahs,name,revelationType;

        holder.number.setText(Integer.toString(SurahModelArrayList.get(position).getNumber()));
        holder.numberOfAyahs.setText(Integer.toString(SurahModelArrayList.get(position).getNumberOfAyahs()));

        holder.name.setText(SurahModelArrayList.get(position).getName());
        holder.revelationType.setText(SurahModelArrayList.get(position).getRevelationType());




    }

    @Override
    public int getItemCount() {
        return SurahModelArrayList.size();


    }

    class MyViewHolder extends RecyclerView.ViewHolder{


        TextView number,numberOfAyahs,name,revelationType;

        public MyViewHolder(View itemView) {

            super(itemView);

            number = (TextView) itemView.findViewById(R.id.no_sur);
            numberOfAyahs = (TextView) itemView.findViewById(R.id.no_ayats);
            name = (TextView) itemView.findViewById(R.id.name_sur);
            revelationType = (TextView) itemView.findViewById(R.id.type_sur);



        }

    }




}