import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class UtilsTest {

    @TestFactory
    fun `calculates correct result for first player in given situation`() = listOf(
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
        DynamicTest.dynamicTest("calculates result for first player in ${move.first} against ${move.second} as $expectedResult") {
            // when
            val result = calculateResultForFirstPlayer(move.first, move.second)

            // then
            Assertions.assertEquals(expectedResult, result)
        }
    }

    @TestFactory
    fun `calculates correct result for second player in given situation`() = listOf(
            Result.WIN to Result.LOSS,
            Result.LOSS to Result.WIN,
            Result.DRAW to Result.DRAW
    ).map { (firstPlayerResult, expectedResult) ->
        DynamicTest.dynamicTest("calculates result for second player as $expectedResult when first player's result is $firstPlayerResult") {
            // when
            val result = calculateResultForSecondPlayer(firstPlayerResult)

            // then
            Assertions.assertEquals(expectedResult, result)
        }
    }
}