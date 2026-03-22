package com.oscarpino.model

import com.google.gson.annotations.SerializedName

data class IndicatorResponse(

    @SerializedName("version") val version: String = "1.7.0",
    @SerializedName("autor") val autor: String = "mindicador.cl",
    @SerializedName("fecha") val date: String = "2026-03-03T16:00:00.000Z",
    @SerializedName("uf") val uf: IndicatorRemote,
    @SerializedName("ivp") val ivp: IndicatorRemote,
    @SerializedName("dolar") val dolar: IndicatorRemote,
    @SerializedName("dolar_intercambio") val dollarExchange: IndicatorRemote,
    @SerializedName("euro") val euro: IndicatorRemote,
    @SerializedName("ipc") val ipc: IndicatorRemote,
    @SerializedName("utm") val utm: IndicatorRemote,
    @SerializedName("imacec") val imacec: IndicatorRemote,
    @SerializedName("tpm") val tpm: IndicatorRemote,
    @SerializedName("libra_cobre") val copperPound: IndicatorRemote,
    @SerializedName("tasa_desempleo") val unemploymentMug: IndicatorRemote,
    @SerializedName("bitcoin") val bitcoin: IndicatorRemote
)

data class IndicatorRemote(
    @SerializedName("codigo") val code: String,
    @SerializedName("nombre") val name: String,
    @SerializedName("unidad_medida") val unitOfMeasure: String,
    @SerializedName("fecha") val date: String?,
    @SerializedName("valor") val value: Double?,
    @SerializedName("serie") val serie: List<SerieRemote>? = null
)

data class SerieRemote(
    @SerializedName("fecha") val fecha: String,
    @SerializedName("valor") val valor: Float
)


