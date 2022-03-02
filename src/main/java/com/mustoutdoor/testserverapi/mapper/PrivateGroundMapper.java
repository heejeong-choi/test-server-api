package com.mustoutdoor.testserverapi.mapper;

import com.mustoutdoor.testserverapi.model.vo.PrivateGround;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrivateGroundMapper {

    void save(PrivateGround privateGround);

    PrivateGround findByHostId(long hostId);

    PrivateGround findById(long pgId);

    List<PrivateGround> findAll();
}
