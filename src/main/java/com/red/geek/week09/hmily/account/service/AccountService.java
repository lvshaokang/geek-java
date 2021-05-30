package com.red.geek.week09.hmily.account.service;

import com.red.geek.week09.hmily.account.entity.Account;
import org.dromara.hmily.annotation.Hmily;

public interface AccountService {

    /**
     * 美元账户和人民币账户交易
     * @param account account
     * @return bool
     */
    @Hmily
    boolean pay(Account account);
}
