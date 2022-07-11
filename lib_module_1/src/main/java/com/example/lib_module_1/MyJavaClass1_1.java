package com.example.lib_module_1;

import com.example.lib_module_2.MyJavaClass2_1;

/**
 * Class doc
 *
 * Note the reference to {@link MyKotlinClass} and {@link MyJavaClass2_1}
 */
class MyJavaClass1_1 {

   /**
    * Constructor, yes
    * @param constructorParam whatever
    */
   public MyJavaClass1_1(float constructorParam) {
//      do nothing lol
      new MyKotlinClass(0);
      new MyJavaClass2_1(0f);
   }

   /**
    * method doc
    *
    * @param param1 whatever
    * @return aaaa
    */
   int myMethod(String param1) {
      return 0;
   }

   /**
    * Field doc
    */
   public String field;
}
