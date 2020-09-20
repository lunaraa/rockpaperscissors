import enums.Move
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
}