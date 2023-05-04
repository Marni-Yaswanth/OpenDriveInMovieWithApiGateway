package com.cg.jfs.casestudy.ms3.Proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cg.jfs.casestudy.ms3.Main.MovieDetails;


@FeignClient(name = "ms2", url = "http://localhost:8082")
public interface MovieDetailsProxy {
	
	 @GetMapping("/getdetails")
	 public List<MovieDetails> getMovieSchedules();
	
 
}







	
	