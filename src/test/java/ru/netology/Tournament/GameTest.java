package ru.netology.Tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 =new Player(1, "Alisa", 300);
    Player player2 =new Player(2, "Rembo", 200);
    Player player3 =new Player(3, "Groot", 400);
    Player player4 =new Player(4, "Ivan", 400);

    @Test
    public void shouldWinFirstPlayer ()
    {
        game.register(player1);
        game.register(player2);
        int expected =  1;
        int actual =game.round("Alisa","Rembo");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldWinSecondPlayer ()
    {
        game.register(player2);
        game.register(player3);
        int expected =  2;
        int actual =game.round("Rembo","Groot");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldBeDrawn ()
    {
        game.register(player4);
        game.register(player3);
        int expected =  0;
        int actual =game.round("Ivan","Groot");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFindFirstPlayer ()
    {
        game.register(player4);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Alisa","Groot");
        });
    }
    @Test
    public void shouldNotFindSecondPlayer ()
    {
        game.register(player4);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan","Rembo");
        });
    }
}
