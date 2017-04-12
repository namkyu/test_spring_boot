package com.kyu.boot.entity.onetomany;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Project : test_project
 * @Date : 2017-04-12
 * @Author : nklee
 * @Description :
 */
@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seq;

    private String name;

    // default fetch type = EAGER
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Phone> phone;

    public Member() {
    }

    public Member(String name) {
        this.name = name;
    }

    public void addPhone(Phone p) {
        if(phone == null) {
            phone = new ArrayList<>();
        }

        phone.add(p);
    }
}
