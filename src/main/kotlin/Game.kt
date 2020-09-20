class Game(private val firstPlayer: Player,
           private val secondPlayer: Player,
           private val roundsToPlay: Int) {

    private val roundResults = mutableListOf<RoundResult>()

    fun play(): GameResult {
        for (currentRound: Int in 1..roundsToPlay) {
            val firstPlayerMove = firstPlayer.makeMove()
            val secondPlayerMove = secondPlayer.makeMove()
            val roundResult = RoundResult(currentRound, firstPlayerMove to secondPlayerMove)
            
            roundResults.add(roundResult)
        }
        return GameResult(roundResults)
    }
}