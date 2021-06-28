package com.istudy.collection.service.imp;

import com.istudy.collection.dao.CollectionMapper;
import com.istudy.collection.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import com.istudy.collection.pojo.Collect;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionImp implements CollectionService {
    @Autowired
    private CollectionMapper collectMapper;

    @Override
    public boolean addCollection(Collect collection) {
        return collectMapper.insertSelective(collection) > 0 ? true:false;
    }

    @Override
    public boolean existSongId(Integer userId, Integer songId) {
        return collectMapper.existSongId(userId, songId)>0 ? true:false;
    }

    @Override
    public boolean updateCollectMsg(Collect collect) {
        return collectMapper.updateCollectMsg(collect) >0 ?true:false;
    }

    @Override
    public boolean deleteCollect(Integer userId, Integer songId) {
        return collectMapper.deleteCollect(userId, songId) >0 ?true:false;
    }

    @Override
    public List<Collect> allCollect()

    {
        return collectMapper.allCollect();
    }

    @Override
    public List<Collect> collectionOfUser(Integer userId)

    {
        return collectMapper.collectionOfUser(userId);
    }
}
