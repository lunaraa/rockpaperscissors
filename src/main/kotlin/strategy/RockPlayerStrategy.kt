package strategy

import Move

class RockPlayerStrategy : PlayerStrategy {

    override fun chooseMove() = Move.ROCK
}