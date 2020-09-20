import mocks.RandomMock
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PlayerStrategyTest {

    @Test
    fun `RockPlayerStrategy chooses ROCK as move`() {
        // given
        val rockStrategy = RockPlayerStrategy()
        val expectedMove = Move.ROCK

        // when
        val move = rockStrategy.chooseMove()

        // then
        Assertions.assertEquals(expectedMove, move)
    }

    @Test
    fun `RandomPlayerStrategy chooses a random move`() {
        // given
        val randomStrategy = RandomPlayerStrategy(RandomMock())
        val expectedMoves = Move.values().asList()

        // when
        val moves = Array(Move.values().size) { randomStrategy.chooseMove() }.asList()

        // then
        Assertions.assertEquals(expectedMoves, moves)
    }
}