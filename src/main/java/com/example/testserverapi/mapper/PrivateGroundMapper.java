package com.example.testserverapi.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrivateGroundMapper {

    @Insert("INSERT INTO private_ground VALUES(``,``,``,``,``,``,``,``,``,``)")
    List<PrivateGroundMapper> findAll();
}
