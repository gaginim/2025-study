package com.tommy.study.domain.test.repository;

import com.tommy.study.domain.test.entity.MyJobTestRecord;
import org.springframework.data.repository.CrudRepository;

public interface MyJobTestRecordRepository extends CrudRepository<MyJobTestRecord, Long> {}
