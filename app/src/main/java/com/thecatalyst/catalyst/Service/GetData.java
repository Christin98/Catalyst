package com.thecatalyst.catalyst.Service;

import com.thecatalyst.catalyst.Model.Login;
import com.thecatalyst.catalyst.Model.RetroUsers;
import com.thecatalyst.catalyst.Model.Technology;
import com.thecatalyst.catalyst.Model.Tmember;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetData {
//    @GET("/PDetails")
//    Call<List<RetroUsers>> getPDetails(@Query("completed") int completed );

    @GET("/tmemeber")
    Call<List<Tmember>> getTmember(@Query("projectId") int memid);

    @GET("/tech")
    Call<List<Technology>> getTechno(@Query("projectId") int techid);

    @GET("/login/find/")
    Call<Login> login(@Query("username") String username, @Query("password") String password);

    @GET("/apk/find")
    Call<RetroUsers> getApk(@Query("completed") int complete);
}
