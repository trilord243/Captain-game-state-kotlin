package live.trilord.capitan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import live.trilord.capitan.ui.theme.CapitanTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CapitanTheme {
                CaptainGame()

            }
        }
    }
}


@Composable
fun CaptainGame(){
    val treasuresFound = remember {
        mutableStateOf(0)
    }
    val direction = remember{
        mutableStateOf(("Norte"))
    }

    val lifeLeft= remember {
        mutableStateOf(10)
    }

    val stormTreasure= remember{
        mutableStateOf("")
    }

    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment=Alignment.CenterHorizontally



    ){
        Spacer(modifier =   Modifier.height(32.dp))
        Text("Tesoros encontrados: ${treasuresFound.value}")


        Text("Direccion: ${direction.value}")
        Button(onClick={   direction.value="Norte" ;  if(Random.nextBoolean()){ treasuresFound.value+=1 ; stormTreasure.value="Tesoro Encontrado!"  } else{
            lifeLeft.value-=1
            stormTreasure.value="Tormenta! Perdiste una vida"
        }      }){
            Text(" Norte ")
        }
        Button(onClick={   direction.value="Sur" ;
            if(Random.nextBoolean()){ treasuresFound.value+=1 ; stormTreasure.value="Tesoro Encontrado!"  } else{
                lifeLeft.value-=1
                stormTreasure.value="Tormenta! Perdiste una vida"
            }



        }){
            Text(" Sur ")
        }
        Button(onClick={   direction.value="Este" ;  if(Random.nextBoolean()){ treasuresFound.value+=1 ; stormTreasure.value="Tesoro Encontrado!"  } else{
            lifeLeft.value-=1
            stormTreasure.value="Tormenta! Perdiste una vida"
        }       }){
            Text(" Este  ")
        }
        Button(onClick={   direction.value="Oeste" ;  if(Random.nextBoolean()){ treasuresFound.value+=1 ; stormTreasure.value="Tesoro Encontrado!"  } else{
            lifeLeft.value-=1
            stormTreasure.value="Tormenta! Perdiste una vida"
        }       }){
            Text(" Oeste ")
        }

        Text("Vidas restantes: ${lifeLeft.value}")
        Text(stormTreasure.value)

    }

}

@Preview(showBackground=true)
@Composable
fun CaptainGamePreview(){
    CaptainGame()
}
