package com.example.springdata.dao;

import com.example.springdata.domain.SupplyRelationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SupplyRelationshipRepository extends Neo4jRepository<SupplyRelationship,Long> {
}
