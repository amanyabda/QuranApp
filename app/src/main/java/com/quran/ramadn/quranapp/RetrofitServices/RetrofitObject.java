package com.quran.ramadn.quranapp.RetrofitServices;

import com.quran.ramadn.quranapp.Utils.AppConstant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {

    private static Retrofit SurahInstance;

    private RetrofitObject() {

    }

    public static Retrofit getSurahApiClient() {
        if (SurahInstance == null) {
            SurahInstance = new Retrofit.Builder()
                    .baseUrl(AppConstant.BASE_API_HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return SurahInstance;
    }


}
