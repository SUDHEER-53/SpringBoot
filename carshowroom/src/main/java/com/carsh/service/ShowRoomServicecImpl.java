package com.carsh.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carsh.model.ShowRoom;
import com.carsh.repo.ShowroomRepo;
@Service
public class ShowRoomServicecImpl implements ShowRoomService {
	Logger LOGGER = LoggerFactory.getLogger(ShowRoomServicecImpl.class);
	@Autowired
	private ShowroomRepo sRepo;

	@Override
	public List<ShowRoom> getAllShowRoom() {
		LOGGER.info("Accepted getAllShowRoom");
		
		return sRepo.findAll();
	}

	@Override
	public ShowRoom getOne( int sid) {
		LOGGER.info("Accepted getOne");
		ShowRoom sr =sRepo.findById(sid).get();
		
		return sr;
		
	}

	@Override
	public ShowRoom addShowRoom(ShowRoom showroom) {
		LOGGER.info("Accepted addShowRoom");
		return sRepo.insert(showroom);
	}

	@Override
	public ShowRoom updateShowRoom(ShowRoom showroom) {
		LOGGER.info("Accepted updateShowRoom");
		List<ShowRoom>list=sRepo.findAll();
		showroom.setsLocation(showroom.getsLocation());
		showroom .setsName(showroom.getsName());
		return sRepo.save(showroom);
	}
	
	@Override
	public void deleteShowRoom() {
		LOGGER.info("Accepted deleteShowRoom");
	sRepo.deleteAll();
	}

	@Override
	public void deleteShowRoomOne(int sid) {
		LOGGER.info("Accepted deleteShowRoomOne");
		sRepo.deleteBySid(sid);
		
	}

	@Override
	public ShowRoom updateOne(ShowRoom showroom, int sid) {
		LOGGER.info("Accepted updateOne");
		Optional<ShowRoom> sr =sRepo.findById(sid);
		ShowRoom s1 =sr.get();
		s1.setsName(showroom.getsName());
		s1.setsLocation(showroom.getsLocation());
		return sRepo.save(s1);
	}


}
