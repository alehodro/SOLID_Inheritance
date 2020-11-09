import java.util.*
import java.util.Timer

open class Timer(time: Int) {
    val task = object : TimerTask() {
        override fun run() {
            println("Dzyn")
        }
    }
    val timerInstance = Timer("Timer")
    val delay = time*1000
    fun start(){
        timerInstance.schedule(task,delay.toLong())
    }
    init {
        this.start()
    }
}