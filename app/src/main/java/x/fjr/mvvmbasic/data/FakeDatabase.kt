package x.fjr.mvvmbasic.data

class FakeDatabase private constructor(){

    var quoteDao = FakeQuoteDao()
        private set //cuma bisa diset dari fakedatabase

    companion object { //singleton klo ada passing constructor, normal object tidak bisa punya constructor aidjaidj alwdijaldijawdil
        @Volatile private  var instance: FakeDatabase? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: FakeDatabase().also { instance = it }
            VIew
        }
    }

}