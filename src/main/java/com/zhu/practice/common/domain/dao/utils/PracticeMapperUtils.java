package com.zhu.practice.common.domain.dao.utils;

import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.zhu.practice.common.domain.dao.mapper.PracticeBaseMapper;
import com.zhu.practice.config.SpringContextUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * <br/>
 * Created by cl_zhu on 2024/12/6
 */
public class PracticeMapperUtils {

    public PracticeMapperUtils () {}

    public static <U extends PracticeBaseMapper> Class<U> getClazz(Object object) {
        Class<?>[] clazz = AopProxyUtils.proxiedUserInterfaces(object);
        Optional<Class<?>> first = Stream.of(clazz).filter((e) -> {
            return PracticeBaseMapper.class.isAssignableFrom(e);
        }).findFirst();
        if (!first.isPresent()) {
            throw new RuntimeException("类型");
        } else {
            return (Class)first.get();
        }
    }

    public static <T, U extends Mapper, R> int batchExecute(Collection<T> data, int batchSize, Class<U> mapperClass, BiFunction<T, U, R> function) {
        int i = 0;
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) SpringContextUtils.getBean(SqlSessionFactory.class);
        SqlSession batchSqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);

        try {
            U mapper = (U) batchSqlSession.getMapper(mapperClass);
            int size = data.size();
            Iterator var9 = data.iterator();

            while(var9.hasNext()) {
                T element = (T) var9.next();
                ++i;
                function.apply(element, mapper);
                if (i % batchSize == 0 || i == size) {
                    batchSqlSession.flushStatements();
                }
            }

            batchSqlSession.commit(!TransactionSynchronizationManager.isSynchronizationActive());
            return i;
        } catch (Exception var14) {
            batchSqlSession.rollback();
            throw new RuntimeException(var14);
        } finally {
            batchSqlSession.close();
        }
    }

}
