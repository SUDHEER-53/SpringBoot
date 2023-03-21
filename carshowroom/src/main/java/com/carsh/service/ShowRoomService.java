package com.carsh.service;

import java.util.List;

import com.carsh.model.ShowRoom;

public interface ShowRoomService {
List<ShowRoom> getAllShowRoom();
ShowRoom getOne(int sid);
ShowRoom addShowRoom (ShowRoom showroom);
ShowRoom updateShowRoom (ShowRoom showroom);
ShowRoom updateOne (ShowRoom showroom ,int sid);
void deleteShowRoom ();
void deleteShowRoomOne(int sid);

}
