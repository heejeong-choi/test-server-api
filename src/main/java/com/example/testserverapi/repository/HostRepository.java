package com.example.testserverapi.repository;

import com.example.testserverapi.model.vo.Host;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository {

    void save(Host host);

}
