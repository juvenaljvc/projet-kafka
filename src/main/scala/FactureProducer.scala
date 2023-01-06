import  java.util.Properties
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer._

object FactureProducer extends App {

  val props = new Properties()
  props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.common.serialization.StringSerializer")
  props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.common.serialization.StringSerializer")
  props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")

  val factureProducer = new KafkaProducer[String, String](props)

  factureProducer.send(new ProducerRecord[String, String]("klanik2", "15"))

  println("Rajout du message effectué avec succès !")

  factureProducer.close()

}
