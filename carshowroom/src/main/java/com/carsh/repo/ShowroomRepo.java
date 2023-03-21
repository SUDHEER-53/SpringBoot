package com.carsh.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carsh.model.ShowRoom;

public interface ShowroomRepo extends MongoRepository<ShowRoom, Integer> {
public void deleteBySid(int id);

}
