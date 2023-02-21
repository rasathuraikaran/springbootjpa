package com.example.springbootjpa;

import com.example.springbootjpa.model.Alien;
import org.springframework.data.repository.CrudRepository;

import javax.management.Query;
import java.util.List;

public interface AlienRepo extends CrudRepository<Alien,Integer> {
List<Alien> findByAlang(String alang);
List<Alien> findByAidGreaterThan(int aid);
@org.springframework.data.jpa.repository.Query("from  Alien where alang=?1 order by aname")
List<Alien> findByAlangSorted(String alang);
}
