package com.green.memoserver;

import com.green.memoserver.model.MemoPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemoMapper {
    int save(MemoPostReq p);
}
