package com.ecom.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.api.model.Category;


@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long>{

}
