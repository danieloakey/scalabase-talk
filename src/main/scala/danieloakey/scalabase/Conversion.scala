package danieloakey.scalabase

import scala.meta._

object Conversion {
  def convertModel(model: Model): Defn.Class = {
    val name = Type.Name(model.name)
    val fields = model.fields.map(convertField)
    q"case class $name(..$fields)"
  }

  def convertField(field: Field): Term.Param = {
    val tpe = convertType(field.tpe, field.isOptional)
    Term.Param(Nil, Name(field.name), Some(tpe), None)
  }

  def convertType(tpe: FieldType, isOptional: Boolean): Type = {
    import FieldType._

    val baseType = tpe match {
      case TString  => Type.Name("String")
      case TNumber  => Type.Name("Int")
      case TBoolean => Type.Name("Boolean")
    }

    if (isOptional)
      Type.Apply(Type.Name("Option"), List(baseType))
    else
      baseType
  }
}
