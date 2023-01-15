package com.poc.uptimefinder.services;

import java.util.List;

import com.poc.uptimefinder.model.URLentity;

public interface ServiceInterface {
	List<URLentity> getAllURL();

    URLentity getURLById(Long id);

    URLentity add(URLentity urLentity);
    

    void updateURL(Long id, URLentity urLentity);

    void deleteURL(Long id);
}

