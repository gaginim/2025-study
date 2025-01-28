package com.tommy.study.domain.myjob.repository;

import com.tommy.study.domain.myjob.entity.MyJobTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyJobTestRepository extends CrudRepository<MyJobTest, Long> {}
