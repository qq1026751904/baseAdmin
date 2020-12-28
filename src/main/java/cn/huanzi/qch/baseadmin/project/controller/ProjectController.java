package cn.huanzi.qch.baseadmin.project.controller;

import cn.huanzi.qch.baseadmin.annotation.Decrypt;
import cn.huanzi.qch.baseadmin.annotation.Encrypt;
import cn.huanzi.qch.baseadmin.common.controller.*;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.project.pojo.Project;
import cn.huanzi.qch.baseadmin.project.repository.ProjectRepository;
import cn.huanzi.qch.baseadmin.project.vo.ProjectVo;
import cn.huanzi.qch.baseadmin.project.service.ProjectService;
import cn.huanzi.qch.baseadmin.sys.sysuser.service.SysUserService;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.SysUserVo;
import cn.huanzi.qch.baseadmin.util.SecurityUtil;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/sys/project/")
public class ProjectController extends CommonController<ProjectVo, Project, Integer> {
    @Resource
    private ProjectRepository projectRepository;

    @Resource
    private ProjectService projectService;

    @Resource
    private SysUserService sysUserService;

    @GetMapping("projectDemoPage")
    public ModelAndView projectDemoPage() {
        return new ModelAndView("project/projectDemo");
    }

    @GetMapping("projectSurveyPage")
    public ModelAndView projectSurveyPage() {
        return new ModelAndView("project/projectSurvey");
    }

    @GetMapping("projectEchartPage")
    public ModelAndView projectEchart() {
        return new ModelAndView("project/projectEchart");
    }

    @PostMapping("insetProject")
    @Decrypt
    @Encrypt
    public Result<Integer> insetProject(ProjectVo projectVo) {
        System.out.println("进入到insetProject方法");

        SysUserVo sysUserVo = sysUserService.findByLoginName(SecurityUtil.getLoginUser().getUsername()).getData();
        String it = sysUserVo.getUserName();
        projectVo.setCreatePerson(it);

        projectVo.setStatue(0);
        projectVo.setParticipants(projectVo.getParticipants());

        try{
            projectService.insert(projectVo);
            return Result.of(1);
        }catch (Exception e){

        }
        return Result.of(2);

    }

    /**
     * 获取所有项目信息
     */
    @PostMapping("projectGetList")
    @Decrypt
    @Encrypt
    public Result<Map<String, Object>> projectGetList() {
        System.out.println("进入到projectGetList方法");
        Map<String, Object> ma = new HashMap<>();
        List<ProjectVo> li = projectService.list(new ProjectVo()).getData();
        ma.put("code", "0");
        ma.put("msg", "");
        ma.put("count", li.size());
        ma.put("data", li);
        return Result.of(ma);
    }

    /**
     * 根据项目状态获取相应状态的项目数目
     *
     * @return
     */
    @PostMapping("getProjectStatueNumber")
    @Decrypt
    @Encrypt
    public Result<Map<String, Object>> getProjectStatueNumber() {
        System.out.println("进入到getProjectStatueNumber方法");
        Map<String, Object> hm = new HashMap<>();
        Integer statue = 0;
        Long a = projectRepository.countByStatue(statue);
        statue = 1;
        Long b = projectRepository.countByStatue(statue);
        statue = 2;
        Long c = projectRepository.countByStatue(statue);
        System.out.println(a + "," + b + "," + c);
        Long data[] = new Long[]{a, b, c};
        String dataT[] = new String[]{"未开始", "进行中", "已完成"};

        hm.put("mapValue", data);
        hm.put("mapName", dataT);

        return Result.of(hm);
    }

    /**
     * 根据情况更新项目状态
     *
     * @param projectVo
     * @return
     */
    @PostMapping("updateProjectStatue")
    @Decrypt
    @Encrypt
    public Result<Integer> updateProjectStatue(ProjectVo projectVo) {
        System.out.println("进入到updateProjectStatue方法");
        Integer a = projectService.updateStatue(projectVo);
        return Result.of(a);
    }
}
