import enums.Move
import enums.Result

class GameResult(val roundResults: List<RoundResult>) {

    val firstPlayerWins = roundResults.count { it.result == Result.WIN }

    val secondPlayerWins = roundResults.count { it.result == Result.LOSS }

    val draws = roundResults.count { it.result == Result.DRAW }

    override fun toString(): String {
        return StringBuilder().apply {
            roundResults.forEach { this.append(it) }
            this.appendLine("-------------------------------------")
            this.appendLine("After ${roundResults.size} round(s) the statistics are:")
            this.appendLine("-------------------------------------")
            this.appendLine("First player wins: $firstPlayerWins.")
            this.appendLine("Second player wins: $secondPlayerWins.")
            this.appendLine("Draws: $draws.")
        }.toString()
    }
}

class RoundResult(
    private val roundNumber: Int,
    private val moves: Pair<Move, Move>
) {

    val result = when {
        moves.first == moves.second -> Result.DRAW
        (getIndexForMove(moves.first) - getIndexForMove(moves.second) + 3) % 3 == 1 -> Result.WIN
        else -> Result.LOSS
    }

    private fun getIndexForMove(move: Move) = Move.values().indexOf(move)

    override fun toString(): String {
        return StringBuilder()
            .appendLine("-------------------------------------")
            .appendLine("Round $roundNumber")
            .appendLine("-------------------------------------")
            .appendLine("First player chooses move: ${moves.first}.")
            .appendLine("Second player chooses move: ${moves.second}.")
            .appendLine("The result for the first player is: $result.")
            .appendLine()
            .toString()
    }
}