package com.academy.third.show.persistence;

import com.academy.third.SessionAction;
import org.hibernate.Session;

public class SaveShowAction implements SessionAction<Show> {

    private final Show show;

    public SaveShowAction(Show show) {
        this.show = show;
    }

    @Override
    public Show execute(Session session) {
        int showId = (int) session.save(show);
        show.setShowId(showId);
        session.refresh(show);
        return show;
    }
}
