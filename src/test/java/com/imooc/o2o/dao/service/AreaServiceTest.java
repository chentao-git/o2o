package com.imooc.o2o.dao.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.imooc.o2o.service.AreaService;
import com.imooc.o2o.service.CacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.entity.Area;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest  {
	@Autowired
	private AreaService areaService;
	@Autowired
	private CacheService cacheService;

	@Test
	public void testGetAreaList() {
		List<Area> areaList = areaService.getAreaList();
		assertEquals("西苑", areaList.get(0).getAreaName());
//		cacheService.removeFromCache(areaService.AREALISTKEY);
//		areaList = areaService.getAreaList();
	}
}
