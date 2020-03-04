package com.example.springdata.domain;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Id;


@NodeEntity
@Builder
@Data
public class CompanyGraph {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 供应商名称
     */
    private String fullName;
}
