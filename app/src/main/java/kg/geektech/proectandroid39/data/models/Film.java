package kg.geektech.proectandroid39.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Film implements Serializable {
    @SerializedName("id")
    String id;
    @SerializedName("title")
    String title;
    @SerializedName("original_title")
    String originalTitle;
    @SerializedName("description")
    String description;
    @SerializedName("producer")
    String producer;

    public Integer getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }

    @SerializedName("release_date")
    Integer releaseDate;



    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
