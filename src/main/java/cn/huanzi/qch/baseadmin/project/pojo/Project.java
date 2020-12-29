package cn.huanzi.qch.baseadmin.project.pojo;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "project")
@Data
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
