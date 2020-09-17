import mocks.MockPlayerStrategy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class PlayerTest {

    @TestFactory
    fun `Player plays move according to strategy`() = Move.values().map {
        DynamicTest.dynamicTest("Player plays $it according to strategy") {
            // given
            val player = Player(MockPlayerStrategy(it))
            val expectedMove = it

            // when
            val move = player.makeMove()

            // then
            Assertions.assertEquals(expectedMove, move)
        }
    }

    @TestFactory
    fun `Player handles result correctly`() = Result.values().map {
        DynamicTest.dynamicTest("Player handles $it correctly") {
            // given
            val player = Player(MockPlayerStrategy(Move.ROCK))
            val expectedScore = hashMapOf(Result.WIN to 0, Result.LOSS to 0, Result.DRAW to 0)
            expectedScore[it] = 1

            // when
            player.handleResult(it)

            // then
            Assertions.assertEquals(expectedScore, player.score)
        }
    }
}