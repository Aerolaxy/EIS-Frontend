package eis.repository;

import eis.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/*企业信息库层
* 利用JPA
* 建立持久对象
* 自动生成查询语句*/

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

    // 根据企业名称模糊查询
    List<Enterprise> findByNameContaining(String name);

    // 根据企业简称模糊查询
    List<Enterprise> findByAbbreviationContaining(String abbreviation);

}
