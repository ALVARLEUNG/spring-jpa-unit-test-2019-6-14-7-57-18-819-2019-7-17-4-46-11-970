package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.RelatedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelatedEntityRepository extends JpaRepository<RelatedEntity, Long> {
}
