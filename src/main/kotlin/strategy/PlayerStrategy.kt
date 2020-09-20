package strategy

import enums.Move

interface PlayerStrategy {

    fun chooseMove(): Move
}