package kr.logcenter.self_esteem

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kr.logcenter.self_esteem.ui.theme.SelfesteemTheme

class MainActivity : ComponentActivity() {
   @SuppressLint("SuspiciousIndentation")
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         SelfesteemTheme {
            Surface(
               modifier = Modifier.fillMaxSize(),
               color = MaterialTheme.colorScheme.background
            ) {
               val viewModel: CalcViewModel by viewModels()
               val state = viewModel.state
               val buttonSpace: Dp = 8.dp

               CalcScreen(state = state,
                  buttonSpace = buttonSpace,
                  modifier = Modifier.padding(16.dp),
                  handleClick = viewModel::onAction )
            }
         }
      }
   }
}
