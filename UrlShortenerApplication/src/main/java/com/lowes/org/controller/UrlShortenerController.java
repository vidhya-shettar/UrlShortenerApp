package com.lowes.org.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.common.hash.Hashing;
import com.lowes.org.model.Url;
import com.lowes.org.service.UrlServiceImpl;


@Controller
public class UrlShortenerController {

  
  
  @Autowired
  private UrlServiceImpl urlService;
  

  @GetMapping("/url")
  public String createProjectForm(Model model) {

      model.addAttribute("project", new Url());
      return "getShortUrl";
  }

  @GetMapping("/{urlId}")
  public String checkUrlId(@ModelAttribute("test") Url test,Model model,@PathVariable ("urlId") String urlId1 ) {
      model.addAttribute("pro", urlId1);
      return "showUrls";
  }
  @PostMapping("/getUrl")
  public String saveProjectSubmission(@ModelAttribute Url project,Model model) {
	  List<Url> urls = urlService.getUrls(project.getUrlVal());
	  List<Url> showurls = new ArrayList<>();
  if(urls == null || urls.isEmpty()) {
	  String id = Hashing.murmur3_32().hashString(project.getUrlVal(), Charset.defaultCharset()).toString();
	    
	  	Url urlDB = new Url();
	  	urlDB.setUrlId(id);
	  	urlDB.setUrlVal(project.getUrlVal());
	  	urlDB.setCount(1);
	    urlService.saveUrl(urlDB);
	    
	    showurls.add(urlDB);
  }else {
	  
	 for(Url eachUrl : urls) {
	 Url urlDB = eachUrl;
	 urlDB.setCount(eachUrl.getCount()+1);
	 urlService.saveUrl(urlDB);

	 }
	 urlService.getAllUrls().forEach(x->showurls.add(x));
	 
  }
  model.addAttribute("createdUrl", showurls);
      return "urlView";
  }
}


