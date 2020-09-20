import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

class GameResultTest {

    @TestFactory
    fun `calculates correct round result in given situation`() = listOf(
            Move.ROCK to Move.ROCK to Result.DRAW,
            Move.ROCK to Move.PAPER to Result.LOSS,
            Move.ROCK to Move.SCISSORS to Result.WIN,
            Move.PAPER to Move.ROCK to Result.WIN,
            Move.PAPER to Move.PAPER to Result.DRAW,
            Move.PAPER to Move.SCISSORS to Result.LOSS,
            Move.SCISSORS to Move.ROCK to Result.LOSS,
            Move.SCISSORS to Move.PAPER to Result.WIN,
            Move.SCISSORS to Move.SCISSORS to Result.DRAW
    ).map { (move, expectedResult) ->
        DynamicTest.dynamicTest("calculates result for ${move.first} against ${move.second} as $expectedResult") {
            // when
            val result = RoundResult(1, move).result

            // then
            Assertions.assertEquals(expectedResult, result)
        }
    }

    @Test
    fun `calculates correct totals for round result WIN`() {
        // given
        val roundResults = listOf(RoundResult(1, Move.ROCK to Move.SCISSORS))

        // when
        val gameResult = GameResult(roundResults)

        // then
        Assertions.assertEquals(1, gameResult.firstPlayerWins)
        Assertions.assertEquals(0, gameResult.secondPlayerWins)
        Assertions.assertEquals(0, gameResult.draws)
    }

    @Test
    fun `calculates correct totals for round result LOSS`() {
        // given
        val roundResults = listOf(RoundResult(1, Move.ROCK to Move.PAPER))

        // when
        val gameResult = GameResult(roundResults)

        // then
        Assertions.assertEquals(0, gameResult.firstPlayerWins)
        Assertions.assertEquals(1, gameResult.secondPlayerWins)
        Assertions.assertEquals(0, gameResult.draws)
    }

    @Test
    fun `calculates correct totals for round result DRAW`() {
        // given
        val roundResults = listOf(RoundResult(1, Move.ROCK to Move.ROCK))

        // when
        val gameResult = GameResult(roundResults)

        // then
        Assertions.assertEquals(0, gameResult.firstPlayerWins)
        Assertions.assertEquals(0, gameResult.secondPlayerWins)
        Assertions.assertEquals(1, gameResult.draws)
    }

    @Test
    fun `toString includes all parameters for RoundResult`() {
        // given
        val roundResult = RoundResult(1, Move.ROCK to Move.SCISSORS)
        val expectedFragments = listOf("Round 1", Move.ROCK.toString(), Move.SCISSORS.toString(), Result.WIN.toString())

        // when
        val actual = roundResult.toString()

        // then
        expectedFragments.forEach {
            Assertions.assertTrue(actual.contains(it))
        }
    }

    @Test
    fun `toString includes all parameters for GameResult`() {
        // given
        val gameResult = GameResult(listOf(RoundResult(1, Move.ROCK to Move.SCISSORS)))
        val expectedFragments = listOf("Round 1", Move.ROCK.toString(), Move.SCISSORS.toString(), Result.WIN.toString(), "1 round(s)", "First player wins: 1.", "Second player wins: 0.", "Draws: 0")

        // when
        val actual = gameResult.toString()

        // then
        expectedFragments.forEach {
            Assertions.assertTrue(actual.contains(it))
        }
    }
}