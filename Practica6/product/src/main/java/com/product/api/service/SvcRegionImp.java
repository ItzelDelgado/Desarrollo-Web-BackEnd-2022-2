package com.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.api.dto.ApiResponse;
import com.product.api.entity.Region;
import com.product.api.repository.RepoRegion;
import com.product.exception.ApiException;

@Service
public class SvcRegionImp implements SvcRegion {
	
	@Autowired
	RepoRegion repo; 
	
	@Override
	public List<Region> getRegions() {
		// TODO Auto-generated method stub
		return repo.findByStatus(1);
	}

	@Override
	public Region getRegion(Integer region_id) {
		Region region = repo.findByRegionId(region_id); 
		if(region == null)
			throw new ApiException(HttpStatus.NOT_FOUND, "region does not exists");
		else 
			return region;
	}
 
	@Override
	public ApiResponse createRegion(Region region) {
		Region regionSaved = (Region) repo.findByRegion(region.getRegion());
		if(regionSaved != null) {
			if(regionSaved.getStatus() == 0) {
				repo.activateRegion(regionSaved.getRegion_id());
				return new ApiResponse("region has been activated");
			}
			else
				throw new ApiException(HttpStatus.BAD_REQUEST,"region already exists");
		}
		repo.createRegion(region.getRegion());
		return new ApiResponse("region created");
	}

	@Override
	public ApiResponse updateRegion(Integer region_id, Region region) {
		Region regionSaved = (Region) repo.findByRegionId(region_id);
		if(regionSaved == null) 
			throw new ApiException(HttpStatus.NOT_FOUND,"region does not exists");
		else {
			if(regionSaved.getStatus() == 0) 
				throw new ApiException(HttpStatus.BAD_REQUEST,"region is not activate");	
			else {
				regionSaved = (Region) repo.findByRegion(region.getRegion());
				if(regionSaved != null) 
					throw new ApiException(HttpStatus.BAD_REQUEST, "region already exists"); 
				repo.updateRegion(region_id, region.getRegion());
				return new ApiResponse("region update");					
			}
		}
	}

	@Override
	public ApiResponse deleteRegion(Integer region_id) {
		Region regionSaved = (Region) repo.findByRegionId(region_id);
		if(regionSaved == null) 
			throw new ApiException(HttpStatus.NOT_FOUND, "region does not exists");
		else {
			repo.deleteById(region_id);
			return new ApiResponse("region removed");
		}
	}

}
