package org.eis.frontend.controller;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.Result;
import org.neo4j.driver.Values;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import java.util.*;

@RestController
public class Neo4jEnterpriseController {

    private final Driver driver;

    public Neo4jEnterpriseController(Driver driver) {
        this.driver = driver;
    }

    @GetMapping(path = "/api/related-enterprises", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getRelatedEnterprises(@RequestParam(name = "name") String name) {
        try (Session session = driver.session()) {
            String query = """
                MATCH (c1:企业 {name: $name})-[r]-(c2:企业)
                WITH c2, 
                     CASE WHEN '经营范围' IN collect(type(r)) THEN 1 ELSE 0 END as scopeCount,
                     collect(type(r)) as allTypes
                WITH c2, 
                     size([x IN allTypes WHERE x <> '经营范围']) + scopeCount as relationCount,
                     [x IN allTypes WHERE x <> '经营范围'] + 
                     CASE WHEN '经营范围' IN allTypes THEN ['经营范围'] ELSE [] END as relationTypes
                WHERE relationCount >= 3
                RETURN c2.name as 关联企业
                ORDER BY relationCount DESC
                LIMIT 10
                """;
            
            Result result = session.run(query, Values.parameters("name", name));
            List<String> enterprises = new ArrayList<>();
            
            while (result.hasNext()) {
                enterprises.add(result.next().get("关联企业").asString());
            }
            
            return enterprises;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
} 