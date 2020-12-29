package cn.huanzi.qch.baseadmin.project.service;

import cn.huanzi.qch.baseadmin.common.service.*;
import cn.huanzi.qch.baseadmin.project.pojo.Project;
import cn.huanzi.qch.baseadmin.project.vo.ProjectVo;
import cn.huanzi.qch.baseadmin.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class ProjectServiceImpl extends CommonServiceImpl<ProjectVo, Project, Integer> implements ProjectService{

    @PersistenceContext
    private EntityManager em;
    @Resource
    private ProjectRepository projectRepository;

    @Resource
    private ProjectService projectService;

    @Override
    public Integer updateStatue(ProjectVo projectVo) {
        ProjectVo projectVo1 = projectService.get(projectVo.getId()).getData();
        ProjectVo projectVo2 = projectService.get(projectVo.getId()).getData();
        if(projectVo1.getStatue() == (projectVo.getStatue()-1)){
            projectVo2.setStatue(projectVo.getStatue());
            super.save(projectVo2);
            return 1;
        }
        if(projectVo1.getStatue() > projectVo.getStatue()){
            return 2;
        }
        if(projectVo1.getStatue() == projectVo.getStatue()){
            return 3;
        }
        if(projectVo1.getStatue() == (projectVo.getStatue()-2)){
            return 4;
        }
        return null;
    }

}
