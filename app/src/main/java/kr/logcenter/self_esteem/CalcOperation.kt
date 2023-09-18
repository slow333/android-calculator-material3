package kr.logcenter.self_esteem

sealed class CalcOperation(val symbol: String) {
   object Add : CalcOperation("+")
   object Subtract : CalcOperation("-")
   object Multiple : CalcOperation("x")
   object Divide : CalcOperation("/")
}
