package com.srikanthsc.myapplication; // package

public class CountriesModel implements Interface_CountriesModel  { //classe qui est lier a une l'interface
    private String flag,country,cases,todayCases,deaths,todayDeaths,recovered,active,critical; //declaration des variables en fonction de l'api

    public CountriesModel() {
    }

    public CountriesModel(String flag, String country, String cases, String todayCases, String deaths, String todayDeaths, String recovered, String active, String critical) {// constructeur de la classe CountriesModel
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
        this.flag = flag;
        this.country = country;
        this.cases = cases;

    }
//------------------------------------------------------ getters et setters-----------------------------------------------------
    public String getFlag() {

        return flag;
    }

    public void setFlag(String flag) {

        this.flag = flag;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public String getCases() {

        return cases;
    }

    public void setCases(String cases) {

        this.cases = cases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {

        this.todayCases = todayCases;
    }

    public String getDeaths() {

        return deaths;
    }

    public void setDeaths(String deaths) {

        this.deaths = deaths;
    }

    public String getTodayDeaths() {

        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {

        this.todayDeaths = todayDeaths;
    }

    public String getRecovered() {

        return recovered;
    }

    public void setRecovered(String recovered) {

        this.recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {

        this.active = active;
    }

    public String getCritical() {

        return critical;
    }

    public void setCritical(String critical) {

        this.critical = critical;
    }
}
//-------------------------------------------------------- fin des getters et setters---------------------------------------------