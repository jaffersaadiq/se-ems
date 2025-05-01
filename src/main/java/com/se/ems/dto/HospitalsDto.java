package com.se.ems.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;

public class HospitalsDto {
    @JsonIgnore
    private String id;
    private double x;
    private double y;
    private long objectId;
    private String name;
    private String address;
    private String city;
    private String state;
    private long zip;
    private String zip4;
    private String telephone;
    private String type;
    private String status;
    private long population;
    private String county;
    private String countyfips;
    private String country;
    private double latitude;
    private double longitude;
    private long naicsCode;
    private String naicsDesc;
    private String source;
    private String sourcedate;
    private String valMethod;
    private String valDate;
    private String website;
    private String stateID;
    private String altName;
    private long stFips;
    private String owner;
    private long ttlStaff;
    private long beds;
    private String trauma;
    private String helipad;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public String getZip4() {
        return zip4;
    }

    public void setZip4(String zip4) {
        this.zip4 = zip4;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountyfips() {
        return countyfips;
    }

    public void setCountyfips(String countyfips) {
        this.countyfips = countyfips;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getNaicsCode() {
        return naicsCode;
    }

    public void setNaicsCode(long naicsCode) {
        this.naicsCode = naicsCode;
    }

    public String getNaicsDesc() {
        return naicsDesc;
    }

    public void setNaicsDesc(String naicsDesc) {
        this.naicsDesc = naicsDesc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourcedate() {
        return sourcedate;
    }

    public void setSourcedate(String sourcedate) {
        this.sourcedate = sourcedate;
    }

    public String getValMethod() {
        return valMethod;
    }

    public void setValMethod(String valMethod) {
        this.valMethod = valMethod;
    }

    public String getValDate() {
        return valDate;
    }

    public void setValDate(String valDate) {
        this.valDate = valDate;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getStateID() {
        return stateID;
    }

    public void setStateID(String stateID) {
        this.stateID = stateID;
    }

    public String getAltName() {
        return altName;
    }

    public void setAltName(String altName) {
        this.altName = altName;
    }

    public long getStFips() {
        return stFips;
    }

    public void setStFips(long stFips) {
        this.stFips = stFips;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getTtlStaff() {
        return ttlStaff;
    }

    public void setTtlStaff(long ttlStaff) {
        this.ttlStaff = ttlStaff;
    }

    public long getBeds() {
        return beds;
    }

    public void setBeds(long beds) {
        this.beds = beds;
    }

    public String getTrauma() {
        return trauma;
    }

    public void setTrauma(String trauma) {
        this.trauma = trauma;
    }

    public String getHelipad() {
        return helipad;
    }

    public void setHelipad(String helipad) {
        this.helipad = helipad;
    }
}
