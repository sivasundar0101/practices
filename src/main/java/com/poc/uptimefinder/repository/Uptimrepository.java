package com.poc.uptimefinder.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.poc.uptimefinder.model.URLentity;
@Repository
public interface Uptimrepository extends CrudRepository<URLentity, Long>{

}
