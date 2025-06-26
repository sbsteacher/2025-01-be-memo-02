package com.green.memoserver;

import com.green.memoserver.model.MemoGetOneRes;
import com.green.memoserver.model.MemoGetReq;
import com.green.memoserver.model.MemoGetRes;
import com.green.memoserver.model.MemoPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {
    //insert, update, delete
    int save(MemoPostReq p);
    List<MemoGetRes> findAll(MemoGetReq req);
    MemoGetOneRes findById(int id);
    int deleteById(int id);

}
