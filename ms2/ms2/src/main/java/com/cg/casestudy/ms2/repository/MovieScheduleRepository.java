package com.cg.casestudy.ms2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.casestudy.ms2.Movie.Movie1;



@Repository
public interface MovieScheduleRepository extends JpaRepository<Movie1, String>  {

}
