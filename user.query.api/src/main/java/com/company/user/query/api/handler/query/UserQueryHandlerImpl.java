package com.company.user.query.api.handler.query;

import com.company.user.query.api.dto.UserLookupResponse;
import com.company.user.query.api.query.FindAllUsersQuery;
import com.company.user.query.api.query.FindUserByIdQuery;
import com.company.user.query.api.query.SearchUsersQuery;
import com.company.user.query.api.repository.RepositoryUser;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserQueryHandlerImpl implements UserQueryHandler {
    @Autowired
    RepositoryUser repositoryUser;

    @QueryHandler
    @Override
    public UserLookupResponse getUserById(FindUserByIdQuery query) {
        var user = repositoryUser.findById(query.getId());
        return user.isPresent() ? new UserLookupResponse(user.get()) : null;
    }

    @QueryHandler
    @Override
    public UserLookupResponse searchUsers(SearchUsersQuery query) {
        var users = new ArrayList<>(repositoryUser.findByFilterRegex(query.getFilter()));
        return new UserLookupResponse(users);
    }

    @QueryHandler
    @Override
    public UserLookupResponse getAllUsers(FindAllUsersQuery query) {
        var users = new ArrayList<>(repositoryUser.findAll());
        return new UserLookupResponse(users);
    }
}
