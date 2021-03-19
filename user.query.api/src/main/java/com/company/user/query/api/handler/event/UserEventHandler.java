package com.company.user.query.api.handler.event;

import com.company.user.core.event.UserRegisteredEvent;
import com.company.user.core.event.UserRemovedEvent;
import com.company.user.core.event.UserUpdatedEvent;

public interface UserEventHandler {
    void on(UserRegisteredEvent event);
    void on(UserUpdatedEvent event);
    void on(UserRemovedEvent event);
}
