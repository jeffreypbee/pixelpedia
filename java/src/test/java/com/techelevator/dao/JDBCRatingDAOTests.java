package com.techelevator.dao;

import com.techelevator.model.Rating;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCRatingDAOTests extends BaseDaoTests{

    private JDBCRatingDAO jdbcRatingDAO;

    private static final Rating RATING_1 = new Rating(1,1,1, 5, 10, 0, 1, 1, 1,1);
    @Before
    public void setup(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcRatingDAO = new JDBCRatingDAO(jdbcTemplate);
    }


    @Test
    public void add_rating_test(){
        Rating newRating = jdbcRatingDAO.addRating(RATING_1);

        int newId = newRating.getRatingId();
        Assert.assertTrue(newId > 0);

        Rating actual = jdbcRatingDAO.getRatingByRatingId(newId);
        assertRatingMatch(newRating, actual);
    }

    private void assertRatingMatch(Rating expected, Rating actual){
        Assert.assertEquals(expected.getRatingId(), actual.getAudioRating());
        Assert.assertEquals(expected.getUserId(), actual.getUserId());
        Assert.assertEquals(expected.getGameId(), actual.getGameId());
        Assert.assertEquals(expected.getReviewId(), actual.getReviewId());
        Assert.assertEquals(expected.getOverallRating(), actual.getOverallRating());
        Assert.assertEquals(expected.getStoryRating(), actual.getStoryRating());
        Assert.assertEquals(expected.getVisualRating(), actual.getVisualRating());
        Assert.assertEquals(expected.getAudioRating(), actual.getAudioRating());
        Assert.assertEquals(expected.getGameplayRating(), actual.getGameplayRating());
        Assert.assertEquals(expected.getDifficultyRating(), actual.getDifficultyRating());
    }
}
