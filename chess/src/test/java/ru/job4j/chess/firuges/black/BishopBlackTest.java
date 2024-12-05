package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BishopBlackTest {

    @Test
    public void testBishopBlackPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        String output = String.valueOf(bishopBlack.position());
        String excepted = "A1";
        assertThat(output).isEqualTo(excepted);
    }

    @Test
    public void testBishopBlackCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        String output = String.valueOf(bishopBlack.copy(Cell.B5).position());
        String excepted = "B5";
        assertThat(output).isEqualTo(excepted);
    }

    @Test
    public void testBishopBlackWayIsDiagonalTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] output = bishopBlack.way(Cell.G5);
        Cell[] excepted = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(output).isEqualTo(excepted);
    }

    @Test
    public void testBishopBlackWayIsDiagonalFalse() {
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    BishopBlack bishopBlack = new BishopBlack(Cell.C1);
                    bishopBlack.way(Cell.G4);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to G4");
    }
}
