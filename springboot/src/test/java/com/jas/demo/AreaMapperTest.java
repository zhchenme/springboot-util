package com.jas.demo;

import com.jas.domain.Area;
import com.jas.mapper.AreaMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaMapperTest {
    
    @Autowired
    private AreaMapper areaMapper;
    
    @Test
    public void queryArea() throws Exception {
        List<Area> list = areaMapper.queryArea();
        System.out.println(list.toString());
    }

    @Test
    public void queryAreaById() throws Exception {
        Area area = areaMapper.queryAreaById(1);
        System.out.println(area);
    }

    @Test
    public void insertArea() throws Exception {
        Area area = new Area();
        
        area.setAreaName("南苑");
        area.setPriority(2);
        
        areaMapper.insertArea(area);
        
        queryArea();
    }

    @Test
    public void updateArea() throws Exception {
        Area area = new Area();
        
        area.setAreaName("南苑");
        area.setAreaId(3);
        area.setLastEditTime(new Date());

        areaMapper.updateArea(area);

        queryArea();
    }

    @Test
    public void deleteAreaById() throws Exception {
        areaMapper.deleteAreaById(2);
        queryArea();
    }
}