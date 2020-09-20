import java.util.*

class RandomPlayerStrategy(private val random: Random) : PlayerStrategy {

    override fun chooseMove() = Move.values()[random.nextInt(Move.values().size)]
}