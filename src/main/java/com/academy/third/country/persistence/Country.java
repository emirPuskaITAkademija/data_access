package com.academy.third.country.persistence;

import com.academy.five.active_record.AbstractActiveRecord;

import java.io.Serializable;
import java.sql.Timestamp;

public class Country extends AbstractActiveRecord<Country, Integer> implements Serializable {
    private Integer countryId;
    private String country;
    private Timestamp lastUpdate;

    public Country() {
    }

    public Country(Integer countryId, String country, Timestamp lastUpdate) {
        this.countryId = countryId;
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return String.format(
                "Country{id=%s, country='%s', lastUpdate=%s}",
                countryId,
                country,
                lastUpdate != null ? lastUpdate.toInstant() : null
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Country)) return false;
        if (this == obj) return true;

        Country country = (Country) obj;
        return countryId != null && countryId.equals(country.countryId);
    }

    @Override
    public int hashCode() {
        return countryId != null ? countryId.hashCode() : 0;
    }
}
