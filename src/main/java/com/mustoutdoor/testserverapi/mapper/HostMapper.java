package com.mustoutdoor.testserverapi.mapper;

import com.mustoutdoor.testserverapi.model.vo.Host;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HostMapper {

    void save(Host host);

    Host findById(long hostId);

    Host findByEmailAndDeletedFalse(String email);

    void deleteById(long hostId);

    Host update(Host host);

}
