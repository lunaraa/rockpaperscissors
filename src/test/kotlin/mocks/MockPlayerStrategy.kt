package mocks

import enums.Move
import strategy.PlayerStrategy

class MockPlayerStrategy(private val moveToMake: Move) : PlayerStrategy {

    override fun chooseMove() = moveToMake
}