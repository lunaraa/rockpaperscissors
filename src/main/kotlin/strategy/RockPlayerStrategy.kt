package strategy

import enums.Move

class RockPlayerStrategy : PlayerStrategy {

    override fun chooseMove() = Move.ROCK
}