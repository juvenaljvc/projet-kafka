import org.apache.kafka.clients.consumer._

import java.time.Duration
import scala.collection.JavaConverters._
import java.util.{Collections, Properties}
import org.apache.kafka.common._

import java.util.Collections._

object FactureConsumer extends App {

  val props : Properties = new Properties()
  props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
  props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false")
  props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
  props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.common.serialization.StringDeserializer")
  props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.common.serialization.StringDeserializer")
  // props.put(ConsumerConfig.GROUP_ID_CONFIG, "")

  val factureConsumer = new KafkaConsumer[String, String](props)
  factureConsumer.subscribe(Collections.singletonList("klanik2"))

  while(true) {

    val messages: ConsumerRecords[String, String] = factureConsumer.poll(Duration.ofSeconds(10))

    if (!messages.isEmpty) {
      println("le nombre de messages collectés dans la fenêtre est de : " + messages.count())

      for(message <- messages.asScala) {
        // c'est ici que vous faites ce que vous voulez avec le message
        println("Topic du message : " + message.topic() )
        println("clé du message: " + message.key() )
        println("message : " + message.value() )
        println("partition du message : " + message.partition() )
        println("offset du message : " + message.offset())
      }

    }
  }

  factureConsumer.commitAsync()


}
