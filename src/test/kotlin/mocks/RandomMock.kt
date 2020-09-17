package mocks

import java.util.*

class RandomMock : Random() {

    private var currentRandomNumber = -1

    override fun nextInt(bound: Int): Int {
        currentRandomNumber = (currentRandomNumber + 1) % bound
        return currentRandomNumber
    }
}