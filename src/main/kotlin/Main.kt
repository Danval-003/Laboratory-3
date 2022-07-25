/*
Daniel Armando Valdez Reyes / carné 21240
Seccion 20 Programación de plataformas móviles
Universidad del Valle de Guatemala
 */
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
    //Se instancia la lista que recibira los ItemData.
    val result= ArrayList<ItemData>()
    //Se utiliza un ?.let para si en caso la lista sea un objeto nullo no lo utilice
    inputList?.let {
        //se utiliza un for para recorrer toda la lista que se recibio originalmente
        for(item in inputList){
            //Se utiliza un when que vaya creando cada ItemData dependiendo el objeto
                val itemData: ItemData = when(item){
                    //Dependiendo que es el objeto recibido se realizan las intrucciones para crear cada uno
                    is Int -> ItemData(inputList.indexOf(item), item,"entero", if(item%10 == 0){ "M10"} else if(item%5==0){ "M5" } else if(item %2==0){ "M2" } else { null})
                    is Boolean ->ItemData(inputList.indexOf(item),item, "booleano", if(item != false) "verdadero" else "falso" )
                    is String ->  ItemData(inputList.indexOf(item), item, "cadena", "L"+item.length)
                    else -> ItemData(inputList.indexOf(item), item?: "po") }
            //Si el item es un objeto nulo no se debe añadir a la lista
                item?.let{result.add(itemData)}
        }
        //se regresa la lista de ItemData
        return result
    }?: return null}//se regresa un null dado que se recibio un objeto null