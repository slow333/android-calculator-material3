package kr.logcenter.self_esteem

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcViewModel: ViewModel() {
   var state by mutableStateOf(CalcState())
      private set

   fun onAction(action: CalcAction) {
      when(action) {
         is CalcAction.Number -> enterNumber(action.number)
         is CalcAction.Decimal -> enterDecimal()
         is CalcAction.Clear -> state = CalcState()
         is CalcAction.Operation -> enterOperation(action.operation)
         is CalcAction.Calculate -> performCalc()
         is CalcAction.Delete -> performDeletion()
      }
   }

   private fun performDeletion() {
      when {
         state.number2.isNotBlank() -> state= state.copy(
            number2 = state.number2.dropLast(1)
         )
         state.op != null -> state = state.copy(
            op = null
         )
         state.number1.isNotBlank() -> state = state.copy(
            number1 = state.number1.dropLast(1)
         )
      }
   }

   private fun performCalc() {
      val number1 = state.number1.toDoubleOrNull()
      val number2 = state.number2.toDoubleOrNull()
      if (number1 != null && number2 != null) {
         val result = when(state.op) {
            is CalcOperation.Add -> number1 + number2
            is CalcOperation.Subtract -> number1 - number2
            is CalcOperation.Multiple -> number1 * number2
            is CalcOperation.Divide -> number1 / number2
            else -> { null }
         }
         state = state.copy(
            number1 = result.toString().take(15),
            number2 = "",
            op = null
         )
      }
   }

   private fun enterOperation(operation: CalcOperation) {
      if (state.number1.isNotBlank()) {
         state = state.copy(op = operation)
      }
   }

   private fun enterDecimal() {
      if(state.op == null && !state.number1.contains(".") &&
         state.number1.isNotBlank()){
         state = state.copy(
            number1 =  state.number1 + "."
         )
         return
      }
      if(!state.number2.contains(".") &&
         state.number2.isNotBlank()){
         state = state.copy(
            number2 =  state.number2 + "."
         )
         return
      }
   }

   private fun enterNumber(number: Int) {
      if(state.op == null) {
         if(state.number1.length >= MAX_NUM_LENGTH ) {
            return
         }
         state = state.copy(
            number1 = state.number1 + number
         )
         return
      }
      if (state.number2.length >= MAX_NUM_LENGTH) {
         return
      }
      state = state.copy(
         number2 = state.number2 + number
      )
   }

   companion object {
      private val MAX_NUM_LENGTH =8
   }
}