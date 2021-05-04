package danieloakey.scalabase

object Main extends App {
  import FieldType._

  val example = Model(
    "Customer",
    List(
      Field("customerId", TNumber, isOptional = false),
      Field("firstName", TString, isOptional = true),
      Field("lastName", TString, isOptional = true),
      Field("isActive", TBoolean, isOptional = false)
    )
  )

  println(Conversion.convertModel(example))
}
