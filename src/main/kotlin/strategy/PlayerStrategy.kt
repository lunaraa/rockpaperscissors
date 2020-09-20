package strategy

import Move

interface PlayerStrategy {

    fun chooseMove(): Move
}