package com.prisoncrush.api.rank;

import com.prisoncrush.api.model.Rank;
import com.prisoncrush.api.model.UserWeapon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankDAO {
    int insertUserScore(@Param("userId") String userId, @Param("score") int score);

    List<Rank> selectRanks(@Param("offset") int offset, @Param("limit") int limit);
}
