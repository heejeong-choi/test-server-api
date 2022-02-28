package com.example.testserverapi.repository;

import com.example.testserverapi.model.vo.PrivateGround;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateGroundRepository {

    void save(PrivateGround privateGround);

}
