package kg.geektech.proectandroid39.ui.films;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kg.geektech.proectandroid39.App;
import kg.geektech.proectandroid39.R;
import kg.geektech.proectandroid39.common.OnItemClick;
import kg.geektech.proectandroid39.data.models.Film;
import kg.geektech.proectandroid39.databinding.FragmentFilmsBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilmsFragment extends Fragment {


    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;
    public FilmsFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FilmsAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(
                inflater,
                container,
                false
        );
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recycler.setAdapter(adapter);
        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setFilms(response.body());
                   adapter.setListener(new OnItemClick<String>() {
                       @Override
                       public void onItemClick(String id, int position) {
                           NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                           Bundle bundle = new Bundle();
                           bundle.putSerializable("body", response.body().get(position));
                           navController.navigate(R.id.filmDetailFragment,bundle);

                       }
                   });
                    Log.e("TAG", "onResponse: ");
                }else {
                    Log.e("TAG","onResponse:" + response.errorBody().toString());

                }
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getLocalizedMessage());
            }
        });
    }




}