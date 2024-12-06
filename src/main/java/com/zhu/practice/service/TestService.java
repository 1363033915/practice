package com.zhu.practice.service;

import com.zhu.practice.common.domain.dao.model.PracticeTestModel;

import java.util.List;

/**
 * <br/>
 * Created by cl_zhu on 2024/12/6
 */
public interface TestService {

    List<PracticeTestModel> selectList();

    PracticeTestModel insert();

}
