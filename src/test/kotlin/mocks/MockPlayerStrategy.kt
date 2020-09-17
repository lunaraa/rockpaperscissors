package mocks

import Move
import PlayerStrategy

class MockPlayerStrategy(private val moveToMake: Move): PlayerStrategy {

    override fun chooseMove() = moveToMake
}