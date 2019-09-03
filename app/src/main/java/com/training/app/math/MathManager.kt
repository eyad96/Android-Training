package com.training.app.math

class MathManager {

    private lateinit var listener: MathmaticalListener

    fun addListener(listener: MathmaticalListener) {
        this.listener = listener
    }

    fun execute(num1: Double, num2: Double, operation: MathOperations) {
        when (operation) {
            MathOperations.ADD -> listener.onAddResult(num1 + num2)
            MathOperations.MULT -> listener.onMult(num1 * num2)
            MathOperations.SUB -> listener.onSubResult(num1 - num2)
        }
    }
}