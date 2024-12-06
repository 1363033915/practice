package com.zhu.practice.common.domain.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhu.practice.common.domain.dao.utils.PracticeMapperUtils;

import java.util.List;

/**
 * <br/>
 * Created by cl_zhu on 2024/12/6
 */
public interface PracticeBaseMapper<T> extends BaseMapper<T> {

 default int batchInsertEntity(List<T> list, int batchSize) {
  return PracticeMapperUtils.batchExecute(list, batchSize, PracticeMapperUtils.getClazz(this), (entity, mapper) -> {
   return mapper.insert(entity);
  });
 }

 default int batchUpdateEntity(List<T> list, int batchSize) {
  return PracticeMapperUtils.batchExecute(list, batchSize, PracticeMapperUtils.getClazz(this), (entity, mapper) -> {
   return mapper.updateById(entity);
  });
 }

 default int batchDeleteEntity(List<T> list, int batchSize) {
  return  PracticeMapperUtils.batchExecute(list, batchSize, PracticeMapperUtils.getClazz(this), (entity, mapper) -> {
   return mapper.deleteById(entity);
  });
 }
}
