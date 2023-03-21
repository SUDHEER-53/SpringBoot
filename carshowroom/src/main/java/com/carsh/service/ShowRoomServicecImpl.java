package com.carsh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carsh.model.ShowRoom;
import com.carsh.repo.ShowroomRepo;
@Service
public class ShowRoomServicecImpl implements ShowRoomService {
	@Autowired
	private ShowroomRepo sRepo;

	@Override
	public List<ShowRoom> getAllShowRoom() {
		
		return sRepo.findAll();
	}

	@Override
	public ShowRoom getOne( int sid) {
		ShowRoom sr =sRepo.findById(sid).get();
		
		return sr;
		
	}

	@Override
	public ShowRoom addShowRoom(ShowRoom showroom) {
		
		return sRepo.save(showroom);
	}

	@Override
	public ShowRoom updateShowRoom(ShowRoom showroom) {
		
		return sRepo.save(showroom);
	}
	
	@Override
	public void deleteShowRoom() {
	sRepo.deleteAll();
	}

	@Override
	public void deleteShowRoomOne(int sid) {
		sRepo.deleteBySid(sid);
		
	}

	@Override
	public ShowRoom updateOne(ShowRoom showroom, int sid) {
		Optional<ShowRoom> sr =sRepo.findById(sid);
		ShowRoom s1 =sr.get();
		s1.setsName(showroom.getsName());
		s1.setsLocation(showroom.getsLocation());
		return sRepo.save(s1);
	}


}
