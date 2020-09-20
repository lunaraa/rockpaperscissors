import strategy.RandomPlayerStrategy
import strategy.RockPlayerStrategy
import java.io.File
import java.util.*

fun main() {
    val firstPlayer = Player(RandomPlayerStrategy(Random()))
    val secondPlayer = Player(RockPlayerStrategy())
    val result = Game(firstPlayer, secondPlayer, 100).play()

    File("rpsResult").bufferedWriter().use { out -> out.write(result.toString()) }
}