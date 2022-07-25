data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(25, "Hola", null, false))
    println(result)
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    if(inputList == null){
        return null
    }

    val result= ArrayList<ItemData>()
    val count:Int= inputList!!.size -1
    var str:String?
    var bool:Boolean?
    var entero:Int?
    var type:String? = ""
    var info:String? =""

    for(i in 0..count){

        when(inputList[i]){
            is Int ->
            {type="entero"

                entero= inputList[i] as? Int
                if((entero ?: 2)%10 == 0){
                    info= "M10"
                } else if((entero ?: 3)%5==0){
                    info="M5"
                }else if((entero ?: 3)%2==0){
                    info="M2"
                }else {
                    info=null
                }

            }
            is Boolean -> {
                type ="booleano"
                bool = inputList[i] as? Boolean
                info = if((bool ?: true)) "verdadero" else "falso"

            }
            is String -> {
                type ="cadena"
                str = inputList[i] as? String
                info= "L"+ (str ?: "").length
            }
            else -> {type =null
                info=null
            }
        }
        if(inputList[i]!= null){
            result.add(ItemData(i, (inputList[i] ?: "null"),type,info ))
        }

    }
    return result
}