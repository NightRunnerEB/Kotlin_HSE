package org.example
import kotlinx.serialization.Serializable

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.time.LocalDateTime


fun getCurrentLocationInfo(): String {
    val stackTrace = Thread.currentThread().stackTrace
    if (stackTrace.size >= 3) {
        val caller = stackTrace[3]
        return "Вызван метод ${caller.methodName} в классе ${caller.className}, файл: ${caller.fileName}, строка: ${caller.lineNumber}"
    }
    else {
        return "Поток пуст"
    }
}

@Serializable
class JournalMessage(private val type:String, private val information:String){
    private val time = LocalDateTime.now().toString()
    private val location = getCurrentLocationInfo()
    fun messageToString(): String {
        return "${type}(${time}): ${location}, ${information}\n"
    }
}

object Journal {
    fun writeToJournal(item: JournalMessage) {
        val messageJson: MutableList<JournalMessage> = Json.decodeFromString<MutableList<JournalMessage>>(File("journal.json").readText())
        val messageTxt: String = FileReader("journal.txt").use { file ->
            file.readText()
        }
        val txtString = messageTxt + item.messageToString()
        FileWriter("journal.txt").use { file1 ->
            file1.write(txtString)
        }

        messageJson.add(item)
        val jsonString = Json.encodeToString(messageJson)
        FileWriter("journal.json").use { file2 ->
            file2.write(jsonString)
        }
    }
}

class Calculator {
    fun division(a: Int, b: Int) : Double {
        if (a == 0) {
            Journal.writeToJournal(
                JournalMessage(
                    "Warning",
                    "Осторожно, деление на данную переменную приведет к ошибке!"
                )
            )
            return 0.0
        }
        else {
            val result =  (b / a).toDouble()
            Journal.writeToJournal(JournalMessage("Inf", "Результат операции деления: ${result}"))
            return result
        }
    }
}

fun main() {
    val a = readln().toIntOrNull()
    if(a == null) {
        Journal.writeToJournal(JournalMessage("Err","Введена пустая строка"))
    } else {
        val calculator = Calculator()
        Journal.writeToJournal(JournalMessage("Inf","Создан калькулятор"))
        var result = calculator.division(a, 100)
    }
}
