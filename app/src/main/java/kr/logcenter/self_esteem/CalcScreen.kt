package kr.logcenter.self_esteem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.logcenter.self_esteem.ui.theme.DarkBlue
import kr.logcenter.self_esteem.ui.theme.LightGray
import kr.logcenter.self_esteem.ui.theme.Orange

@Composable
fun CalcScreen(buttonSpace: Dp = 8.dp, state: CalcState,
               modifier: Modifier = Modifier,
               handleClick: (CalcAction) -> Unit) {
   Box(modifier = Modifier
      .fillMaxSize()
      .padding(buttonSpace)) {
      Column(modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
         verticalArrangement = Arrangement.spacedBy(buttonSpace)
      ) {
         Text(text = state.number1 + (state.op?.symbol ?: "") + state.number2,
            modifier = Modifier.fillMaxWidth()
               .padding(vertical = 22.dp),
            textAlign = TextAlign.End,
            fontSize = 60.sp,
            lineHeight = 68.sp,
            maxLines = 2,
            fontWeight = FontWeight.Bold)
         Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpace)) {
            CalcButton(symbol = "AC",
               modifier = Modifier.aspectRatio(2f).weight(2F),
               bgColor = LightGray,
               onClick = { handleClick(CalcAction.Clear)})
            CalcButton(symbol = "DEL",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = LightGray,
               onClick = { handleClick(CalcAction.Delete)})
            CalcButton(symbol = "/",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = Orange,
               onClick = { handleClick(CalcAction.Operation(CalcOperation.Divide))})
         }
         Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpace)) {
            CalcButton(symbol = "7",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = DarkBlue,
               onClick = { handleClick(CalcAction.Number(7)) })
            CalcButton(symbol = "8",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = DarkBlue,
               onClick = { handleClick(CalcAction.Number(8))})
            CalcButton(symbol = "9",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = DarkBlue,
               onClick = { handleClick(CalcAction.Number(9))})
            CalcButton(symbol = "X",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = Orange,
               onClick = { handleClick(CalcAction.Operation(CalcOperation.Multiple))})
         }
         Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpace)) {
            CalcButton(symbol = "4",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = DarkBlue,
               onClick = { handleClick(CalcAction.Number(4))})
            CalcButton(symbol = "5",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = DarkBlue,
               onClick = { handleClick(CalcAction.Number(5)) })
            CalcButton(symbol = "6",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = DarkBlue,
               onClick = { handleClick(CalcAction.Number(6))})
            CalcButton(symbol = "-",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = Orange,
               onClick = { handleClick(CalcAction.Operation(CalcOperation.Subtract))})
         }
         Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpace)) {
            CalcButton(symbol = "1",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = DarkBlue,
               onClick = { handleClick(CalcAction.Number(1)) })
            CalcButton(symbol = "2",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = DarkBlue,
               onClick = { handleClick(CalcAction.Number(2)) })
            CalcButton(symbol = "3",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = DarkBlue,
               onClick = { handleClick(CalcAction.Number(3)) })
            CalcButton(symbol = "+",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = Orange,
               onClick = { handleClick(CalcAction.Operation(CalcOperation.Add))})
         }
         Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpace)) {
            CalcButton(symbol = "0",
               modifier = Modifier.aspectRatio(2f).weight(2F),
               bgColor = DarkBlue,
               onClick = { handleClick(CalcAction.Number(0)) })
            CalcButton(symbol = ".",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = DarkBlue,
               onClick = { handleClick(CalcAction.Decimal) })
            CalcButton(symbol = "=",
               modifier = Modifier.aspectRatio(1f).weight(1F),
               bgColor = Orange,
               onClick = { handleClick(CalcAction.Calculate)})
         }
      }
   }

}
