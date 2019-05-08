package com.quran.ramadn.quranapp.RetrofitServices;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

import static com.quran.ramadn.quranapp.Utils.AppConstant.GOOGLE_API_CLIENT;


  public interface InterfaceObject {


    @GET(GOOGLE_API_CLIENT)
    Call<ResponseBody> GetListSurah();


}
