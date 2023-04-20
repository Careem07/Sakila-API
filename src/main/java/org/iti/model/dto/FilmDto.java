package org.iti.model.dto;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link org.iti.model.entities.Film} entity
 */
@XmlRootElement
public class FilmDto implements Serializable {
    private  Integer id;
    @Size(max = 128)
    @NotNull
    private  String title;
    private  String description;
    private  Integer releaseYear;
    private  Short rentalDuration;
    @NotNull
    private  BigDecimal rentalRate;
    private  Integer length;
    @NotNull
    private  BigDecimal replacementCost;
    @Size(max = 5)
    private  String rating;
    @Size(max = 54)
    private  String specialFeatures;
    @NotNull
    private  Instant lastUpdate;

    @NotNull
    private LanguageDto language;

    private  Set<FilmActorDto> filmActors;

    private  Set<FilmCategoryDto> filmCategories;

    private  Set<InventoryDto> inventories;



    public FilmDto() {
    }

    public Integer getId() {
        return id;
    }

    public LanguageDto getLanguage() {
        return language;
    }

    public void setLanguage(LanguageDto language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Short getRentalDuration() {
        return rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

//    public Set<InventoryDto> getInventories() {
//        return inventories;
//    }

//    public Set<FilmActorDto> getFilmActors() {
//        return filmActors;
//    }

//    public Set<FilmCategoryDto> getFilmCategories() {
//        return filmCategories;
//    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRentalDuration(Short rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

//    public void setFilmActors(Set<FilmActorDto> filmActors) {
//        this.filmActors = filmActors;
//    }

//    public void setFilmCategories(Set<FilmCategoryDto> filmCategories) {
//        this.filmCategories = filmCategories;
//    }

//    public void setInventories(Set<InventoryDto> inventories) {
//        this.inventories = inventories;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmDto entity = (FilmDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.releaseYear, entity.releaseYear) &&
                Objects.equals(this.rentalDuration, entity.rentalDuration) &&
                Objects.equals(this.rentalRate, entity.rentalRate) &&
                Objects.equals(this.length, entity.length) &&
                Objects.equals(this.replacementCost, entity.replacementCost) &&
                Objects.equals(this.rating, entity.rating) &&
                Objects.equals(this.specialFeatures, entity.specialFeatures) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.filmActors, entity.filmActors) &&
                Objects.equals(this.filmCategories, entity.filmCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, releaseYear, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, lastUpdate, filmActors, filmCategories);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "description = " + description + ", " +
                "releaseYear = " + releaseYear + ", " +
                "rentalDuration = " + rentalDuration + ", " +
                "rentalRate = " + rentalRate + ", " +
                "length = " + length + ", " +
                "replacementCost = " + replacementCost + ", " +
                "rating = " + rating + ", " +
                "specialFeatures = " + specialFeatures + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "filmActors = " + filmActors + ", " +
                "filmCategories = " + filmCategories + ")";
    }
}