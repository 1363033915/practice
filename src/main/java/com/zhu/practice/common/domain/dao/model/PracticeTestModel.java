package com.zhu.practice.common.domain.dao.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * <br/>
 * Created by cl_zhu on 2024/12/6
 */
@Data
@ToString
@TableName("PRACTICE_TEST")
public class PracticeTestModel {

    @TableId
    private Long id;

    private String name;

    private Long createId;

    private Date createDate;

    private Long updateId;

    private Date updateDate;

    @TableLogic(value = "0", delval = "1")
    private String deletedFlag;

    @Version
    private Long version;

}
