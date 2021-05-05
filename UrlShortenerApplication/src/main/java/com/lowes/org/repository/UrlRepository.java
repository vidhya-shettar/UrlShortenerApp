package com.lowes.org.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lowes.org.model.Url;

@Repository
public interface UrlRepository extends CrudRepository<Url, String> {

	public List<Url> findByUrlVal(String id);
}
