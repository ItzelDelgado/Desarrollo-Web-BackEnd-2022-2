package com.product.api.service;

import java.util.List;

import com.product.api.dto.ApiResponse;
import com.product.api.entity.Region;

public interface SvcRegion {
	List<Region> getRegions();		
	Region getRegion(Integer region_id);
	ApiResponse createRegion(Region region);
	ApiResponse updateRegion(Integer region_id, Region region);
	ApiResponse deleteRegion(Integer region_id);
}
