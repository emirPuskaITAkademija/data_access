package com.academy.third.show.persistence;

import com.academy.third.SessionAction;
import org.hibernate.Session;

public class DeleteShowAction implements SessionAction<Void> {

    private final Show show;

    public DeleteShowAction(Show show) {
        this.show = show;
    }
    @Override
    public Void execute(Session session) {
        session.delete(show);
        return null;
    }
}
