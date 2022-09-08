package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var right: Int = 0
    var wrong: Int = 0
    var mutableSecret = secret.toMutableList()
    var mutableGuess = guess.toMutableList()

    for (index in secret.indices) {
        if (secret[index] == guess[index] && mutableGuess.contains(guess[index])) {
            right++
            mutableGuess.removeAt(index + 1 - right)
            mutableSecret.removeAt(index + 1 - right)
        }
    }

    for (index in mutableGuess.indices){
        if (mutableSecret.contains(mutableGuess[index])){
            wrong++
            mutableSecret.remove(mutableGuess[index])
        }
    }

    return Evaluation(right, wrong)
}
