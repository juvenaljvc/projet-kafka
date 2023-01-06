import  scala.collection.immutable._
import scala.collection.mutable._

object HelloWorld {

  def main(args: Array[String]): Unit = {

    println("Hello world : ma première application scala !")

    val mavariable : String = "Ma variable immutable"

    println(mavariable)

    var mutVar = 15

    mutVar = mutVar + 15

  //  println(maFonction(mavariable))

    collectionScala()

  }

  def maFonction (texte : String) : String = {
    texte.toUpperCase
  }

  def TestHello (texte : String, nombre : Int) : Unit = {

    if(texte.length > 10 ) {

      print("votre texte a une longueur supérieur à 10  : " + texte + " " + nombre)

    } else if ( texte.length == 10) {

      print("votre texte a une longueur égale à 10  : " + texte + " " + nombre)

    } else {

      print("votre texte a une longueur inférieure à 10  : " + texte + " " + nombre)

    }

  }

  def structureFor () : Unit = {
    for (i <- 0 to 10 ) {
      println(i)
    }
  }

  def collectionScala () : Unit = {
    val list1 : List[Int] = List(1, 2, 3, 4, 5, 10)
    val list2 = List("julien", "julie", "vincent", "benoit")

    val resultat1 = list1.count(l => l.<(10))
    println("résultat du calcul : " + resultat1)

    val resultat2 = list2.map(e => e.toUpperCase)

    resultat2.foreach(e => println(e.toString))





  }


}
