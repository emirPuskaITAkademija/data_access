package com.academy.third.show.persistence;

import com.academy.third.SessionAction;
import org.hibernate.Session;

public class UpdateShowAction implements SessionAction<Void> {

    private final Show show;

    public UpdateShowAction(Show show) {
        this.show = show;
    }

    @Override
    public Void execute(Session session) {
        session.update(show);
        return null;
    }
}
