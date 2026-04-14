package com.academy.third.show.persistence;

import com.academy.third.SessionAction;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class FindAllShowsAction implements SessionAction<List<Show>> {
    @Override
    public List<Show> execute(Session session) {
        //select * from shows
        Query findAllShowsQuery = session.createQuery("from Show");
        List<Show> shows = findAllShowsQuery.list();
        return shows;
    }
}
