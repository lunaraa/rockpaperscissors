import java.util.Random

class RandomPlayerStrategy(private val random: Random): PlayerStrategy {

    override fun chooseMove() = Move.values()[random.nextInt(NUMBER_OF_MOVES)]
}