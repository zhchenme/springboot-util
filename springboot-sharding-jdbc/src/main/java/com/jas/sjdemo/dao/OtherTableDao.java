package com.jas.sjdemo.dao;

import com.jas.sjdemo.entity.OtherTable;

import java.util.List;

public interface OtherTableDao {

    /**
     * Description:
     *
     * @author fanxb
     * @date 2019/3/26 10:16
     * @param dictionary dictionary
     * @return long
     */
    long addOne(OtherTable table);

    /**
     * Description:
     *
     * @author fanxb
     * @date 2019/3/26 16:31
     * @return java.util.List<com.fanxb.sjdemo.entity.OtherTable>
     */
    List<OtherTable> getAll();


}
