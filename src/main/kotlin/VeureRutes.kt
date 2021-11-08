import classes.Ruta
import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager

fun main(args: Array<String>) {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val sessio = Configuration().configure().buildSessionFactory().openSession()
    val consultaRutas = sessio.createQuery("from Ruta order by nomR")
    val listaRutas = consultaRutas.list()

    for (ruta in listaRutas) {
        ruta as Ruta
        println("")
        println("${ruta.nomR} - ${ruta.punts.size} punts")
        for (punt in ruta.punts){
            println("\t${punt.nomP}")
        }
    }

    sessio.close()
}