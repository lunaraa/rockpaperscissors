import java.util.*

fun main() {
    val firstPlayer = Player(RandomPlayerStrategy(Random()))
    val secondPlayer = Player(RockPlayerStrategy())
    Game(firstPlayer, secondPlayer, 100).play()
}