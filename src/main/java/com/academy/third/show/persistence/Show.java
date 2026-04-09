package com.academy.third.show.persistence;

import java.io.Serializable;
import java.sql.Date;

/**
 * Java Entity koji predstavlja strukturu shows tabele iz BAZE podataka.
 */
public class Show implements Serializable {
    private Integer showId;
    private String showTitle;
    private Short numSeasons;
    private Date initialYear;

    public Show() {
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public Short getNumSeasons() {
        return numSeasons;
    }

    public void setNumSeasons(Short numSeasons) {
        this.numSeasons = numSeasons;
    }

    public Date getInitialYear() {
        return initialYear;
    }

    public void setInitialYear(Date initialYear) {
        this.initialYear = initialYear;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId=" + showId +
                ", showTitle='" + showTitle + '\'' +
                ", numSeasons=" + numSeasons +
                ", initialYear=" + initialYear +
                '}';
    }
}
