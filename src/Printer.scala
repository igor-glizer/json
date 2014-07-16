/**
 * Created by Igor_Glizer on 7/16/14.
 */
class Printer {
  def compact(obj : JsonObject) =
  {
      obj.getValues.foreach( f =>
      {

        print(s"{${f.key}:")
        f.value match
        {
          case JsonObject => compact(f.value)
          case StringValue(value) => print(s"\"{${value}\"")
          case IntValue(value) => print(s"{${value}")
          case DoubleValue(value) => print(s"{${value}")
          case NullValue(value) => print(s"{${value}")
        }
      }
      )
  }
}
