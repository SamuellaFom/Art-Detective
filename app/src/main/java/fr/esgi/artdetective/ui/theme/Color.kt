package fr.esgi.artdetective.ui.theme

import androidx.compose.ui.graphics.Color

// --- Couleurs de fond (Ambiance Galerie Sombre) ---
val BackgroundDark = Color(0xFF0F172A)      // Fond principal des écrans (Bleu nuit profond)
val SurfaceDark = Color(0xFF1E293B)         // Fond des cartes, barres de navigation et modales
val SurfaceVariantDark = Color(0xFF334155)  // Bordures légères, fonds d'éléments verrouillés

// --- Couleurs d'accentuation (Identité Visuelle) ---
val GoldPrimary = Color(0xFFF59E0B)         // Or musée : boutons principaux, badges, étoiles, score
val GoldContainer = Color(0xFF451A03)       // Fond subtil doré (ex: badge sélectionné)
val IndigoSecondary = Color(0xFF6366F1)     // Indigo : boutons secondaires, indices, liens
val IndigoContainer = Color(0xFF1E1B4B)     // Fond subtil indigo

// --- Couleurs de texte ---
val TextPrimary =
    Color(0xFFF8FAFC)         // Blanc cassé très lisible pour les titres et textes principaux
val TextSecondary = Color(0xFF94A3B8)       // Gris bleuté pour les sous-titres, dates et légendes
val TextOnAccent = Color(0xFF0F172A)        // Texte sombre à mettre sur les boutons dorés

// --- Couleurs de feedback (Jeu & Enquêtes) ---
val SuccessGreen = Color(0xFF10B981)        // Bonne réponse au QCM, œuvre débloquée
val ErrorRed = Color(0xFFEF4444)            // Mauvaise réponse, cœur favori actif
val LockedOverlay = Color(0xCC0F172A)       // Voile semi-transparent sur les œuvres non débloquées
