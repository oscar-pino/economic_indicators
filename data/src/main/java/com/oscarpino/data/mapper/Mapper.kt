package com.oscarpino.mapper

import com.oscarpino.domain.model.Indicator
import com.oscarpino.domain.model.Indicators
import com.oscarpino.model.IndicatorRemote
import com.oscarpino.model.IndicatorResponse

fun IndicatorResponse.toIndicators(): Indicators {

    return Indicators(
        version = this.version,
        autor = this.autor,
        date = this.date,
        uf = this.uf.toIndicatorDomain(),
        ivp = this.ivp.toIndicatorDomain(),
        dolar = this.dolar.toIndicatorDomain(),
        dollarExchange = this.dollarExchange.toIndicatorDomain(),
        euro = this.euro.toIndicatorDomain(),
        ipc = this.ipc.toIndicatorDomain(),
        utm = this.utm.toIndicatorDomain(),
        imacec = this.imacec.toIndicatorDomain(),
        tpm = this.tpm.toIndicatorDomain(),
        copperPound = this.copperPound.toIndicatorDomain(),
        unemploymentMug = this.unemploymentMug.toIndicatorDomain(),
        bitcoin = this.bitcoin.toIndicatorDomain()

    )
}

fun IndicatorRemote.toIndicatorDomain(): Indicator {
    return Indicator(
        code = this.code,
        name = this.name,
        unitOfMeasure = this.unitOfMeasure,
        date = this.date,
        value = this.value
    )
}
