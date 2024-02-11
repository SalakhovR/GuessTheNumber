fun main() {
    val game = 1
    val guide = 2
    val exit = 3
    var isFirstStart = true

    println("Добро пожаловать в игру \"Угадай число\"!\n")

    while (true) {
        printMainMenu(isFirstStart)
        val selectedItemMenu = readItemMenu()
        when (selectedItemMenu) {
            game -> runGame()
            guide -> showGuide()
            exit -> System.exit(0)
        }
        isFirstStart = false
    }
}

fun printMainMenu(isFirstStart: Boolean) {
    if (!isFirstStart) {
        println()
    }
    println("1. Запустить игру")
    println("2. Гид по игре")
    println("3. Выйти из игры")
}

fun readItemMenu(): Int {
    println("Выберите пункт:\n")
    val inputCommand = readln().toInt()

    when (inputCommand) {
        1 -> {
            println("Идет запуск игры\n")
        }

        2 -> {
            println("Открывается гид по игре\n")
        }

        3 -> println("Идет закрытие игры\n")

        else -> println("Введите число от 1 до 3, соответствующее пункту меню")
    }
    return inputCommand
}

fun runGame() {
    var variantCount = 0
    var inputNumber = 0
    val choisedDifficulty = difficultyChoice()
    val hiddenNumber = choisedDifficulty[0]
    val finalNumber = choisedDifficulty[1]

    while (true) {
        println("Введите число:")
        inputNumber = readln().toInt()
        variantCount++
        if (inputNumber == 0 || inputNumber > finalNumber) {
            println("Число $inputNumber лежит за пределами заданного промежутка")
        } else if (inputNumber < 0) {
            println("Вы сдались. С $variantCount раза вы не угадали загаданное число: $hiddenNumber.")
            break
        } else if (hiddenNumber == inputNumber) {
            println("Вы угадали число с $variantCount раза!")
            break
        } else if (hiddenNumber > inputNumber) {
            println("Загаданное число больше")
        } else if (hiddenNumber < inputNumber) {
            println("Загаданное число меньше")
        }
    }
}

fun difficultyChoice(): Array<Int> {
    val outputArray = Array<Int>(2) { 0 }
    while (true) {
        println("Выберите уровень сложности:\n1. Легкий\n2. Средний\n3. Сложный\n")
        val difficulty = readln().toInt()
        when (difficulty) {
            1 -> {
                outputArray[0] = (1..10).random()
                outputArray[1] = 10
                break
            }

            2 -> {
                outputArray[0] = (1..100).random()
                outputArray[1] = 100
                break
            }

            3 -> {
                outputArray[0] = (1..1000).random()
                outputArray[1] = 1000
                break
            }

            else -> println("Введите число от 1 до 3, соответствующее уровню сложности\n")
        }
    }
    return outputArray
}

fun showGuide() {
    println(
        "Вопрос: Какая цель игры?\n" +
                "Ответ: Целью игры является отгадывание числа, придуманного ИИ, за минимальное число попыток.\n"
    )
    println(
        "Вопрос: Сколько дается попыток?\n" +
                "Ответ: Количество попыток вычисляет ИИ по собственной формуле, и она отказывается раскрывать ее. Если вам не удается угадать число и вы хотите сдаться и попробовать с новым числом введите любое отрицательное число\n"
    )
    println(
        "Вопрос: Есть ограничение по времени?\n" +
                "Ответ: ИИ очень терпеливая, она будет ждать вашего ответа до тех пор, пока ее Создатель не забудет оплатить счет за аренду сервера.\n"
    )
    println(
        "Вопрос: Что за уровни сложности?\n" +
                "Ответ: В зависимости от выбранного уровня сложности ИИ загадает число в разных диапазонах. При легком - это будет число от 1 до 10. При среднем - от 1 до 100. При сложном - от 1 до 1000\n"
    )
}