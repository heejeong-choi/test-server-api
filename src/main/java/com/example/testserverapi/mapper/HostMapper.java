package com.example.testserverapi.mapper;

import com.example.testserverapi.model.vo.Host;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface HostMapper {

    void save(Host host);

}
