package com.example.springdata.dao;

import com.example.springdata.domain.SupplyGraph;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SupplyGraphRepository extends Neo4jRepository<SupplyGraph,Long> {

}
