package bowling.game;
/**
 * Hello world!
 *
 */
public class Game
{
    private int roll = 0;
    private int[] rolls = new int[21];

    public void roll(int...rolls) {
        for (int pinsDown : rolls)
            roll(pinsDown);
    }

    public void roll(int pinsDown) {
        rolls[roll++] = pinsDown;
    }

    public int score() {
        int score = 0;
        int pointer = 0;
        for (int frame = 0; frame <10; frame++) {
            if(Strike(pointer)){
                score += 10 + rolls[pointer+1] + rolls[pointer+2];
                pointer ++;
            } else if (Spare(pointer)) {
                score += 10 + rolls[pointer+2];
                pointer +=2;
            } else {
                score += rolls[pointer] + rolls[pointer+1];
                pointer +=2;
            }
        }
        return score;
    }

    private boolean Strike(int pointer) {
        return rolls[pointer] == 10;
    }

    private boolean Spare(int pointer) {
        return rolls[pointer] + rolls[pointer+1] == 10;
    }
}