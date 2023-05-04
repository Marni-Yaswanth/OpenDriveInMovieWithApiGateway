package com.cg.casestudy.ms2.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "Movie-Catalogue", url = "http://localhost:8081")
public interface MovieScheduleProxy {
	
	@GetMapping("/viewmovies")
	public List<String> viewAllMovieTitles();

}