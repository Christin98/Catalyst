package com.thecatalyst.catalyst.Fragment;

<<<<<<< HEAD
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
=======

import android.app.AlertDialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
<<<<<<< HEAD
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
=======

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.thecatalyst.catalyst.Adapter.MyAdapter;
<<<<<<< HEAD
import com.thecatalyst.catalyst.Model.RetroUsers;
=======
import com.thecatalyst.catalyst.Model.Datum;
import com.thecatalyst.catalyst.Model.RetroUsers;
import com.thecatalyst.catalyst.Network.NetworkUtil;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
import com.thecatalyst.catalyst.Network.RetrofitClient;
import com.thecatalyst.catalyst.R;
import com.thecatalyst.catalyst.Service.GetData;

import java.util.List;
import java.util.Objects;
<<<<<<< HEAD
=======
import java.util.zip.DataFormatException;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class CurrentFragment extends Fragment {

<<<<<<< HEAD
    private MyAdapter myAdapter;
=======
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
    @BindView(R.id.recycler_child)
    RecyclerView recyclerViewchild;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    private RecyclerView myRecyclerView;
    private ShimmerFrameLayout shimmerFrameLayout;
<<<<<<< HEAD
    SwipeRefreshLayout swipeRefreshLayout;
    View view;
    int completedrunning = 0;
=======
    private SwipeRefreshLayout swipeRefreshLayout;
    private int completedrunning = 0;

>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3

    public CurrentFragment() {
        // Required empty public constructor
    }
<<<<<<< HEAD
=======



>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
<<<<<<< HEAD
    public void onViewCreated(View view, Bundle savedInstanceState) {

        myRecyclerView = view.findViewById(R.id.recycler);
        swipeRefreshLayout =  view.findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadRefreshData();
            }
        });
=======
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        myRecyclerView = view.findViewById(R.id.recycler);
        swipeRefreshLayout =  view.findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(this::loadRefreshData);
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

<<<<<<< HEAD
        shimmerFrameLayout = (ShimmerFrameLayout) view.findViewById(R.id.shimmer_view);
=======
        shimmerFrameLayout = view.findViewById(R.id.shimmer_view);
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
        shimmerFrameLayout.startShimmerAnimation();

        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);

<<<<<<< HEAD
        Call<List<RetroUsers>> call = service.getPDetails(completedrunning);

        call.enqueue(new Callback<List<RetroUsers>>() {

            @Override
            public void onResponse(Call<List<RetroUsers>> call, Response<List<RetroUsers>> response) {
                loadDataList(response.body());
=======
        Call<RetroUsers> call = service.getApk(completedrunning);

        call.enqueue(new Callback<RetroUsers>() {

            @Override
            public void onResponse(@NonNull Call<RetroUsers> call, @NonNull Response<RetroUsers> response) {
                loadDataList(response.body().getData());
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
                shimmerFrameLayout.stopShimmerAnimation();
                shimmerFrameLayout.setVisibility(View.GONE);
            }

            @Override
<<<<<<< HEAD
            public void onFailure(Call<List<RetroUsers>> call, Throwable throwable) {
                showImage();
                Toast.makeText(getActivity(), "Unable to load Current Projects please try again", Toast.LENGTH_SHORT).show();
            }
        });
=======
            public void onFailure(@NonNull Call<RetroUsers> call, @NonNull Throwable throwable) {
                showImage();
                Log.e("TAG", "onFailure: "+throwable.getMessage() );
                if (getActivity() != null) {
                    Toast.makeText(getContext(), "Unable to load data", Toast.LENGTH_SHORT).show();
                }
            }
        });

>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
    }


    @Override
<<<<<<< HEAD
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current, container, false);

    }

    public void showImage() {
        Dialog builder = new Dialog(getActivity());
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

            }
        });

        ImageView imageView = new ImageView(getActivity());
        imageView.setImageResource(R.drawable.internet_error);
        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        builder.show();
    }

    private void loadDataList(List<RetroUsers> usersList) {

        myAdapter = new MyAdapter(usersList , getActivity());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
=======
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_current, container, false);
    }

    private void showImage() {
        String status =   NetworkUtil.getConnectivityStatusString(getContext());
        Log.e("TAG", "showImage: "+status );
        if (status.equals("Wifi enabled") || status.equals("Mobile data enabled")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setIcon(R.drawable.images)
                    .setCancelable(false)
                    .setTitle("No Response!")
                    .setMessage("NO Response From Server.!!" + "   " +
                            "Please Try Again!")
                    .setPositiveButton("RETRY", (dialog, which) -> {
                        loadRefreshData();
                        dialog.dismiss();
                    })
                    .setNegativeButton("CANCEL", ((dialog, which) -> dialog.dismiss())).show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setIcon(R.drawable.images)
                    .setCancelable(false)
                    .setTitle("No Connection!")
                    .setMessage("NOT Connected to Internet.!!" + "   " +
                            "Please Try Again!")
                    .setPositiveButton("RETRY", (dialog, which) -> {
                        loadRefreshData();
                        dialog.dismiss();
                    })
                    .setNegativeButton("CANCEL", ((dialog, which) -> dialog.dismiss()))
                    .show();
        }
    }

    private void loadDataList(List<Datum> usersList) {

        MyAdapter myAdapter = new MyAdapter(usersList, getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), LinearLayoutManager.VERTICAL));
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
        myRecyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

    }

<<<<<<< HEAD
    public void loadRefreshData()
    {
        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);

        Call<List<RetroUsers>> call = service.getPDetails(completedrunning);

        call.enqueue(new Callback<List<RetroUsers>>() {

            @Override
            public void onResponse(Call<List<RetroUsers>> call, Response<List<RetroUsers>> response) {
                loadDataList(response.body());
=======
    private void loadRefreshData()
    {
        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);

        Call<RetroUsers> call = service.getApk(completedrunning);
        Log.e("TAG", "loadRefreshData: "+call );
        call.enqueue(new Callback<RetroUsers>() {

            @Override
            public void onResponse(@NonNull Call<RetroUsers> call, @NonNull Response<RetroUsers> response) {
                loadDataList(response.body().getData());
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
                shimmerFrameLayout.stopShimmerAnimation();
                shimmerFrameLayout.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
<<<<<<< HEAD
            public void onFailure(Call<List<RetroUsers>> call, Throwable throwable) {
                swipeRefreshLayout.setRefreshing(false);
                showImage();
                Toast.makeText(getActivity(), "Unable to load data", Toast.LENGTH_SHORT).show();
=======
            public void onFailure(@NonNull Call<RetroUsers> call, @NonNull Throwable throwable) {
                swipeRefreshLayout.setRefreshing(false);
                Log.e("TAG", "onFailure: "+ throwable.getMessage() );
                showImage();
                if (getActivity() != null) {
                    Toast.makeText(getContext(), "Unable to load data", Toast.LENGTH_SHORT).show();
                }
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
            }
        });
    }

}
