package kg.geektech.proectandroid39.data.remote;

import java.util.List;

import kg.geektech.proectandroid39.data.models.Film;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FilmApi {

    @GET("/films")
    Call<List<Film>> getFilms();

}
