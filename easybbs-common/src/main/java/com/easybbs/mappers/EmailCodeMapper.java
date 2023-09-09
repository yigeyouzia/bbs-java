package com.easybbs.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 邮箱验证码 数据库操作接口
 */
public interface EmailCodeMapper<T, P> extends BaseMapper<T, P> {

    /**
     * 根据EmailAndCode更新
     */
    Integer updateByEmailAndCode(@Param("bean") T t, @Param("email") String email, @Param("code") String code);


    /**
     * 根据EmailAndCode删除
     */
    Integer deleteByEmailAndCode(@Param("email") String email, @Param("code") String code);


    /**
     * 根据EmailAndCode获取对象
     */
    T selectByEmailAndCode(@Param("email") String email, @Param("code") String code);

    /**
     * 验证码重复发送 前面一个无效
     * @param email
     */
    void disableEmailCode(@Param("email") String email);
}
