package emmanuelmuturia.experiment10.uilayer.destinationscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import emmanuelmuturia.experiment10.R

@Composable
fun DestinationScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Here's your treasure:",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(height = 7.dp))
        Image(
            painter = painterResource(id = R.drawable.treasure),
            contentDescription = "Treasure",
            contentScale = ContentScale.Crop
        )
    }

}