package com.academy.third.show.persistence;

import com.academy.third.Dao;

import java.util.List;

public class ShowDao implements Dao<Show, Integer> {
    @Override
    public Show save(Show show) {
        // 1. executeSessionAction prima interfejs SessionAction
        // 2. mi kreiramo jednu implementaciju tog interfejsa SaveShowAction
        SaveShowAction saveShowAction = new SaveShowAction(show);
        Show savedShow = executeSessionAction(saveShowAction);
        return savedShow;
    }

    @Override
    public List<Show> findAll() {
        // 1. executeSessionAction prima interfejs SessionAction
        // 2. mi kreiramo jednu implementaciju tog interfejsa FindAllShowsAction
        FindAllShowsAction findAllShowsAction = new FindAllShowsAction();
        List<Show> shows = executeSessionAction(findAllShowsAction);
        return shows;
    }

    @Override
    public Show findById(Integer id) {
        // 1. executeSessionAction prima interfejs SessionAction
        // 2. mi kreiramo jednu implementaciju tog interfejsa FindShowByIdAction
        FindShowByIdAction findShowByIdAction = new FindShowByIdAction(id);
        Show show = executeSessionAction(findShowByIdAction);
        return show;
    }

    @Override
    public void update(Show show) {
        UpdateShowAction updateShowAction = new UpdateShowAction(show);
        executeSessionAction(updateShowAction);
    }

    @Override
    public void delete(Show show) {
        DeleteShowAction deleteShowAction = new DeleteShowAction(show);
        executeSessionAction(deleteShowAction);
    }
}
