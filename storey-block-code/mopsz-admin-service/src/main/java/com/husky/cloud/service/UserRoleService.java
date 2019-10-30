package com.husky.cloud.service;

import java.util.List;

public interface UserRoleService {
    List<String> getRoleAuthByUserId (Integer userId);
}
