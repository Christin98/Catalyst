package com.thecatalyst.catalyst.Service;

<<<<<<< HEAD
import com.thecatalyst.catalyst.Model.JSONResponse;
import com.thecatalyst.catalyst.Model.RetroUsers;
import com.thecatalyst.catalyst.Model.Task;
=======
import com.thecatalyst.catalyst.Model.Login;
import com.thecatalyst.catalyst.Model.RetroUsers;
import com.thecatalyst.catalyst.Model.Technology;
import com.thecatalyst.catalyst.Model.Tmember;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetData {
<<<<<<< HEAD
    @GET("/PDetails")
    Call<List<RetroUsers>> getPDetails(@Query("completed")int completed);

    @GET("/PDetails")
    Call<List<Task>> getTask();
=======
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
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
}
