import enums.Move
import mocks.MockPlayerStrategy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `game is played the given amount of rounds`() {
        // given
        val roundsToPlay = 5
        val player = Player(MockPlayerStrategy(Move.ROCK))

        // when
        val gameResult = Game(player, player, roundsToPlay).play()

        // then
        Assertions.assertEquals(roundsToPlay, gameResult.roundResults.size)
    }
}