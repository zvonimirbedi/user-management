package com.company.user.query.api.handler.query;

import com.company.user.query.api.dto.UserLookupResponse;
import com.company.user.query.api.query.FindAllUsersQuery;
import com.company.user.query.api.query.FindUserByIdQuery;
import com.company.user.query.api.query.SearchUsersQuery;

public interface UserQueryHandler {
    UserLookupResponse getUserById(FindUserByIdQuery query);
    UserLookupResponse searchUsers(SearchUsersQuery query);
    UserLookupResponse getAllUsers(FindAllUsersQuery query);
}

