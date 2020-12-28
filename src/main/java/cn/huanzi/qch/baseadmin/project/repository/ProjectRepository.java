package cn.huanzi.qch.baseadmin.project.repository;

import cn.huanzi.qch.baseadmin.common.repository.*;
import cn.huanzi.qch.baseadmin.project.pojo.Project;
import cn.huanzi.qch.baseadmin.project.vo.ProjectVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CommonRepository<Project, Integer> {

    Long countByStatue(Integer statue);

}
