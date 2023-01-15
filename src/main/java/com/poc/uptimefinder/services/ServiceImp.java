package com.poc.uptimefinder.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.poc.uptimefinder.model.URLentity;
import com.poc.uptimefinder.repository.Uptimrepository;
@Service
public class ServiceImp implements ServiceInterface{
Uptimrepository uptimrepository;
	
	public ServiceImp (Uptimrepository uptimrepository) {
		this.uptimrepository  = uptimrepository;
		
	}

	@Override
	public List<URLentity> getAllURL() {
		// TODO Auto-generated method stub
		List<URLentity> urlweb = new ArrayList<>();
		uptimrepository.findAll().forEach(urlweb::add);
		return urlweb;
	}


	@Override
	public URLentity getURLById(Long id) {
		// TODO Auto-generated method stub
		return uptimrepository.findById(id).get();
	}


	@Override
	public URLentity add(URLentity urLentity) {
		// TODO Auto-generated method stub
		return uptimrepository.save(urLentity);
	}


	@Override
	public void updateURL(Long id, URLentity urlentity) {
		// TODO Auto-generated method stub
		URLentity urlentity1  = uptimrepository.findById(id).get();
		urlentity1.setURL(urlentity.getURL());
		urlentity1.setTimeInterval(urlentity.getTimeInterval());
		uptimrepository.save(urlentity1);
	}


	@Override
	public void deleteURL(Long id) {
		// TODO Auto-generated method stub
		uptimrepository.deleteById(id);
	}

}
