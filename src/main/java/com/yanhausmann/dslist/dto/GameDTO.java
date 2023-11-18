package com.yanhausmann.dslist.dto;


import com.yanhausmann.dslist.entities.Game;

public class GameDTO {

    private long id;
    private String nome;
    private Integer year;
    private String genre;
    private String platform;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;


    public GameDTO() {

    }

    public GameDTO(Game entity) {
        id = entity.getId();
        nome = entity.getNome();
        year = entity.getYear();
        genre = entity.getGenre();
        platform = entity.getPlatform();
        score = entity.getScore();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
        longDescription = entity.getLongDescription();
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public Double getScore() {
        return score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }
}
