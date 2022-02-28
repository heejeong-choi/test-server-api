package com.example.testserverapi.mapper;

import com.example.testserverapi.model.vo.PrivateGround;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface PrivateGroundMapper {

    void save(PrivateGround privateGround);

//    PrivateGround findById(long hostId);
}
