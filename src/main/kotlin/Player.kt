import strategy.PlayerStrategy

class Player(private val strategy: PlayerStrategy) {

    val score = hashMapOf(Result.WIN to 0, Result.LOSS to 0, Result.DRAW to 0)

    fun makeMove() = strategy.chooseMove()

    fun handleResult(result: Result) {
        score[result] = score[result]!! + 1
    }
}