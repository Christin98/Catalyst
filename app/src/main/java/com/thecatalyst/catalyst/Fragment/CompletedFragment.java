package com.thecatalyst.catalyst.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.thecatalyst.catalyst.Adapter.MyAdapter;
import com.thecatalyst.catalyst.Model.Datum;
import com.thecatalyst.catalyst.Model.RetroUsers;
import com.thecatalyst.catalyst.Network.RetrofitClient;
import com.thecatalyst.catalyst.R;
import com.thecatalyst.catalyst.Service.GetData;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CompletedFragment extends Fragment {

    @Nullable
    @BindView(R.id.recycler_child)
    RecyclerView recyclerViewchild;
    @Nullable
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    private int index;

    private RecyclerView myRecyclerView;
    private ShimmerFrameLayout shimmerFrameLayout;
    final private int completec = 0;


    public CompletedFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        myRecyclerView = view.findViewById(R.id.recycler);
        shimmerFrameLayout = view.findViewById(R.id.shimmer_view);
        shimmerFrameLayout.startShimmerAnimation();

        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);

        Call<RetroUsers> call = service.getApk(completec);

        call.enqueue(new Callback<RetroUsers>() {

            @Override
            public void onResponse(@NonNull Call<RetroUsers> call, @NonNull Response<RetroUsers> response) {
                assert response.body() != null;
                loadDataList(response.body().getData());
                index = getId();
                Log.e("TAG", "onResponse: "+index );
                shimmerFrameLayout.stopShimmerAnimation();
                shimmerFrameLayout.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<RetroUsers> call, @NonNull Throwable throwable) {
//                showImage();
                Log.e("TAG", "onFailure: "+ throwable.getMessage() );
                Toast.makeText(getActivity(), "Unable to load data", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current, container, false);

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
//                    .setNegativeButton("CANCEL", ((dialog, which) -> dialog.dismiss())).show();
//        }
    }

    private void loadDataList(List<Datum> usersList) {

        MyAdapter myAdapter = new MyAdapter(usersList,getActivity());

        Collections.sort(usersList, (o1, o2) -> {
            if (o1.getId() > o2.getId()){
                return -1;
            }else if (o1.getId().equals(o2.getId())){
                return 0;
            }else {
                return 1;
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), LinearLayoutManager.VERTICAL));
        myRecyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

    }



    private void loadRefreshData()
    {
        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);

        Call<RetroUsers> call = service.getApk(completec);

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

}
