package cn.huanzi.qch.baseadmin.project.vo;

import cn.huanzi.qch.baseadmin. common.pojo.PageCondition;import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ProjectVo extends PageCondition implements Serializable {
    private Integer id;//主键

    private String createPerson;//创建人

    private String title;//标题

    private Integer type;//类型

    private String chargePerson;//负责人

    private String startTime;//开始时间

    private String deadline;//截止时间

    private Integer priority;//优先级

    private String participants;//参与人

    private String describes;//描述

    private Integer statue;//状态

}
