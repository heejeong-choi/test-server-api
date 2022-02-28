package com.example.testserverapi.repository;

import com.example.testserverapi.model.vo.Host;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HostRepository {

    void save(Host host);

    Optional<Host> findById(long hostId);

    void deleteById(long hostId);

    void update(Host host);

}
