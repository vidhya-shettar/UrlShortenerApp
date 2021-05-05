package com.lowes.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowes.org.model.Url;
import com.lowes.org.repository.UrlRepository;

@Service
public class UrlServiceImpl {

	@Autowired
	private UrlRepository urlRepository;
	
	public List<Url> getUrls(String url){
		List<Url> urlList = urlRepository.findByUrlVal(url);
		return urlList;
	}
	public void saveUrl(Url url) {
		urlRepository.save(url);
	}
	
	public Iterable<Url> getAllUrls(){
		Iterable<Url> urlList = urlRepository.findAll();
		return urlList;
	}
}
