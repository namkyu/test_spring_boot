package com.kyu.boot.repository;

import com.kyu.boot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project : test_project
 * @Date : 2017-04-11
 * @Author : nklee
 * @Description :
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {
}