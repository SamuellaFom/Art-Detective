package fr.esgi.artdetective.ui.gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import fr.esgi.artdetective.data.repository.FakeArtworkRepository
import fr.esgi.artdetective.domain.model.Artwork
import fr.esgi.artdetective.ui.theme.GoldPrimary
import fr.esgi.artdetective.ui.theme.SurfaceDark
import fr.esgi.artdetective.ui.theme.TextSecondary

@Composable
fun ArtworkListScreen(artworks: List<Artwork>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalArrangement = Arrangement.spacedBy(18.dp),
    ) {
        items(
            items = artworks,
            key = { it.id }
        ) { artwork ->

            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {
                Column {
                    AsyncImage(
                        model = artwork.imageUrl,
                        contentDescription = artwork.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(170.dp)
                            .background(Color.Red),
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(SurfaceDark)
                            .padding(12.dp),
                    ) {
                        Text(
                            text = artwork.style.uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            color = GoldPrimary
                        )

                        Text(
                            text = artwork.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.White
                        )

                        Text(
                            text = artwork.artistName,
                            style = MaterialTheme.typography.labelSmall,
                            color = TextSecondary
                        )
                    }
                }
            }
        }
    }
}
