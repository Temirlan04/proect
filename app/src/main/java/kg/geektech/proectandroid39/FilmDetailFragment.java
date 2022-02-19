package kg.geektech.proectandroid39;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kg.geektech.proectandroid39.data.models.Film;
import kg.geektech.proectandroid39.databinding.FragmentFilmDetailBinding;

public class FilmDetailFragment extends Fragment {

    private FragmentFilmDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding = FragmentFilmDetailBinding.inflate(getLayoutInflater());
        Film film = (Film) getArguments().getSerializable("body");

        binding.tvTitle.setText(film.getTitle());
        binding.tvOriginalTitle.setText(film.getOriginalTitle());
        binding.tvDescription.setText(film.getDescription());
        binding.tvProducer.setText(film.getProducer());
        binding.tvReleaseDate.setText(film.getReleaseDate().toString());


        return binding.getRoot();

    }
}