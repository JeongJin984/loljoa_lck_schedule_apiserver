package com.loljoa.server.db.repository.account;

import com.loljoa.server.db.entity.Account;
import com.loljoa.server.db.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CommonRepository<Account, Long>, AccountRepositoryCustom {
}
