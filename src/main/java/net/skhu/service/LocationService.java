package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.entity.Location;
import net.skhu.repository.LocationRepository;



@Service
public class LocationService {
	
	@Autowired LocationRepository locationRepository;
	
	public Location findById(int id){
		
		return locationRepository.findById(id).get();
		
	}
	
	public List<Location> findAll(){
			
			return locationRepository.findAll();
			
	}
		
}
