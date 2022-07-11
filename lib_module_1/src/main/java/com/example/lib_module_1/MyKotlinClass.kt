package com.example.lib_module_1

/**
 * MyKotlinClass
 */
class MyKotlinClass
/**
 * constructor doc
 */
constructor(foo: Int) {

//   const var thisWillFail = 0F

   init {
      foo + 3
   }

   /**
    * Field doc
    */
   val whatever: String = ""

   /**
    * method doc
    *
    * @param param whatever
    * @return something
    */
   fun method(param: Int): Float {
      return 0F
   }
}
