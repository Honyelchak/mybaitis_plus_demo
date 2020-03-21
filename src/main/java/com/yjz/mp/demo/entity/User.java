package com.yjz.mp.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author Honyelchak
 * @create 2020-03-21 10:35
 */
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    private Integer age;
    @Version
    private Integer version;
    @TableLogic
    private Integer deleted;
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModify;


}
