import strategy.PlayerStrategy

class Player(private val strategy: PlayerStrategy) {

    fun makeMove() = strategy.chooseMove()
}