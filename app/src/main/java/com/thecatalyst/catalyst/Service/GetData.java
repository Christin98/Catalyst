package com.thecatalyst.catalyst.Service;

import com.thecatalyst.catalyst.Model.JSONResponse;
import com.thecatalyst.catalyst.Model.RetroUsers;
import com.thecatalyst.catalyst.Model.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetData {
    @GET("/PDetails")
    Call<List<RetroUsers>> getPDetails(@Query("completed")int completed);

    @GET("/PDetails")
    Call<List<Task>> getTask();
}
