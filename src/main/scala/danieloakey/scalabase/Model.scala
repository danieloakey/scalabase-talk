package danieloakey.scalabase

case class Model(name: String, fields: List[Field])

case class Field(name: String, tpe: FieldType, isOptional: Boolean)

sealed trait FieldType extends Product with Serializable

object FieldType {
  case object TString extends FieldType
  case object TNumber extends FieldType
  case object TBoolean extends FieldType
}
