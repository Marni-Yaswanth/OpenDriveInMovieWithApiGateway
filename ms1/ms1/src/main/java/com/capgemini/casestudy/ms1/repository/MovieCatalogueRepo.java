package com.capgemini.casestudy.ms1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.casestudy.ms1.Movie.Movie;




@Repository
public interface MovieCatalogueRepo extends JpaRepository<Movie, String> {

}