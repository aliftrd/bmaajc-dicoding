package com.github.aliftrd.jetupacto.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen(title: String, actions: (@Composable () -> Unit)? = null, floatingActionButton: (@Composable () -> Unit)? = null, content: @Composable () -> Unit) {
     Scaffold(
         modifier = Modifier.fillMaxSize(),
         topBar = {
             TopAppBar(
                 title = { Text(text = title) },
                 actions = {
                      actions?.let {
                          it()
                      }
                 }
             )
         },
         floatingActionButton = {
             floatingActionButton?.let {
                 it()
             }
         },
     ) { innerPadding ->
         Box(modifier = Modifier.padding(innerPadding)) {
             content()
         }
     }

}