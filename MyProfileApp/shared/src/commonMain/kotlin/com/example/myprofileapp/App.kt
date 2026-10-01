package com.example.myprofileapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import myprofileapp.shared.generated.resources.Res
import myprofileapp.shared.generated.resources.photo

@Preview
@Composable
fun AppPreview() {
    App()
}

@Composable
fun App() {
    MaterialTheme(
        colorScheme = lightColorScheme()
    ) {
        var showMessage by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(24.dp),
            contentAlignment = Alignment.TopCenter
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 700.dp)
            ) {

                // =========================
                // PROFILE HEADER
                // =========================

                ProfileHeader()

                Spacer(
                    modifier = Modifier.height(32.dp)
                )

                // =========================
                // PERSONAL INFORMATION
                // =========================

                ProfileCard()

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                // =========================
                // BUTTON
                // =========================

                Button(
                    onClick = {
                        showMessage = !showMessage
                    },
                    modifier = Modifier.align(Alignment.Start)
                ) {
                    Text("Edit Profile")
                }

                // =========================
                // MESSAGE
                // =========================

                AnimatedVisibility(showMessage) {
                    Text(
                        text = "Profile siap untuk diedit!",
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileHeader() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // =========================
        // PROFILE PHOTO
        // =========================

        Box(
            modifier = Modifier.size(100.dp)
        ) {

            Image(
                painter = painterResource(Res.drawable.photo),
                contentDescription = "Foto profil",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            // Online indicator
            Box(
                modifier = Modifier
                    .size(18.dp)
                    .align(Alignment.BottomEnd)
                    .offset(
                        x = (-2).dp,
                        y = (-2).dp
                    )
                    .clip(CircleShape)
                    .background(Color.Green)
            )
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        // =========================
        // NAME
        // =========================

        Text(
            text = "Muhammad Ghifar",
            style = MaterialTheme.typography.headlineMedium
        )

        // =========================
        // MAJOR
        // =========================

        Text(
            text = "Teknik Informatika",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        // =========================
        // DESCRIPTION
        // =========================

        Text(
            text = "Mahasiswa Teknik Informatika yang tertarik pada Mobile Development dan teknologi.",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun InfoItem(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {

        Text(
            text = label,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = value
        )
    }
}

@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Personal Information",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            InfoItem(
                label = "Email",
                value = "ghifar@example.com"
            )

            InfoItem(
                label = "Phone",
                value = "0812-3456-7890"
            )

            InfoItem(
                label = "Location",
                value = "Lampung, Indonesia"
            )
        }
    }
}
