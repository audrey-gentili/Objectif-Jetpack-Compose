package com.example.objectifcompose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.objectifcompose.data.Planet
import com.example.objectifcompose.data.planets
import com.example.objectifcompose.ui.theme.ObjectifComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Solution() {
    Scaffold(
        topBar = { TopAppBar(title = { _Title() }) }
    ) { paddingValues ->
        _PlanetList(Modifier.padding(paddingValues))
    }
}

@Composable
fun _Title() {
    Text(
        text = "Objectif Jetpack Compose",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun _Planet(planet: Planet) {
    var isVisible by rememberSaveable {
        mutableStateOf(true)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable { isVisible = !isVisible }
            .background(MaterialTheme.colorScheme.secondaryContainer),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = planet.name,
            modifier = Modifier
                .padding(32.dp),
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            style = MaterialTheme.typography.titleLarge,
        )
        AnimatedVisibility(
            visible = isVisible,
            enter = scaleIn(initialScale = 0.5f) + fadeIn(),
            exit = scaleOut(targetScale = 0.0f) + fadeOut(),
        ) {
            Image(
                painter = painterResource(id = planet.drawable),
                contentDescription = planet.name,
                modifier = Modifier
                    .padding(16.dp),
            )
        }
    }
}

@Composable
fun _PlanetList(modifier: Modifier) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(8.dp),
    ) {
        items(planets) { planet ->
            _Planet(planet)
        }
    }
}


@Preview(showSystemUi = false)
@Composable
fun _Preview() {
    ObjectifComposeTheme {
        _Planet(planet = planets.first())
    }
}
