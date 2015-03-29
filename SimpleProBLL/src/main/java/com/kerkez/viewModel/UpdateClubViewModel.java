package com.kerkez.viewModel;

/**
 * Created by Mima on 29-Mar-15.
 */
public class UpdateClubViewModel {

    private  Long ucvmId;

    private String ucvmName;

    private int ucvmYear;

    private String ucvmCity;

    private String ucvmCountry;

    public String getUcvmName() {
        return ucvmName;
    }

    public void setUcvmName(String ucvmName) {
        this.ucvmName = ucvmName;
    }

    public int getUcvmYear() {
        return ucvmYear;
    }

    public void setUcvmYear(int ucvmYear) {
        this.ucvmYear = ucvmYear;
    }

    public String getUcvmCity() {
        return ucvmCity;
    }

    public void setUcvmCity(String ucvmCity) {
        this.ucvmCity = ucvmCity;
    }

    public String getUcvmCountry() {
        return ucvmCountry;
    }

    public void setUcvmCountry(String ucvmCountry) {
        this.ucvmCountry = ucvmCountry;
    }

    public Long getUcvmId() {
        return ucvmId;
    }

    public void setUcvmId(Long ucvmId) {
        this.ucvmId = ucvmId;
    }
}
