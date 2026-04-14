package com.academy.third.show.persistence;

import com.academy.five.active_record.AbstractActiveRecord;

import java.io.Serializable;
import java.sql.Date;
import java.time.Year;

/**
 * Java Entity koji predstavlja strukturu shows tabele iz BAZE podataka.
 *
 * E -> Show
 * PK -> Integer
 */
public class Show extends AbstractActiveRecord<Show, Integer> implements Serializable {
    private Integer showId;
    private String showTitle;
    private Short numSeasons;
    private Short initialYear;



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

    public Short getInitialYear() {
        return initialYear;
    }

    public void setInitialYear(Short initialYear) {
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
