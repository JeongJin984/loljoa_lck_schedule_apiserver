package com.loljoa.server.db.repository.account;

import com.loljoa.server.db.entity.Account;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.loljoa.server.db.entity.QAccount.account;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepositoryCustom {

    private final JPAQueryFactory factory;

    @Override
    public Account findByNickname(String nickname) {
        return factory
                .selectFrom(account)
                .where(account.nickname.eq(nickname))
                .fetchOne();
    }
}
