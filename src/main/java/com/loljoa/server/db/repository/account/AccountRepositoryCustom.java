package com.loljoa.server.db.repository.account;

import com.loljoa.server.db.entity.Account;

public interface AccountRepositoryCustom {
    Account findByNickname(String nickname);
}
