/**
 * Created by Igor_Glizer on 7/16/14.
 */

import scala.collection.mutable

trait JsonValue
case class StringValue (value : String) extends JsonValue
case class IntValue (value : Int) extends JsonValue
case class DoubleValue (value : Double) extends JsonValue
case class NullValue () extends JsonValue

case class JsonField(key : String, value : JsonValue) {

  def +(otherField: JsonField) {
    val jsonObject: JsonObject = new JsonObject
    jsonObject + (this, otherField)
  }
}


class JsonObject extends JsonValue {

  val fieldMap : mutable.Map[String, JsonValue] = new mutable.HashMap[String, JsonValue]

  def getValues : Seq[JsonField] = {
    fieldMap.map(i => JsonField(i._1, i._2))
  }

  def +(fields: JsonField*) {
    fields.foreach(f => fieldMap += f.key -> f.value)
    this
  }

  def replace(field: JsonField) {
    fieldMap(field.key) = field.value
  }


}
