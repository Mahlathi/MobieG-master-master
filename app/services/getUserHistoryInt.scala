package services


import repository.MemberEncountersRepository.MemberEncountersRepository

/**
 * Created by akhona on 2014/09/23.
 */
trait getUserHistoryInt {

    def counter( id : String ) : List[MemberEncountersRepository#TableElementType]

}


