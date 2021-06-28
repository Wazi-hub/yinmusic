package com.istudy.collection.service;


import com.istudy.collection.pojo.Collect;

import java.util.List;

public interface CollectionService {

    boolean addCollection(Collect collect);

    boolean existSongId(Integer userId, Integer songId);

    boolean updateCollectMsg(Collect collect);

    boolean deleteCollect(Integer userId, Integer songId);

    List<Collect> allCollect();

    List<Collect> collectionOfUser(Integer userId);
}
