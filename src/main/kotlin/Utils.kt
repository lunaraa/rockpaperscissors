fun getIndexForMove(move: Move) = Move.values().indexOf(move)

fun calculateResultForFirstPlayer(firstPlayerMove: Move, secondPlayerMove: Move): Result {
    return when {
        firstPlayerMove == secondPlayerMove -> Result.DRAW
        (getIndexForMove(firstPlayerMove) - getIndexForMove(secondPlayerMove) + 3) % 3 == 1 -> Result.WIN
        else -> Result.LOSS
    }
}

fun calculateResultForSecondPlayer(firstPlayerResult: Result): Result {
    return when (firstPlayerResult) {
        Result.WIN -> Result.LOSS
        Result.LOSS -> Result.WIN
        Result.DRAW -> Result.DRAW
    }
}