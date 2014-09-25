package services


import repository.PersonRepository.PersonRepository

/**
 * Created by akhona on 2014/09/24.
 */
trait getAllFacilitatorsInt {
      def getAll() : List[PersonRepository#TableElementType]
      //def changeType( anyL : List[PersonRepository#TableElementType] ): List[String]
}
