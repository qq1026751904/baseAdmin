package cn.huanzi.qch.baseadmin.project.service;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.*;
import cn.huanzi.qch.baseadmin.project.pojo.Project;
import cn.huanzi.qch.baseadmin.project.vo.ProjectVo;

public interface ProjectService extends CommonService<ProjectVo, Project, Integer> {

    Integer updateStatue(ProjectVo projectVo);

}
