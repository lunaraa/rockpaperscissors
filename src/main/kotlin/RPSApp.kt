import strategy.RandomPlayerStrategy
import strategy.RockPlayerStrategy
import java.util.*

fun main() {
    val firstPlayer = Player(RandomPlayerStrategy(Random()))
    val secondPlayer = Player(RockPlayerStrategy())
    val result = Game(firstPlayer, secondPlayer, 100).play()

    println(result)
}