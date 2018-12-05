package com.example.viktor.tzproducttest.pojo.pojoproduct;


import android.arch.persistence.room.Ignore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainImage {
    @Ignore
    @SerializedName("listing_image_id")
    @Expose
    private Integer listingImageId;
    @Ignore
    @SerializedName("hex_code")
    @Expose
    private Object hexCode;
    @Ignore
    @SerializedName("red")
    @Expose
    private Object red;
    @Ignore
    @SerializedName("green")
    @Expose
    private Object green;
    @Ignore
    @SerializedName("blue")
    @Expose
    private Object blue;
    @Ignore
    @SerializedName("hue")
    @Expose
    private Object hue;
    @Ignore
    @SerializedName("saturation")
    @Expose
    private Object saturation;
    @Ignore
    @SerializedName("brightness")
    @Expose
    private Object brightness;
    @Ignore
    @SerializedName("is_black_and_white")
    @Expose
    private Object isBlackAndWhite;
    @Ignore
    @SerializedName("creation_tsz")
    @Expose
    private Object creationTsz;
    @Ignore
    @SerializedName("listing_id")
    @Expose
    private Integer listingId;
    @Ignore
    @SerializedName("rank")
    @Expose
    private Object rank;
    @SerializedName("url_75x75")
    @Expose
    private String url75x75;
    @Ignore
    @SerializedName("url_170x135")
    @Expose
    private String url170x135;
    @Ignore
    @SerializedName("url_570xN")
    @Expose
    private String url570xN;
    @Ignore
    @SerializedName("url_fullxfull")
    @Expose
    private String urlFullxfull;
    @Ignore
    @SerializedName("full_height")
    @Expose
    private Object fullHeight;
    @Ignore
    @SerializedName("full_width")
    @Expose
    private Object fullWidth;

    public Integer getListingImageId() {
        return listingImageId;
    }

    public void setListingImageId(Integer listingImageId) {
        this.listingImageId = listingImageId;
    }

    public Object getHexCode() {
        return hexCode;
    }

    public void setHexCode(Object hexCode) {
        this.hexCode = hexCode;
    }

    public Object getRed() {
        return red;
    }

    public void setRed(Object red) {
        this.red = red;
    }

    public Object getGreen() {
        return green;
    }

    public void setGreen(Object green) {
        this.green = green;
    }

    public Object getBlue() {
        return blue;
    }

    public void setBlue(Object blue) {
        this.blue = blue;
    }

    public Object getHue() {
        return hue;
    }

    public void setHue(Object hue) {
        this.hue = hue;
    }

    public Object getSaturation() {
        return saturation;
    }

    public void setSaturation(Object saturation) {
        this.saturation = saturation;
    }

    public Object getBrightness() {
        return brightness;
    }

    public void setBrightness(Object brightness) {
        this.brightness = brightness;
    }

    public Object getIsBlackAndWhite() {
        return isBlackAndWhite;
    }

    public void setIsBlackAndWhite(Object isBlackAndWhite) {
        this.isBlackAndWhite = isBlackAndWhite;
    }

    public Object getCreationTsz() {
        return creationTsz;
    }

    public void setCreationTsz(Object creationTsz) {
        this.creationTsz = creationTsz;
    }

    public Integer getListingId() {
        return listingId;
    }

    public void setListingId(Integer listingId) {
        this.listingId = listingId;
    }

    public Object getRank() {
        return rank;
    }

    public void setRank(Object rank) {
        this.rank = rank;
    }

    public String getUrl75x75() {
        return url75x75;
    }

    public void setUrl75x75(String url75x75) {
        this.url75x75 = url75x75;
    }

    public String getUrl170x135() {
        return url170x135;
    }

    public void setUrl170x135(String url170x135) {
        this.url170x135 = url170x135;
    }

    public String getUrl570xN() {
        return url570xN;
    }

    public void setUrl570xN(String url570xN) {
        this.url570xN = url570xN;
    }

    public String getUrlFullxfull() {
        return urlFullxfull;
    }

    public void setUrlFullxfull(String urlFullxfull) {
        this.urlFullxfull = urlFullxfull;
    }

    public Object getFullHeight() {
        return fullHeight;
    }

    public void setFullHeight(Object fullHeight) {
        this.fullHeight = fullHeight;
    }

    public Object getFullWidth() {
        return fullWidth;
    }

    public void setFullWidth(Object fullWidth) {
        this.fullWidth = fullWidth;
    }

}
