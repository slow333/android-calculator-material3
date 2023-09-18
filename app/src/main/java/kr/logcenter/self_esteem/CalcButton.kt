package kr.logcenter.self_esteem

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalcButton(symbol: String,
               modifier: Modifier,
               bgColor: Color,
               onClick: () -> Unit) {
   Box(modifier = Modifier
      .clip(CircleShape)
      .background(bgColor)
      .clickable { onClick() }
      .then(modifier),
      contentAlignment = Alignment.Center
   ) {
      Text(
         text = symbol,
         fontSize = 36.sp,
         fontWeight = FontWeight.Light,
         color = Color.White
         )
   }

}