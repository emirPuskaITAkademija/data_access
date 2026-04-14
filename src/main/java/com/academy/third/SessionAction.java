package com.academy.third;

import org.hibernate.Session;

@FunctionalInterface
public interface SessionAction<R> {

    R execute(Session session);
}
