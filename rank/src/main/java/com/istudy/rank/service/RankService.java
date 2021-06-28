package com.istudy.rank.service;

import com.istudy.rank.pojo.Rank;

public interface RankService {
    int rankOfSongListId(Long songListId);

    boolean addRank(Rank rank);
}
