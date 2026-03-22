package com.oscarpino.domain.model

data class Indicators (
    val version:String = "1.7.0",
    val autor:String = "mindicador.cl",
    val date:String = "2026-03-03T16:00:00.000Z",
    val uf:Indicator,
    val ivp:Indicator,
    val dolar:Indicator,
    val dollarExchange:Indicator,
    val euro:Indicator,
    val ipc:Indicator,
    val utm:Indicator,
    val imacec:Indicator,
    val tpm:Indicator,
    val copperPound:Indicator,
    val unemploymentMug:Indicator,
    val bitcoin:Indicator
)

data class Indicator(
    val code: String,
    val name: String,
    val unitOfMeasure: String,
    val date: String,
    val value: Double,
    val serie: List<Serie>
)

data class Serie( val fecha:String, val valor:Float)