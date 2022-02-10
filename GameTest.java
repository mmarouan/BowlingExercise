package bowling.game;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest
{
    private Game game;

    @Before
    public void setUp(){
        game = new Game();
    }

    @Test
    public void ScoreGutterGame() {
        game.roll(0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0);
        assertThat(game.score(), is(0));
    }

    @Test
    public void ScoreAllOnesGame() {
        game.roll(1,1 ,1,1 ,1,1 ,1,1 ,1,1 ,1,1 ,1,1 ,1,1 ,1,1 ,1,1);
        assertThat(game.score(), is(20));
    }

    @Test
    public void ScoreSpareThenFive() {
        game.roll(5,5 ,5,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0);
        assertThat(game.score(), is(20));
    }

    @Test
    public void ScoreStrikeThenFiveThenFour() {
        game.roll(10 ,5,4 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0 ,0,0);
        assertThat(game.score(), is(28));
    }

    @Test
    public void ScorePerfectGame() {
        game.roll(10 ,10 ,10 ,10 ,10 ,10 ,10 ,10 ,10 ,10,10,10);
        assertThat(game.score(), is(300));
    }

    @Test
    public void Score133Game() {
        game.roll(1,4 ,4,5 ,6,4 ,5,5 ,10 ,0,1 ,7,3 ,6,4 ,10 ,2,8, 6);
        assertThat(game.score(), is(133));
    }
}