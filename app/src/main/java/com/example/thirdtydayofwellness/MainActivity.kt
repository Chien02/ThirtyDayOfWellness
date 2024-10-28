package com.example.thirdtydayofwellness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirdtydayofwellness.data.Datasource
import com.example.thirdtydayofwellness.model.WellnessCard
import com.example.thirdtydayofwellness.ui.theme.ThirtyDayOfWellnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThirtyDayOfWellnessTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ThirtyDayOfWellness(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ThirtyDayOfWellness(modifier: Modifier) {
    WellnessCardList(
        cardList = Datasource().loadWellnessCard(),
        modifier = modifier
            .fillMaxWidth()
    )
}

@Composable
fun WellnessCardList(
    cardList: List<WellnessCard>,
    modifier: Modifier = Modifier)
{
    Scaffold (
        topBar = { AppTopBar() },
    ) {
        LazyColumn (
            contentPadding = it,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(dimensionResource(R.dimen.padding_small))
        ) { 
            items(cardList) { card ->
                WellnessCardComponent(
                    wellnessCard = card,
                )
            }
        }
    }

}

@Composable
fun WellnessCardComponent(
    wellnessCard: WellnessCard,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_small))
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .clickable (onClick = {
                    expanded = !expanded
                })
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Text(
                text = stringResource(wellnessCard.dayResourceId),
                style = MaterialTheme.typography.labelSmall,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(dimensionResource(R.dimen.padding_small))
            )
            Text(
                text = stringResource(wellnessCard.titleResourceId),
                style = MaterialTheme.typography.bodyLarge,
                modifier = modifier
                    .padding(horizontal = 8.dp)
            )
            ImageFrame(
                wellnessCard.imageResourceId,
                modifier = modifier
                    .padding(
                        horizontal = 40.dp,
                        vertical = 8.dp,
                    ),
            )
            if (expanded) {
                Text(
                    text = stringResource(wellnessCard.subtitleResourceId),
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.displayMedium,
                    modifier = modifier
                        .padding(dimensionResource(R.dimen.padding_small))
                        .align(Alignment.CenterHorizontally)
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer // Set your desired color here
        ),
        modifier = modifier
    )
}


@Composable
fun ImageFrame(
    @DrawableRes imageId : Int,
    modifier : Modifier = Modifier,
){
        Image(
            painter = painterResource(imageId),
            contentDescription = null,
            modifier = modifier
                .size(dimensionResource(R.dimen.image_size))
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop,
        )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThirtyDayOfWellnessTheme {
        ThirtyDayOfWellness(modifier = Modifier)
    }
}