package com.example.madcamp_proj2;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

interface ApiService {
    @Multipart

    @POST("/photos/upload")

    Call<ResponseBody> postImage(@Part MultipartBody.Part image, @Part("userId") RequestBody userid, @Part("content") RequestBody content, @Part("group") RequestBody photogroup);

    @Multipart
    @POST("/login/upload")
    Call<ResponseBody> postImage2(@Part MultipartBody.Part image, @Part("ID") RequestBody name);
}