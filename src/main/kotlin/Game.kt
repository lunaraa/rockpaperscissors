class Game(private val firstPlayer: Player,
           private val secondPlayer: Player,
           private val roundsToPlay: Int) {

    fun play() {
        for (currentRound: Int in 1..roundsToPlay) {
            val firstPlayerMove = firstPlayer.makeMove()
            val secondPlayerMove = secondPlayer.makeMove()
            val result = calculateResultForFirstPlayer(firstPlayerMove, secondPlayerMove)
            firstPlayer.handleResult(result)
            secondPlayer.handleResult(calculateResultForSecondPlayer(result))
            printRound(currentRound, firstPlayerMove, secondPlayerMove, result)
        }
        printGame()
    }

    private fun printRound(currentRound: Int, firstPlayerMove: Move, secondPlayerMove: Move, result: Result) {
        println("Round $currentRound/$roundsToPlay")
        println("---------------------------------")
        println("Player 1 chose $firstPlayerMove")
        println("Player 2 chose $secondPlayerMove")
        println("The result for Player 1 is $result")
        println()
    }

    private fun printGame() {
        println("After $roundsToPlay rounds the statistics are:")
        println("Player 1's score ${firstPlayer.score}")
        println("Player 2's score ${secondPlayer.score}")
        println("There were ${firstPlayer.score[Result.DRAW]} ties")
    }
}