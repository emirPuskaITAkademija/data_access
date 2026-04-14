package com.academy.third.show.persistence;

import com.academy.third.SessionAction;
import org.hibernate.Session;

public class FindShowByIdAction implements SessionAction<Show> {

    private final Integer showId;

    public FindShowByIdAction(Integer showId) {
        this.showId = showId;
    }

    @Override
    public Show execute(Session session) {
        Show show = (Show) session.get(Show.class, showId);
        return show;
    }
}
