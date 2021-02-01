package cn.timelost.hr.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName position
 */
@Data
public class Position implements Serializable {
    /**
     * 岗位编号
     *
     * @mbg.generated Mon Jan 25 18:27:43 CST 2021
     */
    private Integer id;

    /**
     * 岗位名称
     *
     * @mbg.generated Mon Jan 25 18:27:43 CST 2021
     */
    private String positionName;

    /**
     * 描述
     *
     * @mbg.generated Mon Jan 25 18:27:43 CST 2021
     */
    private String description;

    /**
     * 部门编号
     *
     * @mbg.generated Mon Jan 25 18:27:43 CST 2021
     */
    private Integer departmentId;

    /**
     * 
     *
     * @mbg.generated Mon Jan 25 18:27:43 CST 2021
     */
    private Date createTime;

    /**
     * 
     *
     * @mbg.generated Mon Jan 25 18:27:43 CST 2021
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table position
     *
     * @mbg.generated Mon Jan 25 18:27:43 CST 2021
     */
    private static final long serialVersionUID = 1L;
}