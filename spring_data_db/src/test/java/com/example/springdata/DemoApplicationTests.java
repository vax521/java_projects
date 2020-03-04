package com.example.springdata;

import com.example.springdata.dao.SupplyGraphRepository;
import com.example.springdata.dao.SupplyRelationshipRepository;
import com.example.springdata.domain.CompanyGraph;
import com.example.springdata.domain.SupplyGraph;
import com.example.springdata.domain.SupplyRelationship;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    SupplyGraphRepository supplyGraphRepository;

    @Autowired
    SupplyRelationshipRepository supplyRelationshipRepository;

	@Test
	void contextLoads() {
	}

	@Test
    public void testSave(){
        //采购占比
        String scale = "47.14%";
        // 采购金额
        String amount ="18923.42";
        //供应商名称
        String name = "常州常电及其关联公司";
        //公司实体部分及添加公司节点部分省略...(companyGraph)
        SupplyGraph supplyGraph = SupplyGraph.builder().name(name).build();
        CompanyGraph companyGraph = CompanyGraph.builder().fullName("fullName").build();
        //添加供应商节点
        supplyGraphRepository.save(supplyGraph);
        String indexName = companyGraph.getFullName() + "-" + supplyGraph.getName();
        //供应商关系
        SupplyRelationship supplyRelationship =
                SupplyRelationship.builder().company(companyGraph).supply(supplyGraph).amount(amount).scale(scale).indexName(indexName).build();
        //添加供应关系
        supplyRelationshipRepository.save(supplyRelationship);
	}
}
