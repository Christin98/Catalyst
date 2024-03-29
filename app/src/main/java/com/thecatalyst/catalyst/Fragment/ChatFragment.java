package com.thecatalyst.catalyst.Fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.thecatalyst.catalyst.Adapter.ChatAdapter;
import com.thecatalyst.catalyst.Adapter.MessageAdapter;
import com.thecatalyst.catalyst.Adapter.MyAdapter;
import com.thecatalyst.catalyst.Model.Datum;
import com.thecatalyst.catalyst.Model.RetroUsers;
import com.thecatalyst.catalyst.Network.RetrofitClient;
import com.thecatalyst.catalyst.R;
import com.thecatalyst.catalyst.Service.GetData;
import com.thecatalyst.catalyst.Util.MyDividerItemDecoration;

import java.util.List;

import butterknife.BindView;
import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.thecatalyst.catalyst.R.color.white;


public class ChatFragment extends Fragment {

    @BindView(R.id.chat_recycler_view_main)
    RecyclerView recyclerViewchild;

    private RecyclerView myRecyclerView;
    private ShimmerFrameLayout shimmerFrameLayout;
    private int completedrunning = 0;
    private WaveSwipeRefreshLayout mWaveSwipeRefreshLayout;

    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @SuppressLint("ResourceType")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        myRecyclerView = view.findViewById(R.id.chat_recycler_view_main);
        mWaveSwipeRefreshLayout = view.findViewById(R.id.swipe);
        mWaveSwipeRefreshLayout.setOnRefreshListener(this::loadRefreshData);
        mWaveSwipeRefreshLayout.setWaveRGBColor(111,116,221);
        mWaveSwipeRefreshLayout.setColorSchemeResources(white);

        shimmerFrameLayout = view.findViewById(R.id.shimmer_view);
        shimmerFrameLayout.startShimmerAnimation();

        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);

        Call<RetroUsers> call = service.getApk(completedrunning);

        call.enqueue(new Callback<RetroUsers>() {

            @Override
            public void onResponse(@NonNull Call<RetroUsers> call, @NonNull Response<RetroUsers> response) {
                assert response.body() != null;
                loadDataList(response.body().getData());
                shimmerFrameLayout.stopShimmerAnimation();
                shimmerFrameLayout.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<RetroUsers> call, @NonNull Throwable throwable) {
                showImage();
                Log.e("TAG", "onFailure: "+throwable.getMessage() );
                if (getActivity() != null) {
                    Toast.makeText(getContext(), "Unable to load data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    private void showImage() {
//
//        Log.e("TAG", "showImage: "+status );
//        if (status.equals("Wifi enabled") || status.equals("Mobile data enabled")) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//            builder.setIcon(R.drawable.images)
//                    .setCancelable(false)
//                    .setTitle("No Response!")
//                    .setMessage("NO Response From Server.!!" + "   " +
//                            "Please Try Again!")
//                    .setPositiveButton("RETRY", (dialog, which) -> {
//                        loadRefreshData();
//                        dialog.dismiss();
//                    })
//                    .setNegativeButton("CANCEL", ((dialog, which) -> dialog.dismiss())).show();
//        } else {
//            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//            builder.setIcon(R.drawable.images)
//                    .setCancelable(false)
//                    .setTitle("No Connection!")
//                    .setMessage("NOT Connected to Internet.!!" + "   " +
//                            "Please Try Again!")
//                    .setPositiveButton("RETRY", (dialog, which) -> {
//                        loadRefreshData();
//                        dialog.dismiss();
//                    })
//                    .setNegativeButton("CANCEL", ((dialog, which) -> dialog.dismiss()))
//                    .show();
//        }
    }

    private void loadDataList(List<Datum> usersList) {

        ChatAdapter myAdapter = new ChatAdapter(usersList, getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setAdapter(myAdapter);
        myRecyclerView.setItemAnimator(new DefaultItemAnimator());
        myRecyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        myAdapter.notifyDataSetChanged();

    }

    private void loadRefreshData()
    {
        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);

        Call<RetroUsers> call = service.getApk(completedrunning);
        Log.e("TAG", "loadRefreshData: "+call );
        call.enqueue(new Callback<RetroUsers>() {

            @Override
            public void onResponse(@NonNull Call<RetroUsers> call, @NonNull Response<RetroUsers> response) {
                assert response.body() != null;
                loadDataList(response.body().getData());
                shimmerFrameLayout.stopShimmerAnimation();
                shimmerFrameLayout.setVisibility(View.GONE);
                mWaveSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(@NonNull Call<RetroUsers> call, @NonNull Throwable throwable) {
                Log.e("TAG", "onFailure: "+ throwable.getMessage() );
                mWaveSwipeRefreshLayout.setRefreshing(false);
                showImage();
                if (getActivity() != null) {
                    Toast.makeText(getContext(), "Unable to load data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
