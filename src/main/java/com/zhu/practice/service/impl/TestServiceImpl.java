package com.zhu.practice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhu.practice.common.domain.dao.mapper.PracticeTestMapper;
import com.zhu.practice.common.domain.dao.model.PracticeTestModel;
import com.zhu.practice.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <br/>
 * Created by cl_zhu on 2024/12/6
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Autowired
    private PracticeTestMapper practiceTestMapper;

    @Override
    public List<PracticeTestModel> selectList() {
        LambdaQueryWrapper<PracticeTestModel> wrapper = Wrappers.lambdaQuery();
        List<PracticeTestModel> practiceTestModels = practiceTestMapper.selectList(wrapper);
        return practiceTestModels;
    }

    @Override
    public PracticeTestModel insert() {
        PracticeTestModel practiceTestModel = new PracticeTestModel();
        practiceTestModel.setName("zhuchenlong1");
        practiceTestModel.setVersion(0L);
        practiceTestModel.setDeletedFlag("0");

        PracticeTestModel practiceTestModel1 = new PracticeTestModel();
        practiceTestModel1.setName("zhuchenlong1");
        practiceTestModel1.setVersion(0L);
        practiceTestModel1.setDeletedFlag("0");


        PracticeTestModel practiceTestModel2 = new PracticeTestModel();
        practiceTestModel2.setName("zhuchenlong2");
        practiceTestModel2.setVersion(0L);
        practiceTestModel2.setDeletedFlag("0");

        List<PracticeTestModel> list = Arrays.asList(practiceTestModel, practiceTestModel1, practiceTestModel2);
        practiceTestMapper.batchInsertEntity(list, 10);
        return practiceTestModel;
    }
}
