package cn.timelost.hr.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * null
 * @TableName role
 */
@Data
public class Role implements Serializable {
    /**
     * 
     *
     * @mbg.generated 2021-02-20 19:39:57
     */
    private Integer id;

    /**
     * 
     *
     * @mbg.generated 2021-02-20 19:39:57
     */
    private String name;

    /**
     * 
     *
     * @mbg.generated 2021-02-20 19:39:57
     */
    private String description;

    /**
     * 
     *
     * @mbg.generated 2021-02-20 19:39:57
     */
    private Integer permissionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table role
     *
     * @mbg.generated 2021-02-20 19:39:57
     */
    private static final long serialVersionUID = 1L;
}