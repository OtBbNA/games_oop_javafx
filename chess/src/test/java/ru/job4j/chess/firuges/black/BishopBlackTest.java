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

    @Test
    public void testWayFromD7ToH3ThenE6F5G4H3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D7);
        Cell[] expected = new Cell[] {Cell.E6, Cell.F5, Cell.G4, Cell.H3};
        Assert.assertArrayEquals(expected, bishopBlack.way(Cell.H3));
    }

    @Test
    public void testWayFromH4ToF2ThenG3F2() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H4);
        Cell[] expected = new Cell[] {Cell.G3, Cell.F2};
        Assert.assertArrayEquals(expected, bishopBlack.way(Cell.F2));
    }

    @Test
    public void testWayFromH4ToF6ThenG5F6() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H4);
        Cell[] expected = new Cell[] {Cell.G5, Cell.F6};
        Assert.assertArrayEquals(expected, bishopBlack.way(Cell.F6));
    }
}