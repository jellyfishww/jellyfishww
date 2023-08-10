package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public class AlphaImpl implements AlphaDao{
    @Override
    public String select() {
        return "success";
    }
}
