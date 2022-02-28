package com.mustoutdoor.testserverapi.mapper;

import com.mustoutdoor.testserverapi.model.vo.PrivateGround;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface PrivateGroundMapper {

    void save(PrivateGround privateGround);

    PrivateGround findById(long hostId);
}
