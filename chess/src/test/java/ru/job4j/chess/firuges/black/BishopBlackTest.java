package ru.job4j.chess.firuges.black;

import org.junit.Test;
import org.junit.Assert;
import ru.job4j.chess.firuges.Cell;

public class BishopBlackTest {

    @Test
    public void testPositionIfB1ThenB1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        Assert.assertEquals(Cell.B1, bishopBlack.position());
    }

    @Test
    public void testCopyIfB1ThenB1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        bishopBlack.copy(Cell.B1);
        Assert.assertEquals(bishopBlack.position(), bishopBlack.copy(Cell.B1).position());
    }

    @Test
    public void testWayFromC1ToG5ThenD2E3F4G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(expected, bishopBlack.way(Cell.G5));
    }
}